package com.digispice.indosat.connection;


import java.io.File;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.util.ResourceUtils;

public class ConnectionFactory {

	private static final Logger logger = Logger.getLogger(ConnectionFactory.class.getName());
	
	
	public static Connection getConnection()
	{
		try
		{
			Properties prop= new Properties();
			File file=ResourceUtils.getFile("classpath:db.properties");
			InputStream io= new FileInputStream(file);
			prop.load(io);
			String driver=prop.getProperty("DRIVER");
			
			if(driver != null)
			{
				Class.forName(driver);
				String url=prop.getProperty("DBURL");
				String user=prop.getProperty("USERNAME");
				String dbpassword=prop.getProperty("PWD");
				
				Connection con=DriverManager.getConnection(url,user,dbpassword);
					return con;
			}
			
			else
			{
				logger.error("----Mysql driver is null-----");
				return null;
				
			}
		}
		catch(Exception e)
		{
			logger.info(e);
			return null;
		}
	}
	
	
	
	public static String getProperty(String key)
	{
		Properties prop= new Properties();
		try
		{
			File file=ResourceUtils.getFile("classpath:db.properties");
			InputStream io= new FileInputStream(file);
			prop.load(io);
			return prop.getProperty(key);
		}
		
		catch(Exception e)
		{
			logger.info(e);
			return null;
		}
	}
}