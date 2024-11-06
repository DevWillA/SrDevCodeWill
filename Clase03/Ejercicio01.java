
/*Escriba un programa que permita ingresar un número real e identifique si el número es negativo, positivo o cero. */

import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el numero real para identificar si es negativo positivo o cero");
        int num = entrada.nextInt();

        if (num > 0) {

            System.out.println("El numero " + num + " es Positivo");

        } else if (num < 0) {

            System.out.println("El numero " + num + " es Negativo");

        } else {

            System.out.println("El numero es Cero");
        }

        entrada.close();

    }

}
