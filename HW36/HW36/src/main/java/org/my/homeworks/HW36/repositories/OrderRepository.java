package org.my.homeworks.HW36.repositories;

import java.util.Date;
import java.util.List;

import org.my.homeworks.HW36.dao.OrderDao;
import org.my.homeworks.HW36.entities.Order;
import org.my.homeworks.HW36.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {


    @Autowired
    private OrderDao orderDao;

    public void add() {
        Order order = createOrder();
        orderDao.add(order);
    }


    public Order getById(int id) {
        return orderDao.getById(id);
    }


    public List<Order> getAllEntities() {
        return orderDao.getAllEntities();
    }

    private Order createOrder() {     //Looks terribly
        Order order = new Order();
        List<Product> productList = orderDao.getAvailableProducts();
        int orderId = (int) (Math.random() * 1000) + 1;
        order.setId(orderId);
        order.setDate(new Date());
        int orderCost = (int) (Math.random() * 1000) + 1;
        order.setCost(orderCost);
        order.setProducts(productList);

        return order;
    }
}
