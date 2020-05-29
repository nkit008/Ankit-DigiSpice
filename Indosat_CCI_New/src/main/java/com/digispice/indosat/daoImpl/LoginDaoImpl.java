package com.digispice.indosat.daoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digispice.indosat.connection.ConnectionFactory;
import com.digispice.indosat.dao.LoginDao;
import com.digispice.indosat.model.UserLogin;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao{
	
	public static Logger logger=Logger.getLogger(LoginDaoImpl.class.getName());
	
	
	@Autowired
	HttpSession session;
	
	Connection con=null;
	
	@Override
	public UserLogin checkLogin(String uid,String pwd)
	{
		con=ConnectionFactory.getConnection();
		
		if(con==null)
		{
			logger.info("---connection is not established with database---");
			return null;
			
		}
		
		else
		{
			session.setAttribute("active_connection", con);
			
			String sql="select * from Devotional.tbl_obd_loing where user_ID ='" + uid + "' and PASSWORD='" + pwd + "'";
			logger.info("select * from Devotional.tbl_obd_loing where user_ID ='" + uid + "' and PASSWORD='" + pwd + "'");
	        
	        try 
	        {
	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            
	            logger.info("Record found for username "+uid+" and password "+pwd);
	            if(rs.next()==true)
	            {
	            	rs.previous();
	            	UserLogin user=new UserLogin();
		            while (rs.next())
		            {
		            	
		            	user.setId((String.valueOf(rs.getInt(1))));
		            	user.setUser_id(rs.getString(2));
		            	user.setPassword(rs.getString(3));
		            	user.setAdmin(rs.getString(4));
		            	user.setTech_ops(rs.getString(5));
		            	
		            }
		        
		            return user;
	            }
	            
	            else
	            {
	            	return null;
	            }
	         } 
	        catch (Exception e)
	        {
	            logger.info(e);
	            return null;
	        }
		}
	}

}
