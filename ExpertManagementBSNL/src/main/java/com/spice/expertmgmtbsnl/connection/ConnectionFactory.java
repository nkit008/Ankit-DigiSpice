package com.spice.expertmgmtbsnl.connection;


import java.io.File;



import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.util.ResourceUtils;


public class ConnectionFactory{

	Logger logger=Logger.getLogger(ConnectionFactory.class.getName());
	
	public static Connection getConnection()
	{
		try{
	Properties prop=new Properties();
	
        File file = ResourceUtils.getFile("classpath:db.properties");
        InputStream in = new FileInputStream(file);
        prop.load(in);
    

	String driver = prop.getProperty("jdbc.driver1");
	if(driver != null)
	{
		Class.forName(driver);
	}

	String url=prop.getProperty("jdbc.url1");
	String user=prop.getProperty("jdbc.username1");
	String dbpassword=prop.getProperty("jdbc.password1");
	
	
	System.out.println(" "+prop.getProperty("jdbc.url1")+"  "+prop.getProperty("jdbc.username1"));
	
		Connection con=DriverManager.getConnection(url,user,dbpassword);
		return con;
		
	}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}	
	
	public static Connection getConnection1()
	{
		try{
		
	Properties prop=new Properties();
	
        File file = ResourceUtils.getFile("classpath:db.properties");
        InputStream in = new FileInputStream(file);
        prop.load(in);
    

	String driver = prop.getProperty("jdbc.driver");
	if(driver != null)
	{
		Class.forName(driver);
	}

	String url=prop.getProperty("jdbc.url");
	String user=prop.getProperty("jdbc.username");
	String dbpassword=prop.getProperty("jdbc.password");
	
	System.out.println(" "+prop.getProperty("jdbc.url")+"  "+prop.getProperty("jdbc.username"));
		Connection con=DriverManager.getConnection(url,user,dbpassword);
		return con;
		
	}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}	
}