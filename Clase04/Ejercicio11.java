/*Definir el Problema:
El Índice de Masa Corporal (IMC) es una medida que se utiliza para determinar si una persona tiene un peso saludable en relación con su altura.
La fórmula para calcular el IMC es: IMC = (peso_kg / altura_m) ^ 2.

Categorías del IMC:
Bajo peso: IMC < 18.5
Peso normal: IMC entre 18.5 y 24.9
Sobrepeso: IMC entre 25 y 29.9
Obesidad:
Grado I: IMC entre 30 y 34.9
Grado II: IMC entre 35 y 39.9
Grado III: IMC ≥ 401
Estructura del Programa:
Crear un método separado que realice el cálculo del IMC.
Crear un método separado que determine la categoría del IMC basado en el valor calculado.
Interacción con el Usuario:
Pedir al usuario que ingrese su peso en kilogramos y su altura en metros.

Mostrar Resultados:
Después de calcular el IMC y determinar la categoría, mostrar los resultados al usuario en la consola.
Por ejemplo:

Ingresa tu peso en kilogramos: 70
Ingresa tu altura en metros: 1.75

Tu IMC es: 22.86
Categoría: Peso normal
Ingresa tu peso en kilogramos: 85
Ingresa tu altura en metros: 1.60

Tu IMC es: 33.20
Categoría: Obesidad grado I */

import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa tu peso en kilogramos: ");
        double peso = sc.nextDouble();
        System.out.println("Ingresa tu altura en metros: ");
        double altura = sc.nextDouble();

        double IMC = calculoIMC(peso, altura);

        categoriaIMC(IMC);

        sc.close();

    }

    public static double calculoIMC(double peso, double altura) {

        double IMC = (peso / altura) * (peso / altura);

        return IMC;

    }

    public static void categoriaIMC(double IMC) {

        if (IMC < 18.5) {
            System.out.println("Bajo peso");
        } else if (IMC >= 18.5 && IMC <= 24.9) {
            System.out.println("Peso normal");
        } else if (IMC >= 25 && IMC <= 29.9) {
            System.out.println("Sobrepeso");
        } else if (IMC >= 30 && IMC <= 34.9) {
            System.out.println("Obesidad grado I");
        } else if (IMC >= 35 && IMC <= 39.9) {
            System.out.println("Obesidad grado II");
        } else if (IMC >= 401 && IMC <= 500) {
            System.out.println("Obesidad grado III");
        }
    }
}
