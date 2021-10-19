package com.demo.threads;

public class MessageThread  implements Runnable{
    private MessageService messageService;
    private String message;

    public MessageThread(MessageService messageService, String message) {
        this.messageService = messageService;
        this.message = message;
    }

    @Override
    public void run() {

            messageService.printMessage(message);


    }
}
