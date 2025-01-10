import Factory.Forma;
import Factory.FormaFactory;
import Factory.TipoForma;

public class Main {

    public static void main(String[] args) {

        // Singleton
        Logger logger1 = Logger.getInstancia();
        Logger logger2 = Logger.getInstancia();

        logger1.log("Se Imprimio el pasaporte");
        logger2.log("Se Imprimio la historia clinica");

        // Factory
        Forma forma1 = FormaFactory.getForma(TipoForma.CIRCULO);
        forma1.dibujar();
        Forma forma2 = FormaFactory.getForma(TipoForma.RECTANGULO);
        forma2.dibujar();
        Forma forma3 = FormaFactory.getForma(TipoForma.TRIANGULO);
        forma3.dibujar();
    }

}
