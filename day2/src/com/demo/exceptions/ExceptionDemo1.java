package com.demo.exceptions;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 10;
            double d = a / b;
            int x = Integer.parseInt("Shantanu");
            System.out.println("All fine here..");
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }catch (NumberFormatException e){
            System.out.println(e);
        }
        finally {
            System.out.println("finally block executes..");
        }
        System.out.println("Normal code flow resumed..");
    }
}
