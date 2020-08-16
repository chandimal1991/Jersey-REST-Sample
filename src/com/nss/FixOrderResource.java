package com.nss;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.nss.model.Order;
import com.nss.service.FIXService;

//TODO From design view point, this class should be API for order level, so there should be no sendOrder method. 

@Path("/order")
public class FixOrderResource {
    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAllOrders(@Context ServletContext servletContext) {
        
        FIXService fixService = (FIXService) servletContext.getAttribute("FIX_Service");
        
        List<Order> orderList = fixService.getAllOrders();
        
        return orderList;
    }
    
    @GET
    @Path("/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrder(@PathParam("orderId") String orderId, @Context ServletContext servletContext) {
        
        FIXService fixService = (FIXService) servletContext.getAttribute("FIX_Service");
        
        return fixService.getOrder(orderId);
    }
      
}
