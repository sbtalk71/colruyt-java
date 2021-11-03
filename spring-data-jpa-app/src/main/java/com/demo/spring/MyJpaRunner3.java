package com.demo.spring;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.dao.EmpExistsException;
import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyJpaRunner3 implements CommandLineRunner {
    @Autowired
    EmpRepository dao;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(dao.getClass().getName());
      Optional<Emp> op=dao.findById(104);
      if(op.isPresent()){
          System.out.println(op.get());
      }else{
          System.out.println("Emp Not Found");
      }
    }
}
