/*Necesitamos convertir temperaturas de Celsius a Fahrenheit y viceversa.
Operaciones para las conversiones:

Celsius a Fahrenheit: La fórmula es F = (C * (9 / 5)) + 32.
Fahrenheit a Celsius: La fórmula es C = (F - 32) / (9 / 5).
Estructura del Programa:
Crear métodos separados para cada conversión.

Interacción con el Usuario:
Pedir al usuario que ingrese la temperatura y el tipo de conversión que desea realizar.

Mostrar Resultados:
Mostrar el resultado de la conversión.
Por ejemplo:

temperatura en Celsius: 25

La temperatura en Fahrenheit es: 77.0
Ingresa la temperatura en Fahrenheit: 77

La temperatura en Celsius es: 25.0 */

import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa la opcion del menu:");
        System.out.println("1. Celsius a Fahrenheit");
        System.out.println("2. Fahrenheit a Celsius");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:

                celsiusAFahrenheit(sc);
                break;

            case 2:

                fahrenheitACelsius(sc);
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
        sc.close();
    }

    public static void celsiusAFahrenheit(Scanner sc) {

        System.out.println("Ingrese la tempratura en Celsius: ");
        int temperatura = sc.nextInt();
        double fahrenheit = (temperatura * 1.8) + 32;
        System.out.println("La temperatura en Fahrenheit es: " + fahrenheit);
    }

    public static void fahrenheitACelsius(Scanner sc) {
        System.out.println("Ingrese la tempratura en fahrenheit: ");
        int temperatura = sc.nextInt();
        double celsius = (temperatura - 32) / 1.8;
        System.out.println("La temperatura en Celsius es: " + celsius);
    }

}
