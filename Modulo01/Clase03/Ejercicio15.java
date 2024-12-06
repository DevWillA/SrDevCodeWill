/*Escriba un programa en el que ingrese un número y le diga si es positivo o negativo. Repita el proceso hasta que se ingrese el número cero. */
import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un numero (Si quiere salir del programa ingrese cero)");
        int num = entrada.nextInt();
        
        while (num != 0) {
            if (num > 0) {
                System.out.println("El numero es positivo");
            } else {
                System.out.println("El numero es negativo");
            }
            System.out.println("Ingrese otro numero");
            num = entrada.nextInt();
        }

        entrada.close();
        
    }
    
}
