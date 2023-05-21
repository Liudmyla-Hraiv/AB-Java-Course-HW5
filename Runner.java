package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Runner {

    public static void main(String[] args) {
        List<Employee> employeeLinkedList = new LinkedList<>();
        addToList(new Employee("Sasha", "Petrov", 30, TEAM.MQA, POSITION.JUNIOR), employeeLinkedList);
        addToList(new Employee("Igor", "Astakhov", 45, TEAM.Developer, POSITION.SENIOR), employeeLinkedList);
        addToList(new Employee("Taras", "Taran", 38, TEAM.AQA, POSITION.MIDDLE), employeeLinkedList);
        addToList(new Employee("Ivan", "Ivanov", 25, TEAM.Developer, 1500, POSITION.JUNIOR), employeeLinkedList);
        addToList(new Employee("Taras", "Duda", 38, TEAM.MQA, POSITION.MIDDLE), employeeLinkedList);

//Threads
//        List<EmployeeThread> threads = new ArrayList<>();
//        for(Employee employee : employeeLinkedList) {
//            threads.add( new EmployeeThread(employee));
//        }
//        for (EmployeeThread thread : threads){
//            thread.start();
//            try {
//                if (thread.getEmployee().firstName.equals("Sasha") && thread.getEmployee().lastName.equals("Petrov")){
//                    thread.join();
//                }
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//FutureTasks and Callables
//        List<EmployeeCallable> callables = new ArrayList<>();
//        for(Employee employee : employeeLinkedList) {
//            callables.add( new EmployeeCallable(employee));
//        }
//        List<FutureTask<Integer>> futureTasks = new LinkedList<>();
//
//        for (EmployeeCallable callable : callables){
//            FutureTask<Integer> futureTask = new FutureTask<>(callable);
//            futureTasks.add(futureTask);
//            Thread thread = new Thread(futureTask);
//            thread.start();
//        }
//        for (FutureTask<Integer> futureTask : futureTasks){
//            try {
//                System.out.println(futureTask.get());
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            } catch (ExecutionException e) {
//                throw new RuntimeException(e);
//            }
//        }


//Thread with Executor Service
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (Employee employee : employeeLinkedList){

      service.execute(() -> {employee.work();});  //lambda
    }
        service.shutdown();

//Callables with Executor Service
    ExecutorService callableService = Executors.newFixedThreadPool(2);
    List<Future<Integer>> futureList = new ArrayList<>(); //list for future results
    for( Employee employee : employeeLinkedList){
        Future<Integer> future = callableService.submit(employee :: compute); //method reference
        futureList.add(future); //future results put in the list
    }
    for (Future<Integer> future : futureList){
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
    callableService.shutdown();

    }
    public static void addToList(Employee employee, List<Employee> employeeList){
        if (!employeeList.contains(employee))
            employeeList.add(employee);

    }
}