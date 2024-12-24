public class Pato implements Nadador, Volador {

    @Override
    public void Volador() {
        System.out.println("El pato esta nadando");
    }

    @Override
    public void nadar() {
        System.out.println("El pato esta volando");
    }

}
