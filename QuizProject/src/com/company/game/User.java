package com.company.game;

import java.io.Serializable;

public class User implements Serializable { // this whole class is for declaring user's name and score

    private String username;
    private int score;

    public User (String username , int score){
        this.username = username;
        this.score = score;
    }

    public String getUsername() {

        return username;
    }

    public int getScore() {

        return score;
    }

    public void setScore(int score) {

        this.score = score;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    @Override
    public String toString(){

        return "Username: " + username + " score achieved: " + score;
    }
}
