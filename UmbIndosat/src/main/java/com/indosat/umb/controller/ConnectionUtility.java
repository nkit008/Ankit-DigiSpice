package com.indosat.umb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.util.ResourceUtils;


public class ConnectionUtility {
	
	static Connection con=null;
	
	private static final Logger LOGGER = Logger.getLogger(ConnectionUtility.class);
	
	public static Connection getDBConnection()
	{
		try
		{
			InputStream is = new FileInputStream(ResourceUtils.getFile("classpath:application_local.properties"));
			Properties prop = new Properties();
			prop.load(is);
			
			String driver = prop.getProperty("jdbc.driverClassName");
			String url = prop.getProperty("jdbc.url");
			String username = prop.getProperty("jdbc.username");
			String password = prop.getProperty("jdbc.password");
			
			LOGGER.info("Driver name is {["+driver+"]} URL is {["+url+"]} UserName is {["+username+"]} and Password is {["+password+"]}");
			
			if(driver!=null && url!=null && username!=null && password!=null)
			{
				Class.forName(driver);
				con = DriverManager.getConnection(url,username,password);
			}
			
		}
		
		catch(Exception e)
		{
			LOGGER.info("-----Exception during the estblished of the DB Connection-----");
			LOGGER.info(e);
		}
		
		return con;
	}

}