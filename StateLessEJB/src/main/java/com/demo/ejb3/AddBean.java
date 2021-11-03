package com.demo.ejb3;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Stateless
@Path("math")
public class AddBean /*implements AddRemote*/{

   // @PostConstruct
    public void init(){
        System.out.println("Post construct called..");
    }

   // @PreDestroy
    public void cleanup(){
        System.out.println("Pre destroy called..");
    }

    //@Override
    @Path("add")
    @Produces("text/plain")
    @GET
    public int add(@QueryParam("a") int a, @QueryParam("b") int b) {
        System.out.println("Add EJB called... with "+a+" and"+b);
        return a+b;
    }
}
