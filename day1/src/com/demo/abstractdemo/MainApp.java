package com.demo.abstractdemo;

public class MainApp {
    public static void main(String[] args) {
        Animal animal=null;
        Cat cat = new Cat("Tom");

        Dog dog = new Dog("Spike");

        animal=cat;
        animal.speak();

        animal=dog;
        animal.speak();
    }
}
