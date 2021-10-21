package com.demo.strings;

public class StringDemo {
    public static void main(String[] args) {
        String s1="hello";
        String s2="Hello";
        String s3="hello";
        String s4=new String("hello");
        System.out.println(s1==s3);
        s3=s3+" world";

        String testString="I like java as java is simple and java is good";

        System.out.println(testString.length());
        System.out.println(testString.substring(10,20));
        System.out.println(testString.indexOf("java"));
        System.out.println(testString.lastIndexOf("java"));
        for(String s:testString.split(" ")){
            System.out.println(s);
        }
        System.out.println(testString.toUpperCase());

        String x= testString.intern();
        System.out.println(x);
    }
}
