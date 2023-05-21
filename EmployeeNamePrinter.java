package com.company;

public class EmployeeNamePrinter implements Printer{
    @Override
    public void print(Employee employee) {
        if (employee.firstName.isEmpty() || employee.lastName.isEmpty()) {
            System.out.println("First name or Last name is empty");
        } else {
            System.out.println("First name:" + employee.firstName);
            System.out.println("Last name:" + employee.lastName);
                }
        System.out.println("Position: " + employee.position);
    }
}

