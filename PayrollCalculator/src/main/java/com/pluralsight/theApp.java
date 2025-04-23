package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class theApp {
    public static void main(String[] args) {

        try {
            //fileReader
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            //Wrap the fileReader with bufferedreader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //create variable name input that holds each line from the file
            String inpute;

            //start a loop
            while ((inpute = bufferedReader.readLine()) != null) {
                String[] inputParts = inpute.split("\\|");
                if (inputParts[0].equals("id")) {
                    continue;
                }
                Employee theEmployee = new Employee(Integer.parseInt(inputParts[0]), inputParts[1], Double.parseDouble(inputParts[2]), Double.parseDouble(inputParts[3]));

                System.out.printf("%d - %s - $%.2f\n", theEmployee.getEmployeeId(), theEmployee.getName(), theEmployee.getGrossPay());
                /*
                System.out.println("ID: " + theEmployee.getEmployeeId());
                System.out.println("Name: " + theEmployee.getName());
                System.out.println("Gross Pay: $" + theEmployee.getGrossPay());
                System.out.println("--------------------------");
                */
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }
}
