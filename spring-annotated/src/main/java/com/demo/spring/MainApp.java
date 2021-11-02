package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        //Greeter greeter=(Greeter)ctx.getBean("greeter");
        Greeter greeter=ctx.getBean(Greeter.class);

        /*Greeter greeter1=(Greeter)ctx.getBean("greeter");

        System.out.println(greeter==greeter1);*/

        System.out.println(greeter.getGreeting());
    }
}
