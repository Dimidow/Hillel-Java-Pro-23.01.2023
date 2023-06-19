package org.my.homeworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class OrderRepository {

    private static final List<Order> orders = new ArrayList<>();



    public Order getOrderById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public Product[] getAllOrders() {
        System.out.println(orders.size());
        String[] orderStrings = new String[orders.size()];


        return Arrays.copyOf(orderStrings, orderStrings.length, Product[].class);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
