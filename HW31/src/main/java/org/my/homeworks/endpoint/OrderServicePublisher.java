package org.my.homeworks.endpoint;


import jakarta.xml.ws.Endpoint;
import org.my.homeworks.OrderServiceImpl;

public class OrderServicePublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/OrderService", new OrderServiceImpl());
    }
}
