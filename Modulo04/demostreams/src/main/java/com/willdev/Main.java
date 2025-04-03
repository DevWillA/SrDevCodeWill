package com.willdev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.swing.event.TreeExpansionEvent;

public class Main {
    public static void main(String[] args) {
        ejercicio01();
    }

    private static void ejercicio01() {
        var numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        var mul3 = new ArrayList<Integer>();
        for (var number : numbers) {

            if (number % 3 == 0) {
                mul3.add(number);

            }

        }

        var ordenDesc = new ArrayList<Integer>();

        for (var number : mul3) {
            if (ordenDesc.isEmpty()) {
                ordenDesc.add(number);

            } else {
                for (int i = 0; i < ordenDesc.size(); i++) {
                    Integer valor = ordenDesc.get(i);
                    if (number > valor) {

                        ordenDesc.add(i, number);
                        break;

                    }
                    if (i == ordenDesc.size() - 1) {

                        ordenDesc.add(number);

                    }

                }
            }

        }

        var mul5 = new ArrayList<Integer>();
        for (var number : ordenDesc) {

            mul5.add(number * 5);

        }

        for (var number : mul5) {

            System.out.println(number);

        }

    }

    private static void ejercicio01Stream() {

        var numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        var stream = numbers.stream();
        var sFilter = stream.filter(n -> n % 3 == 0);
        var sDesc = sFilter.sorted(Comparator.reverseOrder());
        var sMul = sDesc.map(n -> n * 5);
        sMul.forEach(n -> System.out.println(n));

    }

    private static void ejercicio01StreamRefcator() {

        var numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        numbers.stream()
                .filter(n -> n % 3 == 0)
                .sorted(Comparator.reverseOrder())
                .map(n -> n * 5)
                .forEach(System.out::println);

    }

    private static class Empleado {
        private String nombre;
        private Integer salario;

        public Empleado(String nombre, Integer salario) {
            this.nombre = nombre;
            this.salario = salario;
        }

        public String getNombre() {
            return nombre;
        }

        public Integer getSalario() {
            return salario;
        }

    }

    private static void ejercicio02() {

        var empleados = Arrays.asList(
                new Empleado("Juan", 60000),
                new Empleado("Ana", 50000),
                new Empleado("Carlos", 70000),
                new Empleado("Luis", 80000),
                new Empleado("Maria", 40000));

        var total = empleados.stream()
                .filter(e -> e.getSalario() > 60000)
                .count();

        System.out.println("El total de empleados que ganan mas de 60Mil: " + total);
    }

    private static void ejercicio03() {

        var words = Arrays.asList("apple", "banana", "cherry", "date", "grape", "kiwi ");

        var groups = new TreeMap<Integer, Set<String>>();
        for (var word : words) {
            var len = word.length();
            if (groups.containsKey(len)) {

                groups.get(len).add(word);

            } else {
                var data = new HashSet<String>();
                data.add(word);
                groups.put(len, data);
            }

        }

        for (var key : groups.keySet()) {
            System.out.println("Palabras de longitud " + key + ": " + groups.get(key));

        }

    }

    private static void ejercicio03Strems() {

        var words = Arrays.asList("apple", "banana", "cherry", "date", "grape", "kiwi ");

        var groups = words.stream().collect(Collectors.groupingBy(String::length));

        groups.forEach((key, wordList) -> System.out.println("Palabras de longitud " + key + ": " + wordList.stream().collect(Collectors.joining(", "))));

    }
}