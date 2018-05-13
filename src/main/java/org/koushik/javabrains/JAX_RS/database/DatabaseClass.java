package org.koushik.javabrains.JAX_RS.database;

import java.util.HashMap;
import java.util.Map;

import org.koushik.javabrains.JAX_RS.model.Message;
import org.koushik.javabrains.JAX_RS.model.Profile;

public class DatabaseClass {
	
	public static Map<Long,Message> messages= new HashMap<>();
	public static Map<String,Profile> profiles= new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}

}
