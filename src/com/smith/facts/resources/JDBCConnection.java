package com.smith.facts.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
  private static Connection getConnection() throws URISyntaxException, SQLException {
		 
		 URI dbUri = new URI(System.getenv("DATABASE_URL"));
		 String username = dbUri.getUserInfo().split(":")[0];
	        String password = dbUri.getUserInfo().split(":")[1];
	        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
	       
	   try {
		  Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	        return DriverManager.getConnection(dbUrl, username, password);
	    }
  public static Connection jdbcConnection() throws URISyntaxException, SQLException
  {
	  return getConnection();
  }
  

}
