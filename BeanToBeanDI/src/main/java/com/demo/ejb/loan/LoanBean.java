package com.demo.ejb.loan;

import com.demo.ejb.credit.CreditLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("loan")
public class LoanBean /*implements LoanRemote*/{
    @EJB
    CreditLocal creditService;

   // @Override
    @GET
   @Produces(MediaType.TEXT_PLAIN)
    public String applyForLoan(@QueryParam("amount") double amount) {
        String credit=creditService.getCredit();
        return "Your loan of INR "+amount+" approved with "+credit+" credit";
    }
}
