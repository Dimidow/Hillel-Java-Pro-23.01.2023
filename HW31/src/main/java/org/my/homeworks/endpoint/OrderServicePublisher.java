package org.my.homeworks.endpoint;


import jakarta.xml.ws.Endpoint;
import org.my.homeworks.ws.OrderService;

public class OrderServicePublisher {

    public static final String URL = "http://localhost:8080/OrderService";

    public static void main(String[] args) {


        Endpoint.publish(URL, new OrderService());

    }
}
