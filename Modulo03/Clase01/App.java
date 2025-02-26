public package Modulo03.Clase01;

import java.util.Scanner;

class App {

    public static void main(String[] args) {
            var sc = new Scanner(System.in);

    System.out.println("Bienvenido a la aplicacion, ingrese una cadena y la pasare a mayusculas");
    var app = new App();
    var cadena = app.readFromKeyboard(sc);
    System.out.printf("la cadena en mayusculas es: '%s'%n", cadena.toUpperCase());

    sc.close();

    }

    private String readFromKeyboard(Scanner sc)  throws BlankStringException {
        System.out.println("Ingrese una cadena");
        var cadena = sc.nextLine();
        if (cadena.isBlank()) {
            throw new BlankStringException("La cadena no puede ser vacia");
        }

        
        return sc.nextLine();


        
    }
}