package com.pluralsight;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f",
                    p.getId(), p.getName(), p.getPrice());
        }
    }
    public static ArrayList<product> getInventory() {
        ArrayList<product> inventory = new ArrayList<product>();
        // this method loads product objects into inventory // and its details are not shown

        try {
            File file =new File("src/main/resources/inventory.csv");
         //   Scanner fileScanner= new Scanner(file);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            //read a whole line from the file
            // while (fileScanner.hasNextLine()){
            //    String line =reader.nextLine();       //store it in a string variable line
               String line;

               while((line= reader.readLine()) !=null){
                //split the line into pieces
                String[] parts =line.split("\\|");

                if (parts.length==3){
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    float price = Float.parseFloat(parts[2]);
                    inventory.add(new product(id,name,price));

                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /*

        inventory.add(new product(1, "product1", 27.99f));
        inventory.add(new product(2, "chips", 5.99f));
        inventory.add(new product(1, "rollerblades", 159.99f));
        inventory.add(new product(1, "dog food", 27.99f));
        inventory.add(new product(1, "cat food", 8.99f));
        return inventory;
       */
        return inventory;
    }
}


