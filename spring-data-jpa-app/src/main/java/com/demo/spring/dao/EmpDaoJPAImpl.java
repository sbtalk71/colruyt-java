package com.demo.spring.dao;

import com.demo.spring.entity.Emp;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmpDaoJPAImpl implements EmpDao {
    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public String save(Emp e) throws EmpExistsException {
        String message = "";
        try {
            Emp emp = this.findById(e.getEmpId());

            if (emp.getEmpId() == e.getEmpId()) {
                throw new EmpExistsException("Emp with id " + e.getEmpId() + " exists");
            }
        } catch (EmpNotFoundException ex) {
            em.persist(e);
            message="emp saved successfully";
        }
        return message;
    }

    @Override
    public String delete(int id) throws EmpNotFoundException {
        return null;
    }

    @Override
    public String update(Emp e) throws EmpNotFoundException {
        return null;
    }

    @Override
    public Emp findById(int id) throws EmpNotFoundException {
        Emp emp = null;
        emp = em.find(Emp.class, id);
        if (emp == null) {
            throw new EmpNotFoundException("Emp with id " + id + " not found");
        }
        return emp;
    }

    @Override
    public List<Emp> listAll() {
        Query query = em.createQuery("select e from Emp e");
        List<Emp> empList = query.getResultList();
        return empList;
    }
}
