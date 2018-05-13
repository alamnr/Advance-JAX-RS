package org.koushik.javabrains.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.JAX_RS.model.Message;

public class GenericDemo {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();

		List<Message> messages = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/")
							.path("messages").queryParam("year", 2015)
							.request(MediaType.APPLICATION_JSON)
							.get(new GenericType<List<Message>>(){});
		
		System.out.println(messages);
	}
}
