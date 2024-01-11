package luv2code.com.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import luv2code.com.hibernate.entity.*;

public class App {
	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String select = "";
		while(true) {
			System.out.println("select :\n"
					+ "1 : create instructor\n"
					+ "2 : find from id\n"
					+ "3 : end\n");
			try {
				select = sc.nextLine();
				if(select.equals("1")) {
					createInstructor();
					break;
				}else if(select.equals("2")){
					System.out.println("enter id : ");
					int id = Integer.parseInt(sc.nextLine());
					findCouseFromID(id);
					break;
					
				}else if(select.equals("3")){
					break;
				}else {
					System.out.println("enter wrong..... again select");
					continue;
				}
			}catch (Exception e) {
				System.out.println("enter wrong..... again select");
			}
		}
		System.out.println("end");
		sc.close();
	}
	public static void createInstructor() {
		System.out.println("Create a instructor.....");
		// create session factory
				// new Configuration() : create new
				// .configure("hibernate.cfg.xml") : Mapping to file .xml connect of database
				// .addAnnotatedClass(Instructor.class) : Mapping to class Instructor
				// .addAnnotatedClass(InstructorDetail.class) :  Mapping to class InstructorDetail
				// .addAnnotatedClass(Course.class) : mapping to class course
				// .buildSessionFactory() : start build sessionFactory
				SessionFactory factory = new Configuration()
											.configure("META-INF/hibernate.cfg.xml")
											.addAnnotatedClass(Instructor.class)
											.addAnnotatedClass(InstructorDetail.class)
											.addAnnotatedClass(Course.class)
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
	public static void findCouseFromID(int id) {
		System.out.println("find to id.....");
		// create session factory
		// new Configuration() : create new
		// .configure("hibernate.cfg.xml") : Mapping to file .xml connect of database
		// .addAnnotatedClass(Instructor.class) : Mapping to class Instructor
		// .addAnnotatedClass(InstructorDetail.class) :  Mapping to class InstructorDetail
		// .addAnnotatedClass(Course.class) : mapping to class course
		// .buildSessionFactory() : start build sessionFactory
		SessionFactory factory = new Configuration()
									.configure("META-INF/hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
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
		
		System.out.println("Step 4 : get the instructor object");
		Instructor tempInstructor = session.get(Instructor.class, id);
		
		System.out.println("Step 5 : print Instructor: \n" + tempInstructor.getCourses());
		System.out.println();
		System.out.println("Done....");
		
		}catch(Exception e){
			System.out.println("Fail....");
		}finally {
			System.out.println("session close....");
			session.close();
		}
	}
}
