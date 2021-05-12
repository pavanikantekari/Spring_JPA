package com.ojas.namedquery.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ojas.namedquery.domain.Person;

@Repository
public interface PeopleManagementDao extends CrudRepository<Person, Integer> {
//    List<Person> findPerson(String firstName);
	List<Person> findPersonLastName(String lastName);

	List<Person> findPersonfirstName(String firstName);

	List<Person> findPersonInfoFirstNameOrEmail(String firstName, String email);

	List<Person> findPersonfirstNameOrLastName(String firstName, String lastName);
}