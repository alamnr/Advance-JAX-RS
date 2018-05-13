package org.koushik.javabrains.JAX_RS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.JAX_RS.database.DatabaseClass;
import org.koushik.javabrains.JAX_RS.model.Message;
import org.koushik.javabrains.JAX_RS.model.Profile;

public class ProfileService {
	
	private Map<String,Profile> profiles = DatabaseClass.getProfiles();


	public List<Profile> getAllProfile() {

		return new ArrayList<Profile>(profiles.values());

	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile removeProfile(String profileName){
		
		return profiles.remove(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		
		return profile;	
	}
	

}
