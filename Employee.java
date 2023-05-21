package com.company;

public class Employee {

    public String firstName; //имя
    public String lastName; //фамилия
    public int age; //возраст
    public TEAM team;  //команда
    public long salary; // зп
    public POSITION position; //позиция сотрудника

    public Employee (String firstName, String lastName, int age, TEAM team, POSITION position){
        this(firstName, lastName, age, team, 0, position);
    }
    public Employee (String firstName, String lastName, int age, TEAM team, long salary, POSITION position){

        if (age <18) {
            System.out.println("Incorrect age value");
        }

        this.firstName=firstName;
        this.lastName=lastName;
        this.age = age;
        this.team = team;
         if (salary == 0){
             salary = position.minSalary;
         }
         this.salary = salary;
        this.position = position;
    }
    public String toString(){
    return   this.firstName + " " + this.lastName + " " + this.position.toString();
    }

    public boolean equals(Object obj){
        return obj instanceof Employee
                && ((Employee) obj).firstName.equals(this.firstName)
                && ((Employee) obj).lastName.equals(this.lastName);
    }
//Count from 0 till 9
    public void work(){
        for (int i=0; i<10; i++){
            System.out.println(firstName + " " + lastName + " works " +i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
// 1*2*3*..*18*19
    public int compute(){
        int result = 1;
        for (int i=1; i<20; i++){
            result*=i;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

}
