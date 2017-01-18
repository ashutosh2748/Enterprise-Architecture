package cs544.excercise03_2.part1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CollectionType;

@Entity
public class Department {
	@Id
	@GeneratedValue
	long id;
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	String name;
	@OneToMany(cascade=CascadeType.ALL)
	List<Employee> employees;
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employees=" + employees + "]";
	}
	public Department(String name) {
		name = name;
		employees=new ArrayList();
	}
	public Department() {
	
	}
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
	}

}
