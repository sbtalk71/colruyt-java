package com.demo.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;

@Singleton
@Startup
public class ProgScheduling {
    @Resource
    TimerService timerService;

    private Timer timer;
    @PostConstruct
    public void init(){
        timer=timerService.createTimer(0,5000,"Timer programed for every 5 seconds");
    }

    @Timeout
    public void executeTimesTask(){

        System.out.println("Method executed every 5 seconds");
    }

    public void cancel(){
        timer.cancel();
    }
}
