package com.company;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.company.game.Game;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        //*create a scanner
        Scanner scanner = new Scanner(System.in);

    Game t1 = new Game();

    t1.startGame();


    }
}
