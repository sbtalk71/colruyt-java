package com.demo.spring;

import com.demo.spring.app2.PetLover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class PetLoverRunner implements CommandLineRunner {
    @Autowired
    PetLover pl;
    @Override
    public void run(String... args) throws Exception {
        pl.getPetList().stream().forEach(System.out::println);
    }
}
