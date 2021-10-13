package com.demo.ex;

public class BoxMain {
    public static void main(String[] args) {
       // Box b1=new Box();
       // b1.length=10;
        Box b1= new Box(10,20,10);
        double vol=b1.getVolume();
        System.out.println(vol);

        Box b2= new Box(10,20,10,"Blue");
    }
}
