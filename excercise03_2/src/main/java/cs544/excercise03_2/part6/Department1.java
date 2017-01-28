package cs544.excercise03_2.part6;

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
public class Department1 {
	@Id
	@GeneratedValue
	long id;
	
	String name;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="department")
	List<Employee1> employees;
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employees=" + employees + "]";
	}
	public List<Employee1> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee1> employees) {
		this.employees = employees;
	}
	public Department1(String name) {
		name = name;
		employees=new ArrayList();
	}
	public Department1() {
		employees=new ArrayList();
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
