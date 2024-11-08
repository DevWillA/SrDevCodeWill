/*El promedio de tres números se calcula sumando los tres números y dividiendo el resultado entre 3.

Estructura del Programa:
Crear un método separado que realice el cálculo del promedio.

Interacción con el Usuario:
Pedir al usuario que ingrese tres números.

Mostrar Resultados:
Después de calcular el promedio, mostrar el resultado al usuario en la consola.
Por ejemplo:

Ingresa el primer número: 10
Ingresa el segundo número: 20
Ingresa el tercer número: 30

El promedio de los tres números es: 20.0
Ingresa el primer número: 5
Ingresa el segundo número: 15
Ingresa el tercer número: 25

El promedio de los tres números es: 15.0 */

import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Este programa calcula el promedio de tres numeros");
        System.out.println("Ingresa el primer número: ");   
        int num1 = sc.nextInt();
        System.out.println("Ingresa el segundo número: ");
        int num2 = sc.nextInt();
        System.out.println("Ingresa el tercer número: ");
        int num3 = sc.nextInt();

        System.out.println("El promedio de los tres nuemros es: "+calcularPromedio(num1, num2, num3));
        
    }

    public static double calcularPromedio(int num1,int num2,int num3){

        double promedio;

        promedio = (num1 + num2 + num3) / 3;

        return promedio;
    }
}
