package com.example.shopping;

import com.example.shopping.model.Customer;
import com.example.shopping.model.Invoice;
import com.example.shopping.model.Order;
import com.example.shopping.model.Product;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Cem", 26);
        Customer customer2 = new Customer("John", 30);
        Customer customer3 = new Customer("Cem", 35);
        List<Customer> customers = new ArrayList<>(Arrays.asList(customer1, customer2, customer3));

        Product product1 = new Product("PC", 30000, "Electronics", 5);
        Product product2 = new Product("Phone", 10000, "Electronics", 15);
        Product product3 = new Product("Headphones", 1000, "Electronics", 20);
        Product product4 = new Product("Novel", 250, "Book", 30);

        Order order1 = new Order();
        order1.addProduct(product2);
        order1.addProduct(product3);
        order1.setInvoice(new Invoice(order1.getTotalAmount()));

        Order order2 = new Order();
        order2.addProduct(product1);
        order2.addProduct(product4);
        order2.setInvoice(new Invoice(order2.getTotalAmount()));

        Order order3 = new Order();
        order3.addProduct(product4);
        order3.setInvoice(new Invoice(order3.getTotalAmount()));

        customer1.addOrder(order1);
        customer2.addOrder(order2);
        customer3.addOrder(order3);

        // Sistemdeki butun musteri sayısı
        System.out.println("Musteri sayısı: " + customers.size());

        // Ismi Cem olan musterilerin aldıkları urun sayısı
        int productCountForCem = 0;
        for (Customer customer : customers) {
            if ("Cem".equals(customer.getName())) {
                for (Order order : customer.getOrders()) {
                    productCountForCem += order.getProducts().size();
                }
            }
        }
        System.out.println("Cem'in satın aldıgı urun sayısı: " + productCountForCem);

        // Ismi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alısveris tutarını hesaplayın
        double totalAmountForCem = 0;
        for (Customer customer : customers) {
            if ("Cem".equals(customer.getName()) && customer.getAge() > 25 && customer.getAge() < 30) {
                for (Order order : customer.getOrders()) {
                    totalAmountForCem += order.getInvoice().getAmount();
                }
            }
        }
        System.out.println("Ismi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alısveris tutarı: " + totalAmountForCem);

        // Sistemdeki 1500 TL uzerindeki faturaları listeleyin
        int highValueInvoicesCount = 0;
        for (Customer customer : customers) {
            for (Order order : customer.getOrders()) {
                if (order.getInvoice().getAmount() > 1500) {
                    highValueInvoicesCount++;
                }
            }
        }
        System.out.println("1500 TL uzeri faturalar: " + highValueInvoicesCount);

    }
}
