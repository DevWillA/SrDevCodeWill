/*Escriba un programa que genere 120 números aleatorios entre -100 y 100. Imprime los siguientes cálculos:

Sumar los valores positivos.
Sumar los valores negativos.
Calcule la media de los números negativos.
Calcule la media de los números positivos.
Cuente la cantidad de ceros. */

import java.math.*;

public class Ejercicio18 {
    public static void main(String[] args) {

        int i = 0;
        int sumaPositivos = 0;
        int sumaNegativos = 0;
        int mediaNegativa = 0;
        int mediaPositiva = 0;
        int conteoNegativa = 0;
        int conteoPositiva = 0;
        int ceros = 0;
        int max = 100;
        int min = -100;

        while (i < 120) {
            int num = min + (int) (Math.random() * ((max - min) + 1));
            if (num > 0) {
                sumaPositivos += num;
                conteoPositiva++;
            } else if (num < 0) {
                sumaNegativos += num;
                conteoNegativa++;
            } else {
                ceros++;
            }
            i++;
        }

        mediaPositiva = sumaPositivos / conteoPositiva;
        mediaNegativa = sumaNegativos / conteoNegativa;

        System.out.println("Suma de los valores positivos: " + sumaPositivos);
        System.out.println("Suma de los valores negativos: " + sumaNegativos);
        System.out.println("Media de los valores negativos: " + mediaPositiva);
        System.out.println("Media de los valores positivos: " + mediaNegativa);
        System.out.println("Cantidad de ceros: " + ceros);

    }

}
