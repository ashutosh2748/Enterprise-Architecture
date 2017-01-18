package cs544.excercise03_2.part2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Publisher {
@Id
@GeneratedValue
long id;
String name;
List<Book> books;

public List<Book> getBooks() {
	return books;
}


public void setBooks(List<Book> books) {
	this.books = books;
}


Publisher(){
	books=new ArrayList();
}


public Publisher(String name, List<Book> books) {
	this.name = name;
	this.books = books;
}


public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Publisher(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Publisher [id=" + id + ", name=" + name + "]";
}


}
