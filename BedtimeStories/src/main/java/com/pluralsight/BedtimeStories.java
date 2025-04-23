package com.pluralsight;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class BedtimeStories {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Which story would you like to read?");
        System.out.println("1. goldilocks.txt");
        System.out.println("2. hansel_and_gretel.txt");
        System.out.println("3. mary_had_a_little_lamb.txt");

        System.out.println("Enter 1, 2, or 3:");
        int num =scanner.nextInt();
        String filename="";

        if (num==1){
            filename="src/main/resources/goldilocks.txt";
        } else if (num==2) {filename="src/main/resources/hansel_and_gretel.txt";

        } else if (num==3) {filename= "src/main/resources/mary_had_a_little_lamb.txt";

        }else {
            System.out.println("Invalid choice.");
        }

        try{
            File storyFile=new File(filename);
            Scanner fileScanner = new Scanner(storyFile);

            int linenumber=1;

            while (fileScanner.hasNextLine()){

                String line=fileScanner.nextLine();
                System.out.println(linenumber + ": " + line);
                linenumber++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Sorry, the story file was not found.");
        }

    }
}
