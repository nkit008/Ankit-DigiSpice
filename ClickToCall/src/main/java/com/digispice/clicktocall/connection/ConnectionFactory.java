package com.digispice.clicktocall.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.springframework.util.ResourceUtils;

public class ConnectionFactory {

	public static Connection getConnection() {
		try {

			Properties prop = new Properties();
			File file = ResourceUtils.getFile("classpath:db.properties");
			InputStream io = new FileInputStream(file);
			prop.load(io);
			String driver = prop.getProperty("jdbc.driver");

			if (driver != null) {
				Class.forName(driver);
			}

			String url = prop.getProperty("jdbc.url");
			String user = prop.getProperty("jdbc.username");
			String dbpassword = prop.getProperty("jdbc.password");

			Connection con = DriverManager.getConnection(url, user, dbpassword);
			return con;
		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
