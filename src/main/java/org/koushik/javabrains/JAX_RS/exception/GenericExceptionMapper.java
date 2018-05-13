package org.koushik.javabrains.JAX_RS.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.koushik.javabrains.JAX_RS.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	
	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage ErrorMessage = new ErrorMessage(exception.getMessage(),500,"http://javabrain.koushik.org");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
						.entity(ErrorMessage).build();
	}

}
