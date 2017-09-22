package com.biblioteca.aluguel.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.biblioteca.aluguel.curso.model.Curso;
import com.biblioteca.aluguel.restfull.model.Book;

@Component
public interface CursoRepository extends JpaRepository<Curso, Long> {

	public Curso findByNome(String nome);
	
}
