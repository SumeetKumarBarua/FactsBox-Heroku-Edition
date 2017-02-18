package com.smith.facts.resources;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletListener implements ServletContextListener {

	// This method is used for creating the session Factory object when the
	// server is started with WAR deployed on it.
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		HibernateUtility.createSessionFactory();
	}

	// This method is used for destroying the session Factory object when the
	// server is stopped or WAR is updated/undeployed
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtility.closeSessionFactory();
	}

}