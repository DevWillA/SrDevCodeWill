/*Crea un programa que calcule el área y el perímetro de un rectángulo. Solicita al usuario la longitud y el ancho del rectángulo. */

import java.util.Scanner;

public class Ejercicio08 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingresa la longitud del rectangulo");
        var longitud = Double.parseDouble(entrada.nextLine());
        System.out.println("Ingresa la ancho del rectangulo");
        var ancho = Double.parseDouble(entrada.nextLine());

        var area = longitud * ancho;
        var perimetro = 2 * (longitud + ancho);

        System.out.println("El area del rectangulo es: " + area);
        System.out.println("El perimetro del rectangulo es: " + perimetro);

        entrada.close();
    }
}