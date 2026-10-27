package com.pluralsight;

public class Employee {
    //private fields
    int employeeId;
    String name;
    double hoursWorked;
    double payRate;


    //constructors
    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    //getters/setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    //derived getter
    public double getGrossPay() {
        double grossPay = hoursWorked * payRate;
        return grossPay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", hoursWorked=" + hoursWorked +
                ", payRate=" + payRate +
                '}';
    }

    /**
     * Returns a pipe-delimited string matching your sample data format:
     * id|name|hours-worked|pay-rate
     */
    public String toCSV() {
        return employeeId + "|" + name + "|" + hoursWorked + "|" + payRate;
    }

    /**
     * Returns a neatly padded, single-line text row ideal for console tables.
     */
    public String toRow() {
        return String.format("%-5d | %-20s | %-12.1f | %-8.2f",
                employeeId, name, hoursWorked, payRate);
    }


    /**
     * Returns a sleek, box-drawn card representation of the employee.
     */
    public String toCard() {
        return String.format(
                "┌────────────────────────────────┐\n" +
                        "│ ID:       %-20d │\n" +
                        "│ Name:     %-20s │\n" +
                        "│ Hours:    %-20.1f │\n" +
                        "│ Pay Rate: $%-19.2f │\n" +
                        "└────────────────────────────────┘",
                employeeId, name, hoursWorked, payRate
        );
    }
}
