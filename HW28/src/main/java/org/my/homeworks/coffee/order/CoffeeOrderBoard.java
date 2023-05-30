package org.my.homeworks.coffee.order;

import java.util.Iterator;
import java.util.PriorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CoffeeOrderBoard {

    private static final Logger logger = LoggerFactory.getLogger(CoffeeOrderBoard.class);
    private final PriorityQueue<Order> orderPriorityQueue;
    private int nextOrderNumber;


    public CoffeeOrderBoard() {
        orderPriorityQueue = new PriorityQueue<>();
        nextOrderNumber = 1;
    }

    public void add(String name) {
        Order order = new Order(nextOrderNumber++, name);
        orderPriorityQueue.offer(order);
        logger.info("Added order: {}", order);
    }

    public Order deliver() {
        Order order = orderPriorityQueue.poll();
        logger.info("Delivered order: {}", order);
        return order;
    }

    public Order deliver(int number) {
        try {
            Iterator<Order> iterator = orderPriorityQueue.iterator();
            while (iterator.hasNext()) {
                Order order = iterator.next();
                if (order.getOrderNumber() == number) {
                    iterator.remove();
                    logger.info("Delivered order by number: {}", order);
                    return order;
                }
            }
            logger.warn("Order not found with number: {}", number);
            return null;
        } catch (Exception e) {
            logger.error("Error delivering order with number: {}", number, e);
            return null;
        }
    }

    public void draw() {
        logger.info("Current orders:");
        logger.info("=============");
        logger.info("# | Name");
        for (Order order : orderPriorityQueue) {
            logger.info(order.getOrderNumber() + " | " + order.getName());
        }
    }
}
