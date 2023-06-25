package org.my.homework.services;

import java.util.Scanner;

import org.my.homework.models.Cart;
import org.springframework.stereotype.Component;

@Component
public class ConsoleCartService {


    private Cart cart;

    public ConsoleCartService(Cart cart) {
        this.cart = cart;
    }

    public void run() {
        System.out.println("\nCart demo-version with add, remove, show products - options");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenuMessage();

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter product ID to add to cart: ");
                    int productIdToAdd = scanner.nextInt();
                    cart.addProductById(productIdToAdd);
                    break;
                case 2:
                    System.out.print("Enter product ID to remove from cart: ");
                    int productIdToRemove = scanner.nextInt();
                    cart.removeProductById(productIdToRemove);
                    break;
                case 3:
                    cart.displayCartProducts();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Wrong option. Try one more time.");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }

    private void printMenuMessage() {
        System.out.println("1. Add product to cart");
        System.out.println("2. Remove product from cart");
        System.out.println("3. Show all products in cart");
        System.out.println("0. Quit");
        System.out.print("Select menu option: ");
    }
}