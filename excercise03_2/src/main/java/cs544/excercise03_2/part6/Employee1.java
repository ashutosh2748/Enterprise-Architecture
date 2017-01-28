package cs544.excercise03_2.part6;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee1 {
	
	@Id
	@GeneratedValue
	long employeeNumber;
	String name;
	@ManyToOne(cascade=CascadeType.ALL)
	Department1 department;
	@ManyToOne(cascade=CascadeType.ALL)
	Office office;
	Employee1(){
		
	}
	public Employee1(long employeeNumber, String name) {
		this.employeeNumber = employeeNumber;
		this.name = name;
	}
	public long getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", name=" + name + ", department=" + department + "]";
	}
	
}
