package com.demo.spring.app1;

import org.springframework.stereotype.Component;

@Component
public class HelloSpring implements Message{
    @Override
    public String getMessage() {
        return "Hello Spring..";
    }
}
