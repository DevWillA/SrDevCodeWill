/*Escribe un programa que para un array de tamaño n (dado por el usuario) de números enteros que son ingresados por teclado, realice las siguientes funciones e imprime el resultado en pantalla:

La suma de todos los elementos.
Encontrar el valor máximo
Encontrar el valor mínimo.
Invertir por completo el array.
Ordenar el array de mayor a menor.
Obtener el promedio de los elementos del array.
Encontrar la moda (el número que mas se repite) */

import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del array");
        int tam = sc.nextInt();
        int[] array = new int[tam];
        System.out.println("Ingrese los elementos del array");
        for (int i = 0; i < tam; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("La suma de todos los elementos es: " + sumaArray(array));
        System.out.println("El valor maximo del array es: " + maximoArray(array));
        System.out.println("El valor minimo del array es: " + minimoArray(array));
        System.out.println("El array invertido es: " + invertirArray(array));
        System.out.println("El array ordenado de mayor a menor es: " + ordenarArray(array));
        System.out.println("El promedio de los elementos del array es: " + promedioArray(array));
        System.out.println("La moda del array es: " + modaArray(array));

        sc.close();

    }

    public static int sumaArray(int[] array) {
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return suma;
    }

    public static int maximoArray(int[] array) {
        int maximo = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maximo) {
                maximo = array[i];
            }
        }
        return maximo;
    }

    public static int minimoArray(int[] array) {
        int minimo = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minimo) {
                minimo = array[i];
            }
        }
        return minimo;
    }

    public static int[] invertirArray(int[] array) {
        int[] invertido = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            invertido[i] = array[array.length - i - 1];
        }
        return invertido;
    }

    public static int[] ordenarArray(int[] array) {
        int[] ordenado = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            ordenado[i] = array[i];
        }
        return ordenado;
    }

    public static double promedioArray(int[] array) {
        double promedio = 0;
        for (int i = 0; i < array.length; i++) {
            promedio += array[i];
        }
        promedio = promedio / array.length;
        return promedio;
    }

    public static int modaArray(int[] array) {
        int moda = array[0];
        int contador = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == moda) {
                contador++;
            } else {
                contador = 1;
            }
            if (contador > array.length / 2) {
                moda = array[i];
            }
        }
        return moda;
    }
}
