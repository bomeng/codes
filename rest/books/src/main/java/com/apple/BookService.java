package com.apple;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/books")
public class BookService {
	private BookDao dao = new BookDao();

	@GET
	@Path("/get")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Book> getBooks() throws SQLException {
		return dao.getBooks();
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBook(Book book) throws SQLException {
		dao.createBook(book);
		String result = "Book saved: " + book;
		return Response.status(201).entity(result).build();
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response createBook(String bookStr) throws SQLException {
		JsonParser parser = new JsonParser();
		JsonElement element =  parser.parse(bookStr);
		if (element.isJsonObject()) {
			JsonObject bookJson = element.getAsJsonObject();
			int id = bookJson.get("id").getAsInt();
			String title = bookJson.get("title").getAsString();
			String authors = bookJson.get("authors").getAsString();
			double price = bookJson.get("price").getAsDouble();
			Book book = new Book(id, title, authors, price);
			dao.createBook(book);
		}
		String result = "Book saved: " + bookStr;
		return Response.status(201).entity(result).build();
	}

	@GET
	@Path("/get/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Book getBook(@PathParam("id") int id) throws SQLException {
		return dao.getBook(id);
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String deleteUser(@PathParam("id") int id) throws SQLException {
		dao.deleteBook(id);
		return "<result>success</result>";
	}
}
