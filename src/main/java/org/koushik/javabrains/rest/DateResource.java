package org.koushik.javabrains.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("date/{dateString}")
public class DateResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	//public String getRequestDate(@PathParam("dateString")String dateString){
	public String getRequestDate(@PathParam("dateString")MyDate mydate){
		return "Got "+ mydate.toString();
	}
}
