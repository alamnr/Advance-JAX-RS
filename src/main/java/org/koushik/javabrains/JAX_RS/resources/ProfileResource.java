package org.koushik.javabrains.JAX_RS.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.JAX_RS.model.Message;
import org.koushik.javabrains.JAX_RS.model.Profile;
import org.koushik.javabrains.JAX_RS.service.MessageService;
import org.koushik.javabrains.JAX_RS.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	ProfileService profileService = new ProfileService();

	@GET
	public List<Profile> getProfile() {
		return profileService.getAllProfile();
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		System.out.println("Post");
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName,Profile profile) {
		profile.setProfileName(profileName);
		
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName) {
		
		 profileService.removeProfile(profileName);
	}


	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		
		return profileService.getProfile(profileName);
	}

}
