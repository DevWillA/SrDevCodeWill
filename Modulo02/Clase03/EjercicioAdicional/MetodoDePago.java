package EjercicioAdicional;

public interface MetodoDePago {

    void procesarPago(double monto);
    String obtenerDetalles();
    boolean validarMonto(double monto);

}
