package clients;

import com.demo.jpa.Dept;
import com.demo.jpa.Emp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Many2OneMainFinder {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
      // EntityTransaction tx = em.getTransaction();
        try {
            Dept dept = em.find(Dept.class, 10);

            System.out.println(dept);

            //dept.getEmps().stream().forEach(System.out::println);

        //   tx.begin();
         //   tx.commit();
            System.out.println("Data saved...");
        } catch (Exception e) {
            //tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();

        }

    }
}
