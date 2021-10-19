package com.demo.threads;

public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++) {
                System.out.println(Thread.currentThread().getName()+" Executing "+i);
                Thread.sleep(1000);
                if(i==6){
                    System.out.println("Count is "+i+" I go home..");
                    Thread.currentThread().interrupt();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
