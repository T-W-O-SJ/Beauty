package ru.sj.beauty.repository.jpa;

import org.springframework.transaction.annotation.Transactional;
import ru.sj.beauty.model.Image;
import ru.sj.beauty.model.Product;
import ru.sj.beauty.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Transactional(readOnly = true)
public class ProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public Product saveImage(int id, Image image) {
       em.merge();
    }

    @Override
    @Transactional
    public Product save(Product product) {
        if (product.isNew()){
            em.persist(product);
            return product;
        }
        else return em.merge(product);
    }


    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(Product.DELETE).setParameter("id",id ).executeUpdate()!=0;
    }

    @Override
    public Product get(int id) {
        return em.createNamedQuery(Product.GetSorted.);
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Set<Image> getProductImage(int id) {
        return null;
    }

    @Override
    public Set<Image> getProducImage(int id) {
        return null;
    }
}
