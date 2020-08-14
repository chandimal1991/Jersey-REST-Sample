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

public class FIXOrderMessageResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderMessage> getMessages(@PathParam("orderId") String orderId,
            @Context ServletContext servletContext) {
        
        FIXService fixService = (FIXService) servletContext.getAttribute("FIX_Service");
        
        return fixService.getAllOrderMessages(orderId);
    }
    
    
    @Path("/ordermsg")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public OrderMessage sendOrderMessage(OrderMessage orderMessage, @Context ServletContext servletContext) {
        
        FIXService fixService = (FIXService) servletContext.getAttribute("FIX_Service");
        return fixService.sendOrderMessage(orderMessage);
        
    }
    
}
