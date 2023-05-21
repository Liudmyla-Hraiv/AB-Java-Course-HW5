package com.company;

import java.util.concurrent.Callable;

public class EmployeeCallable implements Callable<Integer> {

    private Employee employee;

    public EmployeeCallable (Employee employee){
        this.employee=employee;
    }
    @Override
    public Integer call()  {
        return employee.compute();
    }
}
