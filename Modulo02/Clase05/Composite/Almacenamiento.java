package Modulo02.Clase05.Composite;

public class Almacenamiento {

    private int capacidad;

    public Almacenamiento(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCapacidad(){
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }


    public void mostrarDetalles() {
       System.out.println("El Almacenamiento es de: " + this.capacidad + " GB");
    }

}
