package com.demo.misc;

public class BoxingUnboxing {
    public static void main(String[] args) {
        int a=10;
        Integer x = new Integer(a); //Boxing

        //From Java 5 Boxing is automatic

        Integer y=a; //auto Boxing

        int b=y; //auto unboxing

        String s="123";
        int num1 = Integer.parseInt(s);
        System.out.println(num1);

        System.out.println(Double.parseDouble(s));

        printValue(123);

    }

    public static void printValue(Number n){
        System.out.println(n);
    }
}
