package com.nss.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
	
	private String ClOrdID;
	private String OrigClOrdID;
	private String MsgType;
	private String Symbol;
	private String OrdType;
	private String HandlInst;
	private String Side;
	private String OrderQty;
	private String Price;
	private String Currency;
	private String TransactTime;
	private String Session;
	private Map<String, Order> orders = new HashMap<>();
	
	public Order() {
		
	}

	public Order(String clOrdID, String origClOrdID, String msgType, String symbol, String ordType, String handlInst,
			String side, String orderQty, String price, String currency, String transactTime, String session) {
		super();
		ClOrdID = clOrdID;
		OrigClOrdID = origClOrdID;
		MsgType = msgType;
		Symbol = symbol;
		OrdType = ordType;
		HandlInst = handlInst;
		Side = side;
		OrderQty = orderQty;
		Price = price;
		Currency = currency;
		TransactTime = transactTime;
		Session = session;
	}

	public String getClOrdID() {
		return ClOrdID;
	}

	public void setClOrdID(String clOrdID) {
		ClOrdID = clOrdID;
	}

	public String getOrigClOrdID() {
		return OrigClOrdID;
	}

	public void setOrigClOrdID(String origClOrdID) {
		OrigClOrdID = origClOrdID;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public String getOrdType() {
		return OrdType;
	}

	public void setOrdType(String ordType) {
		OrdType = ordType;
	}

	public String getHandlInst() {
		return HandlInst;
	}

	public void setHandlInst(String handlInst) {
		HandlInst = handlInst;
	}

	public String getSide() {
		return Side;
	}

	public void setSide(String side) {
		Side = side;
	}

	public String getOrderQty() {
		return OrderQty;
	}

	public void setOrderQty(String orderQty) {
		OrderQty = orderQty;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getTransactTime() {
		return TransactTime;
	}

	public void setTransactTime(String transactTime) {
		TransactTime = transactTime;
	}

	public String getSession() {
		return Session;
	}

	public void setSession(String session) {
		Session = session;
	}
	
	@XmlTransient
	public Map<String, Order> getOrders() {
		return orders;
	}

	public void setOrders(Map<String, Order> orders) {
		this.orders = orders;
	}
	
}
