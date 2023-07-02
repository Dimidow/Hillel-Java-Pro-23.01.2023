package org.my.homeworks.HW36.controllers;

import java.util.List;

import org.my.homeworks.HW36.entities.Order;
import org.my.homeworks.HW36.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/")
    public String home() {
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome\n")
          .append("Use next mapping\n")
          .append("Get all orders http://localhost:8080/order/all\n")
          .append("Get order by ID http://localhost:8080/order?id={id}\n")
          .append("Use POST-method to add random order http://localhost:8080/order/add");
        return sb.toString();
    }
    @GetMapping(path = "/orders/all")
    public @ResponseBody List<Order> getAllOrders() {
        return orderRepository.getAllEntities();
    }
    @GetMapping(path = "/orders")
    public @ResponseBody Order getOrderById(@RequestParam int id) {
        return orderRepository.getById(id);
    }

    @PostMapping(path = "/orders/add")
    public String addRandomOrder(){
        orderRepository.add();
        return "Random order is added";
    }
}
