package com.demo.threads.pc;

public class PCMain {
    public static void main(String[] args) {
        Resource resource= new Resource();
        Thread consumer=new Thread(new Consumer(resource));
        Thread producer=new Thread(new Producer(resource));

        producer.start();
        consumer.start();

    }
}
