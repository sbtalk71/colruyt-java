package com.demo.spring.runners;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.MyPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class MyRepoTestRunner implements CommandLineRunner {
    @Autowired
    MyPagingAndSortingRepository repo;

    @Override
    public void run(String... args) throws Exception {
        Pageable firstPageQuery= PageRequest.of(0,5);

       Page<Emp> firstPage = repo.findAll(firstPageQuery);

       firstPage.forEach(System.out::println);

        Pageable secondPageQuery= PageRequest.of(0,7);

        Page<Emp> secondPage = repo.findAll(secondPageQuery);

        secondPage.forEach(System.out::println);

        repo.findAll(Sort.by("name").ascending()).forEach(System.out::println);
    }
}
