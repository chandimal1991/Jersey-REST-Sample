package com.nss;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.nss.model.Session;

@Path("/sessions")
public class FixSessionResource {
	
		@GET
		@Path("/list")
		@Produces(MediaType.APPLICATION_JSON)
		public List<String> getSessionList(@Context ServletContext servletContext) {
			
			FIXService fixService = (FIXService) servletContext.getAttribute("FIX_Service");
			
			List<String> sessionList = fixService.getSessionList();
			return sessionList;
		}
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Session> getSessions(@Context ServletContext servletContext) {
			
			FIXService fixService = (FIXService) servletContext.getAttribute("FIX_Service");
			
			List<Session> sessionList = fixService.getSessions();
			
			return sessionList;
		}		
}
