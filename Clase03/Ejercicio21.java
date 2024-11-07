/*Realizar un programa que permita hacer la siguiente conversión:

Millas a kilómetros.
Kilómetros a millas.
Considera que

1 milla son 1.60934 kilómetros
1 kilómetro es 0.621371 millas */

import java.util.Scanner;

public class Ejercicio21 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el tipo de conversión (1 millas a kilómetros, 2 kilómetros a millas)");
        int tipo = entrada.nextInt();

        System.out.println("Ingrese un valor de metraje");
        int valor = entrada.nextInt();

        if (tipo < 1 || tipo > 2) {
            System.out.println("El tipo de conversión no es correcto (1-2)");
        } else if (tipo == 1) {
            System.out.println("La cantidad ingresada es: " + valor + " Millas y esto en kilometros es: "
                    + (valor * 1.60934) + " Kilometros");
        } else if (tipo == 2) {
            System.out.println("La cantidad ingresada es: " + valor + " Kilometros y esto en millas es: "
                    + (valor * 0.621371) + " Millas");
        }
        entrada.close();
    }

}
