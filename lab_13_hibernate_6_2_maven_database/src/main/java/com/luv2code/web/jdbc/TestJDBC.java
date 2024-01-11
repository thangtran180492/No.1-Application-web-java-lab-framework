package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_student_tracker?userSSL=false";
		String user = "webstudent";
		String pass = "webstudent";
		try {
			System.out.println("Connect to : " + jdbcUrl);
			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connect Successfull !!! ");
		}catch (Exception ex) {
			System.out.println("Connect fail");
		}
	}

}
