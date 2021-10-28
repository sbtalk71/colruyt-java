package queries;

import com.demo.jpa.Emp;

import javax.persistence.*;
import java.util.List;

public class NamedQueryDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            //Query query=em.createNamedQuery("demo1");
            Query query2=em.createNamedQuery("demo2");
            query2.setParameter(1,"%Sh%");
            List<Emp> empList=query2.getResultList();
            empList.stream().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();

        }
    }
}
