import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Carro());
        vehiculos.add(new Avion());
        vehiculos.add(new Moto());

        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.moverse();

        }


        Pato pato = new Pato();
        pato.nadar();
        pato.Volador();

    }

}
