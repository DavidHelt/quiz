package com.company.game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question {

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int rightAnswer;
    private int userAnswer;
    private int score;
/*
    @Expose
    private final String question;
    @SerializedName("A")

    private final String option1;
    @SerializedName("B")

    private final String option2;
    @SerializedName("C")

    private final String option3;
    @SerializedName("D")

    private final String option4;

    private final char answer;

*/
    public Question(String question, String option1, String option2, String option3, String option4, int rightAnswer, int userAnswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightAnswer = rightAnswer; //* potreba dodelat
        this.userAnswer = userAnswer;
    }





    public void pickQuestion(){

    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public Object getAnswer() {
        return null;
    }

    public int getDifficulty() {
        return 1;

    }
}
