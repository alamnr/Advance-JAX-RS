package org.koushik.javabrains.JAX_RS.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotation(@MatrixParam("param") String matrixParam,
			
						@HeaderParam("authSessionId")String header,
						@CookieParam("name")String cookie)
	{
		
		return "Test"+matrixParam+" Header Param-"+header +" Cookie- "+cookie;
	}
	
	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo, 
			@Context HttpHeaders httpHeaders){
		String path=uriInfo.getAbsolutePath().toString();
		String cookie = httpHeaders.getCookies().toString();
		
		return "test " +path +" Cookie- "+cookie;
		
	}

}
