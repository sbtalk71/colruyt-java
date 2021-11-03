package com.demo.spring;

import org.springframework.stereotype.Component;

@Component
public class GoodMorning implements Message{
    @Override
    public String getMessage() {
        return "Good Morning";
    }
}
