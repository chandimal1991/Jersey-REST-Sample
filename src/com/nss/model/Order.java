package com.nss.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
    
    // TODO not sure why you need these fields ? this time we are not required
    // to implement OMS function, we do not really need to manage the status of
    // order. We just need manage the messages associated the same order.
    // Probably we do not even need this class
    
    private String                  ClOrdID;
    private String                  OrigClOrdID;
    private String                  MsgType;
    private String                  Symbol;
    private String                  OrdType;
    private String                  HandlInst;
    private String                  Side;
    private String                  OrderQty;
    private String                  Price;
    private String                  Currency;
    private String                  TransactTime;
    private String                  Session;
    
    // TODO why we use Map ? why not List
    private List<OrderMessage> messages = new ArrayList<OrderMessage>();
    
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
    public List<OrderMessage> getMessages() {
        return messages;
    }
    
    public void setMessages(List<OrderMessage> messages) {
        this.messages = messages;
    }
    
}
