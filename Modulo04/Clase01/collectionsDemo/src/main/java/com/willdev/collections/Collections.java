package com.willdev.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.willdev.calculadora.Product;

public class Collections {

    public void prueba() {
        var mapa = new java.util.HashMap<String, Integer>();

        mapa.put("Hola", 1);

        var mapa2 = Map.of("Hola", 1, "Mundo", 2);

        System.out.println(mapa2);

        var list = List.of("hola", "mundo", "java", "collections");
        System.out.println(list);

        var set = Set.of(1, 2, 3, 4, 5);

        var array = new String[] { "Hola", "Mundo", "Java", "Collections" };
        var arrayAsList = Arrays.asList(array);

        printWord("Hola", "Mundo", "Java", "Collections");
    }

    private void printWord(String... words) {
        for (var word : words) {
            System.out.println(word);
        }
    }

    public void pruebHash() {
        var product = new Product("Laptop", 1000.00, 5);
        System.out.println(product);

        var product2 = new Product("Laptop", 1000.00, 5);
        System.out.println(product2);

        System.out.println(product.equals(product2));

        System.out.println(product.getName().equals(product2.getName()) && product.getPrice() == product2.getPrice() && product.getQuantity() == product2.getQuantity());

    } 
}
