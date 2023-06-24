package org.my.homeworks;

import java.util.ArrayList;

public class OrderRepository {

    private ArrayList<Order> orders = new ArrayList<>();

    public Order getOrderById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public ArrayList<Order> getAllOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
