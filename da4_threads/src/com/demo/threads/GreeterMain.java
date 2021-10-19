package com.demo.threads;

public class GreeterMain {
    public static void main(String[] args) throws  Exception{
        MessageService ms = new MessageService();
        Thread t1 = new Thread(new MessageThread(ms,"hello"));
        Thread t2 = new Thread(new MessageThread(ms,"Good"));
        Thread t3 = new Thread(new MessageThread(ms,"World"));


        t1.start();
        t2.start();
        t3.start();


        t1.join();
        t2.join();
        t3.join();

    }
}
