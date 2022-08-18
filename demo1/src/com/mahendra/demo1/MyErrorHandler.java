package com.mahendra.demo1;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class MyErrorHandler implements ExceptionMapper<CustomerException>{

	@Override
	public Response toResponse(CustomerException err) {
		System.out.println("Exception occurred: "+err.getMessage());
		return Response.status(404).entity( "Invalid Customer : "+err.getMessage()).build();
	}

}
