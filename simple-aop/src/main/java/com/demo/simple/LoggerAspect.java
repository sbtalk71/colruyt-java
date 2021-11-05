package com.demo.simple;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
    @Pointcut("execution(* com.demo.simple.Greeter.getGreet(..))")
    private void pcut(){}

    @Before("pcut()")
    public void logBefore(){
        System.out.println("Log Before : Before calling getGreeting...");
    }

    @AfterReturning("pcut()")
    public void logAfter(){
        System.out.println("Log After : After calling getGreeting...");
    }
}
