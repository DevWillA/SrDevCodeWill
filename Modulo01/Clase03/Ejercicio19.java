/*Esta sucesión comienza con los números 0 y 1. El siguiente miembro se calcula como la suma de los dos inmediatamente anteriores.
Crea un programa reciba un número (N) del usuario y muestre los primeros N números de sucesión. */

import java.util.Scanner;

public class Ejercicio19 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un numero que re resentacara la cantidad de numero de la sucecion");
        int num = entrada.nextInt();

        int num1 = 0;
        int num2 = 1;
        int sumNum = 0;

        String numeros = num1+","+num2;

        for (int i = 0; i < num; i++) {
            sumNum = num1 + num2;
            numeros += "," +sumNum;
            num1 = num2;
            num2 = sumNum;
        }

        System.out.println(numeros);

        entrada.close();

        
    }
    
}
