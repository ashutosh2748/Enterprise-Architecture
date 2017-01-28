package cs544.excercise04_1;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Employee {
	@Id
	@GeneratedValue
	int id;
	String firstName;
	String lastName;
	@OneToMany(mappedBy="employee",cascade=CascadeType.ALL)
	Set<Laptop> laptops;
	public Employee(String firstName, String lastName, Set<Laptop> laptops) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.laptops = laptops;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
		laptops=new HashSet<Laptop>();
		
	}
	
	
	public boolean addLaptop(Laptop l){
		l.setEmployee(this);
		return laptops.add(l);
	}
	public boolean removeLaptop(Laptop l){
		//l.setEmployee(this);
		return laptops.remove(l);
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", laptops=" + laptops
				+ "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<Laptop> getLaptops() {
		return laptops;
	}
	public void setLaptops(Set<Laptop> laptops) {
		this.laptops = laptops;
	}

}
