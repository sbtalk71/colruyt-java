package com.demo.spring;

public class Greeter {

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
