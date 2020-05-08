package ru.sj.beauty.repository;

import ru.sj.beauty.model.Product;

import java.util.List;

public interface ProductRepository {
    Product save(Product product);
    boolean delete(int id);
    Product get (int id);
    List<Product>getAll();
    }

