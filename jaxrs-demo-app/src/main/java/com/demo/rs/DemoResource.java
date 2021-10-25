package com.demo.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("service")
public class DemoResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("greet")
    //http://localhost:9080/jaxrs-app-1.0/service/greet
    public String greet(){
        return "Hello from JAXRS";
    }
}
