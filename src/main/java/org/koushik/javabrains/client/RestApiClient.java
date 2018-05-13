package org.koushik.javabrains.client;



import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ClientBinding;
import org.koushik.javabrains.JAX_RS.model.Message;

public class RestApiClient {
	
	public static void main(String[] args){
		
		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/");
		WebTarget messagetarget = baseTarget.path("messages");
		//messagetarget.path("2");
		WebTarget singleMessageTarget = messagetarget.path("{messageId}");
		
		Message msg1 = singleMessageTarget.resolveTemplate("messageId", "1")
						.request(MediaType.APPLICATION_JSON)
						.get(Message.class); 
		System.out.println(msg1.toString());
		
		Message msg2 = singleMessageTarget.resolveTemplate("messageId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class); 
		System.out.println(msg2.toString());
		
		Message postMessage = new Message(4,"New Message from JAX-RS Client", "Koushik");
		Response postResponse =	messagetarget.request().post(Entity.json(postMessage));
		if(postResponse.getStatus()!=201){
			System.out.println("Error");
		}
		Message createdMessage = postResponse.readEntity(Message.class);
		System.out.println(createdMessage);

		
		
	}

}
