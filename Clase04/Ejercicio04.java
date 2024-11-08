/*Un número primo es un número entero mayor que 1 que solo es divisible por 1 y por sí mismo.
Ejemplos de números primos: 2, 3, 5, 7, 11, 13, etc.

Estructura del Programa:
Crear un método separado que realice la verificación de si un número es primo.

Interacción con el Usuario:
Pedir al usuario que ingrese un número entero positivo.

Mostrar Resultados:
Después de verificar si el número es primo, mostrar el resultado al usuario en la consola.
Por ejemplo:

Ingresa un número: 29

El número 29 es primo.
Ingresa un número: 30

El número 30 no es primo. */

import java.util.Scanner;

public class Ejercicio04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero entero positivo");
        int numero = sc.nextInt();

        if (numero < 0) {
            System.out.println("El numero ingresado no es positivo");
        } else if (esPrimo(numero)) {
            System.out.println("El numero " + numero + " es primo");
        } else {
            System.out.println("El numero " + numero + " no es primo");
        }

        sc.close();

    }

    public static boolean esPrimo(int numero) {

        boolean validacion = false;
        int contador = 0;

        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                contador++;
            }

        }

        if (contador == 2) {
            validacion = true;
        }
        return validacion;
    }
}