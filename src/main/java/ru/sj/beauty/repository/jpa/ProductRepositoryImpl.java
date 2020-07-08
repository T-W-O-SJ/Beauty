package ru.sj.beauty.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sj.beauty.model.Image;
import ru.sj.beauty.model.Product;
import ru.sj.beauty.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;
@Repository
@Transactional(readOnly = true)
public class ProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public Product saveImage(int id, Image image) {
       Product product = (em.find(Product.class,id));
       product.getImages().add(image);
       return em.merge(product);
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
        return em.find(Product.class,id);
    }

    @Override
    public List<Product> getAll() {
        return em.createNamedQuery(Product.GetSorted,Product.class).getResultList();
    }

    @Override
    public List <Image> getProductImageList(int id) {
        return em.createNamedQuery(Product.GetImage,Image.class).setParameter("id",id).getResultList();
    }


}
