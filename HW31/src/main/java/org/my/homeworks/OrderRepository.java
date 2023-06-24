package org.my.homeworks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();
    private int orderCount = 0;

    public Order getOrderById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void addOrder() {
        double cost = new Random().nextDouble() * 100;
        Order order = new Order(orderCount++, new Date(), cost, createProducts());
        orders.add(order);
    }

    private List<Product> createProducts() {
        String[] goods = {"milk", "apple", "garlic", "tomato", "potato"};
        int randomValue = new Random().nextInt(goods.length - 1);
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < randomValue; i++) {
            products.add(
                new Product(new Random().nextInt(100),
                            goods[new Random().nextInt(goods.length - 1)],
                            new Random().nextDouble() * 1000)
            );
        }
        return products;
    }
}
