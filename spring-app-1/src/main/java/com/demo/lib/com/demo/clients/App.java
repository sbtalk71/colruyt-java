package com.demo.lib.com.demo.clients;

import com.demo.lib.Mail;
import com.demo.lib.Message;

public class App {
    public static void main(String[] args) {

        Mail mail = new Mail();

        Message message=new Message();
        message.setHeader("Break");
        message.setBody("NOT yet");

        mail.setMessage(message); //DI

        mail.setToAddress("abc@gmail.com");
        mail.setFromAddress("xyz@yahoo.com");

        System.out.println(mail.getMail());
    }
}
