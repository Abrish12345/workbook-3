package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Scanner;

public class theApp {
    //create pattern/formatter we need for time stamp format
    static DateTimeFormatter timeStampFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd: mm:ss");

    static Scanner theScanner= new Scanner(System.in);

    public static void main(String[] args) {
        //when the application launches, make an entery in the log
        logActions("launch");
        logActions("Exit");
          //create a variable that will keep us looping the question for the user
         //until they decide to quite
        boolean appRunning =true;

        while(appRunning){
            //DISPLAY THE QUESTION TO THE USER
            System.out.println("Enter a search term x to exit:");

            //store their answer
            String searchTerm= theScanner.nextLine();

            if(searchTerm.equalsIgnoreCase("x")){
                System.out.println("have a nice day!");
                logActions("exit");
                appRunning = false;
            }else {
                //log the search term to the log file
            logActions("search : " + searchTerm);
            }

        }

    }
    public static void logActions(String theAction){
        //alow us to try and write to the file
        try{
            FileWriter outPutFile = new FileWriter("src/main/resources/logs.txt", true);
            //create the bufferd writer to write to the log file
            BufferedWriter bufferedWriter = new BufferedWriter(outPutFile);

            //create a date and time
            LocalDateTime timeStamp= LocalDateTime.now();
            //
            bufferedWriter.write((timeStamp.format(timeStampFormater) + " " + theAction));
            //make sure we have a new line in our file
            bufferedWriter.newLine();
            //Close the buffwriter so it acctualy write on the file
            bufferedWriter.close();


        }catch (Exception e){
            System.out.println("Error writing to the file: " + e.getMessage());
        }

    }
}
