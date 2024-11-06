/*Escriba un programa que permita ingresar un número y determine si es divisible por dos y siete.
 */

import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un Numero para determinar si es divisible por 2 y 7");
        double num = Double.parseDouble(entrada.nextLine());

        double div2 = num % 2;
        double div7 = num % 7;

        if (div2 == 0 && div7 == 0) {
            System.out.println("El numero " + num + " es divisible por 2 y por 7.");
        } else if (div2 == 0) {
            System.out.println("El numero " + num + " es divisible por 2 pero no por 7.");
        } else if (div7 == 0) {
            System.out.println("El numero " + num + " es divisible por 7 pero no por 2.");
        } else {
            System.out.println("El numero " + num + " no es divisible por 2 ni por 7.");
        }
        entrada.close();
    }

}
