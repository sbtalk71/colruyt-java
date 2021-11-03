package com.demo.ejb.credit;

import com.demo.ejb.interceptors.MyMethodInterceptor;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
public class CreditBean implements CreditLocal{

    @Interceptors({MyMethodInterceptor.class})
    @Override
    public String getCredit() {
        return "good";
    }
}
