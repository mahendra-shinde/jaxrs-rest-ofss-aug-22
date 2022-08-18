package com.mahendra.demo1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.core.Application;

public class AppConfig extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(HelloResource.class, CustomerResource.class));
	}
	
	@Override
	public Set<Object> getSingletons() {
		// TODO Auto-generated method stub
		return new HashSet<>(Arrays.asList(new MyErrorHandler(), new CorsFilter()));
	}
	
}
