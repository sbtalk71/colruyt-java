package com.demo.ejb.credit;

import javax.ejb.Stateless;

@Stateless
public class CreditBean implements CreditLocal{
    @Override
    public String getCredit() {
        return "good";
    }
}
