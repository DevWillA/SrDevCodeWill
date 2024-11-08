/*Un palíndromo es una palabra, frase o secuencia de caracteres que se lee igual de izquierda a derecha que de derecha a izquierda, ignorando espacios, puntuación y mayúsculas.
Ejemplos:

radar
anilina
A man, a plan, a canal, Panama
Estructura del Programa:
Crear un método separado que realice la verificación de si una cadena es un palíndromo.

Interacción con el Usuario:
Pedir al usuario que ingrese una cadena de texto.

Mostrar Resultados:
Después de verificar si la cadena es un palíndromo, mostrar el resultado al usuario en la consola.
Por ejemplo:

Ingresa una cadena de texto: A man, a plan, a canal, Panama

La cadena es un palíndromo.
Ingresa una cadena de texto: Hola

La cadena no es un palíndromo. */

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa una cadena de texto: ");
        String cadena = sc.nextLine();

        // Eliminar espacios, puntuación y mayúsculas
        cadena = cadena.replaceAll("[,\\s]+", "").toLowerCase();

        if (esPalindromo(cadena)) {
            System.out.println("La cadena es un palíndromo.");
        } else {
            System.out.println("La cadena no es un palíndromo.");
        }

        sc.close();
    }

    public static boolean esPalindromo(String cadena) {

        ArrayList<Character> letras = new ArrayList<>();
        ArrayList<Character> letrasRevez = new ArrayList<>();

        // Llenar la lista `letras` con los caracteres de la cadena
        for (int i = 0; i < cadena.length(); i++) {
            letras.add(cadena.charAt(i));
        }

        // Llenar la lista `letrasRevez` con los caracteres de la cadena en orden inverso
        for (int i = cadena.length() - 1; i >= 0; i--) {
            letrasRevez.add(cadena.charAt(i));
        }
        // Comparar ambas listas
        return letras.equals(letrasRevez);
    }

}
