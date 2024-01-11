package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {
	
	public static void main(String[] args) {
		/*
		SessionFactory sessionFactory;
		try {
			System.out.println("Create student.......");
			StandardServiceRegistry stardardServiceRegistry = new StandardServiceRegistryBuilder() 
															.configure("hibernate.cfg.xml").build();
			System.out.println("Step 1 : ");
			
			Metadata metaData = new MetadataSources(stardardServiceRegistry)
								.getMetadataBuilder().build();
			System.out.println("Step 2 : ");
			
			sessionFactory = metaData.getSessionFactoryBuilder().build();
			System.out.println("done ");
		}catch(Exception e) {
			System.out.println("Fail... :  " + e.toString());
		}*/
		
		/**/
		System.out.println("Create a student.....");
		// create session factory
		// new Configuration() : create new
		// .configure("hibernate.cfg.xml") : Mapping to file .xml connect of database
		// .addAnnotatedClass(Sutent.class) : Mapping to class student
		// .buildSessionFactory() : start build sessionFactory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Step 1 : creat student");
			Student student = new Student("peter", "packer", "peterpacker@gmail.com");
			
			System.out.println("Step 2 : start 1 transaction");
			session.beginTransaction();
			
			System.out.println("Step 3 : save student object");
			session.save(student);
			
			System.out.println("Step 4 : commnit transaction");
			session.getTransaction().commit();
		}finally {
			System.out.println("Step 5 : SessionFactory close");
			factory.close();
		}
		
		System.out.println("Done!!!");
	}
}
