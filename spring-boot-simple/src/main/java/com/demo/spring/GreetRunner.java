package com.demo.spring;

import com.demo.spring.app1.Greeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class GreetRunner implements CommandLineRunner {
    @Autowired
    Greeter greeter;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(greeter.getGreeting());
    }
}
