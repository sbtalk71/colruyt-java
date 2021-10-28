package queries;

import com.demo.jpa.Emp;

import javax.persistence.*;
import java.util.List;

public class NamedQuerywithProjection {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {


    /*
            Query query2=em.createNamedQuery("demo3");
            List<Object[]> empList=query2.getResultList();
            for(Object[] data:empList){
                String name=(String)data[0];
                double salary=(Double)data[1];
                System.out.println(name+" "+salary);
            }*/
            Query query2 = em.createNamedQuery("demo4");
            List<Data> empList = query2.getResultList();
            empList.stream().forEach(e -> System.out.println(e.getName() + " " + e.getSalary()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();

        }
    }
}
