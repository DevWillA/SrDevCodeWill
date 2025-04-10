package com.willdev;

import java.util.Collection;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {

        var logger = LoggerFactory.getLogger(Main.class);

        logger.info("Iniciando el sistema de recomendación de películas.");

        var reco = new RecommendationSystem();
        reco.loadMovies(getMovies());

        try (var scanner = new Scanner(System.in)) {
            var exit = false;
            while (!exit) {
                System.out.println("""
                        ----------------------------------------------------
                        Bienvenido al sistema de recomendación de películas.
                        Selecciona una opción:
                        1. Ver todas las peliculas por Genero
                        2. Calcular el totalde votos por Genero
                        3. Recomendar peliculas
                        0. Salir
                        ----------------------------------------------------
                        """);

                var option = getOption(scanner, "Selecciona una opción", 0, 3);

                switch (option) {
                    case 1 -> {
                        showMoviesByGenre(scanner, reco);
                        logger.info("Se han mostrado todas las películas por género.");
                    }
                    case 2 -> {
                        System.out.println("Calcular el total de votos por género");
                        calculateVotesByGenre(reco);
                        logger.info("Se ha calculado el total de votos por género.");
                    }
                    case 3 -> {
                        System.out.println("Recomendar películas");
                        showMovieRecomenadation(scanner, reco);
                        logger.info("Se han recomendado películas.");
                    }
                    case 0 -> {
                        System.out.println("Saliendo...");
                        logger.info("El usuario ha salido del sistema.");
                        exit = true;
                    }
                    default -> {
                        System.out.println("Opción no válida.");
                        logger.warn("Opción no válida: {}", option);
                        waitForEnter(scanner);
                    }
                }
                ;
            }
        }
    }

    private static void calculateVotesByGenre(RecommendationSystem reco) {
        // calcular el total de votos por género
        var genres = reco.getGenres();
        for (var genre : genres) {
            var movies = reco.getMoviesByGenre(genre);
            var totalVotes = movies.stream()
                    .mapToInt(Movie::getVotes)
                    .sum();
            System.out.println("Total de votos para el género " + genre + ": " + totalVotes);
        }
        System.out.println("""
                ----------------------------------------------------
                Fin del listado de votos por género
                ----------------------------------------------------
                """);
        System.out.println("Presiona Enter para continuar...");
        try (var scanner = new Scanner(System.in)) {
            scanner.nextLine();
        }


    }

    private static void showMovieRecomenadation(Scanner scanner, RecommendationSystem reco) {
        System.out.println("""
                ----------------------------------------------------
                Recomendación de películas
                ----------------------------------------------------

                """);
        System.out.println("Selecciona un género:");

        System.out.println("Selecciona un género:");
        var genres = reco.getGenres();
        for (int i = 0; i < genres.size(); i++) {
            System.out.println((i + 1) + ". " + genres.get(i));
        }

        var genre = selectGenre(scanner, reco);

        System.out.println("Películas recomendadas de género " + genre + ":");
        reco.getRecomendationByGenre(genre).forEach(System.out::println);

        waitForEnter(scanner);
    }

    public static String selectGenre(Scanner scanner, RecommendationSystem reco) {
        System.out.println("Selecciona un género:");
        var genres = reco.getGenres();
        for (int i = 0; i < genres.size(); i++) {
            System.out.println((i + 1) + ". " + genres.get(i));
        }

        var option = getOption(scanner, "Seleccione el genero", 1, genres.size());
        return genres.get(--option);
    }

    public static int getOption(Scanner scanner, String message, int min, int max) {

        while (true) {
            try {
                System.out.print("Opción: ");
                var option = Integer.valueOf(scanner.nextLine());

                if (option < min || option > max) {
                    throw new InvalidOptionException();
                }

                return option;
            } catch (NumberFormatException | InvalidOptionException e) {
                System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    private static void showMoviesByGenre(Scanner scanner, RecommendationSystem reco) {
        System.out.println("""

                ----------------------------------------------------
                Listado de Peliculas por Genero
                ----------------------------------------------------

                """);

        var genre = selectGenre(scanner, reco);

        var movies = reco.getMoviesByGenre(genre);
        System.out.println("Películas de género " + genre + ":");
        movies.forEach(System.out::println);

        System.out.println("""
                ----------------------------------------------------
                Fin del listado de películas por género
                ----------------------------------------------------

                """);
        waitForEnter(scanner);

    }

    private static void waitForEnter(Scanner scanner) {
        System.out.println("Presiona Enter para continuar...");
        scanner.nextLine();
    }

    private static Collection<Movie> getMovies() {

        return Set.of(
                new Movie("Extraction", "Acción", 4.1, 120),
                new Movie("Atomic Blonde", "Acción", 4.0, 180),
                new Movie("The Old Guard", "Acción", 3.9, 95),
                new Movie("Nobody", "Acción", 4.2, 140),
                new Movie("Rambo: Last Blood", "Acción", 3.8, 160),
                new Movie("Angel Has Fallen", "Acción", 4.0, 110),
                new Movie("6 Underground", "Acción", 3.7, 150),
                new Movie("Bloodshot", "Acción", 3.6, 130),
                new Movie("Peppermint", "Acción", 4.3, 200),
                new Movie("Hard Kill", "Acción", 3.5, 90),
                new Movie("Vacation Friends", "Comedia", 4.0, 180),
                new Movie("Game Over, Man!", "Comedia", 3.6, 95),
                new Movie("The Wrong Missy", "Comedia", 3.9, 120),
                new Movie("Murder Mystery", "Comedia", 4.2, 140),
                new Movie("Coffee & Kareem", "Comedia", 3.8, 160),
                new Movie("The Lovebirds", "Comedia", 4.1, 150),
                new Movie("Home Sweet Home Alone", "Comedia", 3.7, 100),
                new Movie("Superintelligence", "Comedia", 3.6, 110),
                new Movie("Jexi", "Comedia", 3.8, 200),
                new Movie("Bad Trip", "Comedia", 4.3, 140),
                new Movie("Pieces of a Woman", "Drama", 4.2, 170),
                new Movie("Hillbilly Elegy", "Drama", 4.1, 200),
                new Movie("The Last Letter from Your Lover", "Drama", 4.0, 140),
                new Movie("The Light Between Oceans", "Drama", 3.9, 150),
                new Movie("Penguin Bloom", "Drama", 4.1, 110),
                new Movie("The Dig", "Drama", 4.3, 190),
                new Movie("The Secret: Dare to Dream", "Drama", 3.8, 120),
                new Movie("Fatherhood", "Drama", 4.2, 200),
                new Movie("Finding You", "Drama", 3.7, 100),
                new Movie("Our Friend", "Drama", 4.0, 90),
                new Movie("Outside the Wire", "Ciencia Ficción", 4.1, 180),
                new Movie("Stowaway", "Ciencia Ficción", 4.0, 120),
                new Movie("Infinite", "Ciencia Ficción", 3.9, 150),
                new Movie("Code 8", "Ciencia Ficción", 4.2, 200),
                new Movie("Synchronic", "Ciencia Ficción", 3.8, 140),
                new Movie("Voyagers", "Ciencia Ficción", 3.7, 160),
                new Movie("Cosmic Sin", "Ciencia Ficción", 3.5, 110),
                new Movie("Archive", "Ciencia Ficción", 4.0, 100),
                new Movie("I Am Mother", "Ciencia Ficción", 4.3, 190),
                new Movie("The Midnight Sky", "Ciencia Ficción", 3.7, 130),
                new Movie("The Rental", "Terror", 4.0, 160),
                new Movie("Host", "Terror", 4.2, 110),
                new Movie("Relic", "Terror", 3.9, 95),
                new Movie("The Dark and the Wicked", "Terror", 4.1, 150),
                new Movie("Run", "Terror", 4.3, 190),
                new Movie("The Beach House", "Terror", 3.7, 100),
                new Movie("Come Play", "Terror", 4.0, 170),
                new Movie("No Escape", "Terror", 3.8, 140),
                new Movie("You Should Have Left", "Terror", 3.9, 200),
                new Movie("Amulet", "Terror", 3.6, 120));
    }
}