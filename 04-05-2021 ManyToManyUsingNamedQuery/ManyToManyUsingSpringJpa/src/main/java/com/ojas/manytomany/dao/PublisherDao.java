package com.ojas.manytomany.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.manytomany.domain.Publisher;

public interface PublisherDao extends JpaRepository<Publisher, Integer> {

}
