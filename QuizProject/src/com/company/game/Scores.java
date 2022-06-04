package com.company.game;

import java.io.*;
import java.util.ArrayList;

public class Scores implements Serializable {


    private ArrayList<User> list;

    public Scores() {
        list = new ArrayList<>();
    }

    public void addScore(User user) {
        list.add(user);
    }
    // method for printing user's score
    public void printScores() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    public void saveScore() {
        try {
            //Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream("C:\\Users\\DAVID\\Desktop\\QuizProject\\src\\com\\company\\game\\scores.ser");
            
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(this);
            out.flush();
            //closing the stream
            out.close();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    // loading file with user's score
    public Scores loadScore() throws IOException, ClassNotFoundException {

        ObjectInputStream in=new ObjectInputStream(new FileInputStream("C:\\Users\\DAVID\\Desktop\\QuizProject\\src\\com\\company\\game\\scores.ser"));
        Scores s=(Scores)in.readObject();  
        return s;

            
    }

}
