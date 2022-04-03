package com.company;

import java.util.Scanner;

public class Player {
    int number; //Hier kommt erstmal irgendeine Spielerzahl (Kochtöpfe)
    Scanner scanner = new Scanner(System.in); //Hier kommen alle Eingaben

    //Das ist der Konstruktor für die Player class, dieser muss auch genauso heißen!
    //Der Konstruktor kann ein Kochrezept (class) in einzelne Töpfe (this) verteilen und diese können separiert verändert werden
    public Player(int number){
    this.number = number;
    }

    public int getTurn(){
        System.out.println("Spieler " + number + " Bitte gib das Feld ein, auf welches du setzen möchtest.");
      int input = scanner.nextInt(); //scanner bekommt eine Ganzzahl zurück, welche in System gelesen wurde, dass wird dann zum input
      if(input < 9 && input >= 0){ //die Eingabe wird darauf geprüft ob diese auch einen zulässigen Wert hat, ansonsten wird sie nicht zurückgegeben
          return input;
      }
      System.out.println("Ungültige Eingabe. Bitte nur eine Zahl zwischen 0 - 9 eingeben! Bitte nochmal eingeben.");
      return getTurn();
    }

    public boolean validateTurn(int[] board, int turn){
        if(board[turn] == -1){
            return true;
        }
            return false;
    }
}
