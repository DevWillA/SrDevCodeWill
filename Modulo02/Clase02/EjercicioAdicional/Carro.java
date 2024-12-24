package EjercicioAdicional;

public class Carro extends Vehiculos {
    private int numeroDePuertas;

    public Carro(String marca, String modelo, int numeroDePuertas) {
        super(marca, modelo, 0);
        this.numeroDePuertas = numeroDePuertas;
        
    }

    public int getNumeroDePuertas() {
        return numeroDePuertas;
    }

}
