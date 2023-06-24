package org.my.homeworks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Order {

    protected int id;
    protected Date date;
    protected double cost;

    protected ArrayList<Product> products;

    public Order(int id, Date date, double cost, ArrayList<Product> products) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.products = products;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    public ArrayList <Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products ) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
               "id=" + id +
               ", date=" + date +
               ", cost=" + cost +
               ", products=" + products +
               '}';
    }
}
