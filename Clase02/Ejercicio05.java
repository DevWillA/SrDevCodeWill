
/*El videojuego en el ordenador está viviendo una nueva época de oro con un montón de juegos exclusivos. 
Para comprarte un PC Gamer deberás fijarte principalmente en el procesador, la tarjeta gráfica, la memoria RAM... 
pero sobre todo en los accesorios como el teclado y ratón.

Estás interesado en comprarte un nuevo PC y en la tienda de tu barrio cuesta 660€ con todos los accesorios incluidos. 
Sin embargo, el vendedor te descuenta el 10% por pronto pago ¿Cuánto tienes que pagar en total por el ordenador con todos los accesorios? */


public class Ejercicio05 {
    public static void main(String[] args) {

        double precioPc = 660;

        double PrecioPcProntoPago = precioPc - (precioPc * 0.10);

        System.out.println("PC Gamer con accesorios");
        System.out.println("Precio norma: $"+precioPc);
        System.out.println("Precio Pronto pago: $"+PrecioPcProntoPago);
        
    }
}
