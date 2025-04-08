package com.willdev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        groups.forEach((key, wordList) -> System.out
                .println("Palabras de longitud " + key + ": " + wordList.stream().collect(Collectors.joining(", "))));

    }

    private static void ejercicio04() {

        var numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        var promedio = numbers.stream()
                .collect(Collectors.averagingInt(Integer::intValue));

        System.out.println(promedio);

    }

    private static void ejercicio05() {

        var words = Arrays.asList("Java", "Streams", "are", "poerful");

        var r = words.stream()
                .collect(Collectors.joining(" "));

        System.out.println(r);

    }

    public static class Venta {
        private String producto;
        private int cantidad;

        public Venta(String producto, int cantidad, double precioPorUnidad) {
            this.producto = producto;
            this.cantidad = cantidad;
            this.precioPorUnidad = precioPorUnidad;
        }

        public String getProducto() {
            return producto;
        }

        public int getCantidad() {
            return cantidad;
        }

        public double getPrecioPorUnidad() {
            return precioPorUnidad;
        }

        private double precioPorUnidad;

    }

    private static void ejercicio06() {

        var ventas = Arrays.asList(
                new Venta("ProductoA", 10, 12.5),
                new Venta("ProductoB", 5, 25),
                new Venta("ProductoA", 7, 15),
                new Venta("ProductoC", 20, 4),
                new Venta("ProductoD", 2, 30));

        var r = ventas.stream()
                .filter(v -> v.getCantidad() * v.getPrecioPorUnidad() > 100d)
                .collect(Collectors.groupingBy(v -> v.getProducto(),
                        Collectors.summingDouble(v -> v.getCantidad() * v.getPrecioPorUnidad())));

        r.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(e -> System.out.printf("Producto: %s, cantidad: %,.2f %n", e.getKey(), e.getValue()));
    }

    private static void ejercicio08() {

        var texto = """
                Dado un párrafo de texto convierte el texto en una lista de palabras y elimina las palabras repetidas.
                Luego agrupa las palabras por su longitud y muestra cada grupo de palabras junto con la cantidad de palabras en ese grupo.
                Finalmente encuentra la palabra más larga en el texto y muéstrala por pantalla.
                """;

        var pu = Stream.of(texto.replaceAll("\n", " ")
                .replace('.', '\0')
                .split(" "))
                .collect(Collectors.toSet());

        var ppl = pu.stream()
                .collect(Collectors.groupingBy(String::length));

        ppl.forEach(
                (longitud, palabras) -> System.out.printf("Longitud: %d, Palabras: %d %n", longitud, palabras.size()));

        var pmlo = ppl.entrySet().stream()
        .sorted(Map.Entry.<Integer, List<String>>comparingByKey())
        .findFirst();

        if (pmlo.isPresent()) {
            pmlo.get().getValue().stream().findFirst().ifPresent(System.out::println);
            
        }
        
    }

}