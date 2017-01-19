package cs544.excercise04_1;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class School {
	@Id
	@GeneratedValue
	int id;
	@OneToMany(cascade=CascadeType.ALL)
	@MapKey(name="studentid" )
	Map<Integer,Student> students=new HashMap<Integer,Student>();
	@Override
	public String toString() {
		return "School [id=" + id + ", students=" + students + "]";
	}
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public Student addStudents(Student student){
		return students.put(student.getStudentid(),student);
	}
	public Map<Integer, Student> getStudents() {
		return students;
	}
	public void setStudents(Map<Integer, Student> students) {
		this.students = students;
	}
	
}
