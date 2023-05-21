package com.company;

public class EmployeeThread extends Thread{

    private Employee employee;

    public EmployeeThread(Employee employee){
        this.employee=employee;
    }
    public void run(){
    employee.work();
    }
    public Employee getEmployee(){
        return employee;
    }
}
