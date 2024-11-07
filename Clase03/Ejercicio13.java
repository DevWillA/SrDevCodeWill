/*Tres hermanos acuerdan reunirse. Los hermanos son identificados por los siguientes números: 1 para el mayor, 2 para el del medio y 3 para el menor.
Cuando llega la hora de la reunión, uno de los hermanos va tarde. Dados los números de los hermanos que llegan a tiempo, determine el número del 
hermano que llegará tarde.
Por ejemplo:

Input : 1 2
Output : 3
El tercer hermano es el el que llegara a la reunión tarde. */

import java.util.Scanner;
import java.math.*;

public class Ejercicio13 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el numero del Hermano que llego Primero");
        int hermano1 = entrada.nextInt();
        System.out.println("Ingrese el numero del Hermano que llego Segundo");
        int hermano2 = entrada.nextInt();

        if (hermano1 < 0 || hermano2 < 0 || hermano1 > 3 || hermano2 > 3) {
            System.out.println("El numero ingresado no es valido (1-3)");

        } else if (hermano1 == hermano2) {
            System.out.println("El numero ingresado  es igual al anterior");

        } else {

            int hermanoTarde = (hermano1 + hermano2) - (1 + 2 + 3);
            System.out.println("El numero del hermano que llegara a la reunión tarde es El hermano " + Math.abs(hermanoTarde));
        }

        entrada.close();

    }

}
