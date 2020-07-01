package com.nss;

import java.util.ArrayList;
import java.util.List;

import com.nss.model.Session;


public interface FIXService {

	void init();
	List<String> getSessionList();
	ArrayList<Session> getSessions();
	void sendOrder(String sessionId);
	
}
