package org.my.homeworks.endpoint;


import java.net.MalformedURLException;
import java.net.URL;


import javax.xml.namespace.QName;

import jakarta.xml.ws.Service;
import org.my.homeworks.Order;
import org.my.homeworks.OrderService;


public class OrderClient{

    public static void main(String[] args) throws MalformedURLException {
       URL wsdlUrl = new URL("http://localhost:8080/OrderService?wsdl");
        QName qname = new QName("http://homeworks.my.org/", "OrderServiceImplService");
        Service service = Service.create(wsdlUrl, qname);

        OrderServiceImplService orderServiceImplService = service.getPort(OrderServiceImplService.class);
        OrderService orderService = orderServiceImplService.getOrderServiceImplPort();
        orderService.addOrder(new Order());


    }
}