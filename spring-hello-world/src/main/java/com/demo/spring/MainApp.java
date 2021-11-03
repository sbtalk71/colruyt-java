package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("context.xml");
        Greeter greeter=(Greeter)ctx.getBean("greeter");

        System.out.println(greeter.getGreeting());
    }
}
