package com.example.cart.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    public Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> item = selectItemInCart(product);
            Integer newQuantity = item.getValue() + 1;
            products.put(item.getKey(), newQuantity);
        }
    }
    public Integer countProductQuantity(){
        Integer quantity = 0;
        for (Map.Entry<Product,Integer> entry:products.entrySet()) {
            quantity += entry.getValue();
        }
        return quantity;
    }
    public Integer countItemQuantity(){
        return products.size();
    }
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product,Integer> entry:products.entrySet()) {
            payment = (float) (entry.getKey().getPrice()*entry.getValue());
        }
        return payment;
    }

}
