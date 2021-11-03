package com.demo.ejb.loan;

import javax.ejb.Remote;

@Remote
public interface LoanRemote {

    public String applyForLoan(double amount);
}
