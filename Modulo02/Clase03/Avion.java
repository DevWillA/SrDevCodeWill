public class Avion implements Vehiculo {

    @Override
    public void moverse() {
        System.out.println("El Avion Vuela");

    }

    @Override
    public int obtenerVelocidad() {
        return 300;
    }

    @Override
    public void cambiarMarcha(int cambio) {

        System.out.println("El Carro cambia marcha por " + cambio);
    }

}
