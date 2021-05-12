package com.ojas.manytomany.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.manytomany.domain.Book;


public interface BookDao extends JpaRepository<Book, Integer> {

	List<Book> findAllDetails(int id);
	List<Book> findBookByPublisher(int publisher_id);
}
