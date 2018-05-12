package org.koushik.javabrains.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Life cycle of MyResource is in request scope,
//i.e: each time you make a request an instance of MyResource.java is created
//and after serving the response the MyResource.java instance being destroyed and garbage collected

@Path("test")
@Singleton
public class MyResource {
	
	private int count;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod(){
		count =  count+1;
		return "It Works! The  Method wass called " +count + " time(s)";
	}

}
