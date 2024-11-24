package simuladorInterplanetario;

import java.util.Scanner;

public class SimuladorInterplanetario {

    private static double fuelModificado;
    private static double oxigenoModificado;
    private static double fuel;
    private static double oxigeno;
    private static boolean aumentoRecursos;
    private static boolean naveFallandoGasolina = false;
    private static boolean naveFallandoOxigeno = false;

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        int destino;
        int nave;
        int eventosSubitos;

        System.out.println("Hola Bienvenido");
        System.out.println("¿Cuál es tu nombre?");
        String nombre = sc.nextLine();
        System.out.println("Hola " + nombre + " Bienvenido al Simulador de Vuelo interplanetario");
        do {
            System.out.println(menuInicial());

            destino = sc.nextInt();
            sc.nextLine(); // Limpia el buffer.

            if (destino < 1 || destino > 7) {
                System.out.println("Destino no válido");
            }
        } while (destino < 1 || destino > 7);

        do {
            System.out.println(menuNaves(destino));
            nave = sc.nextInt();
            sc.nextLine(); // Limpia el buffer.w

            if (nave < 1 || nave > 3) {
                System.out.println("Nave no válida");
            }
        } while (nave < 1 || nave > 3);

        int cantidadTripulantes;

        System.out.println("Vamos a " + planetSelect(destino) + " con una nave " + naveSelect(nave));
        do {
            System.out.println("Este viaje se realizará con cuántas personas?");
            cantidadTripulantes = sc.nextInt();
            if (cantidadTripulantes < 1 || cantidadTripulantes > capacidadNave(nave)) {
                System.out.println("Capacidad no válida. Intente nuevamente.");
            }
        } while (cantidadTripulantes < 1 || cantidadTripulantes > capacidadNave(nave));

        eventosSubitos = calcularEventosAleatorios(distanceKM(destino));
        int eventosCompletados = 0;

        System.out.println(calculateDistanceAndTime(destino, nave));

        fuel = calculateFuel(destino, nave);
        oxigeno = calculateOxigen(destino, nave, cantidadTripulantes);

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
            sc.nextLine(); // Limpia el buffer.

            switch (opcion) {
                case 1:
                    if (!aumentoRecursos) {
                        System.out
                                .println("La cantidad de combustible necesario es: " + fuelModificado + " Kilogramos");
                        System.out.println("La cantidad de oxigeno necesario para " + cantidadTripulantes
                                + " personas es: " + oxigenoModificado + " Kilogramos");
                        System.out.println("Es recomendable modificar los recursos de la nave para evitar imprevistos");
                    } else {
                        System.out.println("La cantidad de combustible es: " + fuelModificado + " Kilogramos");
                        System.out.println("La cantidad de oxigeno necesario para " + cantidadTripulantes
                                + " personas es: " + oxigenoModificado + " Kilogramos");
                    }
                    break;
                case 2:
                    calculateAumentoRecursos(sc, cantidadTripulantes);
                    aumentoRecursos = true;
                    break;
                case 3:
                    System.out.println("La nave se encuentra en optimas condiciones");
                    break;
                case 4:
                    String[] secuencia = secuenciaDespegue();

                    for (String mensaje : secuencia) {
                        System.out.println(mensaje);
                        try {
                            Thread.sleep(2000); // Pausa de 2 segundo
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 4);


        for (int etapa = 1; etapa <= 10; etapa++) {

            boolean etapaValida = consultarEtapa(etapa, eventosCompletados, eventosSubitos);

            if (!etapaValida) {
                int randomValue = (Math.random() < 0.5) ? 1 : 2;

                if (randomValue == 1) {
                    eventoSubitoFallaSistema(sc);
                } else {
                    eventoSubitoAsteroides(sc);
                }
            }

            if (etapa == 1) {

                System.out.println("Salimos de la Tierra");
                System.out.println("La nave se encuentra en optimas condiciones");
                System.out.println("Precione enter para continuar");
                sc.nextLine();
            }

            // Verifica si los recursos son suficientes para continuar con la etapa
            if (!validarRecursos(fuelModificado, oxigenoModificado)) {
                break; // Si los recursos no son suficientes, termina el viaje
            }

            System.out.println("""
                                             _______________
                        -----------------   |        ___    \\
                        ----------------    |       |   |     \\
                        ----------------    |       |___|     /
                        -----------------   |_______________/
                    """);

            System.out.println("El proceso del viaje es " + etapa + "0%");
            if (naveFallandoGasolina) {
                // Si la nave está fallando, se pierde un 5% de combustible.
                fuelModificado = fuel - (fuel * etapa / 10) - (fuel * 0.05);
                System.out.println("La nave está fallando y esta perdiendo un 5% de combustible.");
            } else {
                fuelModificado = fuel - (fuel * etapa / 10);
            }

            if (naveFallandoOxigeno) {
                // Si la nave está fallando, se pierde un 5% de oxígeno.
                oxigenoModificado = oxigeno - (oxigeno * etapa / 10) - (oxigeno * 0.05);
                System.out.println("La nave está fallando y esta perdiendo un 5% de oxigeno.");

            } else {
                oxigenoModificado = oxigeno - (oxigeno * etapa / 10);
            }
            double porcentajeCombustible = (fuelModificado / fuel) * 100;
            double porcentajeOxigeno = (oxigenoModificado / oxigeno) * 100;

            System.out.println("El combustible consumido es " + (fuel * etapa / 10) + " kilogramos. Aun nos quedan "
                    + porcentajeCombustible + "% de combustible.");
            System.out.println("El oxigeno consumido es " + (oxigeno * etapa / 10) + " kilogramos. Aun nos quedan "
                    + porcentajeOxigeno + "% de oxigeno.");

            System.out.println("Precione enter para continuar");
            sc.nextLine();

        }

        if (!validarRecursos(fuelModificado, oxigenoModificado)) {
            System.out.println("Mision abortada, no hay suficiente combustible o oxígeno para continuar");
        } else {
            System.out.println("Proceso completado, llegamos a " + planetSelect(destino));
        }
        sc.close();
    }

    // Esta función se encarga de validar si los recursos (combustible y oxígeno)
    // son suficientes para la siguiente etapa.
    private static boolean validarRecursos(double fuelModificado, double oxigenoModificado) {
        if (fuelModificado <= 0) {
            System.out.println("¡Alerta! El combustible se ha agotado antes de tiempo. ¡La nave se detendrá!");
            return false; // Retorna false si el combustible se ha agotado
        }

        if (oxigenoModificado <= 0) {
            System.out.println("¡Alerta! El oxígeno se ha agotado antes de tiempo. ¡La nave se detendrá!");
            return false; // Retorna false si el oxígeno se ha agotado
        }

        return true; // Si los recursos están bien, continúa
    }

    private static boolean consultarEtapa(int etapa, int eventosCompletados, int eventosSubitos) {

        if (eventosCompletados < eventosSubitos) {
            return Math.random() > 0.5; // Simula si una etapa es válida (50% de probabilidades de fallar)
        } else {
            return true;
        }
    }

    private static int calcularEventosAleatorios(double distancia) {
        // A mayor distancia, mayor probabilidad de eventos
        double probabilidadEvento = Math.min(1, distancia / 5000.0);
        int eventos = 1; // Comenzamos con al menos un evento

        // Generar eventos aleatorios basados en la probabilidad
        for (int i = 0; i < 7; i++) {
            if (Math.random() < probabilidadEvento) {
                eventos++;
            }
        }

        // Limitar el número total de eventos a un máximo de 7
        return Math.min(eventos, 7);
    }

    private static int velocidadNave(int nave) {
        return switch (nave) {
            case 1 -> 100000;
            case 2 -> 89000;
            case 3 -> 80000;
            default -> -1;
        };
    }

    private static int capacidadNave(int nave) {
        return switch (nave) {
            case 1 -> 3;
            case 2 -> 2;
            case 3 -> 4;
            default -> -1;
        };
    }

    private static void eventoSubitoFallaSistema(Scanner sc) {

        int opcion;
        double porcentajeOxigenoPerdido = 0.05; // 5% de oxígeno perdido por cada etapa.
        double oxigenoExtra = 0; // Para almacenar la cantidad de oxígeno perdido.

        System.out.println("""
                   +----------------------------------+
                   |  ⚠️  SYSTEM FAILURE DETECTED  ⚠️  |
                   |----------------------------------|
                   |        ERROR CODE: 503           |
                   |   CRITICAL SYSTEM MALFUNCTION    |
                   |                                  |
                   |  REBOOT IMMEDIATELY OR CONTACT   |
                   |        TECHNICAL SUPPORT         |
                   +----------------------------------+

                        [!!] SYSTEM SHUTTING DOWN...
                """);

        do {
            System.out.println("Evento subito: Fallo del sistema");
            System.out.println("Que acción tomar?");
            System.out.println("1. Reparar fallo");
            System.out.println("2. Seguir con la nave fallando");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpia el buffer.

            if (opcion != 1 && opcion != 2) {
                System.out.println("Opción no válida");

            }
        } while (opcion != 1 && opcion != 2);

        if (opcion == 1) {
            System.out.println("Fallo reparado");
            System.out.println("La reparacion retrazo la nave");
            double tiempoReparacion = (int) (Math.random() * 100);
            System.out.println("Tiempo de reparación: " + tiempoReparacion + " minutos");

            // Durante la reparación, se pierde un porcentaje de oxígeno.
            oxigenoExtra = (oxigeno * porcentajeOxigenoPerdido); // 5% de oxígeno durante la reparación.
            oxigenoModificado -= oxigenoExtra; // Reducimos el oxígeno disponible.

            System.out.println("Oxígeno consumido durante la reparación: " + oxigenoExtra );
            System.out.println("Oxígeno restante: " + oxigenoModificado + "%");
        } else {
            System.out.println("Nave fallando");
            // La nave pierde un 5% de oxígeno por el fallo.
            oxigenoExtra = (oxigeno * porcentajeOxigenoPerdido); // 5% de oxígeno perdido por fallo.
            oxigenoModificado -= oxigenoExtra; // Reducimos el oxígeno disponible.

            System.out.println("Oxígeno consumido debido al fallo: " + oxigenoExtra );
            System.out.println("Oxígeno restante: " + oxigenoModificado);

            // Si la nave sigue fallando, pierde otro 5% de oxígeno.
            oxigenoExtra = (oxigeno * porcentajeOxigenoPerdido); // Otro 5% de oxígeno.
            oxigenoModificado -= oxigenoExtra; // Reducimos el oxígeno disponible.

            System.out.println("Oxígeno adicional consumido por el fallo continuo: " + oxigenoExtra);
            System.out.println("Oxígeno restante: " + oxigenoModificado);
            naveFallandoOxigeno = true; // Marcamos que la nave está fallando.
        }

        // Si el oxígeno se agota o está en niveles bajos, puedes incluir una condición
        // para manejar la emergencia.
        if (oxigenoModificado <= 0) {
            System.out.println("¡Atención! El oxígeno se ha agotado. La nave está en peligro crítico.");
            // Aquí podrías finalizar la misión o ejecutar alguna lógica de emergencia.
        }
    }

    private static void eventoSubitoAsteroides(Scanner sc) {
        int opcion;
        int opcion2;
        double gasolinaExtra = 0; // Para almacenar la gasolina perdida.
        double porcentajePerdida = 0.05; // El 5% de gasolina que se pierde por cada etapa de fallo.
        System.out.println("""
                   *  o     *    .   o
                     .   *     o     .
                  .   .    O   .  *    o
                   o   *   .     *   .
                 *   .   o   *  o    *
                     o   *    .    *
                  .  *  o    .   *
                """);
        do {
            System.out.println("Evento subito: Asteroides");
            System.out.println("¿Qué acción tomar?");
            System.out.println("1. Tomar ruta nueva");
            System.out.println("2. Atravesar");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpia el buffer.

            if (opcion != 1 && opcion != 2) {
                System.out.println("Opción no válida");
            }
        } while (opcion != 1 && opcion != 2);

        if (opcion == 1) {
            // Si se elige atravesar asteroides, se gasta gasolina.
            gasolinaExtra = (Math.random() * 50); // El gasto de gasolina por atravesar los asteroides.
            System.out.println("El evento de asteroides ha consumido: " + gasolinaExtra + " Kilogramos de gasolina.");
            fuelModificado -= gasolinaExtra; // Reducimos el combustible.
        } else if (opcion == 2) {
            // Si se decide atravesar los asteroides, también se puede generar un fallo.
            System.out.println("Atravesando Asteroides");
            boolean azar = Math.random() > 0.5; // Determina si el atravesar los asteroides es exitoso o no.

            if (azar) {
                System.out.println("Atravesando sin problemas");
            } else {
                System.out.println("Atravesando con problemas");
                do {
                    System.out.println("Se presenta un fallo en la nave");
                    System.out.println("¿Qué acción tomar?");
                    System.out.println("1. Reparar fallo");
                    System.out.println("2. Seguir con la nave fallando");
                    opcion2 = sc.nextInt();
                    sc.nextLine(); // Limpia el buffer.

                    if (opcion2 != 1 && opcion2 != 2) {
                        System.out.println("Opción no válida");
                    }
                } while (opcion2 != 1 && opcion2 != 2);

                if (opcion2 == 1) {
                    // Si se repara, se pierde menos gasolina que si la nave sigue fallando.
                    System.out.println("Fallo reparado");
                    System.out.println("La reparación retrasó la nave, pero no pierde más gasolina.");
                    gasolinaExtra = (Math.random() * 30); // Se pierde menos gasolina en reparación.
                    System.out.println("Gasolina consumida en la reparación: " + gasolinaExtra + " Kilogramos.");
                    fuelModificado -= gasolinaExtra; // Reducimos el combustible.
                } else {
                    // Si sigue fallando, se pierde un 5% adicional de gasolina.
                    System.out.println("Nave fallando");
                    gasolinaExtra = (fuelModificado * porcentajePerdida); // Se pierde un 5% de la gasolina actual.
                    System.out.println("Gasolina perdida por fallo: " + gasolinaExtra + " Kilogramos.");
                    fuelModificado -= gasolinaExtra; // Reducimos el combustible.
                    naveFallandoGasolina = true; // Marcamos que la nave está fallando.
                }
            }
        }

        // Mostrar el resultado final de la gasolina.
        System.out.println("El combustible restante es: " + fuel + " Kilogramos.");

        // Si el combustible se agota o está en niveles bajos, puedes incluir una condición
        // para manejar la emergencia.
        if (fuelModificado <= 0) {
            System.out.println("¡Atención! El combustible se ha agotado. La nave está en peligro crítico.");
            // Aquí podrías finalizar la misión o ejecutar alguna lógica de emergencia.
        }
    }

    private static String menuNaves(int destino) {

        System.out.println("Para su viaje a " + planetSelect(destino) + " necesitamos una nave.");

        return """
                ¿Qué tipo de nave desea?
                1. Nave: Star Voyager | Capacidad: 3 personas | Velocidad: 100000 km/h
                2. Nave: Cosmo Cruiser | Capacidad: 2 personas | Velocidad: 89000 km/h
                3. Nave: Galaxy Explorer | Capacidad: 4 personas | Velocidad: 80000 km/h
                        """;

    }

    private static String naveSelect(int nave) {
        return switch (nave) {
            case 1 -> "Star Voyager";
            case 2 -> "Cosmo Cruiser";
            case 3 -> "Galaxy Explorer";
            default -> "Opcion aun no creada en este universo";
        };
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

    private static String[] secuenciaDespegue() {
        return new String[] {
                "Iniciando Despegue....",
                "Despegamos en",
                "5",
                "4",
                "3",
                "2",
                "1",
                "Despegue......"
        };
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

    private static void calculateAumentoRecursos(Scanner sc, int cantidadTripulantes) {

        if (aumentoRecursos) {

            System.out.println(
                    "Recuerde que ya anteriormente hizo un aumento de recursos, por lo tanto se tendran en cuenta los recursos base");
        }
        System.out.println(
                "En cantidad de %, ¿cuánto quiere aumentar el combustible? (Máximo puede aumentar en un 30%)");
        double aumentoC = sc.nextDouble();
        System.out
                .println("En cantidad de %, ¿cuánto quiere aumentar el oxígeno? (Máximo puede aumentar en un 30%)");
        double aumentoO = sc.nextDouble();

        if (aumentoC <= 30 && aumentoO <= 30) {
            fuelModificado = fuel + (fuel * aumentoC / 100);
            oxigenoModificado = oxigeno + (oxigeno * aumentoO / 100);

            System.out.println("La nueva cantidad de combustible es: " + fuelModificado + " Kilogramos");
            System.out.println("La nueva cantidad de oxígeno para " + cantidadTripulantes + " personas es: "
                    + oxigenoModificado + " Kilogramos");
        } else {
            System.out.println("El aumento excede el total máximo");
        }
    }

    private static double timeDD(int destino, int nave) {
        double distancia = distanceKM(destino) * 1e6; // Distancia en kilómetros
        double velocidad = velocidadNave(nave); // Velocidad promedio en km/h
        double tiempoHH = distancia / velocidad;
        return tiempoHH / 24; // Convertir a días
    }

    private static String calculateDistanceAndTime(int destino, int nave) {
        if (distanceKM(destino) == -1) {
            return "Opcion aun no creada en este universo, Destino no válido.";
        }

        int tiempoMM = (int) Math.ceil(timeDD(destino, nave) / 30.0); // Redondeo hacia arriba
        return String.format(
                "La distancia a %s es %.1f millones de kilómetros desde la Tierra y el tiempo estimado es de %d meses.",
                planetSelect(destino), distanceKM(destino), tiempoMM);
    }

    private static double calculateFuel(int destino, int nave) {
        if (distanceKM(destino) == -1) {
            return 0.0;
        }

        double distanciaMillonesKM = distanceKM(destino);
        double consumoBasePorMillonKM = 500;
        double factorVelocidad = velocidadNave(nave) / 100000.0; // Ajuste basado en velocidad (normalizado con 100,000
                                                                 // km/h)

        return distanciaMillonesKM * consumoBasePorMillonKM * factorVelocidad;
    }

    private static double calculateOxigen(int destino, int nave, int cantidadTripulantes) {
        // Consumo promedio de oxigeno de una persona 0.84kg
        return cantidadTripulantes * timeDD(destino, nave) * 24 * 0.84; // Oxígeno en kilogramos considerando horas
    }
}
