package org.koushik.javabrains.JAX_RS.resources;

import java.net.URI;
import java.net.URISyntaxException;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.koushik.javabrains.JAX_RS.beans.MessageFilterBean;
import org.koushik.javabrains.JAX_RS.model.Message;
import org.koushik.javabrains.JAX_RS.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
//@Produces(value={MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class MessageResource {

	MessageService messageService = new MessageService();

	@GET
	// @Produces(MediaType.TEXT_PLAIN)
	//@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getJSONMessages(@BeanParam MessageFilterBean filterBean) {
		System.out.println("JSON Method called");
		if(filterBean.getStart()>0 && filterBean.getSize()>=0){
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		if(filterBean.getYear() >0){
			return messageService.getAllMessageForYear(filterBean.getYear());
		}
		return messageService.getAllMessage();
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Message> getXMLMessages(@BeanParam MessageFilterBean filterBean) {
		System.out.println("XML Method called");
		if(filterBean.getStart()>0 && filterBean.getSize()>=0){
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		if(filterBean.getYear() >0){
			return messageService.getAllMessageForYear(filterBean.getYear());
		}
		return messageService.getAllMessage();
	}
	
	
	/*@POST
	public Message addMessage(Message msg) {
		
		return messageService.addMessage(msg);
	}*/
	
	@POST
	public Response addMessage(Message msg, @Context UriInfo uriInfo) throws URISyntaxException {
		Message newMessage = messageService.addMessage(msg);
		/*return  Response.status(Status.CREATED)
				.entity(newMessage)
				.build(); */
		String id = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
		return Response.created(uri)
				//.created(new URI("/JAX-RS/webapi/messages/"+newMessage.getId()))
				.entity(newMessage)
				.build();
		
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id,Message msg) {
		msg.setId(id);
		
		return messageService.updateMessage(msg);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		
		 messageService.removeMessage(id);
	}


	@GET
	@Path("/{messageId}")
	//@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") long id, 
			@Context UriInfo uriInfo) throws Exception {
		Message msg = messageService.getMessage(id);
		msg.addLinkToList(getUriForSelf(uriInfo, msg), "self");
		msg.addLinkToList(getUriForProfile(uriInfo, msg), "profile");
		msg.addLinkToList(getUriForComments(uriInfo, msg), "comments");
		return msg;
	}

	private String getUriForSelf(UriInfo uriInfo, Message msg) {
		String uri = uriInfo.getBaseUriBuilder()
							.path(MessageResource.class)
							.path(Long.toString(msg.getId()))
							.build().toString();
		return uri;
	}
	
	private String getUriForProfile(UriInfo uriInfo, Message msg) {
		String uri = uriInfo.getBaseUriBuilder()
							.path(ProfileResource.class)
							.path(msg.getAuthor())
							.build().toString();
		return uri;
	}
	
	private String getUriForComments(UriInfo uriInfo, Message msg) {
		String uri = uriInfo.getBaseUriBuilder()
							.path(MessageResource.class)
							.path(MessageResource.class, "getCommentResource")
							.path(CommentResource.class)
							.resolveTemplate("messageId", msg.getId())
							.build().toString();
		return uri;
	}
	
	
	@GET
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
	/*@GET
	@Path("/{messageId}/comments")
	public CommentResourceTest getCommentResource(){
		return new CommentResourceTest();
	}*/
	
	
}
