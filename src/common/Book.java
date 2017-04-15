package common;

import java.sql.Timestamp;

public class Book {
	private String ISBN;
	private String id;
	private String name;
	private String author;
	private String press;
	private double price;
	private String location;
	private Timestamp publish_date;
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Timestamp getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Timestamp publish_date) {
		this.publish_date = publish_date;
	}
	
}
