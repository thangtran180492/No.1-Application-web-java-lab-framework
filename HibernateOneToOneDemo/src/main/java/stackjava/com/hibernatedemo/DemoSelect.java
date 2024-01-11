package stackjava.com.hibernatedemo;

import jakarta.persistence.*;
import stackjava.com.hibernatedemo.entities.*;

public class DemoSelect {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    entityManager.getTransaction().begin();
	    Student student= entityManager.find(Student.class, 1);
	    System.out.println(student);
	    System.out.println(student.getPerson());
	    
	    entityManager.getTransaction().commit();
	    entityManager.close();
	    entityManagerFactory.close();
	}

}
