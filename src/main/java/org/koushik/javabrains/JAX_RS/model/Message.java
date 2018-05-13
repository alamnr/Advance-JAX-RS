package org.koushik.javabrains.JAX_RS.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	
	private long id;
	private String message;
	private Date created;
	private String author;
	private Map<Long,Comment> comments = new HashMap<>();
	private List<Link> links = new ArrayList<>();
	
	public Message(){
		
	}
	
	public Message(long id, String message, String author){
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	/*public List<Link> getLinks() {
		return links;
	}

	
	public void setLinks(List<Link> links) {
		this.links = links;
	}*/
	
	public Iterator<Link> getLinksIterator() {
		return links.iterator();
	}
	
	public void addLinkToList(String url,String rel) throws Exception{
		
		Link link  = new Link();
		link.setLink(url);
		link.setRel(rel);
		for(Iterator iter=getLinksIterator();iter.hasNext();){
			Link existingLink = (Link)iter.next();
			if(existingLink.equals(link)){
				throw new Exception("Duplicate link can't be added");
			}
			
		}
		links.add(link);
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", created=" + created + ", author=" + author
				+ ", comments=" + comments + ", links=" + links + "]";
	}
	
	
	

}
