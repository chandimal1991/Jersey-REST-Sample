package com.nss;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletContext;

import com.nss.model.Order;

import simplefix.Application;
import simplefix.Engine;
import simplefix.EngineFactory;
import simplefix.Message;
import simplefix.MsgType;
import simplefix.Session;
import simplefix.Tag;

public class FIXServiceImpl implements FIXService {

	private static EngineFactory _engineFact;
	private Engine _engine;
	private ServletContext _servletContext;

	public FIXServiceImpl(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	@Override
	public void init() {

		try {

			Class<?> classobj = Class.forName("simplefix.quickfix.EngineFactory");
			Object engineobj = classobj.newInstance();

			if (engineobj instanceof EngineFactory) {

				_engineFact = (EngineFactory) engineobj;
				_engine = _engineFact.createEngine();
				_engine.initEngine(_servletContext.getRealPath("/WEB-INF/banzai.cfg"));

				Application application = new _Application();

				_engine.startInProcess(application);

				System.out.println("engine started");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<String> getSessionList() throws IllegalArgumentException {
		ArrayList<String> sessions = new ArrayList<String>();

		for (Session session : _engine.getAllSessions()) {
			sessions.add(session.getSenderCompID() + "<-->" + session.getTargetCompID());
		}

		Collections.sort(sessions);
		return sessions;
	}
	
	@Override
	public ArrayList<com.nss.model.Session> getSessions() throws IllegalArgumentException {

		ArrayList<com.nss.model.Session> sessions = new ArrayList<com.nss.model.Session>();
		int sessionID = 1;

		for (Session session : _engine.getAllSessions()) {
			System.out.println(session.getSenderCompID() + "<-->" + session.getTargetCompID());
			com.nss.model.Session sessionObj = new com.nss.model.Session(sessionID,
					session.getSenderCompID() + "<-->" + session.getTargetCompID());
			sessions.add(sessionObj);
			sessionID++;
		}

		return sessions;
	}
	
	@Override
	public void sendOrder(String sessionId) throws IllegalArgumentException {

		try {

			for (Session session : _engine.getAllSessions()) {
				

				if (sessionId.equals(session.getSenderCompID() + "<-->" + session.getTargetCompID())) {

					if (quickfix.Session.lookupSession(session.getSenderCompID(), session.getTargetCompID())
							.isLoggedOn()) {
						

						Message ordMsg = _engineFact.createMessage(MsgType.ORDER_SINGLE);

						ordMsg.setValue(Tag.ClOrdID, "Cld-1234");
						ordMsg.setValue(Tag.Symbol, "6758");
						ordMsg.setValue(Tag.Side, "1");
						ordMsg.setValue(Tag.OrderQty, "1000");
						ordMsg.setValue(Tag.Price, "123.45");
						ordMsg.setValue(Tag.OrdType, "2");
						ordMsg.setValue(Tag.HandlInst, "3");
						ordMsg.setValue(Tag.TransactTime, "20200508-04:36:42");

						session.sendAppMessage(ordMsg);
						
						Message ordMsgAmend = _engineFact.createMessage(MsgType.ORDER_SINGLE);

						ordMsg.setValue(Tag.ClOrdID, "Cld-12345");
						ordMsg.setValue(Tag.OrigClOrdID, "Cld-1234");
						ordMsg.setValue(Tag.Symbol, "6758");
						ordMsg.setValue(Tag.Side, "1");
						ordMsg.setValue(Tag.OrderQty, "1100");
						ordMsg.setValue(Tag.Price, "123.45");
						ordMsg.setValue(Tag.OrdType, "2");
						ordMsg.setValue(Tag.HandlInst, "3");
						ordMsg.setValue(Tag.TransactTime, "20200508-04:36:42");

						session.sendAppMessage(ordMsgAmend);

						System.out.println("Executing sendOrder function==>" + sessionId);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public Order sendOrder(Order order) throws IllegalArgumentException {

		try {

			for (Session session : _engine.getAllSessions()) {
				

				if (order.getSession().equals(session.getSenderCompID() + "<-->" + session.getTargetCompID())) {

					if (quickfix.Session.lookupSession(session.getSenderCompID(), session.getTargetCompID())
							.isLoggedOn()) {
						

						Message ordMsg = _engineFact.createMessage(MsgType.ORDER_SINGLE);

						ordMsg.setValue(Tag.ClOrdID, order.getClOrdID());
						ordMsg.setValue(Tag.Symbol, order.getSymbol());
						ordMsg.setValue(Tag.Side, order.getSide());
						ordMsg.setValue(Tag.OrderQty, order.getOrderQty());
						ordMsg.setValue(Tag.Price, order.getPrice());
						ordMsg.setValue(Tag.OrdType, order.getOrdType());
						ordMsg.setValue(Tag.HandlInst, order.getHandlInst());
						ordMsg.setValue(Tag.TransactTime, order.getTransactTime());

						session.sendAppMessage(ordMsg);

						System.out.println("Executing sendOrder function==>" + order.getSession());
						
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;

	}

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
	};

}
