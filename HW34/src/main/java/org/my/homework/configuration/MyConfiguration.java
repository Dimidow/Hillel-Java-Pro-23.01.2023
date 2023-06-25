package org.my.homework.configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.my.homework.models.Cart;
import org.my.homework.models.Product;
import org.my.homework.services.ConsoleCartService;
import org.my.homework.services.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfiguration {

    @Bean
    @Scope("prototype")
    public ProductRepository productRepository() {
        return new ProductRepository(products());
    }

    @Bean
    public Cart cart() {
        return new Cart(productRepository());
    }

    @Bean
    public ConsoleCartService consoleCartService(){
        return new ConsoleCartService(cart());
    }

    private List<Product> products(){
        return Stream.of(
            new Product(13, "Milk", 50.5),
            new Product(21, "Chicken", 150.8),
            new Product(7, "Tomato", 65.0)
        ).collect(Collectors.toList());
    }
}
