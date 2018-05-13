package org.koushik.javabrains.rest;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;


@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URI_PREFIX = "secured";
	@Override
	public void filter(ContainerRequestContext reqContext) throws IOException {
		
		if(reqContext.getUriInfo().getPath().contains(SECURED_URI_PREFIX)){
			List<String> authHeader = reqContext.getHeaders().get(AUTHORIZATION_HEADER);
			
			if(authHeader!=null && authHeader.size()>0){
				String authToken = authHeader.get(0);
				authToken =  authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodeString = Base64.decodeAsString(authToken);
				StringTokenizer tokenizer = new StringTokenizer(decodeString,":");
				String userName= tokenizer.nextToken();
				String password = tokenizer.nextToken();
				
				if("user".equals(userName) && "password".equals(password)){
					return;
				}
				
				Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
													.entity("User can't access the resource")
													.build();
				reqContext.abortWith(unauthorizedStatus);

		}
					
		}

	}

}
