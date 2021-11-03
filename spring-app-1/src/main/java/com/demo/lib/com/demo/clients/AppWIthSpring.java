package com.demo.lib.com.demo.clients;

import com.demo.lib.Mail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppWIthSpring {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
       Mail mail= (Mail)ctx.getBean("mymail");
        System.out.println(mail.getMessage().getBody());

    }
}
