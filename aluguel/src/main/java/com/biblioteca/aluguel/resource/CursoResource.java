package com.biblioteca.aluguel.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.biblioteca.aluguel.curso.model.Curso;
import com.biblioteca.aluguel.curso.repository.CursoRepository;

@Component
@Path("/curso")
public class CursoResource {

	@Inject
	private CursoRepository repo;
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll(){
		List<Curso> cursos = repo.findAll();
		
		if(cursos != null){
			return Response.ok().entity(cursos).build();
		} else {
			return Response.status(404).entity(new Curso()).build();
		}
	}
	
}
