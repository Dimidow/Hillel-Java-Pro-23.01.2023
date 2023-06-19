package org.my.homeworks.endpoint;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.namespace.QName;

import jakarta.xml.ws.Service;
import org.my.homeworks.Order;
import org.my.homeworks.OrderService;
import org.my.homeworks.Product;


public class OrderClient {

    public static void main(String[] args) throws MalformedURLException {
        URL wsdlUrl = new URL("http://localhost:8080/OrderService?wsdl");
        QName qname = new QName("http://homeworks.my.org/", "OrderServiceImplService");
        Service service = Service.create(wsdlUrl, qname);
        OrderService orderService = service.getPort(OrderService.class);




        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Product 1", 10.99));
        products.add(new Product(6,"Product 2", 20.99));
        products.add(new Product(4,"Product 3", 30.99));



       // Order order = new Order(1, new Date(), 100.99, products);
      //  orderService.addOrder(order);

        Object[] array = orderService.getAllOrders();
        for (Object obj : array) {
            System.out.println(obj);
        }
    }
}