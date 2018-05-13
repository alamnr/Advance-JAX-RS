package org.koushik.javabrains.JAX_RS.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.JAX_RS.beans.MessageFilterBean;
import org.koushik.javabrains.JAX_RS.model.Message;
import org.koushik.javabrains.JAX_RS.service.MessageService;

@Path("/")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class CommentResourceTest {
	
	@GET
	public String test(){
		return "new sub resource";
	}

	@GET
	@Path("/{commentId}/")
	public String test2(@PathParam("commentId") long commentId,
			@PathParam("messageId") long messageId){
		return "Method To return Comment Id :"  +commentId +" for  message: " +messageId;
	}
	
	
}
