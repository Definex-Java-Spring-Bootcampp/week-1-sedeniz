package com.example.shopping.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private int age;
    private List<Order> orders;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

