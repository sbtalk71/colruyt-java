package com.demo.spring;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String getMessage(){
        return "from Service";
    }
}
