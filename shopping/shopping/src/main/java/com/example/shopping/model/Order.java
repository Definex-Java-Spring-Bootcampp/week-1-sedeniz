package com.example.shopping.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products;
    private Invoice invoice;
    private int totalAmount;

    public Order() {
        this.products = new ArrayList<>();
        totalAmount = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalAmount += (int) product.getPrice();
        product.decreaseStock();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

}

