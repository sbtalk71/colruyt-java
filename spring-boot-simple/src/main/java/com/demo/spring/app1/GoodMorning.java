package com.demo.spring.app1;

import org.springframework.stereotype.Component;

@Component
public class GoodMorning implements Message{
    @Override
    public String getMessage() {
        return "Good Morning";
    }
}
