package com.demo.ejb.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MyMethodInterceptor {
    @AroundInvoke
    public Object invoke(InvocationContext ctx) throws Exception {
       System.out.println("Before : Method Interceptior "+this.getClass().getName()+" Invoked ");
       Object retVal= ctx.proceed();
        System.out.println("After : Method Interceptior "+this.getClass().getName()+" Invoked ");
        return retVal;
    }
}
