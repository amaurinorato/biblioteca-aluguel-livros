package com.biblioteca.aluguel.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.biblioteca.aluguel.restfull.model.Book;
import com.biblioteca.aluguel.restfull.model.Usuario;
import com.biblioteca.aluguel.restfull.repository.UsuarioRepository;

@Component
@Path("/usuario")
public class UsuarioResource {
	
	@Inject
	private UsuarioRepository usuarioRepo;
	
	@GET
	@Path("/{cpf}")
	@Produces(MediaType.APPLICATION_JSON)
	@org.springframework.transaction.annotation.Transactional(readOnly=true)
	public Response findByCpf(@PathParam("cpf") Long cpf){
		Usuario usuario = usuarioRepo.findByCpf(cpf);
		if(usuario != null){
			Hibernate.initialize(usuario.getBooks());
			return Response.ok().entity(usuario).build();
		} else {
			return Response.status(404).entity(new Book()).build();
		}
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll(){
		List<Usuario> usuarios = usuarioRepo.findAll();
		
		if(usuarios != null){
			return Response.ok().entity(usuarios).build();
		} else {
			return Response.status(404).entity(new Book()).build();
		}
	}
	
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByTitle(@RequestBody Usuario usuario){
		usuario = usuarioRepo.save(usuario);
		
		if(usuario != null){
			return Response.ok().entity("Usuario Salvo com Sucesso!").build();
		} else {
			return Response.status(404).entity(new Book()).build();
		}
	}

}
