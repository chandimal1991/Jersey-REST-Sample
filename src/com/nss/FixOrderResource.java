package com.nss;

import javax.servlet.ServletContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;


@Path("/order")
public class FixOrderResource {
	
	@POST
	@Path("/{sessionId}")
	public void sendOrder(@PathParam("sessionId") String sessionId, @Context ServletContext servletContext) {

		FIXService fixService = (FIXService) servletContext.getAttribute("FIX_Service");

		fixService.sendOrder(sessionId);

	}

}
