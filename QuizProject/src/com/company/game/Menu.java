package com.company.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {
        static Scanner scan = new Scanner(System.in);
        static Scores scores = new Scores();
        static User user;

    // method for setting username using serialization
    public static void start() throws IOException, ClassNotFoundException {
        // loading file with user's score
      File file = new File("src/com/company/game/scores.ser/");

        if(file.exists()) {
            scores = scores.loadScore();

            scores.printScores();
        }

        System.out.println("Enter username");
        String username = scan.next();
        // if the user enters the same username as one of the previous users, the program will ask for a new username
        while(username == null || username.isBlank() || username.isEmpty()) {
            System.out.println("invalid name try again");
            username = scan.next();
        }
        user = new User(username,0);
        gameStart();
    }
    // "upgrading" start game method for selecting the topic
    public static void gameStart(){

        Topic topic = Topic.general;

            boolean valid = false;
            try {
                while (valid == false) { // loop for checking if the user entered a valid topic
                    System.out.println("Select topic: A. GENERAL B. TV C. GAMES");
                    String choice = scan.next();
                        // if for checking if the user entered a valid choice
                    if (choice.equalsIgnoreCase("a") || choice.equalsIgnoreCase("b") || choice.equalsIgnoreCase("c")) {
                        valid = true;
                        // switch in which I use lambda expressions to shorten the code
                        switch (choice.toLowerCase()) {
                            case "a" -> {
                                topic = Topic.general;
                            }
                            case "b" -> {
                                topic = Topic.tv;
                            }
                            case "c" -> {
                                topic = Topic.games;
                            }
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                System.out.println("Try again");
                gameStart();
            }
        CSV_File csv = new CSV_File(); // creating new csv file object
        try {
            csv.start(topic);
        } catch (FileNotFoundException e) {
            System.out.println("Question file not found exitting now");
            System.exit(1);
        }
        // creating a new game object
        Question q1 = new Question();
        // calling the method for starting the game
        Game t1 = new Game(scores,user);
        q1.gameIntroduction();
        q1.rulesExplanation();
        t1.startGame(csv.getQuestions());
    }
}
