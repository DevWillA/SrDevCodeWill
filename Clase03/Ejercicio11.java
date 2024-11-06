/*Escriba una función en la que pueda ingresar tres números enteros y diferentes. Imprima estos valores en orden ascendente.
Por ejemplo:

Input : 3 , 100 , 1
Output : 13100
Tenga en cuenta que la respuesta es un texto. Los números los puede concatenar. */

import java.util.Scanner;
import java.math.*;

public class Ejercicio11 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println(" ingrese el primer numero");
        int num1 = Integer.parseInt(entrada.nextLine());
        System.out.println(" ingrese el segundo numero");
        int num2 = Integer.parseInt(entrada.nextLine());
        System.out.println(" ingrese el tercer numero");
        int num3 = Integer.parseInt(entrada.nextLine());
        

        int mayor = Math.max(num3,Math.max(num1, num2));
        int menor = Math.min(num3,Math.max(num1, num2));
        int medio = (num1 + num2 + num3) - (mayor + menor);

        System.out.println("Los valore sque ingreso ordenados en forma ascendente son: "+menor+""+""+medio+""+""+mayor);

    }


    
}
