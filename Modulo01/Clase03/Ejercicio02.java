/*Escriba un programa que le permita ingresar tres números e imprima en la consola el más grande de ellos.
 */

import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Escribe el primer numero");
        double num1 = Double.parseDouble(entrada.nextLine());
        System.out.println("Escribe el segundo numero");
        double num2 = Double.parseDouble(entrada.nextLine());
        System.out.println("Escribe el tercer numero");
        double num3 = Double.parseDouble(entrada.nextLine());
        

        double mayor = Math.max(num3,Math.max(num1, num2));

        System.out.println("El numero mayo entre los tres que ingreso es: "+mayor);
        entrada.close();
    }
    
}
