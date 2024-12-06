/*Escribe un programa que convierta una temperatura dada en grados Celsius a grados Fahrenheit y Kelvin. Usa las siguientes fórmulas:

Fahrenheit = Celsius * 9/5 + 32
Kelvin = Celsius + 273.15 */

import java.util.Scanner;

public class Ejercicio09 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el valor de grados celsios para hacer la conversion");
        var celsius = Double.parseDouble(entrada.nextLine());

        var fahrenheit = celsius * 9/5 + 32;
        var kelvin = celsius + 273.15; 

        System.out.println("Temperatura en Fahrenheit: " + fahrenheit + " °F");
        System.out.println("Temperatura en Kelvin: " + kelvin + " K");

        entrada.close();

    }

}
