package org.koushik.javabrains.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ClientBinding;
import org.koushik.javabrains.JAX_RS.model.Message;

public class RestApiClient {
	
	public static void main(String[] args){
		
		Client client = ClientBuilder.newClient();
		
		Response response=client.target("http://localhost:8080/advanced-jaxrs-01/webapi/messages/1")
			  .request().get();
		Message msg = response.readEntity(Message.class);
		System.out.println(msg.toString());
		
		
		
		
	}

}
