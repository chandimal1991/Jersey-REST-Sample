package com.nss;

import javax.servlet.ServletContext;

import org.glassfish.jersey.servlet.ServletContainer;

public class MyServletContainer extends ServletContainer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init()
	          throws javax.servlet.ServletException {
		super.init();
		
		ServletContext servletContext = getServletContext();

		FIXService fixService = new FIXServiceImpl(servletContext);
		fixService.init();
		
		servletContext.setAttribute("FIX_Service", fixService);;
	}
}
