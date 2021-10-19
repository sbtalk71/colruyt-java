package com.demo.threads;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Main Thread starts ...");
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();

        t1.join();
        t2.join();

       // t1.start(); //a dead thread cannot be restarted....
        System.out.println("Main thread exits..");
    }
}
