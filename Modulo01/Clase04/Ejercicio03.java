/*El factorial de un número entero positivo n (denotado como n!) es el producto de todos los enteros positivos desde 1 hasta n.
Por ejemplo:

3! = 3 * 2 * 1 = 6
5! = 5 * 4 * 3 * 2 * 1 = 120
Estructura del Programa:
Crear un método separado que realice el cálculo del factorial.

Interacción con el Usuario:
Pedir al usuario que ingrese un número entero positivo.

Mostrar Resultados:
Después de calcular el factorial, mostrar el resultado al usuario en la consola. */

import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero entero positivo");
        int numero = sc.nextInt();

        if (numero < 0) {
            System.out.println("El numero ingresado no es positivo");
        } else {
            int resultado = calculoFactorial(numero);
            System.out.println("El factorial de " + numero + " es: " + resultado);

        }

        sc.close();

    }

    public static int calculoFactorial(int numero) {

        int resultado = 1;

        for (int i = 1; i <= numero; i++) {

            resultado *= i ;
        }
        return resultado;

    }

}
