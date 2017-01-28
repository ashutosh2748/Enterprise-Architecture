package cs544.excercise03_2.part6;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Office {
	@Id
	@GeneratedValue
	int id;
	int roomNum;
	String building;
	@OneToMany(mappedBy="office",cascade=CascadeType.ALL)
	List<Employee1> employees;
	public Office() {
		super();
		employees=new ArrayList();
		// TODO Auto-generated constructor stub
	}
	public List<Employee1> getEmployees() {
		
		return employees;
	}
	public void setEmployees(List<Employee1> employees) {
		this.employees = employees;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	

}
