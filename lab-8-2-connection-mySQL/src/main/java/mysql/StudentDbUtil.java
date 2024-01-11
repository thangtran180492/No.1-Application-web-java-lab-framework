package mysql;

import java.sql.Connection;
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
			// step 1 : connect database
			myConn = dataSource.getConnection();
			
			// step 2 : create statement
			myStmt = myConn.createStatement();
			
			// step 3 : execute query
			String sql = "select * from student";
			myRs = myStmt.executeQuery(sql);
			
			// step 4 : creat object
			while(myRs.next()) {
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				students.add(new Student(id, firstName, lastName, email));
			}
			
		}
		finally {
			// step 5 : close
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
}
