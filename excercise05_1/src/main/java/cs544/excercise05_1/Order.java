package cs544.excercise05_1;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Product_Order")
public class Order {
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", date=" + date + ", orderlines=" + orderlines + "]";
	}
	@Id
	@GeneratedValue
	long orderid;
	Date date;
	@ManyToOne
	Customer customer;
	@OneToMany(cascade=CascadeType.ALL)
	List<OrderLine> orderlines=new ArrayList<OrderLine>();
	public long getOrderid() {
		return orderid;
	}
	
	public boolean addOrderLine(OrderLine orderline){
		
		return orderlines.add(orderline);
	}
	private void setOrderid(long orderid) {
		this.orderid = orderid;
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
	public List<OrderLine> getOrderlines() {
		return orderlines;
	}
	public void setOrderlines(List<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}
	
}
