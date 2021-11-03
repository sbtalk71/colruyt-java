package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@Scope("prototype")
public class Greeter {

    @Autowired
   @Qualifier("helloSpring")
   private Message message;

    public Greeter() {
        System.out.println("greeter created with no args constructor");
    }

    public Greeter(Message message) {
        this.message = message;
        System.out.println("greeter created with 1 args constructor");
    }

    public void setMessage(Message message) {
        System.out.println("setter called with value "+message);
        this.message = message;
    }

    public String getGreeting(){
        return message.getMessage();
    }
}
