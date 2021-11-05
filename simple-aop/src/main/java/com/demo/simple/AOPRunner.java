package com.demo.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class AOPRunner implements CommandLineRunner {
    @Autowired
    Greeter greeter;
    @Override
    public void run(String... args) throws Exception {
        greeter.getGreet();
        System.out.println(greeter.getClass().getName());
        for(Method m: greeter.getClass().getMethods()){
            System.out.println(m.getName());
        }
    }
}
