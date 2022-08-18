package com.mahendra.demo2;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;


public class MyErrorHandler implements ExceptionMapper<CustomerException>{

	@Override
	public Response toResponse(CustomerException err) {
		System.out.println("Exception occurred: "+err.getMessage());
		return Response.status(404, "Invalid Customer : "+err.getMessage()).build();
	}

}
