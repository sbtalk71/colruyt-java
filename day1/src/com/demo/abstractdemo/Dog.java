package com.demo.abstractdemo;

public class Dog extends Animal{

    public Dog(String name){
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(super.name +" says wooff..");
    }
}
