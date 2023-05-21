package com.company;

public class EmployeeSalaryPrinter implements Printer {

    @Override
    public void print(Employee employee) {
        if (employee.salary <0) {
            System.out.println("Incorrect salary value");
        }else {
        System.out.println("Salary: " + employee.salary);}
    }
}
