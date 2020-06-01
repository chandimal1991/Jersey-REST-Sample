package com.nss;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
			                                @HeaderParam("authSessionID") String headerParam,
			                                @CookieParam("name") String cookieParam) {
		
		
		return "Matrix Param : " + matrixParam + "Header Param : " + headerParam + "Cookie Param : " + cookieParam;
	}

}
