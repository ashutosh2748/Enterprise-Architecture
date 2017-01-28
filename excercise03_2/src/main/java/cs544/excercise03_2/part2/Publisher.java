package cs544.excercise03_2.part2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
@Entity
public class Publisher {
@Id
@GeneratedValue
long id;
String name;
//@OneToMany()
//@JoinColumn(foreignKey=)

//@JoinTable()
//List<Book> books;



Publisher(){
	
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
