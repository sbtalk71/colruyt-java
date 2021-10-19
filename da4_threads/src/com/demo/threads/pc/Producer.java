package com.demo.threads.pc;

public class Producer implements Runnable{
    Resource resource;
    int i=0;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.put(i++);
        }
    }
}
