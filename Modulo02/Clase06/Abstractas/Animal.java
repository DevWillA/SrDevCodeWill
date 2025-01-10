package Modulo02.Clase06.Abstractas;

abstract class Animal {
    

    private String raza;

    abstract void hacerSonido();

    void dormir(){
        System.out.println("Durmiendo....zZz");
    }
}
