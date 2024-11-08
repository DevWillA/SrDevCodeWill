/*Necesitamos calcular el área de un círculo, un cuadrado y un triángulo utilizando las fórmulas matemáticas correspondientes.
Fórmulas de Cálculo:

Área de un Círculo: La fórmula es A = pi * r ^ 2, donde r es el radio del círculo.
Área de un Cuadrado: La fórmula es A = l ^ 2, donde l es la longitud del lado del cuadrado.
Área de un Triángulo: La fórmula es A = (b * h) / 2, donde b es la base y h es la altura del triángulo.
Estructura del Programa:
Crear métodos separados para calcular el área de cada figura geométrica.
Puede utilizar la función creada en el ejercicio 7 para calcular los cuadrados en las formulas.

Interacción con el Usuario:
Pedir al usuario que ingrese los valores necesarios (radio, lado, base y altura) para calcular el área de cada figura.

Mostrar Resultados:
Después de calcular el área, mostrar el resultado al usuario en la consola. */

import java.util.Scanner;
import java.math.*;

public class Ejercicio08 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a la calculadora de areas");
        System.out.println("¿Qué figura deseas calcular?");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Salir");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:

                System.out.println("Ingrese el radio del circulo");
                double radio = sc.nextDouble();
                System.out.println(" EL área del circulo con radio " + radio + " es: " + calcularAreaCirculo(radio));

                break;

            case 2:

                System.out.println("Ingrese uno de los lados del cuadrado");
                double lado = sc.nextDouble();
                System.out.println(" EL área del cuadrado con lado " + lado + " es: " + calcularAreaCuadrado(lado));

                break;

            case 3:

                System.out.println("Ingrese la base del triangulo");
                double base = sc.nextDouble();
                System.out.println("Ingrese la altura del triangulo");
                double altura = sc.nextDouble();
                System.out.println("EL área del trangulo con Base " + base + " y Altura " + altura + " es: "
                        + calcularAreaTriangulo(base, altura));

                break;

            case 4:
                System.out.println("Saliendo...");
                break;

            default:
                System.out.println("Opcion Incorrecta");

                break;
        }
        sc.close();
    }

    public static double calcularAreaCirculo(double radio) {
        double areaCirculo = Math.PI * (radio * radio);
        return areaCirculo;

    }

    public static double calcularAreaCuadrado(double lado) {
        double areaCuadrado = lado * lado;
        return areaCuadrado;

    }

    public static double calcularAreaTriangulo(double base, double altura) {
        double areaTriangulo = (base * altura) / 2;
        return areaTriangulo;

    }
}
