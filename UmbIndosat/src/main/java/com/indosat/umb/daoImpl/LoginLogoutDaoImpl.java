package com.indosat.umb.daoImpl;

import java.net.InetAddress;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.indosat.umb.controller.ConnectionUtility;

@Repository
public class LoginLogoutDaoImpl {
	
	private static final Logger LOGGER = Logger.getLogger(LoginLogoutDaoImpl.class);
	
	Connection con = null;
			
	public String checkUserAuthentication(String username,String password)
	{
		LOGGER.info("Entered UserName and password is {["+username+"]} {["+password+"]}");
		String response = null;
		
		try
		{
			con = ConnectionUtility.getDBConnection();
			if(con!=null)
			{
				InetAddress localhost = InetAddress.getLocalHost();
				CallableStatement cst = con.prepareCall("{call proc_login(?,?,?,?,?)}");
				cst.setString(1, username);
				cst.setString(2, password);
				cst.setString(3, localhost.getHostAddress());
				cst.setString(4, "NA");
				cst.registerOutParameter(5, java.sql.Types.VARCHAR);
				cst.execute();
				response = cst.getString(5);
				
				LOGGER.info("Response is "+response);
				
			}
			
		}
		
		catch(Exception e)
		{
			LOGGER.info(e);
		}
		
		return response;
	}

}
