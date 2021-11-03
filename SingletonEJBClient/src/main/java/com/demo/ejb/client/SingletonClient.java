package com.demo.ejb.client;

import com.demo.ejb.CounterBean;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("hits")
public class SingletonClient {
    //@EJB
    @Inject
    CounterBean counter;

    @GET
    @Produces("text/plain")
    public Response getHitCount() {
        Response resp = null;
       /* try {

            InitialContext ctx = new InitialContext();
            CounterBean counter = (CounterBean) ctx.lookup("ejblocal:com.demo.ejb.CounterBean");*/
            resp = Response.ok(counter.getHits()).build();
        /*} catch (NamingException e) {
            e.printStackTrace();
        }*/
        return resp;
    }
}
