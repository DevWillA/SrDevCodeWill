/*Necesitamos convertir unidades de longitud (metros a kilómetros y viceversa) y unidades de masa (gramos a kilogramos y viceversa).

Estructura del Programa:
Crear métodos separados para cada tipo de conversión (metros a kilómetros, kilómetros a metros, gramos a kilogramos, kilogramos a gramos).

Interacción con el Usuario:
Pedir al usuario que ingrese el valor y el tipo de conversión que desea realizar.

Mostrar Resultados:
Después de realizar la conversión, mostrar el resultado al usuario en la consola. */

import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al conversor de medidas");
        System.out.println("1. Conversión de metros a kilómetros");
        System.out.println("2. Conversión de kilómetros a metros");
        System.out.println("3. Conversión de gramos a kilogramos");
        System.out.println("4. Conversión de kilogramos a gramos");
        System.out.println("5. Salir");
        System.out.print("Ingrese la opción deseada: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ingrese la cantidad de metros a convertir a kilometros");
                double metros = sc.nextDouble();
                metrosAKilometros(metros);
                break;

                case 2:
                System.out.println("Ingrese la cantidad de kilometros a convertir a metros");
                double kilometros = sc.nextDouble();
                kilometrosAMetros(kilometros);
                break;

            default:
                break;
        }

    }

    public static void metrosAKilometros(double metros) {
        double kilometros = metros / 1000;
        System.out.println("Son: " + kilometros + " Kilometros");
    }

    public static void kilometrosAMetros(double kilometros) {
        double metros = kilometros * 1000;
        System.out.println("Son: " + metros + " Metros");
    }


}
