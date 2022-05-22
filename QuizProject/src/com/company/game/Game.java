package com.company.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Scanner;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class Game implements ActionListener {

    private static List<Question> questions;

    private int index;

    // method for reading json file using List of Question
public static List<Question> readJsonList() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("src/com/company/game/questions.json"));
        Type QuestionType = new TypeToken<List<Question>>() {
        }.getType();
        questions = gson.fromJson(reader, QuestionType);

        return questions;
    }

   // generate question indexes
    public void generateQuestionIndexes() {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            indexes.add(i);
        }
        Collections.shuffle(indexes);
        this.index = indexes.get(0);
    }

    // method for generating question
    public Question generateQuestion() {
        return questions.get(index);
    }

    /// method for loading questions
    public void loadQuestions() throws FileNotFoundException {
        readJsonList();
        generateQuestionIndexes();
    }

// mozna start game metoda???
    public void startGame() throws FileNotFoundException {
        readJsonList();
        generateQuestionIndexes();
        Question question = questions.get(index);
        System.out.println(question.getQuestion());
        System.out.println(question.getOption1());
        System.out.println(question.getOption2());
        System.out.println(question.getOption3());
        System.out.println(question.getOption4());
        System.out.println("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        int userAnswer = scanner.nextInt();
        if (userAnswer == question.getRightAnswer()) {
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong!");
        }
    }

    public Question getRandomQuestion() {
        Random rand = new Random();
        int random = rand.nextInt(questions.size());
        return questions.get(random);
    }

/*
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

   /*method for getting answer from user
    public String getAnswer() {
        System.out.println("Enter your answer: ");
        return sc.nextLine();
    }*/


    //method for cycling through questions
    public Question getCurrentQuestion() {
        return questions.get(index);

    }

    //method for getting question number
    public int getCurrentQuestionNumber() {
        return index + 1;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void displayAnswer() {

    }
    public void results() {

    }


}
