package com.ahorcado;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class hangman {

    public static void startGame() {

        var words = List.of("Carro", "Casa");
        var sc = new Scanner(System.in);
        var rnd = new Random();

        var playAgain = false;

        do {
            var word = words.get(rnd.nextInt(words.size())).toUpperCase();

            playGame(word, sc);

            System.out.print("Desea jugar de nuevo? (S/n): ");
            var option = sc.nextLine();
            playAgain = !option.equalsIgnoreCase("N");
        } while (playAgain);
        System.out.println("Hasta Luego");

        sc.close();
    }

    private static void playGame(String word, Scanner sc) {

        var guessed = new ArrayList<Character>();
        var letters = new ArrayList<Character>();
        for (int i = 0; i < word.length(); i++) {

            letters.add('_');

        }

        var errors = 0;
        var endGame = false;
        while (!endGame) {

            showScreen(letters, guessed, errors);

            System.out.print("Ingrese una nueva letra: ");
            var letter = sc.nextLine().toUpperCase().charAt(0);

            if (word.indexOf(letter) != -1) {

                guessed.add(letter);
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter) {
                        letters.set(i, letter);

                    }

                }
            }

            else {
                guessed.add(letter);
                errors++;
            }

            if (errors == 6){
                showScreen(letters, guessed, errors);
                System.out.println("Perdiste");
                endGame = true;
            }
            if (!letters.contains('_')) {
                showScreen(letters, guessed, errors);
                System.out.println("Ganaste");
                endGame = true;
                
            }
        }

        endGame = true;
    }

    private static void showScreen(List<Character> letters, List<Character> guessed, Integer errors) {
        System.out.print("Palabra a adivinar: ");

        for (var letter : letters) {
            System.out.printf("%c ", letter);

        }
        System.out.println();

        System.out.print("Letras intentadas");
        for (var letter : guessed) {
            System.out.printf("%c ", letter);

        }

        System.out.println();

        var draw = switch (errors) {
            default -> """
                    +-----+
                    |     |
                    |
                    |
                    |
                    |
                    |
                    """;
            case 1 -> """
                    +------+
                    |     |
                    |     O
                    |
                    |
                    |
                    |
                    """;
            case 2 -> """
                    +-----+
                    |     |
                    |     O
                    |     |
                    |     |
                    |
                    |
                    """;
            case 3 -> """
                    +-----+
                    |     |
                    |     O
                    |     |\\
                    |     |
                    |
                    |
                    """;
            case 4 -> """
                    +-----+
                    |     |
                    |     O
                    |    /|\\
                    |     |
                    |    
                    |
                    """;
            case 5 -> """
                    +-----+
                    |     |
                    |     O
                    |    /|\\
                    |     |
                    |    / 
                    |
                    """;
            case 6 -> """
                    +-----+
                    |     |
                    |     O
                    |    /|\\
                    |     |
                    |    / \\
                    |
                    """;

        };
        System.out.println(draw);

    }
}