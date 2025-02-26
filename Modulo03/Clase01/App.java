// Version: 1.0
// Date: 2021-07-07

package Modulo03.Clase01;

import java.util.Scanner;

class App {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.println("Bienvenido a la aplicacion, ingrese una cadena y la pasare a mayusculas");
        var app = new App();

        try {
            var cadena = app.readFromKeyboard(sc);
            System.out.printf("la cadena en mayusculas es: '%s'%n", cadena.toUpperCase());
        } catch (BlankStringException e) {
            System.out.println("Acaba de ocurrir un error " + e.getMessage());
            e.printStackTrace(System.err); // muestra el error
        }
        sc.close();

    }

    private String readFromKeyboard(Scanner sc) throws BlankStringException {
        System.out.println("Ingrese una cadena");
        var cadena = sc.nextLine();
        if (cadena.isBlank()) {
            throw new BlankStringException("La cadena no puede ser vacia");
        }

        return cadena.trim();

    }
}