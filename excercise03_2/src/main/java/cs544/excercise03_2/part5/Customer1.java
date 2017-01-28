package cs544.excercise03_2.part5;

import java.util.List;

import javax.persistence.*;


@Entity
public class Customer1 {
	@Id
	@GeneratedValue
	int id;
	String name;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	List<Reservation1> reservation;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Reservation1> getReservation() {
		return reservation;
	}
	public void setReservation(List<Reservation1> reservation) {
		this.reservation = reservation;
	}

}
