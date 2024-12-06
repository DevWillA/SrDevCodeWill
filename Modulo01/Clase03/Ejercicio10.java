/*Escriba una función en la que ingrese un número entero entre 1 y 12. Este número corresponde con un mes
(1 enero, 2 febrero, ..., 12 diciembre). El resultado debe ser el número de días del mes ingresado.
Ejemplo:

Input : 12
Output : 31
A continuación encuentras la cantidad de días que tienen cada mes.

Mes	Días
1, 3, 5, 7, 8, 10 y 12 =	31
4, 6, 9, 11	= 30
2	= 28 */

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Escriba un numero del 1 al 12 que correspondera a cada mes del año");
        int numM = entrada.nextInt();

        if (numM < 1 || numM > 12) {
            System.out.println("El numero ingresado no esta en el rango (1 al 12).");
        } else if (numM == 2) {
            System.out.println("El mes que corresponde el numero (" + numM + ") contiene 28 dias");
        } else if (numM == 4 || numM == 6 || numM == 9 || numM == 11) {
            System.out.println("El mes que corresponde el numero (" + numM + ") contiene 30 dias");
        } else {
            System.out.println("El mes que corresponde el numero (" + numM + ") contiene 31 dias");
        }
        entrada.close();
    }

}
