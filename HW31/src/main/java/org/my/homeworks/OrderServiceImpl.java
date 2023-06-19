package org.my.homeworks;

import jakarta.jws.WebService;


@WebService(endpointInterface = "org.my.homeworks.OrderService")
public class OrderServiceImpl implements OrderService {


    private OrderRepository orderRepository = new OrderRepository();


    @Override
    public Order getOrderById(int id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public Product[] getAllOrders() {

        return orderRepository.getAllOrders();
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }
}