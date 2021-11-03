package com.demo.ejb;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class MyTaskSchedular {
    @Schedule(second = "*/5",minute = "*",hour = "5")
    public void executeTask(){
        System.out.println("every 1 minute Task started on schedule....");
    }
}
