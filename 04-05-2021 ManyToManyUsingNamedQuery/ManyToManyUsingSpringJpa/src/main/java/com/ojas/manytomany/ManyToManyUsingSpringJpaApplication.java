package com.ojas.manytomany;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ojas.manytomany.dao.BookDao;
import com.ojas.manytomany.dao.PublisherDao;
import com.ojas.manytomany.domain.Book;
import com.ojas.manytomany.domain.Publisher;

@SpringBootApplication
public class ManyToManyUsingSpringJpaApplication implements CommandLineRunner{
	@Autowired
	private BookDao bDao;

	@Autowired
	private PublisherDao pDao;

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyUsingSpringJpaApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println("welcome");
			//saveTableData();
			//getBookDetails();
              //findBookByPublisher();
//			findAllDetails();
	}

	private void saveTableData() {
		Publisher publisherA = new Publisher("PublisherA");
		Publisher publisherB = new Publisher("PublisherB");
		Publisher publisherC = new Publisher("PublisherC");

		Book bookA = new Book("BookA", new HashSet<>(Arrays.asList(publisherA, publisherB)));
		Book bookB = new Book("BookB", new HashSet<>(Arrays.asList(publisherA, publisherC)));
		bDao.saveAll(Arrays.asList(bookA, bookB));

		Book bookC = new Book("BookC");
		Book bookD = new Book("BookD");
		Book bookE = new Book("BookE");
		Publisher publisherD = new Publisher("publisherD", new HashSet<>(Arrays.asList(bookC, bookD)));
		Publisher publisherE = new Publisher("publisherE", new HashSet<>(Arrays.asList(bookC, bookE)));
		pDao.saveAll(Arrays.asList(publisherD, publisherE));

		System.out.println("Saved");
	}

	private void getBookDetails() {
		List<Book> books = bDao.findAllDetails(1);
		for (Book book : books) {
			System.out.println("Book Objects: " + book.toString());
		}
	}

	private void findBookByPublisher() {
		List<Book> book = bDao.findBookByPublisher(1);
		for (Book book2 : book) {
			System.out.println("Book Objects: " + book2.toString());
		}

	}

	private void findAllDetails() {
		List<Book> bookList = bDao.findAllDetails(1);
		System.out.println("bookd" + bookList.size());
		for (Book book : bookList) {
			System.out.println("Book Objects: " + book.toString());
		}
	}

}
