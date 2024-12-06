/*Escriba un programa que permita ingresar una letra e identifique si es vocal o consonante.
 */

import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese una letra");
        char letra = entrada.nextLine().charAt(0);

        // Pasamos a minuscula para identificar mejor
        letra = Character.toLowerCase(letra);

        if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {

            System.out.println("La letra (" + letra + ") es una vocal");

        } else if (Character.isLetter(letra)) {
            System.out.println("La letra (" + letra + ") es una consonante");

        } else {
            System.out.println("Esto (" + letra + ") no es una letra");
        }

        entrada.close();
    }

}
