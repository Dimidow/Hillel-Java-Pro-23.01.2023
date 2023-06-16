package org.my.homeworks.coffee.order;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order implements Comparable<Order> {


    private int orderNumber;
    private String name;


    @Override
    public int compareTo(Order order) {
        if (this.orderNumber == order.orderNumber) {
            return this.name.compareTo(order.name);
        }
        return Integer.compare(this.orderNumber, order.orderNumber);
    }
}
