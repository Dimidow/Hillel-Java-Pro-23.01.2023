package org.my.homeworks.endpoint;


import org.my.homeworks.ws.generated.OrderService;
import org.my.homeworks.ws.generated.OrderServiceImplService;


public class OrderClient {

    public static void main(String[] args) {
        OrderServiceImplService orderServiceImplService = new OrderServiceImplService();
        OrderService orderService = orderServiceImplService.getOrderServiceImplPort();
        orderService.addOrder();
        System.out.println(orderService.getAllOrders());
        System.out.println(orderService.getOrderById(1));
    }
}
