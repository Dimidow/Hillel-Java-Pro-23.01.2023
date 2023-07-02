package org.my.homeworks.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.my.homeworks.entities.Order;
import org.my.homeworks.entities.Product;
import org.my.homeworks.repository.OrderRepository;
import org.my.homeworks.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    public void createOrder(){
        Order order = new Order();
        order.setId(1);
        order.setCost(50);
        order.setDate(new Date());
        order.setProducts(createProductsList());
        orderRepository.save(order);
    }

    public List<Order> getAllOrders(){
        return (List<Order>) orderRepository.findAll();
    }

    public Optional<Order> getOrderById(int id){
        return orderRepository.findById(id);
    }
    //Delete All or Delete by ID
    public void removeOrder(){
        orderRepository.deleteAll();
    }
    private List<Product> createProductsList(){
        Product product = new Product();
        product.setId(13);
        product.setName("Onion");
        product.setCost(50.0);
        productRepository.save(product);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        return productList;
    }
}
