package com.nss.database;

import java.util.HashMap;
import java.util.Map;

import com.nss.model.Order;

public class Database {
    
    private static Map<String, Order> orders = new HashMap<>();
    
    public static Map<String, Order> getOrders() {
        return orders;
    }
    
}
