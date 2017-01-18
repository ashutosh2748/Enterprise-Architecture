package edu.mum.cs.cs544.exercises;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Owner {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Owner(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Owner [name=" + name + ", address=" + address + "]";
	}
	public Owner() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
} 
