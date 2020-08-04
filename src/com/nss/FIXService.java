package com.nss;

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
	//List<Order> getAllOrders(String orderID);
	List<OrderMessage> getAllOrderMessages(String orderId);
	OrderMessage addOrderMessage(String orderId, OrderMessage orderMessage);
	void addOrder(Order order);
	Order sendOrder(Order order);
}
