/*Realice un programa que genere el tablero de ajedrez en consola usando instrucciones de repetición.

| B | N | B | N | B | N | B | N |
| N | B | N | B | N | B | N | B |
| B | N | B | N | B | N | B | N |
| N | B | N | B | N | B | N | B |
| B | N | B | N | B | N | B | N |
| N | B | N | B | N | B | N | B |
| B | N | B | N | B | N | B | N |
| N | B | N | B | N | B | N | B |
donde N representa al cuadro negro y B representa al cuadro blanco. */

public class Ejercicio20 {
    public static void main(String[] args) {

        int columnas = 8;
        int filas = 8;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Si la suma de los dos es par, imprime el caracter B
                // Si es impar, imprime el caracter N
                if ((i + j) % 2 == 0) {
                    System.out.print("| B ");
                } else {
                    System.out.print("| N ");
                }

            }
            // Si es el último elemento de la fila, imprime el caracter |
            System.out.println("|");
        }
    }
}