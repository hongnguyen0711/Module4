package com.example.product.service;

import com.example.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface IProductService {

    Map<Integer, Product> getAll();

    void addProduct(Product product);

    Product findById(int id);

    void deleteProduct(int id);

    void update(Product product);

    Map<Integer,Product> search(String keyword);
}
