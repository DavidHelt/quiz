package com.company.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Scanner;
import java.util.*;
import com.company.categories.Question;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;


public class Game implements ActionListener {

    private List<Question> questions;
    private int index;

    public Game() {
    }

   // method for reading json file
    public void readJson() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("src/com/company/game/questions.json"));
        Type listType = new TypeToken<ArrayList<Question>>() {
        }.getType();
        questions = gson.fromJson(reader, listType);
    }

    public Question getRandomQuestion() {
        Random rand = new Random();
        int random = rand.nextInt(questions.size());
        return questions.get(random);
    }


    public int getNumberOfQuestions() {
        return questions.size();
    }


    public boolean checkAnswer(Question question, String answer) {
        return question.getAnswer().equals(answer);
    }


    public Question getQuestionByIndex(int index) {
        return questions.get(index);
    }


    public void nextQuestion() {
        index++;
    }


    public boolean hasNextQuestion() {
        return index < questions.size();
    }

    public void chooseDifficulty(int difficulty) {
        List<Question> temp = new ArrayList<>();
        for (Question question : questions) {
            if (question.getDifficulty() == difficulty) {
                temp.add(question);
            }
        }
        questions = temp;
    }


    static Scanner sc = new Scanner(System.in);

    public static int getChoice() {
        int choice = 0;
        while (choice < 1 || choice > 4) {
            System.out.println("Please enter a number between 1 and 3");
            choice = sc.nextInt();


        }
        return choice;
    }

    public static void startGame() {
        System.out.println("Welcome to the game!");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void displayAnswer() {

    }
    public void results() {

    }

}
