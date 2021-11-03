package com.demo.ejb;
import com.demo.jpa.entity.Emp;

import javax.ejb.Remote;

@Remote
public interface EmpApp {
    public String save(int id, String name, String city,double salary);
}
