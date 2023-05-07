package com.udacity.store;

import antlr.build.Tool;
import com.udacity.store.controller.ProductController;
import com.udacity.store.model.Product;
import com.udacity.store.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





@SpringBootApplication
@Slf4j
public class StoreApplication  implements CommandLineRunner {

    public static void main(String[] args) {
            SpringApplication.run(StoreApplication.class, args);
        }

    @Autowired
     ProductController productController;
    @Autowired
     ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {
        // TODO: Populate the database with products

        Product product = new Product(5L,
                "test",
                 4.99,
                "https://www.montblanc.com/variants/images/22527730565448096/A/w2500.jpg",
                "test anything with it!");
         productController.newproduct(product);
        log.info("added");


    }

   
}
