package cs544.excercise03_2.part5;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
@Entity
public class Reservation1 {
	@Id
	@GeneratedValue
	int id;
	Date date;
	@ManyToOne(cascade=CascadeType.ALL)
	Customer1 customer;
	@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="reservations")
	Book1 book;
	@Override
	public String toString() {
		return "Reservation [date=" + date + ", customer=" + customer + "]";
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Customer1 getCustomer() {
		return customer;
	}
	public void setCustomer(Customer1 customer) {
		this.customer = customer;
	}
	

}
