package com.demo.abstractdemo;

public class Cat extends Animal{

    public Cat(String name){
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(super.name +" says meow");
    }
}
