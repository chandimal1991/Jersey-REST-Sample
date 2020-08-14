package com.nss.service;

import java.util.List;

import com.nss.model.Order;
import com.nss.model.OrderMessage;
import com.nss.model.Session;

public interface FIXService {
    
    void init();
    
    List<Session> getSessions();
    
    List<Order> getOrders();
    
    Order getOrder(String ClOrdID);
    
    List<OrderMessage> getAllOrderMessages(String orderId);
    
    OrderMessage sendOrderMessage(OrderMessage orderMessage);
}
