package com.demo.ejb;

import javax.ejb.Remote;

@Remote
public interface EmpApp {
    public String save(int id, String name, String city,double salary) throws EmpExistsException;
}
