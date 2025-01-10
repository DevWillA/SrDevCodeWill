package EjercicioAdicional;

public class NotificacionFactory {

    public static Notificacion getNotificacion(TipoNotificacion tipo) {
        switch (tipo) {
            case PUSH:
                return new Push();
            case SMS:
                return new SMS();
            case EMAIL:
                return new Correo();
            default:
                throw new IllegalArgumentException("Tipo de Notificacion Incorrecto");
        }
    }

}
