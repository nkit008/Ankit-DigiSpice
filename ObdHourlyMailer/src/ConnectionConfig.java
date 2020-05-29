import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionConfig {

	private static final Logger LOGGER = Logger.getLogger(ConnectionConfig.class.getName());
	
	InputStream input = null;
	
	public Connection DB_connection(String driver,String username,String password,String Ip)
	{
		Connection con=null;
		LOGGER.info("-----Creating DB Connection--------");
		try
		{
			input = new FileInputStream("config.properties");
			Properties prop = new Properties();
			prop.load(input);
			
			String var_driver = prop.getProperty(driver);
			String var_username = prop.getProperty(username);
			String var_password = prop.getProperty(password);
			String var_ip = prop.getProperty(Ip);
			LOGGER.info("DriverName is {["+var_driver+"}] username is {["+var_username+"}] password is {{"+var_password+"}] Ip is {["+var_ip+"}]");
			if((var_driver!=null) && (var_username!=null) && (var_password!=null) && (var_ip!=null))
			{
				Class.forName(var_driver);
				con = DriverManager.getConnection(var_ip,var_username,var_password);
				//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expertchatBSNL","root","spice@1234");
				LOGGER.info("Connection up with database for "+username.substring(0, 3));
			}
			
		}
		catch(Exception ex)
		{
			LOGGER.info("Exception in Connection with DB block :: ",ex);
		}
		
		finally
		{
			if(input!=null)
			{
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return con;
	}
	
	
	public String getValuefromProperties(String key)
	{
		String value=null;
		try
	{
			input = new FileInputStream("config.properties");
			Properties prop = new Properties();
			prop.load(input);
			value = prop.getProperty(key);
			LOGGER.info("Fetching value for {["+key+"}] is {["+value+"}]");
		}
		catch(Exception ex)
		{
			LOGGER.info("Exception in fetch_data() connection with DB block :: ",ex);
		}
		
		finally
		{
			if(input!=null)
			{
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
		return value;
	}

}
