package ru.sj.beauty.repository.jdbc;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.sj.beauty.model.User;
import ru.sj.beauty.repository.UserRepository;

import java.util.List;
public class jdbcUserRepositoryImpl implements UserRepository {
private final JdbcTemplate jdbcTemplate;
private  final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
private  final SimpleJdbcInsert insert;
private  final BeanPropertyRowMapper ROW_MAPPER = BeanPropertyRowMapper.newInstance(User.class);
    public jdbcUserRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("users").usingGeneratedKeyColumns("id");
    }

    @Override
    public User save(User user) {
        BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(user);
      if (user.isNew()){
          Number uKey = insert.executeAndReturnKey(source);
          user.setId(uKey.intValue());
      }
      else if
          (namedParameterJdbcTemplate.update("UPDATE users SET name=:name, password=:password, phone=:phone, "+
      "registered=:registered, enabled=:enabled, email=:email WHERE id=:id",source)==0){
          return null;
      }
return user;
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id=?",id)!=0;
    }

    @Override
    public User get(int id) {

        List<User> users = jdbcTemplate.query("SELECT * FROM users WHERE id=?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(users);
    }

    @Override
    public User getByEmail(String email) {
        List<User>temp = jdbcTemplate.query("SELECT FROM users WHERE email=?",ROW_MAPPER,email);
        return DataAccessUtils.singleResult(temp);
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM users",ROW_MAPPER);
    }
}
