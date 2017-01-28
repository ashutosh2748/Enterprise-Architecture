package cs544.exercise16_1.bank.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Customer {
	@Id
	@GeneratedValue
	long id;
	private String name;

	public Customer(){}
	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setId(long id){
		this.id=id;
	}
	

}
