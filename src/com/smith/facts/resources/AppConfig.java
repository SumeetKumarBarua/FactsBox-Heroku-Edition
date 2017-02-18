package com.smith.facts.resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class AppConfig {
	public static final Properties PROPERTIES;
	public static InputStream inputStream = null;
	static {
		try {
			inputStream = AppConfig.class
					.getResourceAsStream("configuration.properties");
		} catch (Exception e) {
			Logger logger = Logger.getLogger(AppConfig.class);
			logger.error(e.getMessage(), e);
		}
		PROPERTIES = new Properties();
		try {
			PROPERTIES.load(inputStream);
		} catch (IOException e) {
			Logger logger = Logger.getLogger(AppConfig.class);
			logger.error(e.getMessage(), e);
		}
	}
}