package com.apple;

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
	@Produces(MediaType.APPLICATION_JSON)
	public Book getTrackInJSON() {
		Book book = new Book();
		book.setTitle("Enter Sandman");
		book.setSinger("Metallica");

		return book;
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Book book) {
		String result = "Track saved : " + book;
		return Response.status(201).entity(result).build();
	}

}

