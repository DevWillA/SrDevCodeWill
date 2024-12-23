public class Carro implements Vehiculo{ 

    @Override
    public void moverse() {
        System.out.println("El Carro se mueve");


    }
    @Override
    public int obtenerVelocidad() {
        return 80;
    }
    @Override
    public void cambiarMarcha(int cambio) {
        System.out.println("El Carro cambia marcha por "+cambio);

    }

}
