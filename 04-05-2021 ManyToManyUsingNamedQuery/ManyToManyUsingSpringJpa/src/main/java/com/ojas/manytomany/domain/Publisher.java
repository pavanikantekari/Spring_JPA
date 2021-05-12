package com.ojas.manytomany.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToMany(mappedBy = "publisher")
	private Set<Book> book;

	public Publisher() {

	}

	public Publisher(String name) {
		super();
		this.name = name;
	}

	public Publisher(String name, Set<Book> book) {
		super();
		this.name = name;
		this.book = book;
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

	public Set<Book> getBook() {
		return book;
	}

	public void setBook(Set<Book> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		String result = String.format("Publisher [id=%d, name='%s']%n", id, name);
		if (book != null) {
			for (Book book2 : book) {
				result += String.format("Book[id=%d, name='%s']%n", book2.getId(), book2.getName());
			}
		}
		return result;
	}

}
