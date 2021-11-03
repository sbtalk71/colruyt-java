package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PetLoverMain {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("context.xml");
        PetLover pl =(PetLover) ctx.getBean("petLover");
        pl.getPetList().stream().forEach(System.out::println);
    }
}
