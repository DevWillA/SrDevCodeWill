package Modulo02.Clase06.Abstractas;

public class Perro extends Animal {

    @Override
    void hacerSonido() {
        System.out.println("ladrar");
    }

    void rascarse() {
        System.out.println("Rasacandose");
    }


}
