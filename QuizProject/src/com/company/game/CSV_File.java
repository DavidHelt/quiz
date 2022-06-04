package com.company.game;
import java.io.*;
import java.util.*;
public class CSV_File {

    String[] array;
    private ArrayList<Question> questions;

// method for loading csv file and selecting topic using lambda expressions to shorten the code
 public void start(Topic topic) throws FileNotFoundException {
     questions = new ArrayList<>();
     String questionPath = "src/com/company/CSVFiles/";
     switch (topic){
         case tv -> {
            questionPath += "tv.csv";
         }
         case games -> {
             questionPath += "games.csv";
         }
         case general -> {
             questionPath += "questions.csv";
         }
     }


     BufferedReader br = new BufferedReader(new FileReader(questionPath));
    String line;

        try{
            while ((line = br.readLine()) != null) {
                String[] array = line.split(",");
                // adding csv file content to the arrayList, sorted by its position in the csv file
                Question q = new Question(array[0], array[1], array[2], array[3], array[4], array[5]);
                questions.add(q);
              /*  System.out.println(q);*/

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
 }
    @Override
    public String toString() {
        return "CSV_File{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public ArrayList<Question> getQuestions(){
     return this.questions;
    }



}
