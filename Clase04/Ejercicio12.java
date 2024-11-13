/*Definir el Problema:
Necesitamos convertir una cantidad de segundos ingresada por el usuario en días, horas, minutos y segundos.

Estructura del Programa:
Crear un método separado que realice la conversión de segundos a días, horas, minutos y segundos.

Interacción con el Usuario:
Pedir al usuario que ingrese la cantidad de segundos.

Mostrar Resultados:
Después de realizar la conversión, mostrar los resultados al usuario en la consola.
Por ejemplo:

Ingresa la cantidad de segundos: 100000

Días: 1
Horas: 3
Minutos: 46
Segundos: 40 */

import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa la cantidad de segundos: ");
        int ss = sc.nextInt();

        convertirSegundos(ss);

        sc.close();
        
    }

    public static void convertirSegundos(int ss) {
        
        int dias = ss / 86400;
        int horas = (ss % 86400) / 3600;
        int minutos = (ss % 3600) / 60;
        int segundos = ss % 60;
        
        System.out.println("Días: " + dias);
        System.out.println("Horas: " + horas);
        System.out.println("Minutos: " + minutos);
        System.out.println("Segundos: " + segundos);
        
    }
    
}
