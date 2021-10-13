package com.demo.inheritance;

public class MainApp {
    public static void main(String[] args) {
        Employee emp = new Employee(100,"Shantanu",80000);
        System.out.println(emp.getDetails());


        TraineeEmployee te = new TraineeEmployee(100,"Shantanu",80000,"good");
        System.out.println(te.getDetails());


        System.out.println(te);
    }
}
