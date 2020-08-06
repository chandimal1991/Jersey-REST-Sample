package com.nss.database;

import java.util.HashMap;
import java.util.Map;

import com.nss.model.Order;

//TODO this class cannot solve the issue, better to remove it.
public class Database {
    
    private static Map<String, Order> orders = new HashMap<>();
    
    public static Map<String, Order> getOrders() {
        return orders;
    }
    
}
