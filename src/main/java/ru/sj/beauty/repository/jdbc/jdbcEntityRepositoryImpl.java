package ru.sj.beauty.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.sj.beauty.model.Product;
import ru.sj.beauty.repository.ProductRepository;

import java.util.List;
@Repository
public class jdbcEntityRepositoryImpl implements ProductRepository {
    private final JdbcTemplate template;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert simpleInsert;
    private final BeanPropertyRowMapper ROW_MAPER = BeanPropertyRowMapper.newInstance(Product.class);
@Autowired
    public jdbcEntityRepositoryImpl(JdbcTemplate template, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.template = template;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.simpleInsert = new SimpleJdbcInsert(template).withTableName("entities").usingGeneratedKeyColumns("id");
    }

    @Override
    public Product save(Product product) {
        BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(product);
        if (product.isNew()){
            Number eKey = simpleInsert.executeAndReturnKey(source);
            product.setId(eKey.intValue());
        }
        else if(namedParameterJdbcTemplate.update("UPDATE entities SET description=:description," +
                " time=:time, price=:price WHERE id=:id ",source)==0){
            return  null;
        }
        return product;
    }

    @Override
    public boolean delete(int id) {
        return template.update("DELETE FROM entities WHERE id =?",id)!=0;

    }


    @Override
    public Product get(int id) {
    List<Product> temp  = template.query("SELECT FROM entities WHERE id=?",ROW_MAPER,id);

        return DataAccessUtils.singleResult(temp);
    }

    @Override
    public List<Product> getAll() {
        return template.query("SELECT * FROM entities",ROW_MAPER);
    }
}
