package com.demo.spring.repo;

import com.demo.spring.entity.Emp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "emps",itemResourceRel = "emp",collectionResourceRel = "empList")
public interface EmpRestDataRepository extends CrudRepository<Emp,Integer> {

}
