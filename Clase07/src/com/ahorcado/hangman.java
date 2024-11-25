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

            playGame(word);

            System.out.print("Desea jugar de nuevo? (S/n): ");
            var option = sc.nextLine();
            playAgain = !option.equalsIgnoreCase("N");
        } while (playAgain);
        System.out.println("Hasta Luego");
    }

    private static void playGame(String word) {

        var guessed = new ArrayList<Character>();
        var letters = new ArrayList<Character>();
        for (int i = 0; i < word.length(); i++) {

            letters.add('_');

        }

        var errors = 0;
        var endGame = false;
        while (!endGame) {

            showScreen(letters, guessed);

            endGame = true;
        }
    }

    private static void showScreen(List<Character> letters, List<Character> guessed) {
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

    }
}