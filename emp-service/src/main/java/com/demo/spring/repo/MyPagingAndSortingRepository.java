package com.demo.spring.repo;

import com.demo.spring.entity.Emp;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MyPagingAndSortingRepository extends PagingAndSortingRepository<Emp,Integer> {

}
