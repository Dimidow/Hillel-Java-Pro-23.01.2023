package org.my.homework;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository {

    @Bean
    public List<Product> getAllProductsList() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(13, "Milk", 50.5));
        products.add(new Product(21, "Chicken", 150.8));
        products.add(new Product(7, "Tomato", 65.0));
        return products;
    }

    public Product getProductById(int id) {
        return getAllProductsList().stream()
                                   .filter(product -> product.getId() == id)
                                   .findFirst()
                                   .orElse(null);
    }
}
