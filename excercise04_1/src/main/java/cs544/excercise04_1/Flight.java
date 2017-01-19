package cs544.excercise04_1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue
	private int id;
	private String flightNo;
	@Column(name="flightFrom")
	private String from;
	@Column(name="flightTo")
	private String to;
	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNo=" + flightNo + ", from=" + from + ", to=" + to + ", date=" + date + "]";
	}
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
