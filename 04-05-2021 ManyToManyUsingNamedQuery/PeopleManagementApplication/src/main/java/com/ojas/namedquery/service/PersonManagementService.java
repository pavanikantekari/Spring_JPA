package com.ojas.namedquery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.namedquery.dao.PeopleManagementDao;
import com.ojas.namedquery.domain.Person;

@Service
public class PersonManagementService {
	@Autowired
	private PeopleManagementDao dao;

	public Person createperson(Person person) {
		return dao.save(person);
	}

	public Optional<Person> getPerson(Integer person_id) {
		return dao.findById(person_id);
	}

	public List<Person> createpersonList(List<Person> person) {
		Iterable<Person> list = dao.saveAll(person);
		return (List<Person>) list;
	}

	public Iterable<Person> getPerson(List<Integer> person) {
		return dao.findAll();
	}

	public void deletePerson(Integer personId) {
		dao.deleteById(personId);
	}

	public void updatePerson(Person newperson) {
		dao.save(newperson);
	}

	public List<Person> getPersonBylastName(String lastName) {
		return dao.findPersonLastName(lastName);
	}

	public List<Person> getPersonByfirstName(String firstName) {
		return dao.findPersonfirstName(firstName);
	}

	public List<Person> getpersonByFirstNameorEmail(String firstName, String email) {
		return dao.findPersonInfoFirstNameOrEmail(firstName, email);
	}

	public List<Person> getPersonByFirstNameorlastName(String firstName, String lastname) {
		return dao.findPersonfirstNameOrLastName(firstName, lastname);
	}
}
