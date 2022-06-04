package com.company.game;

import java.util.Scanner;
import java.util.*;

public class Game {


    private Scores scores;
    private User user;

    public Game(Scores scores, User user) {
        this.scores = scores;
        this.user = user;
    }

    private int score;
    //method for starting the game

    public void startGame(ArrayList<Question> questionsIn) {
        Random rand = new Random();
        score = 0;
        ArrayList<Question> questions = questionsIn;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of questions you want (max 10), if you set more than 10, number of questions will be set to default 10");
        int count;
        try {
            count = scanner.nextInt();
            if (count >= questions.size() || count <= 0) {
                count = questions.size();
            }
        } catch (Exception e) {
            System.out.println("Invalid input, only numbers are allowed");
            return;
        }
        boolean sameAsLast = false; // flag for checking if the user entered the same question as the last one
        int i;
        int last = 0;
       for(int a = 0;a < count; a++){

           if(sameAsLast){ // if the user entered the same question as the last one, the program will ask for a new question
               i = last;
               sameAsLast = false;

           }else{
            i = rand.nextInt(count);
            sameAsLast = false;
           }

            System.out.println("Your score: " + score + "\n");
            System.out.println(questions.get(i).s + "\nEnter your answer: ");
            System.out.println("Options:\n " + questions.get(i).s1 + "\n " + questions.get(i).s2 + "\n " + questions.get(i).s3 + "\n " + questions.get(i).s4);
            String userAnswer = scanner.next();
            if (userAnswer.equalsIgnoreCase("a") || userAnswer.equalsIgnoreCase("b") || userAnswer.equalsIgnoreCase("c") || userAnswer.equalsIgnoreCase("d")) {

                if (userAnswer.equalsIgnoreCase(questions.get(i).s5)) {
                    System.out.println("CORRECT ANSWER! +50 points");
                    score += 50;
                    questions.remove(i);

                } else if (userAnswer.equalsIgnoreCase("exit")) {
                    System.out.println("You are ending the game early");
                    break;
                } else {
                    questions.remove(i);
                    score -= 50;
                    System.out.println("WRONG ANSWER, -50 points");
                    System.out.println("The correct answer is: " + questions.get(i).s5);

                }
            } else {
                last = i;
                sameAsLast = true;
                a--;

                System.out.println("Invalid input, only A,B,C,D are allowed");
            }

        }

        System.out.println("End of the game, your score: " + score);
        user.setScore(score);
        scores.addScore(user);
        scores.saveScore();


    }

}

