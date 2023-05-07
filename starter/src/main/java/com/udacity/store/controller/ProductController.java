package com.udacity.store.controller;

import com.udacity.store.model.Order;
import com.udacity.store.model.Product;
import com.udacity.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:4200")


public class ProductController {
// TODO: Use the mapping products to add an API endpoint to fetch the products from the ProductRepository

    @Autowired
    ProductRepository productRepository;
    @GetMapping("product")
    public List<Product> getAllProduct(){
        List<Product> products = productRepository.findAll();
        return products;
    }

    @GetMapping("product/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return  productRepository.findById(id).get();
    }

    @PostMapping("new")
    public ResponseEntity<Product> newproduct(@RequestBody Product product){

        return ResponseEntity.ok(productRepository.save(product));
    }
}
