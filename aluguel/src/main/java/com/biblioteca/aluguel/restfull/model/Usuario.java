package com.biblioteca.aluguel.restfull.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {
	
	@EmbeddedId
	private UsuarioId usuarioId;
	
	private String nome;

	public UsuarioId getUsuarioId() {
		return usuarioId;
	}
	
	@OneToMany()
	@JoinTable(name="usuario_book", 
				joinColumns={@JoinColumn(name="cpf"), 
							 @JoinColumn(name="rg")},
				inverseJoinColumns=@JoinColumn(name="id_book", columnDefinition="Int"))
	private List<Book> books;

	public void setUsuarioId(UsuarioId usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
