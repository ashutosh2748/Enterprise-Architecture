package cs544.excercise04_1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Passenger {
@Id
@GeneratedValue
int id;
String name;
@OneToMany(cascade=CascadeType.ALL)
List<Flight> flights;
public Passenger() {
	super();
	// TODO Auto-generated constructor stub
	flights=new ArrayList<Flight>();
}
@Override
public String toString() {
	return "Passenger [id=" + id + ", name=" + name + ", flights=" + flights + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public boolean addFlight(Flight flight){
	
	return flights.add(flight);
}
public boolean removeFlight(Flight flight){
	return flights.remove(flight);
}
public List<Flight> getFlights() {
	return flights;
}
public void setFlights(List<Flight> flights) {
	this.flights = flights;
}

}
