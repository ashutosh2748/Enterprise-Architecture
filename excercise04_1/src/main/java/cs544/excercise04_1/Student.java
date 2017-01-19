package cs544.excercise04_1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
@Id
@GeneratedValue
private int id;
private int studentid;
@Override
public String toString() {
	return "Student [id=" + id + ", studentid=" + studentid + ", firstName=" + firstName + ", lastName=" + lastName
			+ "]";
}
private String firstName;
private String lastName;
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + id;
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + studentid;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Student other = (Student) obj;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (id != other.id)
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	if (studentid != other.studentid)
		return false;
	return true;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getStudentid() {
	return studentid;
}
public void setStudentid(int studentid) {
	this.studentid = studentid;
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

}
