package EjercicioAdicional;

public class Moto extends Vehiculos {   
    private boolean sideCars;

    public Moto(String marca, String modelo, boolean sideCars) {
        super(marca, modelo, 0);
        this.sideCars = sideCars;
        
    }

    public boolean getSideCars() {
        return sideCars;
    }

}
