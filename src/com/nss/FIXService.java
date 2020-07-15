package com.nss;

import java.util.ArrayList;
import java.util.List;

import com.nss.model.Message;
import com.nss.model.Order;
import com.nss.model.Session;


public interface FIXService {

	void init();
	ArrayList<Session> getSessions();
	ArrayList<Order> getOrders();
	void addOrder(Order order);
	Order sendOrder(Order order);
}
