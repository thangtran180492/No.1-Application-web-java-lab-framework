package luv2code.com.hibernate.entity;

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

	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.PERSIST, 
							CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
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
	
}
