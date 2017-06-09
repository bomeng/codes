package com.apple;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/books")
public class BookService {
	@GET
	@Path("/get")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Book> getBooks() {
		BookDao dao = new BookDao();
		return dao.getBooks();
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBook(Book book) {
		String result = "Book saved : " + book;
		return Response.status(201).entity(result).build();
	}
}

