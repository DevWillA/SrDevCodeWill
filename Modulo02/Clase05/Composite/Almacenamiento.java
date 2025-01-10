package Modulo02.Clase05.Composite;

public class Almacenamiento {

    private int capacidad;
    private String tipo;

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
       System.out.println("El Almacenamiento es de tipo: "+ this.tipo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
