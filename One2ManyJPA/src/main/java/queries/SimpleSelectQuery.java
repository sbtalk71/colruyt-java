package queries;

import com.demo.jpa.Emp;

import javax.persistence.*;
import java.util.List;

public class SimpleSelectQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            Query query=em.createQuery("select e from Emp e where e.empId between 100 and 109");
            List<Emp> empList=query.getResultList();
            empList.stream().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();

        }
    }
}
