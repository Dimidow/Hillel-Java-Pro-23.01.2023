package coffee.order;

import java.util.Iterator;
import java.util.PriorityQueue;

public class CoffeeOrderBoard {

    private final PriorityQueue<Order> orderPriorityQueue;
    private int nextOrderNumber;


    public CoffeeOrderBoard() {
        orderPriorityQueue = new PriorityQueue<>();
        nextOrderNumber = 1;
    }

    public void add(String name) {
        Order order = new Order(nextOrderNumber++, name);
        orderPriorityQueue.offer(order);
    }

    public Order deliver() {
        return orderPriorityQueue.poll();
    }

    public Order deliver(int number) {
        Iterator<Order> iterator = orderPriorityQueue.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getOrderNumber() == number) {
                iterator.remove();
                return order;
            }
        }
        return null;
    }

    public void draw() {
        System.out.println("=============\n" + "# | Name");
        for (Order order : orderPriorityQueue) {
            System.out.println(order.getOrderNumber() + " | " + order.getName());
        }
    }
}
