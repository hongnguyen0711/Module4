package com.example.product_jpa.repository;

import com.example.product_jpa.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product ", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void addProduct(Product product) {
        try {
            entityManager.persist(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Transactional
    @Override
    public void delete(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Transactional
    @Override
    public void update(Product product) {
        try {
            entityManager.merge(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> search(String keyword) {
        TypedQuery<Product> query = entityManager.createQuery("from Product where name like concat('%', :keyword, '%') ", Product.class);
        query.setParameter("keyword", keyword);
        return query.getResultList();
    }
}