package com.demo.threads;

public class MessageService {
    public synchronized void printMessage(String message){
        try {
            System.out.print("[" + message);
            Thread.sleep(2000);
            System.out.println("]");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void sayHello(String name){
        try {
            System.out.print("[" + "Hello");
            Thread.sleep(2000);
            System.out.println(name+"]");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
