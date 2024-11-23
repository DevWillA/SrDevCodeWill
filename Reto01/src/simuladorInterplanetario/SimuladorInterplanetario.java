package simuladorInterplanetario;

import java.util.Scanner;

public class SimuladorInterplanetario {

    private static double fuelModificado;
    private static double oxigenoModificado;
    private static double fuel;
    private static double oxigeno;
    private static boolean aumentoRecursos;

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        int destino;
        int eventosSubitos;

        System.out.println("Hola Bienvenido");
        System.out.println("¿Cuál es tu nombre?");
        String nombre = sc.nextLine();
        System.out.println("Hola " + nombre + " Bienvenido al Simulador de Vuelo interplanetario");
        do {
            System.out.println(menuInicial());

            destino = sc.nextInt();

            if (destino < 1 || destino > 7) {
                System.out.println("Destino no válido");
            }
        } while (destino < 1 || destino > 7);

        eventosSubitos = generarEventosAleatorios(distanceKM(destino));

        System.out.println(eventosSubitos);

        System.out.println(calculateDistanceAndTime(destino));

        fuel = calculateFuel(destino);
        oxigeno = calculateOxigen(destino);

        // Asignar valores iniciales
        fuelModificado = fuel;
        oxigenoModificado = oxigeno;

        int opcion;
        aumentoRecursos = false;

        do {
            System.out.println(menuSecond());
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                sc.next(); // Limpiar entrada no válida
            }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    if (!aumentoRecursos) {
                        System.out
                                .println("La cantidad de combustible necesario es: " + fuelModificado + " Kilogramos");
                        System.out.println("La cantidad de oxigeno necesario es: " + oxigenoModificado + " Kilogramos");
                        System.out.println("Es recomendable modificar los recursos de la nave para evitar imprevistos");
                    } else {
                        System.out.println("La cantidad de combustible es: " + fuelModificado + " Kilogramos");
                        System.out.println("La cantidad de oxigeno es: " + oxigenoModificado + " Kilogramos");
                    }
                    break;
                case 2:
                    calculateAumentoRecursos(sc);
                    aumentoRecursos = true;
                    break;
                case 3:
                    System.out.println("La nave se encuentra en optimas condiciones");
                    break;
                case 4:
                    System.out.println(secuenciaDespegue());
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 4);

        for (int i = 0; i < eventosSubitos; i++) {

            
        }
        sc.close();
    }

    private static int generarEventosAleatorios(double distancia) {
        // A mayor distancia, mayor probabilidad de eventos
        double probabilidadEvento = Math.min(1, distancia / 1000.0);
        int eventos = 1 + (int) (Math.random() * 10);

        // Generar eventos aleatorios en base a la probabilidad
        for (int i = 0; i < 10; i++) {
            // Si la probabilidad se cumple, incrementamos el número de eventos
            if (Math.random() < probabilidadEvento) {
                // Aseguramos que el número de eventos no exceda 10
                eventos = Math.min(eventos + 1, 10);
            }
        }

        return eventos;
    }

    private static void calculateAumentoRecursos(Scanner sc) {

        if (!aumentoRecursos) {

            System.out.println(
                    "Recuerde que ya anteriormente hizo un aumento de recursos, por lo tanto se terndran en cuenta los recursos base");
        }
        System.out.println(
                "En cantidad de %, ¿cuánto quiere aumentar el combustible? (Máximo puede aumentar en un 50%)");
        double aumentoC = sc.nextDouble();
        System.out
                .println("En cantidad de %, ¿cuánto quiere aumentar el oxígeno? (Máximo puede aumentar en un 50%)");
        double aumentoO = sc.nextDouble();

        if (aumentoC <= 50 && aumentoO <= 50) {
            fuelModificado = fuel + (fuel * aumentoC / 100);
            oxigenoModificado = oxigeno + (oxigeno * aumentoO / 100);

            System.out.println("La nueva cantidad de combustible es: " + fuelModificado + " Kilogramos");
            System.out.println("La nueva cantidad de oxígeno es: " + oxigenoModificado + " Kilogramos");
        } else {
            System.out.println("El aumento excede el total máximo");
        }
    }

    private static String menuSecond() {
        return """
                ¿Ahora que desea hacer?
                1. Verificar los recursos de la nave
                2. Modificar los recursos de la nave
                3. Verificar el estado de la nave
                4. Iniciar el viaje
                        """;
    }

    private static String secuenciaDespegue() {
        return """
                Inciando Despegue....
                Despegamos en 
                5
                4
                3
                2
                1
                Despegue......
                        """;
    }

    private static String menuInicial() {
        return """
                ¿Cuál es tu destino?
                1. Mercurio
                2. Venus
                3. Marte
                4. Júpiter
                5. Saturno
                6. Urano
                7. Neptuno
                        """;
    }

    private static String planetSelect(int destino) {
        return switch (destino) {
            case 1 -> "Mercurio";
            case 2 -> "Venus";
            case 3 -> "Marte";
            case 4 -> "Júpiter";
            case 5 -> "Saturno";
            case 6 -> "Urano";
            case 7 -> "Neptuno";
            default -> "Opcion aun no creada en este universo";
        };
    }

    private static double distanceKM(int destino) {
        return switch (destino) {
            case 1 -> 91.7;
            case 2 -> 41.4;
            case 3 -> 225;
            case 4 -> 778;
            case 5 -> 1429;
            case 6 -> 2871;
            case 7 -> 4497;
            default -> -1;
        };
    }

    private static double timeDD(int destino) {
        double distancia = distanceKM(destino) * 1e6; // Distancia en kilómetros
        double velocidad = 100000; // Velocidad promedio en km/h
        double tiempoHH = distancia / velocidad;
        return tiempoHH / 24; // Convertir a días
    }

    private static String calculateDistanceAndTime(int destino) {
        if (distanceKM(destino) == -1) {
            return "Opcion aun no creada en este universo, Destino no válido.";
        }

        int tiempoMM = (int) Math.ceil(timeDD(destino) / 30.0); // Redondeo hacia arriba
        return String.format(
                "La distancia a %s es %.1f millones de kilómetros desde la Tierra y el tiempo estimado es de %d meses.",
                planetSelect(destino), distanceKM(destino), tiempoMM);
    }

    private static double calculateFuel(int destino) {
        if (distanceKM(destino) == -1) {
            return 0.0; // No calcular combustible si el destino es inválido
        }

        double deltaV = (distanceKM(destino) * 1e9) / (timeDD(destino) * 24 * 3600); // Delta-V en m/s
        double masaInicial = 50000; // Masa inicial en kg
        double isp = 350; // Impulso específico en segundos
        double g0 = 9.81; // Gravedad en m/s^2

        return masaInicial * (Math.exp(deltaV / (isp * g0)) - 1); // Combustible en kg
    }

    private static double calculateOxigen(int destino) {
        // Consumo promedio de oxigeno de una persona 0.84kg
        // Consideraremos que el viaje lo hace solo una persona
        return timeDD(destino) * 24 * 0.84; // Oxígeno en kilogramos considerando horas
    }
}
