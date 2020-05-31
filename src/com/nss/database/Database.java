package com.nss.database;

import java.util.HashMap;
import java.util.Map;

import com.nss.model.Message;
import com.nss.model.Profile;

public class Database {
	
	private static Map<Long,Message> messages = new HashMap<>();
	private static Map<Long,Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<Long, Profile> getProfiles(){
		return profiles;
	}

}
