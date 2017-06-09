package com.apple;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientInsertDeleteTest {
	public static void main(String[] args) {
		try {

			Client client = Client.create();

			WebResource webResource = client.resource("http://localhost:8080/books/rest/books/post");

			String input = "{\"id\":4,\"price\":29.95,\"authors\":[\"Bo Meng\",\"Alan Smith\"],\"title\":\"Rest To Test\"}";

			ClientResponse response = webResource.type(MediaType.TEXT_PLAIN).post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			System.out.println("Output from Server:");
			String output = response.getEntity(String.class);
			System.out.println(output);

			System.out.println();

			webResource = client.resource("http://localhost:8080/books/rest/books/delete/4");
			response = webResource.delete(ClientResponse.class, input);
			System.out.println("Output from Server:");
			output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
