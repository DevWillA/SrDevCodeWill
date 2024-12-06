/*Realizar un programa que imprima un diamante usando caracteres de texto. El programa debe pedir al usuario el tamaño del diamante, 
el cual debe ser un número entero positivo impar. Ej:

Si tamaño es: 3
 *
***
 *
Si tamaño es: 7
   *
  ***
 *****
*******
 *****
  ***
   *
Ten en cuenta que la linea de asteriscos (*) de la fila central es la mas grande y debe estar alineada a la parte izquierda de 
la pantalla y debe tener del tamaño del número dado. El resto de las lineas deben quedar los asteriscos centrados teniendo como 
base la linea central. En caso de que el número ingresado no sea válido, se le debe informar el usuario el caso que no está cumpliendo. */

import java.util.Scanner;

public class Ejercicio23 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el valor con el cual haremos el diamante, debe ser positivo e impar");
        int num = entrada.nextInt();

        int div = Math.abs(num / 2);

        System.out.println(div);

        if (num % 2 != 0 || num > 0) {

            // Parte superior
            for (int i = 0; i <= div; i++) {
                for (int j = 0; j < div - i; j++) {
                    System.out.print(" ");
                }
                for (int k = 0; k < 2 * i + 1; k++) {
                    System.out.print("*");
                }
                System.out.println();

            }
             // Parte superior
             for (int i = div -1; i >= 0; i--) {
                for (int j = 0; j < div - i; j++) {
                    System.out.print(" ");
                }
                for (int k = 0; k < 2 * i + 1; k++) {
                    System.out.print("*");
                }
                System.out.println();

            }
        } else {
            System.out.println("El numero ingresado no es valido (debe ser positivo e impar)");
        }
        entrada.close();

    }

}
