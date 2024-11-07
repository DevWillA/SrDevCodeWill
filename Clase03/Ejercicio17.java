/*Escriba un programa que escriba en pantalla los números del 1 al 100 de 5 en 5. */

public class Ejercicio17 {
    public static void main(String[] args) {

        int i = 0;
        while (i <= 100) {
            if (i == 0) {
                System.out.println(i + 1);
            } else {
                System.out.println(i);
            }
            i += 5;
        }

    }

}
