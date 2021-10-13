package com.demo.inheritance;

public class MainApp2 {
    public static void main(String[] args) {
        Employee e = new Employee(100,"Shantanu",78000);
        TraineeEmployee te = new TraineeEmployee(100,"Shantanu",80000,"good");
        Person p=e;
        printDetails(p);

        p=te;

        printDetails(p);

    }

    public static void printDetails(Person p){
        System.out.println(p.getDetails());
    }
}
