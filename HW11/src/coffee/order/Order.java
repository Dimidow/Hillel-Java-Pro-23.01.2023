package coffee.order;

import java.util.Objects;

public class Order implements Comparable<Order> {

    private int orderNumber;
    private String name;

    public Order(int orderNumber, String name) {
        this.orderNumber = orderNumber;
        this.name = name;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Order order = (Order) o;
        return orderNumber == order.orderNumber && name.equals(order.name);
    }

    @Override
    public String toString() {
        return "Order{" +
               "orderNumber=" + orderNumber +
               ", name='" + name + '\'' +
               '}';
    }

    @Override
    public int compareTo(Order order) {
        if (this.orderNumber == order.orderNumber) {
            return this.name.compareTo(order.name);
        }
        return Integer.compare(this.orderNumber, order.orderNumber);
    }
}
