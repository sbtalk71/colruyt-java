package com.demo.ejb;

import com.demo.jpa.entity.Emp;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EmpAppBean implements EmpApp{

    @PersistenceContext
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String save(int id, String name, String city, double salary) {
        em.persist(new Emp(id,name,city,salary));
        return "Emp Saved";
    }



}
