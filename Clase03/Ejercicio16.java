/*Escriba un programa que permita ingresar un número mientras estos sean negativos. Detener cuando el número 
ingresado sea positivo y de cómo resultado la cantidad de números negativos ingresados. */

import java.util.Scanner;

public class Ejercicio16 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un numero (Si quiere salir del programa ingrese un valor positivo)");
        int num = entrada.nextInt();
        int numNegativos = 0;

        while (num < 0) {
            numNegativos = ++numNegativos;
            System.out.println("Ingrese otro numero");
            num = entrada.nextInt();
        }

        System.out.println("El numero de numeros negativos ingresados es " + numNegativos);

        entrada.close();
    }
    
}
