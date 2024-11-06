/*Escriba un programa que permita ingresar un número e identificar si es par o impar. */

import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un numero");
        int num = entrada.nextInt();

        var mod = num % 2;
       
        if (mod == 0.0) {

            System.out.println("el numero "+ num +" es par");
            
        } else {System.out.println("el numero "+ num +" es impar");}
        


        entrada.close();
    }
    
}
