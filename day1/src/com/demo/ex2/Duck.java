package com.demo.ex2;

public class Duck {

    static{
        System.out.println( "this is a static block..."    );

    }
    static int  duckCount=0;
    private String duckName;
    public Duck(String name) {
        this.duckName=name;
        duckCount++;
    }

    public String getDuckName(){
        return duckName;
    }

    public static void fun(){
        //getDuckName();
        System.out.println("This is a static method..");
    }
}
