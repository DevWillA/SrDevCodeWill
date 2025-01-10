package Modulo02.Clase05.Composite;

public class Grafica {

    private int capacidad;

    public int getCapacidad(){
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Grafica(int capacidad) {
        this.capacidad = capacidad;
    }

    public void mostrarDetalles() {
       System.out.println("La memoria grafica es de: " + this.capacidad + " GB");
    }

}
