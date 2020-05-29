package com.VodaGhanaNewsAlert.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConnectionFactory {
	
	private static final Logger logger = LogManager.getLogger(ConnectionFactory.class);
	
	public static Connection getDBConnection(){
		Connection c=null;
		
		Properties prop= new Properties();
		try{
			prop.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties"));
			//prop.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("dbTest.properties"));
			String driver = prop.getProperty("db.driver");
			String url = prop.getProperty("db.url");
			
			String username = prop.getProperty("db.user");
			String password = prop.getProperty("db.password");
			
			logger.info("Driver is "+driver);
			logger.info("URL is "+url);
			logger.info("username is "+username);
			logger.info("pass is "+password);
			
			Class.forName(driver);
			
			c = DriverManager.getConnection(url,username,password);
			logger.info("Connection Connected !!!!! "+c);	
			
			//logger.debug("Connection:: "+c);
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error("Error while connecting the database !!!!!! "+e);
		}
		return c;
	}
}
