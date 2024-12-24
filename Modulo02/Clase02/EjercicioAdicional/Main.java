package EjercicioAdicional;

public class Main {

    public static void main(String[] args) {
        Moto moto = new Moto("Honda", "CBR1000", true);
        Carro carro = new Carro("Audi", "Q3", 4);
        
        
        moto.mostrarDetalles();
        System.out.println("El motor tiene side cars: "+moto.getSideCars());
        carro.mostrarDetalles();
        System.out.println("El carro tiene  "+carro.getNumeroDePuertas()+" puertas");
    }

}
