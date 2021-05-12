package com.icommerce.microcommerce.controller;

import com.icommerce.microcommerce.dao.ProductDao;
import com.icommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController {

    //allows Spring to resolve and inject collaborating beans into our bean
    @Autowired
    private ProductDao productDao;

    @GetMapping(value="Products")
    public List<Product> ListProducts(){
        return productDao.findAll();
    }
    @GetMapping(value="Products/{id}")
    public Product afficherUnProduct(@PathVariable int id){
        return productDao.findById(id);
    }

    @PostMapping(value="Products")
    public ResponseEntity<Void> ajouterUnProduct(@RequestBody Product product){
        Product product1 = productDao.save(product);
        if(product1 == null){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product1.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
