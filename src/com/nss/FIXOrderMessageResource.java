package com.nss;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.nss.model.OrderMessage;

@Path("/")
public class FIXOrderMessageResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderMessage> getMessages(@PathParam("orderId") String orderId, @Context ServletContext servletContext) {
		
		FIXService fixService = (FIXService) servletContext.getAttribute("FIX_Service");
		
		return fixService.getAllOrderMessages(orderId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public OrderMessage addOrderMessage(@PathParam("orderId") String orderId, OrderMessage orderMessage, @Context ServletContext servletContext) {

		FIXService fixService = (FIXService) servletContext.getAttribute("FIX_Service");
		return fixService.addOrderMessage(orderId, orderMessage);

	}

}
