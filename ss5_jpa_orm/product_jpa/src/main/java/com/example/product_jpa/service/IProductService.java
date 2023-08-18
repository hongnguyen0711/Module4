package com.example.product_jpa.service;

import com.example.product_jpa.model.Product;

import java.util.List;
import java.util.Map;


public interface IProductService {

    List<Product> getAll();

    void addProduct(Product product);

    Product findById(int id);

    void deleteProduct(int id);

    void update(Product product);

    List<Product> search(String keyword);
}
