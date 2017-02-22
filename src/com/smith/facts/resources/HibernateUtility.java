package com.smith.facts.resources;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtility {

	private static final String CONFIGURATION_LOCATION = "com/smith/facts/resources/hibernate.cfg.xml";
	private static SessionFactory sessionFactory = getSessionFactory();

	private static SessionFactory getSessionFactory() {
		try {
			if (sessionFactory == null) {
				Configuration configuration = new Configuration()
						.configure(CONFIGURATION_LOCATION);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration
						.buildSessionFactory(serviceRegistry);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Logger logger = Logger.getLogger(HibernateUtility.class);
			logger.debug(e.getMessage(), e);
		}
		return sessionFactory;
	}

	public static SessionFactory createSessionFactory() {
return getSessionFactory();
	}

	public static void closeSessionFactory() {
		if (!sessionFactory.isClosed()) {
			sessionFactory.close();
		}
	}
}
