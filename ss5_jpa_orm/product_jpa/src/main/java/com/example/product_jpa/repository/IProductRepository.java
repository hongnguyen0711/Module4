package com.example.product_jpa.repository;

import com.example.product_jpa.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductRepository {
    List<Product> getAll();

    void addProduct(Product product);

    Product findById(int id);

    void delete(int id);

    void update(Product product);

    List<Product> search(String keyword);
}
