package com.willdev;

import com.willdev.calculadora.Inventory;
import com.willdev.calculadora.Product;

public class Main {
    public static void main(String[] args) {
        var inventory = new Inventory();
        inventory.addProduct(new Product("Laptop", 1000.00, 5));
        inventory.addProduct(new Product("Mouse", 20.00, 10));
        inventory.addProduct(new Product("Keyboard", 50.00, 7));
        inventory.addProduct(new Product("Monitor", 200.00, 3));
        inventory.addProduct(new Product("Laptop", 1000.00, 2));

        var products = inventory.getInventory();
        for (var product : products) {
            System.out.println(product);
        }

        try {
            var product = inventory.getProduct("Laptop");
            System.out.println("Product found: " + product);
        } catch (NullPointerException e) {
            System.out.println("Product not found: " + e.getMessage());
        }

        var total = inventory.getTotalInventoryValue();
        System.out.println("Total inventory value: " + total);

    }
}