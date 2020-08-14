package com.nss.database;

import java.util.HashMap;
import java.util.Map;

import com.nss.model.OrderMessage;

public class OrderStore {
    
    // TODO we need manage the relationship between Order and OrderMessage in
    // this class.
    // So we need the following methods:
    // 1. get all orders
    // 2. get all messages of all orders
    // 3. get all messages of one order by clorderid
    // 4. registerMsg to input message and manage it in this class.
    
    // TODO Data structure, please think of it by yourself firstly, if still
    // difficult I will give more hint.
	
	private static Map<String, OrderMessage> orderMessages = new HashMap<>();
	
	public static Map<String, OrderMessage> getOrderMessages() {
        return orderMessages;
    }
}
