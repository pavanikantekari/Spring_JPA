package com.ojas.namedquery.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "person_table")
@NamedQueries(value = {
		@NamedQuery(name = "Person.findPersonInfoFirstNameOrEmail", query = "select p from Person p  where p.lastName=?1 OR p.email=?2"),
		@NamedQuery(name = "Person.findPersonLastName", query = "select p from Person p  where p.lastName=?1"),
		@NamedQuery(name = "Person.findPersonfirstName", query = "select p from Person p  where p.firstName=?1"),
		@NamedQuery(name = "Person.findPersonfirstNameOrLastName", query = "select p from Person p  where p.lastName=?1 OR p.lastName=?2") })
//@NamedQuery(name = "Person.findPersonInfoFirstNameOrEmail", query = "select p from Person p  where p.lastName=?1 OR p.email=?2")
//@NamedQuery(name = "Person.findPersonLastName", query = "select p from Person p  where p.lastName=?1")

public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "firstName", length = 60, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 60, nullable = false)
	private String lastName;

	@Column(name = "email", length = 60, nullable = false)
	private String email;
	@Column(name = "create_date")
	@CreationTimestamp
	private Date createDate;

	public Person() {

	}

	public Person(int id, String firstName, String lastName, String email, Date createDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", createDate=" + createDate + "]";
	}

}