package ru.sj.beauty.repository.jpa;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sj.beauty.model.User;
import ru.sj.beauty.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional(readOnly = true)
public class UserRepositoryJpaImpl implements UserRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional
    public User save(User user) {
        if(user.isNew()){
            em.persist(user);
            return user;
        }
        else{
            return em.merge(user);
        }

    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(User.DELETE).setParameter("id",id).executeUpdate()!=0;
    }

    @Override
    public User get(int id) {
        return em.find(User.class,id);
    }

    @Override
    public User getByEmail(String email) {
        List<User> list = em.createNamedQuery(User.GetByEmail,User.class).setParameter(1,email).getResultList();

        return DataAccessUtils.singleResult(list);
    }

    @Override
    public List<User> getAll() {
        return em.createNamedQuery(User.GetSorted,User.class).getResultList();
    }
}
