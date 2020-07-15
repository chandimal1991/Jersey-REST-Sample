package com.nss.database;

import java.util.HashMap;
import java.util.Map;

import com.nss.model.Message;
import com.nss.model.Order;
import com.nss.model.Profile;

public class Database {
	
	private static Map<Long,Message> messages = new HashMap<>();
	private static Map<String,Profile> profiles = new HashMap<>();
	private static Map<String,Order> orders = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
	
	public static Map<String, Order> getOrders(){
		return orders;
	}
	

}
