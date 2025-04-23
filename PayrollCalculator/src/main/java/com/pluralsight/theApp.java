package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class theApp {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        // Prompt for input and output filenames.
        System.out.print("Enter the name of the employee file to process:" );
        String inputFileName= scanner.nextLine();
        System.out.print("Enter the name of the payroll file to create:" );
        String outputFileName= scanner.nextLine();

        try {
            //fileReader
            FileReader fileReader = new FileReader("src/main/resources/" + inputFileName);
            //Wrap the fileReader with bufferedreader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            BufferedWriter writer= new BufferedWriter(new FileWriter("src/main/resources/" + outputFileName));
            writer.write("id|name|gross pay\n");

            //create variable name input that holds each line from the file
            String inpute;

            //start a loop
            while ((inpute = bufferedReader.readLine()) != null) {
                String[] inputParts = inpute.split("\\|");
                if (inputParts[0].equals("id")) {
                    continue;
                }
                Employee theEmployee = new Employee(Integer.parseInt(inputParts[0]), inputParts[1], Double.parseDouble(inputParts[2]), Double.parseDouble(inputParts[3]));

                String outputLine= theEmployee.getEmployeeId() +"|" + theEmployee.getName() +"|"+ theEmployee.getGrossPay();
                writer.write(outputLine + "\n");


                 /*
                System.out.printf("%d - %s - $%.2f\n", theEmployee.getEmployeeId(), theEmployee.getName(), theEmployee.getGrossPay());

                System.out.println("ID: " + theEmployee.getEmployeeId());
                System.out.println("Name: " + theEmployee.getName());
                System.out.println("Gross Pay: $" + theEmployee.getGrossPay());
                System.out.println("--------------------------");
                */
            }
            writer.close();
            bufferedReader.close();
            System.out.println("Payroll file created: " + outputFileName);

        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }
}
