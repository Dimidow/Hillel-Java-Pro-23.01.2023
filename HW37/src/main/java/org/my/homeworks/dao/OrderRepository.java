package org.my.homeworks.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.my.homeworks.entities.Order;
import org.my.homeworks.entities.Product;
import org.springframework.stereotype.Repository;


@Repository
public class OrderRepository implements StoreDao<Order>{

    private List<Order> orderList= new ArrayList<>();



    @Override
    public void add() {
        Order order = createOrder();
        orderList.add(order);
    }

    @Override
    public Order getById(int id) {

        return orderList.stream()
                                .filter(order -> order.getId() == id)
                                .findFirst()
                                .orElse(null);
    }

    @Override
    public List<Order> getAllEntities() {
        return orderList;
    }

    private Order createOrder() {     //Looks terribly
        Order order = new Order();
        List<Product> productList = new ArrayList<>();
        int orderId = (int) (Math.random() * 1000) + 1;
        order.setId(orderId);
        order.setDate(new Date());
        int orderCost = (int) (Math.random() * 1000) + 1;
        order.setCost(orderCost);
        for (int i = 0; i < 10; i++) {
            int productId = (int) (Math.random() * 100) + 1;
            String productName = generateRandomProductName();
            double productCost = generateRandomProductCost();
            Product product = new Product(productId, productName, productCost);
            productList.add(product);
        }
        order.setProducts(productList);
        return order;
    }

    private String generateRandomProductName() {
        String[] productNames = {"Milk", "Bread", "Cheese", "Eggs", "Apples", "Oranges", "Chicken", "Beef", "Rice", "Pasta"};
        int randomIndex = (int) (Math.random() * productNames.length);
        return productNames[randomIndex];
    }

    private double generateRandomProductCost() {
        return (Math.random() * 100) + 1;
    }
}
