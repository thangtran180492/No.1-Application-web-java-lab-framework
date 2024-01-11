package MVC;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {
	public static List<Student> getStudent(){
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("May", "White", "maywhite@email.com"));
		students.add(new Student("Jond", "Peter", "johnpeter@email.com"));
		students.add(new Student("Jack", "homer", "jackhomer@email.com"));
		return students;
	}
}
