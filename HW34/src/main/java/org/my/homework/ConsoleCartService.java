package org.my.homework;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleCartService implements CommandLineRunner {


    @Autowired
    private Cart cart;

    @Override
    public void run(String... args) {
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