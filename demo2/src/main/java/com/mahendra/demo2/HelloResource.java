package com.mahendra.demo2;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello")
public class HelloResource {

	@GET 
	@Produces("text/plain")
	public String sayHello1() {
		return "Hello World";
	}
	
	@GET 
	@Produces("text/html")
	public String sayHello2() {
		return "<h2>Hello World</h2>";
	}
}
