package queries;

import com.demo.jpa.Emp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class NamedNativeQueryDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            Query query2=em.createNamedQuery("demoSQL1");

            List<Object[]> empList=query2.getResultList();
            for(Object[] data:empList){
                String name=(String)data[0];
                BigDecimal salary=(BigDecimal)data[1];
                System.out.println(name+" "+salary);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();

        }
    }
}
