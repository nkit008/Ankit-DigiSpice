package com.digispice.ghana.connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.springframework.util.ResourceUtils;






public class GetConnection
{
  private static final Logger logger = Logger.getLogger(GetConnection.class.getName());
  
  static Connection con = null;
  
  public GetConnection() {}
  
  public static Connection getConnection() {
    try {
      Properties prop = new Properties();
      InputStream is = new FileInputStream(ResourceUtils.getFile("classpath:db.properties"));
      prop.load(is);
      String driver = prop.getProperty("jdbc.driver");
      
      if (driver != null)
      {
        Class.forName(driver);
      }
      
      String url = prop.getProperty("jdbc.url");
      String user = prop.getProperty("jdbc.username");
      String dbpassword = prop.getProperty("jdbc.password");
      
      
      logger.info("driver-- "+driver+" url "+url+" username "+user+" password "+dbpassword);
      con = DriverManager.getConnection(url, user, dbpassword);
      logger.info("connection is " + con);
      return con;

    }
    catch (Exception e)
    {
      e.printStackTrace(); }
    return null;
  }
}