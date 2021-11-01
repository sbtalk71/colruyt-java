package com.demo.ejb.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MyDefaultInterceptor {
    @AroundInvoke
    public Object invoke(InvocationContext ctx) throws Exception {
       System.out.println("Before : Default Interceptior "+this.getClass().getName()+" Invoked ");
       Object retVal= ctx.proceed();
        System.out.println("After : Default Interceptior "+this.getClass().getName()+" Invoked ");
        return retVal;
    }
}
