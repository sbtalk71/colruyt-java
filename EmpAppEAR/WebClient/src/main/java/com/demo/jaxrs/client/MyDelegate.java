package com.demo.jaxrs.client;

import com.demo.ejb.EmpApp;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class MyDelegate {
    @EJB
    EmpApp app;

    public EmpApp getApp() {
        return app;
    }
}
