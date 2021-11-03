package com.demo.spring.dao;

import com.demo.spring.entity.Emp;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoMockImpl implements EmpDao{
    @Override
    public String save(Emp e) {
        return "EMp saved with id "+e.getEmpId();
    }
}
