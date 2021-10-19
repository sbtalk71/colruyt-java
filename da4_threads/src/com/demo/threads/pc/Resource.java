package com.demo.threads.pc;

public class Resource {
    private int data=0;
    private boolean valueSet=false;

    public synchronized void get(){
        if(!valueSet){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("GOT: "+this.data);
        this.valueSet=false;
        notify();
    }

    public synchronized void put(int i){
        if(valueSet){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.data=i;
        System.out.println("PUT: "+i);
        this.valueSet=true;
        notify();
    }
}
