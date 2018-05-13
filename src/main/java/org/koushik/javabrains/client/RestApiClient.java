package org.koushik.javabrains.client;



import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ClientBinding;
import org.koushik.javabrains.JAX_RS.model.Message;

public class RestApiClient {
	
	public static void main(String[] args){
		
		Client client = ClientBuilder.newClient();
		
		WebTarget target =client.target("http://localhost:8080/advanced-jaxrs-01/webapi/messages/1");
		
		Builder builder = target.request(MediaType.APPLICATION_JSON);
		//Message msg = builder.get(Message.class);
		String msg = builder.get(String.class);
		 
		System.out.println(msg.toString());
		
		
		
		
	}

}
