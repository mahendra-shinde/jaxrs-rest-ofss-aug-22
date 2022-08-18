package com.mahendra.demo1;
//Package belongs to JAX-RS API
import jakarta.ws.rs.*;

// Resulting Path: http://localhost:8000/demo1/hello
@Path("/hello")
public class HelloResource {

	// Endpoint Method with Request Type HTTP/GET
	@GET
	public String sayHello1() {
		return "Hello World, This is GET Method";
	}
	
	
	// Endpoint Method with Request Type HTTP/PUT
	@PUT
	public String sayHello2() {
		return "Hello World, This is PUT Method";
	}
	
}
