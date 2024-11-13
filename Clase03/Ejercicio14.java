/*Realice un programa en el que ingrese un número y muestre el cubo. Repita el proceso hasta que se introduzca un valor negativo. */

import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un numero (Si quiere salir del programa ingrese un numero negativo)");
        int num = entrada.nextInt();

        while (num >= 0) {
            System.out.println("El cubo de " + num + " es " + Math.pow(num, 3));
            System.out.println("Ingrese otro numero (Si quiere salir del programa ingrese un numero negativo)");
            num = entrada.nextInt();
        }

        entrada.close();

    }

}
