package com.company;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import com.company.game.CSV_File;
import com.company.game.Game;
import com.company.game.Menu;
import com.company.game.Question;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // wrapping the game in while cycle to allow the user to play again
        while (true) {
            Menu.start();
            System.out.println("Do you want to try again? Type yes to continue");
            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();
            if (answer.equals("yes")) {
                System.out.println("Here we go again >.< \n");

            } else {
                System.out.println("Thank you for playing >.<");
                break;
            }


        }
    }
}
