package com.demo.web.client;

import com.demo.ejb.Cart;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.HashMap;

@Path("client")

public class CartClientResource  {

    @GET
    @Path("testCart")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testCart() {
        Response resp = null;
        try {
            InitialContext ctx = new InitialContext();
            Cart cart = (Cart) ctx.lookup("com.demo.ejb.Cart");
            cart.addToCart("pen", 3);
            cart.addToCart("pen", 3);
            cart.addToCart("pencil", 4);
            cart.addToCart("shirt", 3);
            cart.addToCart("shirt", 3);
            HashMap<String, Integer> cartValue=cart.getCart();
            cart.checkOut();
            resp = Response.ok(cartValue).build();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return resp;
    }


}
