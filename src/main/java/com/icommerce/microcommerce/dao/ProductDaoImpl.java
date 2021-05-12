package com.icommerce.microcommerce.dao;

import com.icommerce.microcommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


//@Repository’s job is to catch persistence-specific exceptions and re-throw them as one of Spring’s unified unchecked exceptions.
@Repository
public class ProductDaoImpl implements ProductDao{
    public static List<Product> products = new ArrayList<Product>();
    static {
        products.add(new Product(1,"Nom1",100, 10));
        products.add(new Product(2,"Nom2",200,20));
        products.add(new Product(3,"Nom3",300, 30));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if(product.getId()==id)
                return product;
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}
