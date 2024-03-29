package org.my.homework.models;

import java.util.List;

import org.my.homework.services.ProductRepository;


public class Cart {


    private ProductRepository productRepository;
    private List<Product> products;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
        products = productRepository.getAllProductsList();
    }

    public void addProductById(int id) {
        Product product = productRepository.getProductById(id);
        if (product != null) {
            products.add(product);
            System.out.println("Product with ID " + id + " added to Cart.");
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    public void removeProductById(int id) {
        boolean removed = products.removeIf(product -> product.getId() == id);
        if (removed) {
            System.out.println("Product with ID " + id + " removed.");
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    public void displayCartProducts() {
        if (products.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            System.out.println("Cart with:");
            for (Product product : products) {
                System.out.println(product.getId() + ": " + product.getName() + ", Price: " + product.getPrice());
            }
        }
    }
}