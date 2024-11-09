/*Necesitamos generar la tabla de multiplicar de un número dado por el usuario, mostrando los resultados desde 1 hasta 10.

Estructura del Programa:
Crear un método separado que genere y muestre la tabla de multiplicar.
Usa printf para formatear la salida del programa.

Interacción con el Usuario:
Pedir al usuario que ingrese el número para el cual desea generar la tabla de multiplicar.

Mostrar Resultados:
Después de generar la tabla de multiplicar, mostrar los resultados al usuario en la consola.
Por ejemplo::

Ingrese el número para generar la tabla: 15

15 x 1 = 15
15 x 2 = 30
...
15 x 10 = 150
Generación de Tablas de Multiplicar: Crea un método que genere la tabla de multiplicar de un número dado. */

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número (Mayor que el 0) para generar la tabla: ");
        int numero = sc.nextInt();
        if (numero > 1) {
            generarTabla(numero);
        } else {
            System.out.println("Numero Incorrecto");
        }

        sc.close();

    }

    public static void generarTabla(int numero) {

        System.out.println("La tabla del "+numero);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x ", numero);
            System.out.printf("%d =", i);
            System.out.printf(" %d %n", (numero * i));
            
        }

    }

}
