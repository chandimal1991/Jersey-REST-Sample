package com.nss.model;

public class Order {
	
	private String ClOrdID;
	private String Symbol;
	private String Side;
	private String OrderQty;
	private String Price;
	private String OrdType;
	private String HandlInst;
	private String TransactTime;
	
	public Order(String clOrdID, String symbol, String side, String orderQty, String price, String ordType,
			String handlInst, String transactTime) {
		ClOrdID = clOrdID;
		Symbol = symbol;
		Side = side;
		OrderQty = orderQty;
		Price = price;
		OrdType = ordType;
		HandlInst = handlInst;
		TransactTime = transactTime;
	}

	public String getClOrdID() {
		return ClOrdID;
	}

	public void setClOrdID(String clOrdID) {
		ClOrdID = clOrdID;
	}

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
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

	public String getTransactTime() {
		return TransactTime;
	}

	public void setTransactTime(String transactTime) {
		TransactTime = transactTime;
	}

}
