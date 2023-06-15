package org.my.homeworks.ws;

import java.util.List;


import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import lombok.NoArgsConstructor;
import org.my.homeworks.Order;
import org.my.homeworks.OrderRepository;


@NoArgsConstructor
@WebService(serviceName = "order-service") //(endpointInterface = "org.my.homeworks.ws.OrderService")
public class OrderService {


    private OrderRepository orderRepository = new OrderRepository();

    @WebMethod //(operationName="Get order by ID")
    public Order getOrderById(int id) {
        return orderRepository.getOrderById(id);
    }

    @WebMethod
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @WebMethod
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }
}