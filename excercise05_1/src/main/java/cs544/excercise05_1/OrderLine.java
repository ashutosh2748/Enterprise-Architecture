package cs544.excercise05_1;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class OrderLine {

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", quantity=" + quantity + ", product=" + product + "]";
	}
	@Id
	@GeneratedValue
	long id;
	int quantity;
	@ManyToOne(cascade=CascadeType.ALL)
	Product product;
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
