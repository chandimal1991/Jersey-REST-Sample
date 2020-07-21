package com.nss;

import java.util.ArrayList;
import com.nss.model.Order;
import com.nss.model.Session;

public interface FIXService {

	void init();
	ArrayList<Session> getSessions();
	ArrayList<Order> getOrders();
	Order getOrder(String ClOrdID);
	void addOrder(Order order);
	Order sendOrder(Order order);
}
