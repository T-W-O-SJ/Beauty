package ru.sj.beauty.repository;

import ru.sj.beauty.model.Image;
import ru.sj.beauty.model.Product;

import java.util.List;
import java.util.Set;

public interface ProductRepository {
    Product save(Product product);
    boolean delete(int id);
    Product get (int id);
    List<Product>getAll();
    Set<Image> getProductImage(int id);
   Product saveImage(int id ,Image image);
    }

