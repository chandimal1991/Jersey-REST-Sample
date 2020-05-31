package com.nss.service;

import java.util.ArrayList;
import java.util.List;

import com.nss.model.Message;

public class MessageService {
	
	public List<Message> getAllMessages(){
		
		Message m1 = new Message(1L,"Hello World","Rasika");
		Message m2 = new Message(1L,"Hello Jercey","Rasika");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
	}

}
