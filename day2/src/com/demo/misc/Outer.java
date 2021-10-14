package com.demo.misc;

public class Outer {

    public void fun(){
        System.out.println("outer class");

    }
    class Inner{

        public void innerFun(){
            System.out.println("Inner class");
            fun();

        }
        //inner class
    }

    static class Inner2{
        public void inner2Fun(){
            System.out.println("Inner2 class");

        }
        // static nested class
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.new Inner();

        Inner2 inner2 = new Inner2();
    }
}
