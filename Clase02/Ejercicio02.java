/*En el mercado, podemos encontrar que el precio del producto Pernil Iberic D'Engreix Llen. Azuaga en porción de 100 gramos cuesta 5,95€ y el vendedor nos dice que el precio por kilo cuesta 29,75€. ¿Crees que es correcto el precio?

En este reto tienes que hacer un programa que calcule correctamente el precio por kilo del producto. */

public class Ejercicio02 {
    public static void main(String[] args) {
        System.out.println("El precio del Pernil Iberic D'Engreix Llen. 100 Gr $5,95");

        // Calculamos el precio por Gramos
        var precioXGramo = 5.95d/100;

        // Mostramos Info y multiplicamos el precio por gramo * 1000 para hallar el valor del kilo
        System.out.println("El precio de un kilo es: $"+precioXGramo *1000);
    }
}
