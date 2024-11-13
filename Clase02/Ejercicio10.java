/*Crea un programa que calcule la media aritmética de tres números introducidos por el usuario. */

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el primer numero");
        var num1 = Double.parseDouble(entrada.nextLine());
        System.out.println("Ingrese el segundo numero");
        var num2 = Double.parseDouble(entrada.nextLine());
        System.out.println("Ingrese el tercer numero");
        var num3 = Double.parseDouble(entrada.nextLine());

        var mediaaritmetica = (num1 + num2 + num3) / 3;


        System.out.println("La media aritmetica de los tres numeros ingresados es: "+mediaaritmetica);

        entrada.close();
    }
    
}
