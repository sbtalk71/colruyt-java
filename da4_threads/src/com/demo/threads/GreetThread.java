package com.demo.threads;

public class GreetThread implements Runnable{
    private MessageService messageService;
    private String message;

    public GreetThread(MessageService messageService, String message) {
        this.messageService = messageService;
        this.message = message;
    }

    @Override
    public void run() {
        messageService.sayHello(message);
    }
}
