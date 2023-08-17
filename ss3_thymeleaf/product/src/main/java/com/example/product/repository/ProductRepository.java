package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "iPhone 12", 999.99, "Flagship smartphone from Apple", "Apple Inc."));
        productMap.put(2, new Product(2, "Samsung Galaxy S21", 899.99, "Flagship smartphone from Samsung", "Samsung Electronics"));
        productMap.put(3, new Product(3, "Google Pixel 5", 699.99, "Flagship smartphone from Google", "Google LLC"));
        productMap.put(4, new Product(4, "OnePlus 9 Pro", 799.99, "Flagship smartphone from OnePlus", "OnePlus Technology"));
        productMap.put(5, new Product(5, "Xiaomi Mi 11", 699.99, "Flagship smartphone from Xiaomi", "Xiaomi Corporation"));
    }

    @Override
    public Map<Integer, Product> getAll() {
        return productMap;
    }

    @Override
    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }

    @Override
    public void update(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Map<Integer, Product> search(String keyword) {
        Map<Integer, Product> product = new HashMap<>();

        for (Map.Entry<Integer, Product> map : productMap.entrySet()) {
            if (map.getValue().getName().toLowerCase().contains(keyword.toLowerCase())) {
                product.put(map.getKey(), map.getValue());
            }
        }
        return product;
    }
}
