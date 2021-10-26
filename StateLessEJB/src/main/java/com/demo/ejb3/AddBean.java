package com.demo.ejb3;

import javax.ejb.Stateless;

@Stateless
public class AddBean implements AddRemote{
    @Override
    public int add(int a, int b) {
        System.out.println("Add EJB called...");
        return a+b;
    }
}
