package luv2code.com.hibernate.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;

	@ManyToOne(
			cascade= {
					CascadeType.MERGE, CascadeType.PERSIST, 
					CascadeType.REFRESH, CascadeType.DETACH}
			)
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	// JoinTable of tables
	// name : of ManyToMany table
	// joinColumns : table 1
	// inverseJoinColumns : table 2 
	@ManyToMany
	@JoinTable(
			name="course_student",
			joinColumns=@JoinColumn(name="course_id"),
			inverseJoinColumns=@JoinColumn(name="student_id")
			)
	private List<Student> students;
	
	
	public Course() {
	}

	public Course(String title, Instructor instructor) {
		this.title = title;
		this.instructor = instructor;
	}

	public Course(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + ", students=" + students + "]";
	}
	
}
