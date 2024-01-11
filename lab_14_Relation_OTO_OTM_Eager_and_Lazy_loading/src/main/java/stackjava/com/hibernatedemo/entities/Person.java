package stackjava.com.hibernatedemo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {
	  @Id
	  @Column(name = "id")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer id;
	  @Column(name = "name")
	  private String name;
	  @Column(name = "address")
	  private String address;
	
	public Person() {
		
	}

	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}


	@Override
	public String toString() {
	return "Person [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	  
}
