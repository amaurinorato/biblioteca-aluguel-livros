package com.biblioteca.aluguel.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.biblioteca.aluguel.restfull.model.Book;
import com.biblioteca.aluguel.restfull.repository.BookRepository;

@Component
@Path("/book")
public class BookResource {
	
	@Inject
	private BookRepository bookRepo;
	
	@GET
	@Path("/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByTitle(@PathParam("title") String title){
		Book book = bookRepo.findByTitle(title);
		
		if(book != null){
			return Response.ok().entity(book).build();
		} else {
			return Response.status(404).entity(new Book()).build();
		}
	}
	
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByTitle(@RequestBody Book book){
		book = bookRepo.save(book);
		
		if(book != null && book.getId() != null){
			return Response.ok().entity("Livro Salvo com Sucesso!").build();
		} else {
			return Response.status(404).entity(new Book()).build();
		}
	}
}
