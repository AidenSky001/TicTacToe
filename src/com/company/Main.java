package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	//Hier wird der Spieler gespeichert, der grade am Zug ist
        int turn =0;
        int winner = -1;
        //Hier werden die Felder auf dem Brett gesetzt welche verändert werden können
        int[] board = new int[9];
        //Zuerst werden alle Felder auf Null gesetzt um ein Neutrales Feld zu generieren
        for(int i =0; i < board.length; i++){
        board[i] = -1;
        }
        System.out.println("Bitte Spielername eingeben.");
        System.out.println("Spieler 1: ");
        Scanner scanner = new Scanner(System.in);
        String spielername1 = scanner.next();
        System.out.println("Bitte Spielername eingeben.");
        System.out.println("Spieler 2: ");
        Scanner scanner2 = new Scanner(System.in);
        String spielername2 = scanner.next();
        //Neue Spieler aus der Player class
        Player a = new Player(0);
        Player b = new Player(1);
        Player[] players = new Player[2];
        players[0] = a;
        players[1] = b;
        System.out.println("Ok " + spielername1 + " Du, bist am Zug.");


        //Eine Dauerschleife die solange ausgeführt wird bis ein Spieler gewonnen hat
        while(winner == -1) {
            printBoard(board);
            int turnField = players[turn].getTurn();
            if(players[turn].validateTurn(board, turnField)){
                board[turnField] = players[turn].number;
                turn = (turn +1) % 2;
            }
            winner = checkWinner(board);
        }
        System.out.println("Herzlichen Glückwunsch Spieler " + winner + " Du hast gewonnen!");
    }
    //Das "static" steht für alles was drin steht gleich, also hier kann kein Konstruktor erzeugt werden
    public static int checkWinner(int[] board){
        int winner = -1;
        if(board[0] == board[1] && board[0] == board[2] && board[0] != -1){
            winner = board[0];
        }
        else if (board[3] == board[4] && board[3] == board[5] && board[3] != -1){
            winner = board[3];
        }
        else if (board[6] == board[7] && board[6] == board[8] && board[6] != -1){
            winner = board[6];
        }
        else if (board[0] == board[3] && board[0] == board[6] && board[0] != -1){
            winner = board[0];
        }
        else if (board[1] == board[4] && board[1] == board[7] && board[1] != -1){
            winner = board[1];
        }
        else if (board[2] == board[5] && board[2] == board[8] && board[2] != -1){
            winner = board[2];
        }
        else if (board[0] == board[4] && board[0] == board[8] && board[0] != -1){
            winner = board[0];
        }
        else if (board[2] == board[4] && board[2] == board[6] && board[2] != -1){
            winner = board[2];
        }
        else {
            winner = -1;
        }
        return winner;
    }

    public static void printBoard(int[] meinBoard){
        System.out.println(meinBoard[0] + " | " + meinBoard[1] + " | " + meinBoard[2]);
        System.out.println("____________");
        System.out.println(meinBoard[3] + " | " + meinBoard[4] + " | " + meinBoard[5]);
        System.out.println("____________");
        System.out.println(meinBoard[6] + " | " + meinBoard[7] + " | " + meinBoard[8]);
        System.out.println("____________");

    }

}
