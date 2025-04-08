package com.willdev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Clase29 {

    public static void main(String[] args) {
        ejercicio3();
    }

    private static void ejercicio1() {
        try {
            var lineas = Files.lines(Paths.get("ventas.csv"));

            var r = lineas.filter(line -> !line.isBlank())
                    .skip(1) // Saltar la primera línea (encabezados)
                    .map(line -> line.split(","))
                    .collect(Collectors.groupingBy(data -> data[0],
                            Collectors.summingInt(data -> Integer.parseInt(data[2]))));

            r.forEach((region, total) -> System.out.println("Region: " + region + ", Total: " + total));
        } catch (IOException e) {

            System.out.println("Error al leer el archivo: " + e.getMessage());

        }

    }

    private static void ejercicio2() {

        var text = "Java Streams son poderosos. Streams en java son eficientes.";

        var words = Arrays.stream(text.split(" "))
                .map(word -> word.replace('.', '\0'))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(words);
    }

    private static void ejercicio3() {

        var begin = System.currentTimeMillis();
        IntStream.rangeClosed(1, 10_000_000)
                .map(Integer::valueOf)
                .parallel()
                .filter(Clase29::isPrime);
                //.forEach(System.out::println);
        
        var end = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución: " + (end - begin) + " ms");


    }

    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}
