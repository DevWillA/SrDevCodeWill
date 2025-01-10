package EjercicioAdicional;

public class Correo implements Notificacion{

    @Override
    public void enviar() {
        System.out.println("Envio de Correo");
    }

}
