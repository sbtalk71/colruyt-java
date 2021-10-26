package com.demo.ejb.client;

import com.demo.ejb3.AddRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("client")
public class AddClient {
    @Path("add")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response invokeAdd(@QueryParam("a") int a, @QueryParam("b") int b){
        int result=0;
        try {
            InitialContext ctx= new InitialContext();
         // AddRemote adder=(AddRemote) ctx.lookup("java:global/StateLessEJB-1/AddBean!com.demo.ejb3.AddRemote");
            AddRemote adder=(AddRemote) ctx.lookup("com.demo.ejb3.AddRemote");
            System.out.println("Stub Here ====== "+adder.getClass().getName());
            result=adder.add(a,b);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return Response.ok(result).build();
    }
}
