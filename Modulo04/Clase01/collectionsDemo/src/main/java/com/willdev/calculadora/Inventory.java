package com.willdev.calculadora;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Inventory {
    
    private Map<String, Product> products = new HashMap<>();    


    public void addProduct(Product product) {

        if (products.containsKey(product.getName().toUpperCase())) {
            var oldProduct = products.get(product.getName().toUpperCase());
            var quantity = oldProduct.getQuantity();
            quantity += product.getQuantity();
            oldProduct.setQuantity(quantity);
        } else {
            products.put(product.getName().toUpperCase(), product);
            System.out.println("Product added to inventory: " + product.getName());
            
        }

    }

    public Queue<String> getInventory() {

        Queue<String> inventory = new java.util.LinkedList<>();

        for (var product : products.keySet()) {
            var value = products.get(product);
            inventory.add(String.format("Product: %s, Price: %.2f, Quantity: %d", value.getName(), value.getPrice(), value.getQuantity()));
        }

        return inventory;
    }

    public Product getProduct(String name) {
        return products.get(name.toUpperCase());
    }

    public double getTotalInventoryValue() {
        double totalValue = 0.0;
        for (var product : products.values()) {
            totalValue += product.getPrice() * product.getQuantity();
        }
        return totalValue;
    }
}
