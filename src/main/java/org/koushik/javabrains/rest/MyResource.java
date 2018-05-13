package org.koushik.javabrains.rest;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//Life cycle of MyResource is in request scope,
//i.e: each time you make a request an instance of MyResource.java is created
//and after serving the response the MyResource.java instance being destroyed and garbage collected

@Path("test")

public class MyResource {
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date testMethod(){
		
		return Calendar.getInstance().getTime();
	}

}
