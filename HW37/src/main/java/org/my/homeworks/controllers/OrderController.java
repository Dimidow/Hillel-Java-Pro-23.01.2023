package org.my.homeworks.controllers;

import java.util.List;

import org.my.homeworks.dao.OrderRepository;
import org.my.homeworks.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String orders(Model model) {
        orderRepository.add();
        model.addAttribute("orders", orderRepository.getAllEntities());
        return "orders";
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public String getOrderById(Model model, @PathVariable int orderId) {
        model.addAttribute("order", orderRepository.getById(orderId));
        return "order";
    }
}
