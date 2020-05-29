package com.spice.expertmgmtbsnl.daoImpl;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spice.expertmgmtbsnl.connection.ConnectionFactory;
import com.spice.expertmgmtbsnl.dao.LoginLogoutDetailsDao;
import com.spice.expertmgmtbsnl.model.UserLoginModel;

@Repository
@Transactional
public class LoginLogoutDetailsImpl implements LoginLogoutDetailsDao{

	Logger logger=Logger.getLogger(LoginLogoutDetailsImpl.class.getName());
	
	@Autowired
	HttpSession session;
	
	public void loginDetails()
	{
		try{

			Date date=new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String fDate=df.format(date);
			String sessionId=session.getId();
			UserLoginModel login=(UserLoginModel)session.getAttribute("loginObj");
			String name=login.getUserName();
			InetAddress localhost = InetAddress.getLocalHost(); 
			String ipAddress=localhost.getHostAddress();

		Connection con=ConnectionFactory.getConnection1();
		String sql="insert into tbl_login_logout_details(B_NAME,SESSION_ID,IP_ADDRESS, LOGIN_TIME) values (?,?,?,?)";
		
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, name);
		pst.setString(2, sessionId);
		pst.setString(3, ipAddress);
		pst.setString(4, fDate);
		pst.executeUpdate();
	}
		catch(Exception e)
		{
			logger.info(e);
		}
	}
	
	public void logoutDetails(String sessionId)
	{		try{

				Date date=new Date();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String fDate=df.format(date);	
			Connection con=ConnectionFactory.getConnection1();
			String sql="update tbl_login_logout_details set LOGOUT_TIME=? where SESSION_ID='"+sessionId+"'";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, fDate);
			pst.executeUpdate();
		}
			catch(Exception e)
			{
				logger.info(e);
			}
		}
	}
