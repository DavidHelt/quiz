package com.company.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public abstract class Menu {
        static Scanner scan = new Scanner(System.in);
        static Scores scores = new Scores();
        static User user;

    // method for setting username using serialization
    public static void start() throws IOException, ClassNotFoundException {
      File file = new File("C:\\Users\\DAVID\\Desktop\\QuizProject\\src\\com\\company\\game\\scores.ser");
        if(file.exists()) {
            scores = scores.loadScore();

            scores.printScores();
        }

        System.out.println("Enter username");
        String username = scan.next();

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
        System.out.println("Entere topic: A. GENERAL B. TV C. GAMES");
        String choice = scan.next();
        // switch in which i use lambda expressions to shorten the code
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
        CSV_File csv = new CSV_File();
        try {
            csv.start(topic);
        } catch (FileNotFoundException e) {
            System.out.println("Questtion file not found exitting now");
            System.exit(1);
        }

        Question q1 = new Question();

        Game t1 = new Game(scores,user);
        q1.gameIntroduction();
        q1.rulesExplanation();
        t1.startGame(csv.getQuestions());
    }
}
