package Modulo02.Clase05.Composite;

public class Computador {
    private TarjetaMadre tarjetaMadre;

    public Computador() {
        this.tarjetaMadre = new TarjetaMadre(1000,16,4,8,12);
        tarjetaMadre.registrarTipoDiscoDuro("SSD");
    }

    public void mostrarConfiguracion() {
        System.out.println("Configuracion del Computador");
        tarjetaMadre.getMotherBoardComponets();
        
    }

}
