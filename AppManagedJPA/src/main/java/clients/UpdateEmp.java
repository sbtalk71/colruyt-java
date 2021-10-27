package clients;

import com.demo.jpa.Address;
import com.demo.jpa.Emp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateEmp {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("test");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            Emp emp = em.find(Emp.class,301);
//            emp.getImages().add("Front.jpg");
//            emp.getImages().add("Left.jpg");
            Address address= new Address("123","2nd Street","800009");
            emp.setAddress(address);
            tx.begin();
            em.merge(emp);
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
