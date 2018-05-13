package org.koushik.javabrains.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvocationDemo {
	
	public static void main(String[] args){
		
		InvocationDemo demo = new InvocationDemo();
		Invocation invocation = demo.prepareRequestMessagesByYear(2015);
		Response invoke = invocation.invoke();
		
		System.out.println(invoke.getStatus());
		
	}

	public Invocation prepareRequestMessagesByYear(int year) {
		Client client = ClientBuilder.newClient();
		
		return client.target("http://localhost:8080/advanced-jaxrs-01/webapi/")
			  .path("messages")
			  .queryParam("year", year)
			  .request(MediaType.APPLICATION_JSON)
			  .buildGet();
			
		
	}

}
