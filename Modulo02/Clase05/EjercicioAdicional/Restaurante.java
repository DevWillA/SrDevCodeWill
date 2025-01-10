package Modulo02.Clase05.EjercicioAdicional;

public class Restaurante {

    private Cocina cocina;
    private Mesero mesero;
    private Caja caja;  

    public Restaurante() {
        this.cocina = new Cocina();
        this.mesero = new Mesero();
        this.caja = new Caja();
    }

    public void OperarRestaurante() {
        System.out.println("Operacion del Restaurante");
        cocina.prepararPlato();
        mesero.servir();
        caja.procesarPago();
    }

}
