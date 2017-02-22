package com.smith.facts.resources;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		HibernateUtility.createSessionFactory();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtility.closeSessionFactory();
	}

}