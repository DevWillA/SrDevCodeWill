package EjercicioAdicional;

public class Bitcoin implements MetodoDePago {

    @Override
    public void procesarPago(double monto) {
        if (validarMonto(monto)) {
            System.out.println("Se proceso el pago con bitcoin");
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
        if (monto >= 0.001) {
            return true;
        } else {
            return false;
        }
    }

}
