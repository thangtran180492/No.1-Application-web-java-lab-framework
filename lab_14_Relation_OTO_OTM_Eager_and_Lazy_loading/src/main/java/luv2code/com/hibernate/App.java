package luv2code.com.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import luv2code.com.hibernate.entity.*;

public class App {
	private static SessionFactory factory;
	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String select = "";
		while(true) {
			System.out.println("select :\n"
					+ "1 : create instructor\n"
					+ "2 : find from id\n"
					+ "3 : create course\n"
					+ "4 : find course\n"
					+ "5 : create student\n"
					+ "6 : find student\n"
					+ "7 : end\n");
			try {
				select = sc.nextLine();
				if(select.equals("1")) {
					createInstructor();
				}else if(select.equals("2")){
					System.out.println("enter id : ");
					int id = Integer.parseInt(sc.nextLine());
					findCouseFromIDInstructor(id);
					
				}else if(select.equals("3")){
					createCourse();
				}else if(select.equals("4")){
					findCouseFromID();
				}else if(select.equals("5")){
					createStudent();
				}else if(select.equals("6")){
					findStudentFromID();
				}else if(select.equals("7")){
					break;
				}else {
					throw new Exception();
				}
			}catch (Exception e) {
				System.out.println("enter wrong..... again select");
			}
		}
		System.out.println("end");
		sc.close();
	}
	public static void setUp() {
		// create session factory
		// new Configuration() : create new
		// .configure("hibernate.cfg.xml") : Mapping to file .xml connect of database
		// .addAnnotatedClass(Instructor.class) : Mapping to class Instructor
		// .addAnnotatedClass(InstructorDetail.class) :  Mapping to class InstructorDetail
		// .addAnnotatedClass(Course.class) : mapping to class course
		// .buildSessionFactory() : start build sessionFactory
		factory = new Configuration()
									.configure("META-INF/hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
	}
	public static void createCourse() throws Exception {
		System.out.println("Create a course.....");
		setUp();
		
		System.out.println("Step 1 : create course\n"
				+"Enter id Instructor --> \n");

		try {
			int instructorId = Integer.parseInt(sc.nextLine());
			
			System.out.println("Step 1-1 : create session");
			Session session = factory.getCurrentSession();
			
			System.out.println("Step 1-2 : begin Transaction");
			session.beginTransaction();
			
			System.out.println("Step 1-3 : get the instructor object");
			Instructor tempInstructor = session.get(Instructor.class, instructorId);
			
			//
			System.out.println("Step 1-4 :\n"
					+ "Enter name new course --> \n");
			String nameCourse = sc.nextLine();
			Course course = new Course(nameCourse, tempInstructor);
			
			System.out.println("Step 2 : save instructor");
			session.save(course);
			
			System.out.println("Step 3 : commnit transaction");
			session.getTransaction().commit();
			
			System.out.println("Done....!!!");
			
		}catch(Exception e){
			System.out.println("Fail....");
			throw new Exception();
		}finally {
			System.out.println("session close....");
		}
	}
	public static void findCouseFromID() throws Exception {
		System.out.println("find course to id.....");
		setUp();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Step 1 : Enter id course -->\n");
			int courseId = Integer.parseInt(sc.nextLine());
			
			System.out.println("Step 2 : create session");
			
			
			System.out.println("Step 2 : begin Transaction");
			session.beginTransaction();
			
			System.out.println("Step 3 : get the instructor object");
			Course course = session.get(Course.class, courseId);
			
			System.out.println("Step 4 : print Instructor: \n" + course.toString()+"\n");
			System.out.println("Done....!!!");
		
		}catch(Exception e){
			System.out.println("Fail....");
			throw new Exception();
		}finally {
			System.out.println("session close....");
			session.close();
			factory.close();
		}
		
	}
	public static void createInstructor() {
		System.out.println("Create a instructor.....");
		setUp();
		
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
		
		System.out.println("Done....!!!");
		
		}catch(Exception e){
			System.out.println("Fail....");
		}finally {
			System.out.println("session close....");
			session.close();
			factory.close();
		}
	}
	public static void findCouseFromIDInstructor(int id) throws Exception {
		System.out.println("find course to id instructor.....");
		setUp();
		
		System.out.println("Step 1 : create session");
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Step 2 : begin Transaction");
			session.beginTransaction();
			
			System.out.println("Step 3 : get the instructor object");
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			System.out.println("Step 4 : print Instructor: \n" + tempInstructor.getCourses()+"\n");
			System.out.println("Done....!!!");
		
		}catch(Exception e){
			System.out.println("Fail....");
			throw new Exception();
		}finally {
			System.out.println("session close....");
			session.close();
			factory.close();
		}
	}
	public static void createStudent() {
		System.out.println("Create a Student.....");
		setUp();
		
		System.out.println("Step 1 : create student \n"
				+ "Enter first name : -->\n");
		String firstName = sc.nextLine();
		
		System.out.println("Enter last name : -->\n");
		String lastName = sc.nextLine();
		
		System.out.println("Enter email : -->\n");
		String email = sc.nextLine();
		
		Student student = new Student(firstName, lastName, email);
		
		System.out.println("Step 2 : create session");
		Session session = factory.getCurrentSession();
		try {
		System.out.println("Step 3 : begin Transaction");
		session.beginTransaction();
		
		System.out.println("Step 4 : save instructor");
		session.save(student);
		
		System.out.println("Step 5 : commnit transaction");
		session.getTransaction().commit();
		
		System.out.println("Done....!!!");
		
		}catch(Exception e){
			System.out.println("Fail....");
		}finally {
			System.out.println("session close....");
			session.close();
			factory.close();
		}
	}
	public static void findStudentFromID() throws Exception {
		System.out.println("find student to id .....");
		setUp();
		
		System.out.println("Step 1 : create session");
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Step 2 : Enter id student -->\n");
			int studentID = Integer.parseInt(sc.nextLine());
			
			System.out.println("Step 2 : begin Transaction");
			session.beginTransaction();
			
			System.out.println("Step 3 : get the instructor object");
			Student student = session.get(Student.class, studentID);
			
			System.out.println("Step 4 : print Instructor: \n" + student.toString()+"\n");
			System.out.println("Done....!!!");
		
		}catch(Exception e){
			System.out.println("Fail....");
			throw new Exception();
		}finally {
			System.out.println("session close....");
			session.close();
			factory.close();
		}
	}
	
}
