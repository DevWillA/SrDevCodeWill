/*Necesitamos calcular la potencia de un número dado una base y un exponente. La fórmula general es resultado = base ^ exponente.
Esto significa que hay que multiplicar la base por si mismo exponente veces.
Por ejemplo:

2 ^ 4 = 2 * 2 * 2 * 2 = 16
5 ^ 2 = 5 * 5 = 25
27 ^ 1 = 27
325 ^ 0 = 1
Recuerda que si el exponente es 0, la potencia es igual a 1.

Estructura del Programa:
Crear un método separado que realice el cálculo de la potencia.

Interacción con el Usuario:
Pedir al usuario que ingrese la base y el exponente.

Mostrar Resultados:
Después de calcular la potencia, mostrar el resultado al usuario en la consola. */

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Ejercicio07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa la base");
        int base = sc.nextInt();
        System.out.println("Ingresa el exponente");
        int exponente = sc.nextInt();

        System.out.println("La potencia de la Base " + base + " y del Exponecial " + exponente + " es: "+calculoPotencias(base,exponente));

        sc.close();

    }

    public static int calculoPotencias(int base, int potencia) {

        int cPotencia = base;

        for (int i = 1; i < potencia; i++) {
            cPotencia *= base;
        }
        return cPotencia;

    }

}
