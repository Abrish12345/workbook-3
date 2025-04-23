package com.pluralsight;

import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] quotes = new String[10];

        quotes[0] = " The only limit to our realization of tomorrow is our doubts of today.";
        quotes[1] = " Life is what happens when you're busy making other plans.";
        quotes[2] = " The purpose of our lives is to be happy";
        quotes[3] = " Get busy living or get busy dying.";
        quotes[4] = " You have within you right now, everything you need to deal with whatever the world can throw at you.";
        quotes[5] = " Believe you can and you're halfway there";
        quotes[6] = " The future belongs to those who believe in the beauty of their dreams.";
        quotes[7] = " It does not matter how slowly you go as long as you do not stop";
        quotes[8] = " Success is not final, failure is not fatal: It is the courage to continue that counts.";
        quotes[9] = " In the middle of every difficulty lies opportunity.";

        //start the loop
        boolean appRun = true;

        while (appRun) {
            try {
                System.out.println("Please choose a number between 1 and 10:");
                int quote = scanner.nextInt();
                System.out.println(quotes[quote - 1]);

            } catch (Exception e) {
                System.out.println("Please enter a valid number between 1 and 10 ");
                continue;
            }
        }

    }

}
