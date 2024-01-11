package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {
	
	public static void main(String[] args) {
		
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
		
		System.out.println("Done!!!");
	}
}
