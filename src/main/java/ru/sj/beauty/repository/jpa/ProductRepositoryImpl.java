package ru.sj.beauty.repository.jpa;

import ru.sj.beauty.model.Product;
import ru.sj.beauty.repository.ProductRepository;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Product get(int id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
