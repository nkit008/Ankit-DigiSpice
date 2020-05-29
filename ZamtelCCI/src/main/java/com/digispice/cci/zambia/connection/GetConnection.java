package com.digispice.cci.zambia.connection;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

public class GetConnection {

	public static final Logger logger = LoggerFactory.getLogger(GetConnection.class);

	static Connection con = null;

	public static Connection getConnection() throws SQLException {
		try {
			String driver = loadProp("jdbc.driver");

			if (driver != null) {
				Class.forName(driver);
			}

			String url = loadProp("jdbc.url");
			String user = loadProp("jdbc.username");
			String dbpassword = loadProp("jdbc.password");

			con = DriverManager.getConnection(url, user, dbpassword);
			return con;
		}

		catch (Exception e) {
			logger.info("exception occured {}", e);
			;
			return null;
		}

	}

	public static Connection getConnectionNextMusic() throws SQLException {
		try {
			String driver = loadProp("jdbc.driver");

			if (driver != null) {
				Class.forName(driver);
			}

			String url = loadProp("jdbc.NextMusic.url");
			String user = loadProp("jdbc.username");
			String dbpassword = loadProp("jdbc.password");

			con = DriverManager.getConnection(url, user, dbpassword);
			return con;
		}

		catch (Exception e) {
			logger.info("exception occured {}", e);
			;
			return null;
		}

	}

	public static Connection getConnectionNextVoice() throws SQLException {
		try {
			String driver = loadProp("jdbc.driver");
			if (driver != null) {
				Class.forName(driver);
			}

			String url = loadProp("jdbc.NextVoice.url");
			String user = loadProp("jdbc.username");
			String dbpassword = loadProp("jdbc.password");

			con = DriverManager.getConnection(url, user, dbpassword);

			return con;
		}

		catch (Exception e) {
			logger.info("exception occured {}", e);
			;
			return null;
		}

	}

	public static String loadProp(String var) {
		InputStream is = null;
		try {
			Properties prop = new Properties();
			is = new FileInputStream(ResourceUtils.getFile("classpath:db.properties"));
			prop.load(is);
			return prop.getProperty(var);
		}

		catch (Exception e) {
			logger.info("exception occured {}", e);
			;
		}

		finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.info("exception occured {}", e);
					;
				}
			}
		}

		return null;

	}

}
