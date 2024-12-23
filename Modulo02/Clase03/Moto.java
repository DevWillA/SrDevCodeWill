public class Moto implements Vehiculo {

    @Override
    public void moverse() {
System.out.println("Moto se mueve");
    }

    @Override
    public int obtenerVelocidad() {
       return 120;
    }

    @Override
    public void cambiarMarcha(int cambio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarMarcha'");
    }

    public void hacerCaballito() {

        System.out.println("Moto hace caballito");
    }



}
