package com.demo.threads;

public class ThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup g1 = new ThreadGroup("gp1");
        g1.setMaxPriority(7);

        ThreadGroup g2 = new ThreadGroup("gp2");
        g2.setMaxPriority(8);

        Thread t1=new Thread(g1,"g1-t1");
        Thread t2=new Thread(g1,"g1-t2");
        Thread t3=new Thread(g1,"g1-t3");

        Thread t4=new Thread(g2,"g1-t1");
        Thread t5=new Thread(g2,"g1-t2");
        Thread t6=new Thread(g2,"g1-t3");

        t1.setPriority(10);
        System.out.println(t1.getThreadGroup());
        System.out.println(t1.getPriority());
        System.out.println(t1.getName());

        System.out.println(t6);

        t4.start();
        t5.start();

        System.out.println(g2.activeCount());




    }
}
