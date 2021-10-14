package com.demo.exceptions;

import java.util.Scanner;

public class ThrowDemo {
    public static void main(String[] args) {

        AdultChecker ac = new AdultChecker();
        try {
            ac.checkAge(10);
        }catch (NotAnAdultException e){
            System.out.println(e.getMessage());
        }
    }
}
    class AdultChecker {
        public  void checkAge(int age) throws NotAnAdultException{

            if (age >= 18 && age < 60) {
                System.out.println("You are an adult and allowed here");
            } else {
              throw new NotAnAdultException("You are below 18 years or a senior citizen");
            }
        }
    }



