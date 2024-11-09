/*Interés Simple: El interés se calcula solo sobre el capital inicial durante todo el período.
Interés Compuesto: El interés se calcula sobre el capital inicial más los intereses acumulados en cada período.
Fórmulas de Cálculo:
Interés Simple: La fórmula es I = P * r * t, donde:
I es el interés.
P es el capital inicial.
r es la tasa de interés anual.
t es el tiempo en años.
Interés Compuesto: La fórmula es A = P * (1 + (r / n) ^ (n * t)), donde:
A es el monto total después del tiempo t.
P es el capital inicial.
r es la tasa de interés anual.
n es el número de veces que se aplica el interés compuesto por año.
t es el tiempo en años.
Estructura del Programa:
Crear métodos separados para calcular el interés simple y el interés compuesto.
Puede utilizar la función creada en el ejercicio 7 para calcular los cuadrados en las formulas.

Interacción con el Usuario:
Pedir al usuario que ingrese el capital inicial, la tasa de interés, el tiempo y, en el caso del interés compuesto, el número de veces que se aplica el interés por año.

Mostrar Resultados:
Después de calcular los intereses, mostrar los resultados al usuario en la consola.
Por ejemplo:

Interés Simple
Ingresa el monto de capital: 1000
Ingresa la tasa de interés anual (en porcentaje): 5
Ingresa el tiempo (en años): 3

El interés simple es: 150.0

Interés compuesto
Ingresa el monto de capital: 1000
Ingresa la tasa de interés anual (en porcentaje): 5
Ingresa el tiempo (en años): 3
Ingresa el número de veces que se aplica el interés por año: 4

El monto total después de 3 años es: 1157.6250000000002
El interés compuesto es: 157.62500000000023 */

import java.util.Scanner;

public class Ejercicio09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a la calculadora de intereses");
        System.out.println("¿Qué interes deseas calcular?");
        System.out.println("1. Interes simple");
        System.out.println("2. Interes compuesto");
        System.out.println("3. Salir");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:

                System.out.println("Interes Simple");
                System.out.println("Ingresa el capital");
                double capitalS = Double.parseDouble(sc.nextLine());
                System.out.println("Ingresa el interes anual (No ingresar el simbolo %)");
                double interesAnualS = Double.parseDouble(sc.nextLine()) / 100;
                System.out.println("Ingresa el tiempo en años");
                double tiempoS = Double.parseDouble(sc.nextLine());
                System.out.println("Para el capital solicitado : $" + capitalS);
                System.out.println("A un plazo de " + tiempoS + " Años");
                System.out.println("Con un interes de " + interesAnualS * 100 + "% Anual");
                System.out.println("El interes simple es: $" + calcularInteresSimple(capitalS, interesAnualS, tiempoS));

                break;

            case 2:

                System.out.println("Interes Compuesto");
                System.out.println("Ingresa el capital");
                double capitalC = Double.parseDouble(sc.nextLine());
                System.out.println("Ingresa el interes anual (No ingresar el simbolo %)");
                double interesAnualC = Double.parseDouble(sc.nextLine()) / 100;
                System.out.println("Ingresa el tiempo en años");
                double tiempoC = Double.parseDouble(sc.nextLine());
                System.out.println("Ingresa la cantidad de veces que se aplicara el interes en el año");
                double aplicacionInteresAnualC = Double.parseDouble(sc.nextLine());
                System.out.println("Para el capital solicitado : $" + capitalC);
                System.out.println("A un plazo de " + tiempoC + " Años");
                System.out.println("Con un interes de " + interesAnualC * 100 + "% Anual");
                System.out.println("Este interes se aaplica " + aplicacionInteresAnualC + " veces por Año");
                System.out.println("El monto total después de " + tiempoC + " años es: $" + (capitalC +calcularInteresCompuesto(capitalC, interesAnualC, tiempoC, aplicacionInteresAnualC)));
                System.out.println("El interes Compuesto es: $"
                        + calcularInteresCompuesto(capitalC, interesAnualC, tiempoC, aplicacionInteresAnualC));

                break;

            case 3:
                System.out.println("Saliendo....");
                break;

            default:
                System.out.println("Opcion incorrecta");
                break;
        }

        sc.close();

    }

    public static double calcularInteresSimple(double capitalS, double interesAnualS, double tiempoS) {

        double interesSimple = capitalS * interesAnualS * tiempoS;
        return interesSimple;
    }

    public static double calcularInteresCompuesto(double capital, double interesAnual, double tiempo,
            double aplicacionInteresAnualC) {

        double interesDivVecesAnual = 1 + (interesAnual / aplicacionInteresAnualC);
        double vecesPorTiempo = aplicacionInteresAnualC * tiempo;
        double montoInteresCompuesto = capital * Math.pow(interesDivVecesAnual, vecesPorTiempo);
        double interesCompuesto = montoInteresCompuesto - capital;
        return interesCompuesto;
    }

}
