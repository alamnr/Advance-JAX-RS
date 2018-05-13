package org.koushik.javabrains.JAX_RS.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.koushik.javabrains.JAX_RS.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	
	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage ErrorMessage = new ErrorMessage(exception.getMessage(),404,"http://javabrain.koushik.org");
		return Response.status(Status.NOT_FOUND)
						.entity(ErrorMessage).build();
	}

}
