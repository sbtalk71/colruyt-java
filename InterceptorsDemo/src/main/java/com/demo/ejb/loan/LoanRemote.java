package com.demo.ejb.loan;

import javax.ejb.Remote;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Remote
public interface LoanRemote {

    public String applyForLoan(double amount);
}
