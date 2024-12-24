package EjercicioAdicional;

public class TarjetaCredito implements MetodoDePago {

    @Override
    public void procesarPago(double monto) {
        if (validarMonto(monto)) {
            System.out.println("Se proceso el pago con tarjeta credito");
        } else {
            System.out.println("El monto no es valido");
        }
    }

    @Override
    public String obtenerDetalles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerDetalles'");
    }

    @Override
    public boolean validarMonto(double monto) {
        if (monto > 0) {
            return true;
        } else {
            return false;
        }
    }

}
