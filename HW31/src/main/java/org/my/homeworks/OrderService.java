package org.my.homeworks;

import java.util.List;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface OrderService {

    @WebMethod
    Order getOrderById(int id);

    @WebMethod
    List<Order> getAllOrders();

    @WebMethod
    void addOrder();
}