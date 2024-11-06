/*En este reto deberás programar la operación matemática "6 / 2 ( 1 + 2 )" utilizando las instrucciones necesarias.

¿Cuál es el resultado correcto de la operación? ¿1 ó 9?
Explique por que la otra calculadora genera un resultado diferente. */

package Clase02;

public class Ejercicio01 {

    public static void main(String[] args) {

        // Declaramos las Variables
        int num1 = 1,num2 = 2,num3 = 6;

        // Realizamos las Operaciones
        int sum = num1 + num2;
        int div = num3 / num2;
        int mul = div * sum;

        // Mostramos Info
        System.out.println("El resultado es " + mul + " El otro resultado esta mal ya que no sigue la jerarquia de operaciones");
    }
}