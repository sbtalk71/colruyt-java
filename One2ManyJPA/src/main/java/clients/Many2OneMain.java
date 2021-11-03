package clients;

import com.demo.jpa.Dept;
import com.demo.jpa.Emp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Many2OneMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            Dept dept = em.find(Dept.class, 10);

            Emp emp1 = new Emp(400, "Karan", "Mumbai", 90000);
            Emp emp2 = new Emp(401, "Charan", "Hyderabad", 80000);

            emp1.setDept(dept);
            emp2.setDept(dept);

            tx.begin();
            em.persist(emp1);
            em.persist(emp2);
            tx.commit();
            System.out.println("Data saved...");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();

        }

    }
}
