package org.my.homeworks.controllers;

import java.util.List;
import java.util.Optional;

import org.my.homeworks.entities.Order;
import org.my.homeworks.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String home() {
        return "Welcome";
    }

    @PostMapping("/orders")
    public void createOrder(){
        orderService.createOrder();
    }

    @GetMapping("/orders/all")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping(path = "/orders")
    public @ResponseBody Optional<Order> getOrderById(@RequestParam int id) {
        return orderService.getOrderById(id);
    }
}
