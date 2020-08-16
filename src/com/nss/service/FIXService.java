package com.nss.service;

import java.util.List;

import com.nss.model.Order;
import com.nss.model.OrderMessage;
import com.nss.model.Session;

public interface FIXService {
    
    void init();
    
    List<Session> getSessions();
    
    List<Order> getAllOrders();
    
    Order getOrder(String ClOrdID);
    
    List<OrderMessage> getAllOrderMessages();
    
    List<OrderMessage> getOrderMessages(String orderId);
    
    OrderMessage sendOrderMessage(OrderMessage orderMessage);
}
