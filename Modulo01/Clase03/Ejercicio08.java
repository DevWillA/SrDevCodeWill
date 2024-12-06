/*Escriba un programa que permita ingresar un número (va a representar la cantidad de años) y de como respuesta la etapa 
en la que se encuentra la persona de acuerdo con la siguiente tabla.

Años	Etapas
0 - 5	Primera infancia
6 - 11	Infancia
12 - 18	Adolescencia
19 - 26	Juventud
27 - 59	Adultez
> 59	Persona mayor */

import java.util.Scanner;

public class Ejercicio08 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese una edad");
        int edad = entrada.nextInt();

        if (edad < 0) {

            System.out.println("Cantidad de años errada..");

        } else if (edad < 6) {
            System.out.println("La etapa en la que se encuentra con esta edad (" + edad + ") es Primera Infancia");

        } else if (edad < 12) {
            System.out.println("La etapa en la que se encuentra con esta edad (" + edad + ") es Infancia");

        } else if (edad < 19) {
            System.out.println("La etapa en la que se encuentra con esta edad (" + edad + ") es Adolescencia");

        } else if (edad < 27) {
            System.out.println("La etapa en la que se encuentra con esta edad (" + edad + ") es Juventud");

        } else if (edad < 60) {
            System.out.println("La etapa en la que se encuentra con esta edad (" + edad + ") es Adultez");

        } else if (edad > 59) {
            System.out.println("La etapa en la que se encuentra con esta edad (" + edad + ") es Persona mayor");

        }

        entrada.close();
    }

}
