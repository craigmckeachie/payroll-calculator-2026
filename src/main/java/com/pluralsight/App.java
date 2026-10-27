package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            System.out.println("______________________");
            // read a line into line, then check it isn't null, all in one step
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //Split it into individual fields using the | character as the delimiter
                String[] fields = line.split(Pattern.quote("|"));


                //print each field in the line
                System.out.println(fields[0]);
                System.out.println(fields[1]);
                System.out.println(fields[2]);
                System.out.println(fields[3]);
                System.out.println("______________________");


            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("There was an error reading the transactions file. Check the location of the file.");
        }
    }
}
