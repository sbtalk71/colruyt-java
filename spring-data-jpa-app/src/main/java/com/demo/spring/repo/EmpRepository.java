package com.demo.spring.repo;

import com.demo.spring.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpRepository  extends JpaRepository<Emp,Integer> {

    @Query("select e from Emp e where e.salary between ?1 and ?2")
    public List<Emp> getEmpBetweenSalaryRange(double lower, double higher);
}
