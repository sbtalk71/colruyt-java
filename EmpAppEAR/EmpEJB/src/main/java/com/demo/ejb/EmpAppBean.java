package com.demo.ejb;

import com.demo.jpa.entity.Emp;

import javax.ejb.*;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EmpAppBean implements EmpApp{

    @PersistenceContext
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String save(int id, String name, String city, double salary) throws EmpExistsException {

      try {
          System.out.println(em);
          Emp e = em.find(Emp.class, id);

          if (e != null) {
              throw new EmpExistsException("Emp Exists with id " + id);
          } else {
              em.persist(new Emp(id, name, city, salary));
              return "Emp Saved";
          }
      }catch(EmpExistsException ex){
          throw ex;
      }
    }



}
