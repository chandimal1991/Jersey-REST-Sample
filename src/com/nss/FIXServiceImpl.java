package com.nss;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletContext;

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

	private static class _Application implements Application {

		public _Application() {
		}

		@Override
		public void onAppMessage(final Message arg0, final Session arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onLogon(final Session sessionId) {
			Message ordMsg = _engineFact.createMessage(MsgType.ORDER_SINGLE);

			ordMsg.setValue(Tag.ClOrdID, "Cld-1234");
			ordMsg.setValue(Tag.Symbol, "6758");
			ordMsg.setValue(Tag.Side, "1");
			ordMsg.setValue(Tag.OrderQty, "1000");
			ordMsg.setValue(Tag.Price, "123.45");
			ordMsg.setValue(Tag.OrdType, "2");
			ordMsg.setValue(Tag.HandlInst, "3");

			ordMsg.setValue(Tag.TransactTime, "20200508-04:36:42");

			sessionId.sendAppMessage(ordMsg);

		}

		@Override
		public void onLogout(final Session arg0) {
			// TODO Auto-generated method stub

		}
	};

}
