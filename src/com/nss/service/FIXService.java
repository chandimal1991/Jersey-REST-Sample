package com.nss.service;

import java.util.ArrayList;
import java.util.List;

import com.nss.model.Order;
import com.nss.model.OrderMessage;
import com.nss.model.Session;

public interface FIXService {
    
    void init();
    
    ArrayList<Session> getSessions();
    
    ArrayList<Order> getOrders();
    
    Order getOrder(String ClOrdID);
    
    // List<Order> getAllOrders(String orderID);
    List<OrderMessage> getAllOrderMessages(String orderId);
    
    // TODO why you need this method ? if not please remove it.
    OrderMessage addOrderMessage(String orderId, OrderMessage orderMessage);
    
    // TODO why you need this method ? if not please remove it.
    void addOrder(Order order);
    
    // TODO we do not send order, we send message
    Order sendOrder(Order order);
}
