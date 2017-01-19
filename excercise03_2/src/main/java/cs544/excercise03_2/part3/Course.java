package cs544.excercise03_2.part3;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {
@Id
@GeneratedValue
long id;
int coursenumber;
String name;
@ManyToMany
List<Student> students;
public Course() {
	super();
	// TODO Auto-generated constructor stub
}
public Course(int coursenumber, String name) {
	this.coursenumber = coursenumber;
	this.name = name;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public int getCoursenumber() {
	return coursenumber;
}
public void setCoursenumber(int coursenumber) {
	this.coursenumber = coursenumber;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


}
