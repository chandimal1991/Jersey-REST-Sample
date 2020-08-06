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
import com.nss.service.FIXService;

//TODO From design view point, this class should be API for message level, so there should be one sendMsg method. 
//TODO At least we need one method to return all message for one order, better to have another method to return all messages

// TODO why you use root path ?
@Path("/")
public class FIXOrderMessageResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderMessage> getMessages(@PathParam("orderId") String orderId,
            @Context ServletContext servletContext) {
        
        FIXService fixService = (FIXService) servletContext.getAttribute("FIX_Service");
        
        return fixService.getAllOrderMessages(orderId);
    }
    
    // TODO why you need this method ? if not please remove it.
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public OrderMessage addOrderMessage(@PathParam("orderId") String orderId, OrderMessage orderMessage,
            @Context ServletContext servletContext) {
        
        FIXService fixService = (FIXService) servletContext.getAttribute("FIX_Service");
        return fixService.addOrderMessage(orderId, orderMessage);
        
    }
    
}
