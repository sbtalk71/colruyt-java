package com.demo.ejb.client;

import com.demo.ejb.loan.LoanRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("loan")
public class InterceptorEjbClient {

    @GET
    @Path("apply")
    public Response getLoan(@QueryParam("amount") double amount){
        Response response=null;
        try{
            InitialContext ctx = new InitialContext();
            LoanRemote bank=(LoanRemote) ctx.lookup("com.demo.ejb.loan.LoanRemote");
            response=Response.ok(bank.applyForLoan(amount)).build();
        }catch (NamingException e){
            e.printStackTrace();
            response= Response.ok("Server Error..").build();
        }
        return response;
    }
}
