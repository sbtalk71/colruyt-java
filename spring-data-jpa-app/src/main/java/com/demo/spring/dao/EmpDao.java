package com.demo.spring.dao;

import com.demo.spring.entity.Emp;

import java.util.List;

public interface EmpDao {
    public String save(Emp e) throws EmpExistsException;
    public String delete(int id) throws EmpNotFoundException;
    public String update(Emp e) throws EmpNotFoundException;
    public Emp findById(int id) throws EmpNotFoundException;
    public List<Emp> listAll();
}
