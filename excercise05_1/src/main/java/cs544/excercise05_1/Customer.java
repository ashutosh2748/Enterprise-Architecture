package cs544.excercise05_1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
@Id
@GeneratedValue
int id;
String first;
String last;
@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
List<Order> orders=new ArrayList<Order>();
public int getId() {
	return id;
}

private void setId(int id) {
	this.id = id;
}
public boolean addOrder(Order order){
	order.setCustomer(this);
	return orders.add(order);
}
@Override
public String toString() {
	return "Customer [id=" + id + ", first=" + first + ", last=" + last + ", orders=" + orders + "]";
}

public String getFirst() {
	return first;
}
public void setFirst(String first) {
	this.first = first;
}
public String getLast() {
	return last;
}
public void setLast(String last) {
	this.last = last;
}
public List<Order> getOrders() {
	return orders;
}
public void setOrders(List<Order> orders) {
	this.orders = orders;
}


}
