package Modulo02.Clase05.Composite;

public class TarjetaMadre {

    private Procesador procesador;
    private Memoria memoria;
    private Almacenamiento almacenamiento;
    private Grafica grafica;

    public TarjetaMadre() {

        this.almacenamiento = new Almacenamiento(0);
        this.grafica = new Grafica(0);
        this.memoria = new Memoria(0);
        this.procesador = new Procesador(0);
    }

    public void getMotherBoardComponets(){
        System.out.println("Componentes de la Tarjeta Madre");
        almacenamiento.mostrarDetalles();
        grafica.mostrarDetalles();
        memoria.mostrarDetalles();
        procesador.mostrarDetalles();
    }

}
