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
        while(true){
        Menu.start();
        System.out.println("Do you wanna try again? enter yes to try again and no to exit");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();
        if(answer.equals("no")){
            System.out.println("Thank you for playing >.<");
            break;
        }
        }


        }
    }

