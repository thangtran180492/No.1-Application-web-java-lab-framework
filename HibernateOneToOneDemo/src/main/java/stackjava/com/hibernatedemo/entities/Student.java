package stackjava.com.hibernatedemo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "class_name")
	private String className;
	@Column(name = "school_name")
	private String schoolName;
	@OneToOne
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;
	
	
	public Student() {
	}

	
	public Student(String className, String schoolName) {
		this.className = className;
		this.schoolName = schoolName;
	}

	@Override
	public String toString() {
	return "Student [id=" + id + ", className=" + className + ", schoolName=" + schoolName + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
