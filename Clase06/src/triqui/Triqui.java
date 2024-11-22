package triqui;

import triqui.Triqui;
import java.util.Scanner;

public class Triqui {
    public static void startGame() {

        // identificaamos el primer jugador X u O
        // Incializar y mostart el tablero
        // Leer el moviemitno del jugador
        // Verificar si hizo tres en linea
        // Si lo hizo Diga Gano
        // Si no lo hizo Preguntar si quiere seguir jugando

        var sc = new Scanner(System.in);
        var player = 'X';
        var isFinish = false;
        var counter = 0;
        var board = inicializeBoard();
        do {
            showBoard(board);

            System.out.printf("Jugador %c ingresa tu movimeinto: %n", player);
            System.out.print("Fila (1-3): ");
            var row = sc.nextInt() - 1;
            System.out.print("Columna (1-3): ");
            var column = sc.nextInt() - 1;

            if (makeMove(board, row, column, player)) {
                counter++;
                showBoard(board);
                if (checkWinner(board, player)) {
                    System.out.printf("Jugador %c Gano! %n", player);
                    isFinish = true;
                } else {

                    player = player == 'X' ? 'O' : 'X';

                }

            } else

            {
                System.out.println("Movimiento invalidao, intenta de nuevo.");
            }

            if (counter == 9) {
                showBoard(board);
                System.out.println("Empate");
                isFinish = true;
            }
        } while (!isFinish);

        sc.close();
    }



    private static boolean checkWinner(char[][] board, char player) {

        for (var row : board) {
            if (row[0] == player && row[1] == player && row[2] == player) {
                return true;
            }

        }

        for (int i = 0; i < board[0].length; i++) {

            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {

                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {

            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {

            return true;
        }

        return false; // Añadido retorno por defecto si no hay ganador

    }

    private static boolean makeMove(char[][] board, int row, int column, char player) {
        if (board[row][column] != ' ') {

            return false;

        }
        board[row][column] = player;
        return true;
    }

    private static void showBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j < board[i].length - 1) {
                    System.out.print('|');

                }
            }

            System.out.println();
            if (i < board.length - 1) {
                System.out.println("-----");
            }
        }

    }

    private static char[][] inicializeBoard() {
        var board = new char[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';

            }

        }

        return board;

    }
    // end{code}
}