/*Un vendedor al por mayor de camisas ofrece diferentes precios de acuerdo a la cantidad de unidades que le compren. La siguiente tabla muestra la información:

Unidades	Precio por unidad
[1 - 50]	$50.000
(50 - 100]	$45.000
(100 - 150]	$40.000
(150 - 200]	$35.000
> 200	$25.000
Escriba un programa que dado un número de camisas retorne el precio por unidad. */

import java.util.Scanner;

public class Ejercicio09 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        double pCamisas;

        System.out.println("Ingrese el numero de camisas");
        int nCamisas = entrada.nextInt();

        if (nCamisas < 1) {
            System.out.println("El numero de camisas no puede ser menos a 1");

        } else if (nCamisas < 51) {

            pCamisas = nCamisas * 50000;
            System.out.println("El precio por camisa es $50.000, por lo tanto debe pagar: $" + pCamisas);

        } else if (nCamisas <= 100) {

            pCamisas = nCamisas * 45000;
            System.out.println("El precio por camisa es $45.000, por lo tanto debe pagar: $" + pCamisas);

        } else if (nCamisas <= 150) {

            pCamisas = nCamisas * 40000;
            System.out.println("El precio por camisa es $40.000, por lo tanto debe pagar: $" + pCamisas);

        } else if (nCamisas <= 200) {

            pCamisas = nCamisas * 35000;
            System.out.println("El precio por camisa es $35.000, por lo tanto debe pagar: $" + pCamisas);

        } else if (nCamisas > 200) {

            pCamisas = nCamisas * 25000;
            System.out.println("El precio por camisa es $25.000, por lo tanto debe pagar: $" + pCamisas);

        }

        entrada.close();

    }

}
