package com.demo.spring;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.dao.EmpNotFoundException;
import com.demo.spring.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyJpaRunner implements CommandLineRunner {
    @Autowired
    EmpDao dao;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Dao Object is "+dao.getClass().getName());
        try {
            Emp emp = dao.findById(104);
            System.out.println(emp.getClass().getName());

        }catch (EmpNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
