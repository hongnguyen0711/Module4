package com.example.product.repository;

import com.example.product.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductRepository {
    Map<Integer, Product> getAll();

    void addProduct(Product product);

    Product findById(int id);

    void delete(int id);

    void update(Product product);

    Map<Integer,Product> search(String keyword);
}
