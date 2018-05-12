package org.koushik.javabrains.rest;

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

@Path("{pathParam}/test")
//@Singleton
// You can't declare a resource singleton having member variable with annotation @PathParam and @QueryParam
// cause in singleton mode the resource is instantiated while application is started up
// and at them time those member variable with @PathParam and @QueryParam annotation can't be initialised
// hence exception thrown, validation failed

public class MyResource {
	
	
	@PathParam("pathParam")private String pathParamExample;
	@QueryParam("query")private String queryParamExample;
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod(){
		
		return "It Works! Path Param is -" + pathParamExample + " and Query param is- "+ queryParamExample;
	}

}
