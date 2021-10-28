package clients;

import com.demo.jpa.Emp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveOneMain {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("test");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
           Emp emp = new Emp(301,"Rakesh","Mumbai",90000);
            tx.begin();
            em.persist(emp);
            tx.commit();

        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }
    }
}
