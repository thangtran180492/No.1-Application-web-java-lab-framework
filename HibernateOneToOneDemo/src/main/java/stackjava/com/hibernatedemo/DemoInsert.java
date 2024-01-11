package stackjava.com.hibernatedemo;

import jakarta.persistence.*;

import stackjava.com.hibernatedemo.entities.*;

public class DemoInsert {

	public static void main(String[] args) {
		System.out.println("Step 0 : create EntityManagerFactory");
		EntityManagerFactory entityManagerFactory = 
					Persistence.createEntityManagerFactory("persistence");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    System.out.println("Step 1 : begin transaction");
	    entityManager.getTransaction().begin();
	    
	    System.out.println("Step 2 : create object student and person");
	    Person person = new Person("kai", "ha noi - viet nam");
	    Student student = new Student("D11CN2", "PTIT");
	    // set person from student
	    student.setPerson(person);
	    
	    
	    System.out.println("Step 3 : save student to database");
	    entityManager.persist(person);
	    entityManager.persist(student);
	    
	    
//	    Student student2 = new Student("DXXXX1", "FTU");
//	    student2.setPerson(person);
	    
	    System.out.println("Step 4 : save student 2 to database");
//	    entityManager.persist(student2);
	    entityManager.getTransaction().commit();
	    System.out.println("--------- after insert -------------");
	    System.out.println(person);
	    System.out.println(student);
	    
	    entityManager.close();
	    entityManagerFactory.close();
	  }

}
