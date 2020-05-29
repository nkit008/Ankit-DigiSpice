package com.prison.complainsystem.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.prison.complainsystem.connection.ConnectionFactory;
import com.prison.complainsystem.dao.LoginLogoutDao;
import com.prison.complainsystem.model.UserLogin;

@Repository
@Transactional
public class LoginLogoutDaoImpl implements LoginLogoutDao{
	
	@Autowired
	HttpSession session;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginLogoutDaoImpl.class);
	Connection con=null;
	
	@Override
	public List<UserLogin> checkLoginDetails(String username,String pass)
	{
		
		try
		{
			con=ConnectionFactory.getConnection();
			
			if(con==null)
			{
				logger.info("connection is not establish!");
				return null;
			}
			
			else
			{
				List<UserLogin> list=new ArrayList<UserLogin>();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select id,user_name,"
						+ "password,name,user_role,created_by,created_at,active,updated_by,updated_at from tbl_user_login WHERE user_name='"+username+"' and binary password='"+pass+"' and active=true");
				if(rs==null)
				{
					logger.info("wrong credential!");
					return list;
				}
				
				else
				{
					while(rs.next())
					{
						UserLogin user=new UserLogin();
						user.setId(rs.getLong(1));
						user.setUser_name(rs.getString(2));
						user.setPassword(rs.getString(3));
						user.setName(rs.getString(4));
						user.setUser_role(rs.getString(5));
						user.setCreated_by(rs.getString(6));
						user.setCreated_at(rs.getString(7));
						user.setActive(rs.getBoolean(8));
						user.setUpdated_by(rs.getString(9));
						user.setUpdated_at(rs.getString(10));
						list.add(user);
					}
					
					return list;
				}
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public int changepass(String password,String id)
	{
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String updatedAt=df.format(date);
		String updatedBy=((UserLogin)session.getAttribute("userObj")).getName();
		int i=0;
		logger.info("changing User password");
		try
		{
			con=ConnectionFactory.getConnection();
			
			if(con==null)
			{
				logger.info("connection is not establish!");
				return i;
			}
			
			else
			{
				PreparedStatement pst=con.prepareStatement("update tbl_user_login set password=?,updated_by=?,"
						+ "updated_at=? where id=?");
				pst.setString(1, password);
				pst.setString(2, updatedBy);
				pst.setString(3, updatedAt);
				pst.setLong(4, Long.parseLong(id));
				
				i=pst.executeUpdate();
				
				logger.info(i+" records password changed ");
				
				return i;
			}
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return i;
		}
		
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}