package com.demo.misc;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

public class DempJava8 {
    public static void main(String[] args) {

        Runnable worker = new Runnable() {
            @Override
            public void run() {
                System.out.println("2. Hello from Thread..");
            }
        };
        //java8 lamda
        //square_sum(x,y)=x.x+y.y
        //(x,y)->x.x+y.y
        //()->{}
     //Runnable worker1=()->System.out.println("3. Hello from Thread..");

        Thread t1= new Thread(()->System.out.println("3. Hello from Thread.."));
        t1.start();
    }
}

//

class Worker implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from Thread..");
    }
}
