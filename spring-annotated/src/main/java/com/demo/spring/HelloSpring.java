package com.demo.spring;

import org.springframework.stereotype.Component;

@Component
public class HelloSpring implements Message{
    @Override
    public String getMessage() {
        return "Hello Spring..";
    }
}
