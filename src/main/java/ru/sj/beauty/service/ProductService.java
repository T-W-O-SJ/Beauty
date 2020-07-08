package ru.sj.beauty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sj.beauty.model.Image;
import ru.sj.beauty.model.Product;
import ru.sj.beauty.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

   private final ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }

    public boolean delete(int id) {
        return repository.delete(id);
    }

    public Product get(int id) {
        return repository.get(id);
    }

    public List<Product> getAll() {
        return repository.getAll();
    }

    public List<Image> getProductImageList(int id) {
        return repository.getProductImageList(id);
    }

    public Product saveImage(int id, Image image) {
        return repository.saveImage(id, image);
    }

    @Autowired

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

}
