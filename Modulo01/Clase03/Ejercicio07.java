/*Escriba un programa que permita ingresar tres números (representan la longitud de una línea) y compruebe si con estos números se puede formar un triángulo. */

import java.util.Scanner;

public class Ejercicio07 {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el primer numero");
        double num1 = Double.parseDouble(entrada.nextLine());
        System.out.println("Ingrese el segundo numero");
        double num2 = Double.parseDouble(entrada.nextLine());
        System.out.println("Ingrese el tercer numero");
        double num3 = Double.parseDouble(entrada.nextLine());

        if ((num1 + num2) > num3 && (num1 + num3) > num2 && (num3 + num2) > num1) {

            System.out.println("Los tres numeros pueden formar un triangulo");
            
        }else {System.out.println("Los tres numero no pueden formar un triangulo");}

        entrada.close();

    }
    
}
