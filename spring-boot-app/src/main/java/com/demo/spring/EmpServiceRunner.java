package com.demo.spring;

import com.demo.spring.entity.Emp;
import com.demo.spring.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmpServiceRunner implements CommandLineRunner {
    @Autowired
    EmpService service;
    @Override
    public void run(String... args) throws Exception {
        String resp=service.registerEmployee(new Emp(100,"A","B",1.0));
        System.out.println(resp);

    }
}
