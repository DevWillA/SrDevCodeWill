/*Escribe un programa que solicite al usuario dos números y luego realice las operaciones de suma, resta, 
multiplicación y división con esos números. Muestra los resultados en la consola. */
import java.util.Scanner;

public class Ejercicio07 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Porfavor Ingrese el primer numero");
        var num1 = Double.parseDouble(entrada.nextLine());
        System.out.println("Porfavor Ingrese el segundo");
        var num2 = Double.parseDouble(entrada.nextLine());

        var sum =  num1 + num2;
        var res =  num1 - num2;
        var mul =  num1 * num2;
        var div =  num1 / num2;
        
        System.out.println("La suma de los numeros es: "+sum);
        System.out.println("La resta de los numeros es: "+res);
        System.out.println("La multiplicacion de los numeros es: "+mul);
        System.out.println("La division de los numeros es: "+div);


        entrada.close();
    }
    
}
