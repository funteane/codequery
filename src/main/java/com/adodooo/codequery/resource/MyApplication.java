package com.adodooo.codequery.resource;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("resources")
public class MyApplication extends ResourceConfig {
	
	public MyApplication() {
		packages("com.adodooo.codequery.resource");
	}
	
}