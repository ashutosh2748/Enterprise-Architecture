package cs544.excercise03_2.part4;

import java.util.List;

import javax.persistence.*;


@Entity
public class Customer {
	@Id
	@GeneratedValue
	int id;
	String name;
	@OneToMany(mappedBy="customer")
	List<Reservation> reservation;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Reservation> getReservation() {
		return reservation;
	}
	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

}
