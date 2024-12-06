/*Realizar un programa que permita controlar el juego de piedra, papel, tijera introduciendo P para piedra, L para papel y T para tijera por cada jugador.
El sistema debe indicar qué jugador gana la ronda o si hay empate. Al final de cada ronda preguntar si desea volver a jugar. */

import java.util.Scanner;

public class Ejercicio22 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Vamos a jugar Piedra (P), Papel (L) o Tijera (T)");
        System.out.println("Ingrese la letra correspondiente del jugador 1");
        char player1 = entrada.nextLine().charAt(0);
        System.out.println("Ingrese la letra correspondiente del jugador 2");
        var player2 = entrada.nextLine().charAt(0);

        player1 = Character.toLowerCase(player1);
        player2 = Character.toLowerCase(player2);

        if (player1 != 'p' && player1 != 't' && player1 != 'l') {
            System.out.println("Letra ingresada incorrecta en el jugador 1 (P),(T),(L) .");
        } else if (player2 != 'p' && player2 != 't' && player2 != 'l') {
            System.out.println("Letra ingresada incorrecta en el jugador 2 (P),(T),(L) .");
        } else if (player1 == 'p' && player2 == 't') {
            System.out.println("Jugador 1 gana la ronda");
        } else if (player1 == 't' && player2 == 'p') {
            System.out.println("Jugador 2 gana la ronda");
        } else if (player1 == 'p' && player2 == 'l') {
            System.out.println("Jugador 2 gana la ronda");
        } else if (player1 == 'l' && player2 == 'p') {
            System.out.println("Jugador 1 gana la ronda");
        } else if (player1 == 'l' && player2 == 't') {
            System.out.println("Jugador 1 gana la ronda");
        } else if (player1 == 't' && player2 == 'l') {
            System.out.println("Jugador 2 gana la ronda");
        } else {
            System.out.println("Empate, No hay ganador");

        }
        entrada.close();
    }

}
