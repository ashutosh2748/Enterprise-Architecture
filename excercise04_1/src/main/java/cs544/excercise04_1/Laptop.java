package cs544.excercise04_1;
import javax.persistence.*;

@Entity
public class Laptop {

@Id
@GeneratedValue
int id;

String brand;
String type;
@ManyToOne(cascade=CascadeType.ALL)
Employee employee;

@Override
public String toString() {
	return "Laptop [id=" + id + ", brand=" + brand + ", type=" + type + "]";
}
public Laptop(String brand, String type, Employee employee) {
	this.brand = brand;
	this.type = type;
	this.employee = employee;
}
public Laptop() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
}
