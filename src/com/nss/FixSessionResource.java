package com.nss;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/sessions")
public class FixSessionResource {
	
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		public String getSessions(@Context ServletContext servletContext) {
			
			FIXService fixService = (FIXService) servletContext.getAttribute("FIX_Service");
			
			List<String> sessionList = fixService.getSessionList();
			
			return sessionList.toString();
		}

}
