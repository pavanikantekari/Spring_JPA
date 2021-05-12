package com.ojas.manytomany.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Book.findAllDetails", query = "SELECT b FROM Book b JOIN b.publisher p WHERE b.id=?1"),
		@NamedQuery(name = "Book.findBookByPublisher", query = "SELECT p FROM Book b JOIN b.publisher p WHERE p.id=?1") })
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "book_publisher", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "id"))
	private Set<Publisher> publisher;

	public Book() {

	}

	public Book(String name) {
		super();
		this.name = name;
	}

	public Book(String name, Set<Publisher> publisher) {
		super();
		this.name = name;
		this.publisher = publisher;
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

	public Set<Publisher> getPublisher() {
		return publisher;
	}

	public void setPublisher(Set<Publisher> publisher) {
		this.publisher = publisher;
	}

	public String toString() {
		String result = String.format("Publisher [id=%d, name='%s']%n", id, name);
		if (publisher != null) {
			for (Publisher publisher : publisher) {
				result += String.format("Book[id=%d, name='%s']%n", publisher.getId(), publisher.getName());
			}
		}
		return result;
	}

}
