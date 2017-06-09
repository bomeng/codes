package com.apple;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class Book implements Serializable {
	private static final long serialVersionUID = 2877654108916158753L;

	private int id;
	private String title;
	private String authors;
	private double price;

	public Book() {
	}

	public Book(int id, String title, String authors, double price) {
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getAuthors() {
		return authors;
	}

	@XmlElement
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public double getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authors=" + authors + ", price=" + price + "]";
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (!(object instanceof Book)) {
			return false;
		} else {
			Book book = (Book) object;
			if (id == book.getId() && title.equals(book.getTitle())) {
				return true;
			}
		}
		return false;
	}
}
