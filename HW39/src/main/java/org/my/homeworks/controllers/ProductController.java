package org.my.homeworks.controllers;

import java.util.List;
import java.util.Optional;

import org.my.homeworks.entities.Product;
import org.my.homeworks.entities.User;
import org.my.homeworks.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String home(@AuthenticationPrincipal User user) {
        return "Welcome";
    }

    @GetMapping("/products/all")
    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    @GetMapping("/products")
    public Optional<Product> getProductById(@RequestParam int id){
        return productRepository.getProductById(id);
    }

    @PostMapping("/products/create")
    public void createProduct(){
        productRepository.createProduct();
    }

    @DeleteMapping("/products/delete")
    public void removeProduct(){
        productRepository.removeProduct();
    }
}
