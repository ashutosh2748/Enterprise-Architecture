package cs544.excercise03_2.part4;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import cs544.excercise03_2.part5.Book1;
@Entity
public class Reservation {
	@Id
	@GeneratedValue
	int id;
	Date date;
	@ManyToOne
	Customer customer;
	//@OneToMany(mappedBy="reservation")
	//Book book;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
