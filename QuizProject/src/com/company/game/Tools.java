package com.company.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Game implements ActionListener {


    public Game() {
    }

    static Scanner sc = new Scanner(System.in);

    public static int getChoice() {
        int choice = 0;
        while (choice < 1 || choice > 3) {
            System.out.println("Please enter a number between 1 and 3");
            choice = sc.nextInt();


        }
        return choice;
    }


    public static void startGame() {
        System.out.println("Welcome to the game!");
        System.out.println("Press 1 to start the game");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void displayAnswer() {

    }
    public void results() {

    }

}
