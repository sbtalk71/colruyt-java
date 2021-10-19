package com.demo.threads;

public class RunnableMain {
    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new MyRunnableThread());

        t1.start();

        t1.setPriority(8);
        System.out.println(t1.getName());
        System.out.println(t1.getPriority()); // Priority 1-10 ,Thread.MIN_PRIORITY
        System.out.println(t1.getState());

        t1.setName("My Runnable Thread");
        t1.join();
    }
}
