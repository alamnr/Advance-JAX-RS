package org.koushik.javabrains.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext reqContext) throws IOException {
		System.out.println("Header : "+ reqContext.getHeaders());
	}

	@Override
	public void filter(ContainerRequestContext reqContext, ContainerResponseContext resContext) throws IOException {
		
		System.out.println("Response Filter");
		System.out.println(resContext.getHeaders());
	}

}
