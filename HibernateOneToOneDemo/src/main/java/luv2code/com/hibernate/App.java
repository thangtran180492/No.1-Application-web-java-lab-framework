package luv2code.com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import luv2code.com.hibernate.entity.*;

public class App {
	public static void main(String[] args) {

		System.out.println("Create a instructor.....");
		// create session factory
		// new Configuration() : create new
		// .configure("hibernate.cfg.xml") : Mapping to file .xml connect of database
		// .addAnnotatedClass(Instructor.class) : Mapping to class Instructor
		// .addAnnotatedClass(InstructorDetail.class) :  Mapping to class InstructorDetail
		// .buildSessionFactory() : start build sessionFactory
		SessionFactory factory = new Configuration()
									.configure("META-INF/hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		System.out.println("Step 1 : create Instructor and InstructorDetail ");
		Instructor instructor = new Instructor("Chad", "Darby","chadbarby@gmail.com");
		
		InstructorDetail instructorDetail = 
				new InstructorDetail("http://www/luv2code.com/yoube", "luv 2 code");
		// set instructorDetail of instructor
		instructor.setInstructorDetail(instructorDetail);
		
		System.out.println("Step 2 : create session");
		Session session = factory.getCurrentSession();
		try {
		System.out.println("Step 3 : begin Transaction");
		session.beginTransaction();
		
		System.out.println("Step 4 : save instructor");
		session.save(instructor);
		
		System.out.println("Step 5 : commnit transaction");
		session.getTransaction().commit();
		
		System.out.println("Done....");
		
		}catch(Exception e){
			System.out.println("Fail....");
		}finally {
			System.out.println("session close....");
			session.close();
		}
	}
}
