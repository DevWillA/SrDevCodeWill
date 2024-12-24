//o	Simula el uso del sistema, creando una lista de diferentes métodos de pago y procesando pagos con cada uno de ellos.
//o	Valida montos antes de procesar un pago.
//o	Imprime los detalles de cada método y el resultado de los pagos.


package EjercicioAdicional;

public class Main {
    public static void main(String[] args) {

        // Crear un objeto de cada tipo de método de pago
        MetodoDePago metodoDePago1 = new Paypal();
        MetodoDePago metodoDePago2 = new TarjetaCredito();
        MetodoDePago metodoDePago3 = new TarjetaRegalo();
        MetodoDePago metodoDePago4 = new Bitcoin();
        
        // Procesar pagos
        metodoDePago1.procesarPago(100);
        System.out.println(metodoDePago1.obtenerDetalles());
        System.out.println(metodoDePago1.validarMonto(100));
        
        metodoDePago2.procesarPago(100);
        System.out.println(metodoDePago2.obtenerDetalles());
        System.out.println(metodoDePago2.validarMonto(100));
        
        metodoDePago3.procesarPago(100);
        System.out.println(metodoDePago3.obtenerDetalles());
        System.out.println(metodoDePago3.validarMonto(100));
        
        metodoDePago4.procesarPago(100);
        System.out.println(metodoDePago4.obtenerDetalles());
        System.out.println(metodoDePago4.validarMonto(100));    

        // Imprimir los resultados
        

    }

}
