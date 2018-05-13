package org.koushik.javabrains.JAX_RS.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;



import org.koushik.javabrains.JAX_RS.database.DatabaseClass;
import org.koushik.javabrains.JAX_RS.model.Comment;
import org.koushik.javabrains.JAX_RS.model.Message;

public class CommentService {
	
	private Map<Long,Message> messages = DatabaseClass.getMessages();


	
	public List<Comment> getAllComment(long messageId) {
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());

	}
	
	public Comment getComment(long messageId,long commentId){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
	
	public Comment addComment(long messageId, Comment comment){
		
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(),comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		if(comment.getId()<=0){
			return null;
		}
		comments.put(comment.getId(), comment);
		
		return comment;	
	}
	
	public Comment removeComment(long mesageId, long commentId){
		Map<Long,Comment> comments = messages.get(mesageId).getComments();
		return comments.remove(commentId);
	}
	
	

}
