package com.spice.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class DBConnection {
	//private static final Logger log = Logger.getLogger(SubDetails.class);

    //("jdbc:mysql://localhost:3306/soccer","root", "password")
	//private final static Logger log = Logger.getLogger(MysqlConnectionManager.class);
    private static String ip = "";
    private static String port = "";
    private static String db = "";
    private static String db2 = "";
    private static String db3 = "";
    private static String userName = "";
    private static String password = "";
    private static final String JDBC_URL = "jdbc:mysql://%s:%s/%s";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //log.info("Trying to create Mysql Connection");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties prop = loadParams("com.spice.connection.Config");
            ip = prop.getProperty("ip");
            //System.out.println("IP is -------------"+ip);
            port = prop.getProperty("port");
            //System.out.println("PORT is ------------"+port);
            userName = prop.getProperty("userName");
            //System.out.println("USERNAME ------------"+userName);
            password = prop.getProperty("password");
            //System.out.println("PASSWORD is ------------"+password);
            db = prop.getProperty("dbName");
          
            //System.out.println("DB is ----------------"+db);
            Connection conn = DriverManager.getConnection(String.format(JDBC_URL, ip, port, db),userName,password);
            
            if (conn != null ) {
            	//log.info("Connction create successfully..............");
            	System.out.println("Connction created successfully..............");
                return conn;
            } else {
            	//log.info("Some thing went wrong in connection creations !!!!");
            	System.out.println("Some thing went wrong in connection creations !!!!");
            }
        } catch(Exception e) {
        	//log.error("Exception in creating connection ---- ",e);
        	System.out.println("Exception in creating connection ---- "+e);
        }
        return null;
    }
    
    public static Connection getConnectionNradio() throws ClassNotFoundException, SQLException {
        //log.info("Trying to create Mysql Connection");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties prop = loadParams("com.spice.connection.Config");
            ip = prop.getProperty("ip");
            //System.out.println("IP is -------------"+ip);
            port = prop.getProperty("port");
            //System.out.println("PORT is ------------"+port);
            userName = prop.getProperty("userName");
            //System.out.println("USERNAME ------------"+userName);
            password = prop.getProperty("password");
            //System.out.println("PASSWORD is ------------"+password);
            db = prop.getProperty("dbName");
            db2 = prop.getProperty("dbName2");
            Connection conn = DriverManager.getConnection(String.format(JDBC_URL, ip, port, db2),userName,password);
            if (conn != null ) {
            	//log.info("Connction create successfully..............");
            	System.out.println("Connction created successfully..............");
                return conn;
            } else {
            	//log.info("Some thing went wrong in connection creations !!!!");
            	System.out.println("Some thing went wrong in connection creations !!!!");
            }
        } catch(Exception e) {
        	//log.error("Exception in creating connection ---- ",e);
        	System.out.println("Exception in creating connection ---- "+e);
        }
        return null;
    }
    
    
    public static Connection getConnectionShayari() throws ClassNotFoundException, SQLException {
        //log.info("Trying to create Mysql Connection");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties prop = loadParams("com.spice.connection.Config");
            ip = prop.getProperty("ip");
            //System.out.println("IP is -------------"+ip);
            port = prop.getProperty("port");
            //System.out.println("PORT is ------------"+port);
            userName = prop.getProperty("userName");
            //System.out.println("USERNAME ------------"+userName);
            password = prop.getProperty("password");
            //System.out.println("PASSWORD is ------------"+password);
            db = prop.getProperty("dbName");
            db3 = prop.getProperty("dbName3");
            Connection conn = DriverManager.getConnection(String.format(JDBC_URL, ip, port, db3),userName,password);
            if (conn != null ) {
            	//log.info("Connction create successfully..............");
            	System.out.println("Connction created successfully..............");
                return conn;
            } else {
            	//log.info("Some thing went wrong in connection creations !!!!");
            	System.out.println("Some thing went wrong in connection creations !!!!");
            }
        } catch(Exception e) {
        	//log.error("Exception in creating connection ---- ",e);
        	System.out.println("Exception in creating connection ---- "+e);
        }
        return null;
    }
    
    public static Properties loadParams(String str ) throws IOException {
        Properties prop = new Properties();
        ResourceBundle bundle;
        bundle = ResourceBundle.getBundle(str);
        Enumeration enumParams = bundle.getKeys();
        String key = null;
        
        while(enumParams.hasMoreElements()) {
            key = (String)enumParams.nextElement();
            prop.put(key, bundle.getObject(key));
        }
        return prop;
    }
    
    public static void main(String args[]) throws Exception {
        getConnection();
    }
}
