package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {
	private DataSource dataSource;
	
	public StudentDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Student> getStudents() throws Exception {
		List<Student> students = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// read step 1 : connect database
			myConn = dataSource.getConnection();
			
			// read step 2 : create statement
			myStmt = myConn.createStatement();
			
			// read step 3 : execute query
			String sql = "select * from student";
			myRs = myStmt.executeQuery(sql);
			
			// read step 4 : creat object
			while(myRs.next()) {
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				students.add(new Student(id, firstName, lastName, email));
			}
			
		}
		finally {
			// read step 5 : close
			close(myConn, myStmt, myRs);
		}
		return students;
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		
			try {
				if(myConn != null)
					myConn.close();
				if(myStmt != null)
					myStmt.close();
				if(myRs != null)
					myRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void addStudents(Student student) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			// create step 4 : create connection to data source
			myConn = dataSource.getConnection();
			
			// create step 5 : create sql for insert
			String sql = "insert into student"
						+ "(first_name, last_name, email)"
						+ "value(?,?,?)";
			myStmt = myConn.prepareStatement(sql);
			
			// create step 6 : set param for student
			myStmt.setString(1, student.getFirstname());
			myStmt.setString(2, student.getLastname());
			myStmt.setString(3, student.getEmail());
			
			// create step 7 : excute sql for insert
			myStmt.execute();
		
		}finally {
			// create step 8 : clear up JDBC
			close(myConn, myStmt, null);
		}
		
	}

	public Student getStudent(String studentId) throws Exception {
		Student student = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
		// load step 5 : cover String id to int id
		int id = Integer.parseInt(studentId);
		
		// load step 6 : connection dataSource
		myConn = dataSource.getConnection();
		
		// load step 7 : create sql and create prepared statement
		String sql = "select * from student where id=?";
		myStmt = myConn.prepareStatement(sql);
		
		// load step 8 : set parament statement ?
		myStmt.setInt(1, id);
		
		// load step 9 : execute result statement
		myRs = myStmt.executeQuery();
		
		// load step 10 : create and return result student
		if(myRs.next()) {
			int stID = myRs.getInt("id");
			String stFristName = myRs.getString("first_name");
			String stLastName = myRs.getString("last_name");
			String stEmail = myRs.getString("email");
			student = new Student(stID, stFristName, stLastName, stEmail);
		}else {
			throw new Exception("Can't find student id : " + studentId);
		}
				
		return student;
		
		}finally {
			// load step 11 : clear up
			close(myConn, myStmt, myRs);
		}
	}

	public void updateStudent(Student theStudent) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			// update step 5 : create connection
			myConn = dataSource.getConnection();
		
			// update step 6 : create update SQL AND prepare statement
			String sql = "update student "
						+ "set first_name=?, last_name=?, email=? "
						+ "where id=?";
			myStmt = myConn.prepareStatement(sql);
		
			// update step 7 : set param =?
			myStmt.setString(1, theStudent.getFirstname());
			myStmt.setString(2, theStudent.getLastname());
			myStmt.setString(3, theStudent.getEmail());
			myStmt.setInt(4, theStudent.getId());
			
			// update step 8 : excute SQL
			myStmt.execute();
			
		}finally {
			// update step 9 : clear up
			close(myConn, myStmt, null);
		}
	}

	public void deleteStudent(String studentId) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			// delete step 4 : cover String to int
			int id = Integer.parseInt(studentId);
			
			// delete step 5 : create connection
			myConn = dataSource.getConnection();
			
			// delete step 6 : create sql to delele student from database
			String sql = "DELETE FROM student WHERE id=?";
			
			// delete step 7 : prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// delete step 8 : set params =?
			myStmt.setInt(1, id);
			
			// delete step 9 : execute sql statement
			myStmt.execute();
			
		}finally {
			// delete step 10 : clear up
			close(myConn, myStmt, null);
		}
	}
}
