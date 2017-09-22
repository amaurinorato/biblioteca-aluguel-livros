package com.biblioteca.aluguel.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.biblioteca.aluguel.restfull.model.Book;

@Component
public interface BookRepository extends JpaRepository<Book, Long>{

	public Book findByTitle(String title);
	
}
