package com.demo.spring;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.dao.EmpExistsException;
import com.demo.spring.dao.EmpNotFoundException;
import com.demo.spring.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class MyJpaRunner2 implements CommandLineRunner {
    @Autowired
    EmpDao dao;
    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("Dao Object is "+dao.getClass().getName());
           Emp e = new Emp(218,"Smitha","Kolkata",87000);
            System.out.println(dao.save(e));

        }catch (EmpExistsException e){
            System.out.println(e.getMessage());
        }
    }
}
