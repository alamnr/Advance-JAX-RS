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
import org.koushik.javabrains.JAX_RS.model.Comment;
import org.koushik.javabrains.JAX_RS.model.Message;
import org.koushik.javabrains.JAX_RS.service.CommentService;
import org.koushik.javabrains.JAX_RS.service.MessageService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	CommentService commentService = new CommentService();

	@GET
	public List<Comment> getAllComments(@PathParam("messageId")long messageId) {
	  return commentService.getAllComment(messageId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId")long messageId,Comment comment) {
		
		return commentService.addComment(messageId,comment);
	}
	
	@PUT
	@Path("/{messageId}")
	public Comment updateComment(@PathParam("messageId") long messageId,
			@PathParam("commentId") long commentId,Comment comment) {
		comment.setId(commentId);
		
		return commentService.updateComment(messageId,comment);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteComment(@PathParam("messageId") long messageId,
			@PathParam("commentId") long commentId) {
		
		 commentService.removeComment(messageId, commentId);
	}


	
}
