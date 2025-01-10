package Modulo02.Clase05;

public class Procesador {

    private int capacidad;

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Procesador(int capacidad) {
        this.capacidad = capacidad;
    }

    public void mostrarDetalles() {
        System.out.println("el procesador es de: " + this.capacidad + " GHz");
    }

}
