package com.demo.ejb.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MyClassInterceptor {
    @AroundInvoke
    public Object invoke(InvocationContext ctx) throws Exception {
       System.out.println("Before : Class Interceptior "+this.getClass().getName()+" Invoked ");
       Object retVal= ctx.proceed();
        System.out.println("After : Class Interceptior "+this.getClass().getName()+" Invoked ");
        return retVal;
    }
}
