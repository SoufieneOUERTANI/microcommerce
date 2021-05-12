package com.icommerce.microcommerce.dao;

import com.icommerce.microcommerce.model.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> findAll();
    public Product findById(int id);
    public Product save(Product product);
}
