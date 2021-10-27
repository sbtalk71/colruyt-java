package com.demo.ejb.credit;

import javax.ejb.Local;

@Local
public interface CreditLocal {
    public String getCredit();
}
