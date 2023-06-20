package org.my.homework.services;

import java.util.List;

import org.my.homework.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository {

    private List<Product> products;


    public ProductRepository(List<Product> products) {
        this.products = products;
    }

    public List<Product> getAllProductsList() {
        return products;
    }

    public Product getProductById(int id) {
        return getAllProductsList().stream()
                                   .filter(product -> product.getId() == id)
                                   .findFirst()
                                   .orElse(null);
    }
}
