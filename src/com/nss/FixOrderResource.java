package com.nss;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.nss.model.Order;


@Path("/order")
public class FixOrderResource {
	
	@POST
	@Path("/{sessionId}")
	public void sendOrder(@PathParam("sessionId") String sessionId, @Context ServletContext servletContext) {

		FIXService fixService = (FIXService) servletContext.getAttribute("FIX_Service");

		fixService.sendOrder(sessionId);

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Order sendOrder(Order order, @Context ServletContext servletContext) {

		FIXService fixService = (FIXService) servletContext.getAttribute("FIX_Service");

		return fixService.sendOrder(order);

	}


}
