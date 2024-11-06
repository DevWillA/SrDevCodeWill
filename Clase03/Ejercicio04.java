/*Escriba un programa que permita ingresar una letra e identifique si la letra es mayúscula o minúscula. */

import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese una letra");
        char letra = entrada.nextLine().charAt(0);

        if (Character.isUpperCase(letra)) {
            System.out.println("La letra (" + letra + ") es mayuscula");

        } else if (Character.isLowerCase(letra)) {
            System.out.println("La letra (" + letra + ") es minuscula");

        } else {
            System.out.println("Esto (" + letra + ") no es una letra");
        }

        entrada.close();
    }

}
