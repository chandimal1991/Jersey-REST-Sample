package com.nss.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import com.nss.database.OrderStore;
import com.nss.model.Order;
import com.nss.model.OrderMessage;

import simplefix.Application;
import simplefix.Engine;
import simplefix.EngineFactory;
import simplefix.Message;
import simplefix.MsgType;
import simplefix.Session;
import simplefix.Tag;

public class FIXServiceImpl implements FIXService {
    
    private static EngineFactory _engineFact;
    private Engine               _engine;
    private ServletContext       _servletContext;
    
    // TODO One simple Map can not solve the problem, we need one OrderStore
    // class
    private Map<String, OrderMessage>   orderMessages = OrderStore.getAllOrderMessages();
    
    public FIXServiceImpl(ServletContext servletContext) {
        _servletContext = servletContext;
    }
    
    @Override
    public void init() {
        
        try {
            
            Class<?> classobj = Class.forName("simplefix.quickfix.EngineFactory");
            Object engineobj = classobj.newInstance();
            
            if ( engineobj instanceof EngineFactory ) {
                
                _engineFact = (EngineFactory) engineobj;
                _engine = _engineFact.createEngine();
                _engine.initEngine(_servletContext.getRealPath("/WEB-INF/banzai.cfg"));
                
                Application application = new _Application();
                
                _engine.startInProcess(application);
                
                System.out.println("engine started");
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public ArrayList<com.nss.model.Session> getSessions() throws IllegalArgumentException {
        
        ArrayList<com.nss.model.Session> sessions = new ArrayList<com.nss.model.Session>();
        int sessionID = 1;
        
        for ( Session session : _engine.getAllSessions() ) {
            System.out.println(session.getSenderCompID() + "<-->" + session.getTargetCompID());
            com.nss.model.Session sessionObj = new com.nss.model.Session(sessionID,
                    session.getSenderCompID() + "<-->" + session.getTargetCompID());
            sessions.add(sessionObj);
            sessionID++;
        }
        
        return sessions;
    }
    
    @Override
    public OrderMessage sendOrderMessage(OrderMessage orderMessage) throws IllegalArgumentException {
        
        try {
            
            for ( Session session : _engine.getAllSessions() ) {
                
                if ( orderMessage.getSession().equals(session.getSenderCompID() + "<-->" + session.getTargetCompID()) ) {
                    
                    if ( quickfix.Session.lookupSession(session.getSenderCompID(), session.getTargetCompID())
                            .isLoggedOn() ) {
                        
                        Message ordMsg = _engineFact.createMessage(MsgType.ORDER_SINGLE);
                        
                        ordMsg.setValue(Tag.ClOrdID, orderMessage.getClOrdID());
                        ordMsg.setValue(Tag.Symbol, orderMessage.getSymbol());
                        ordMsg.setValue(Tag.Side, orderMessage.getSide());
                        ordMsg.setValue(Tag.OrderQty, orderMessage.getOrderQty());
                        ordMsg.setValue(Tag.Price, orderMessage.getPrice());
                        ordMsg.setValue(Tag.OrdType, orderMessage.getOrdType());
                        ordMsg.setValue(Tag.HandlInst, orderMessage.getHandlInst());
                        ordMsg.setValue(Tag.TransactTime, orderMessage.getTransactTime());
                        
                        session.sendAppMessage(ordMsg);
                        orderMessages.put(orderMessage.getClOrdID(), orderMessage);
                        
                        System.out.println("Executing sendOrder function==>" + orderMessage.getSession());
                        
                    }
                }
            }
            
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return orderMessage;
        
    }
    
    /*
    @Override
    public ArrayList<Order> getOrders() {
        return new ArrayList<Order>(orders.values());
    };
    
    @Override
    public Order getOrder(String ClOrdID) {
        return orders.get(ClOrdID);
    };
    
    @Override
    public void addOrder(Order order) {
        orders.put(order.getClOrdID(), order);
    }
    
    
     * public List<Order> getAllOrders(String orderID){ Map<String, Order> order
     * = orders.get(orderID).getOrders(); return new
     * ArrayList<Order>(order.values()); }
     
    
    @Override
    public List<OrderMessage> getAllOrderMessages(String orderId) {
        Map<Long, OrderMessage> orderMessages = orders.get(orderId).getMessages();
        return new ArrayList<OrderMessage>(orderMessages.values());
    }
    
    @Override
    public OrderMessage addOrderMessage(String orderId, OrderMessage orderMessage) {
        Map<Long, OrderMessage> orderMessages = orders.get(orderId).getMessages();
        orderMessage.setId(orderMessages.size() + 1);
        orderMessages.put(orderMessage.getId(), orderMessage);
        return orderMessage;
    }
    
    */
    
    private static class _Application implements Application {
        
        public _Application() {
        }
        
        @Override
        public void onAppMessage(final Message arg0, final Session arg1) {
            // TODO Auto-generated method stub
            
        }
        
        @Override
        public void onLogon(final Session sessionId) {
            
        }
        
        @Override
        public void onLogout(final Session arg0) {
            // TODO Auto-generated method stub
            
        }
    }

	@Override
	public Order getOrder(String ClOrdID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderMessage> getAllOrderMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderMessage> getOrderMessages(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}
  
}
