package com.company.game;


public class Question {

    public Question() {

    }
 // method for printing the rules
    public void rulesExplanation(){
        System.out.println("Rules: ");
        System.out.println("1. You will answer questions from 1 of 3 categories you choose");
        System.out.println("2. You have to answer A,B,C,D. If you answer wrong or other character than these, you will be penalized by losing score points");
        System.out.println("3. If you answer wrong, you will lose 100 points. If you answer right, you will get 50 points.\n");
    }
    // just an introduction to the game method UwU
    public void gameIntroduction(){
        System.out.println("Welcome to the quiz game!\n");
    }

    String s;
    String s1;
    String s2;
    String s3;
    String s4;
    String s5;

    // constructor arrays in startGame()method in class CSV_File
    public Question(String s, String s1, String s2, String s3, String s4, String s5) {
        this.s = s;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.s5 = s5;

    }

}

