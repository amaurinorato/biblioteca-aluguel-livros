package com.biblioteca.aluguel.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biblioteca.aluguel.restfull.model.Usuario;
import com.biblioteca.aluguel.restfull.model.UsuarioId;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UsuarioId>{
	
	@Query("select u, u.books from Usuario u where u.usuarioId.cpf = :cpf")
	public Usuario findByCpf(@Param("cpf")Long cpf);
	
}
