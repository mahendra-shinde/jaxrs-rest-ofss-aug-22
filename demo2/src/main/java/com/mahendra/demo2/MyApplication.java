package com.mahendra.demo2;

import org.glassfish.jersey.server.ResourceConfig;

import io.swagger.jaxrs.config.BeanConfig;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class MyApplication extends ResourceConfig{

	public MyApplication() {
	  	BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:9000");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("com.mahendra.demo2");	        
        beanConfig.setScan(true);
		
		register(HelloResource.class);
		register(CustomerResource.class);
		register(MyErrorHandler.class);
		register(io.swagger.jaxrs.listing.ApiListingResource.class);
		register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
	}
}
