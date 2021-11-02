package com.demo.ejb.loan;

import com.demo.ejb.credit.CreditLocal;
import com.demo.ejb.interceptors.MyClassInterceptor;
import com.demo.ejb.interceptors.MyMethodInterceptor;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Stateless
@Interceptors({MyClassInterceptor.class})
public class LoanBean implements LoanRemote {

    @EJB
    CreditLocal creditService;

    @Interceptors({MyMethodInterceptor.class})
    @Override
    public String applyForLoan(double amount) {
        String credit = creditService.getCredit();
        return "Your loan of INR " + amount + " approved with " + credit + " credit";
    }
}
