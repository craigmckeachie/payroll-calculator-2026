package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        List<Employee> employees = loadEmployees();

        printEmployeeCards(employees);
        printEmployeeTable(employees);


    }

    private static List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // read a line into line, then check it isn't null, all in one step
            String line;
            String headerLine = bufferedReader.readLine(); //ignore header

            while ((line = bufferedReader.readLine()) != null) {
                //Split it into individual fields using the | character as the delimiter
                String[] fields = line.split(Pattern.quote("|"));


                //fill data into employee object and add to list
                int employeeId = Integer.parseInt(fields[0]);
                String name = fields[1];
                Double hoursWorked = Double.parseDouble(fields[2]);
                Double payRate = Double.parseDouble(fields[3]);
                Employee employee = new Employee(employeeId,name,hoursWorked, payRate);
                employees.add(employee);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("There was an error reading the transactions file. Check the location of the file.");
        }
        return employees;
    }

    private static void printEmployeeTable(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toRow());
        }
    }

    private static void printEmployeeCards(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toCard());
        }
    }
}
