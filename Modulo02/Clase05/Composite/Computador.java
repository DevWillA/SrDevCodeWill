package Modulo02.Clase05.Composite;

public class Computador {
    private TarjetaMadre tarjetaMadre;

    public Computador() {
        this.tarjetaMadre = new TarjetaMadre();
    }

    public void mostrarConfiguracion() {
        System.out.println("Configuracion del Computador");
        tarjetaMadre.getMotherBoardComponets();
        
    }

}
