package com.ojas.namedquery;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ojas.namedquery.domain.Person;
import com.ojas.namedquery.service.PersonManagementService;

@SpringBootApplication
public class PeopleManagement implements CommandLineRunner {
	@Autowired
	private PersonManagementService serivce;

	public static void main(String[] args) {

		SpringApplication.run(PeopleManagement.class, args);

	}

	private void createPerson() {
		Person person = new Person(1, "suresh", "Thota", "suresh@gmail.com", new Date());
		person = serivce.createperson(person);
		System.out.println("saved");
	}

	private void createPersons() {
		List<Person> personList = Arrays.asList(new Person(1, "suresh", "Thota", "suresh@gmail.com", new Date()),
				new Person(2, "ram", "king", "ram@gmail.com", new Date()),
				new Person(3, "balu", "abc", "balu@gmail.com", new Date()),
				new Person(4, "kiran", "def", "kiran@gmail.com", new Date()));
		Iterable<Person> list = serivce.createpersonList(personList);
		for (Person person : list) {
			System.out.println(person.toString());
		}
	}

	private void getPersonsByFirstorLastName() {
		List<Person> personList = serivce.getPersonBylastName("def");
		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());
		}
	}

	private void findPersonInfobyFirstNameorEmail() {
		List<Person> personList = serivce.getpersonByFirstNameorEmail("balu", "balu@gmail.com");
		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());
			System.out.println("rerode ok");
		}
	}

	private void getfindPersonfirstName() {
		List<Person> personList = serivce.getPersonByfirstName("suresh");
		for (Person person : personList) {
			System.out.println("person list " + person.toString());
		}
	}

	private void getfindpersonfirstNameorLastname() {
		List<Person> personlist = serivce.getPersonByFirstNameorlastName("suresh", "THOTA");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//     createPerson();
//     createPersons();
		findPersonInfobyFirstNameorEmail();
		getPersonsByFirstorLastName();
		getfindPersonfirstName();
		getfindpersonfirstNameorLastname();

	}

}
