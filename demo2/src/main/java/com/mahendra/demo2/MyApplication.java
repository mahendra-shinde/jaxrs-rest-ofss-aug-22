package com.mahendra.demo2;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class MyApplication extends ResourceConfig{

	public MyApplication() {
		register(HelloResource.class);
		register(CustomerResource.class);
		register(MyErrorHandler.class);
	}
}
