package com.spice.expertmgmtbsnl.daoImpl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.spice.expertmgmtbsnl.connection.ConnectionFactory;
import com.spice.expertmgmtbsnl.dao.LoginDao;
import com.spice.expertmgmtbsnl.model.UserLoginModel;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao{

	Logger logger=Logger.getLogger(LoginDaoImpl.class.getName());
	
	
	@Override
	public UserLoginModel checkLogin(String userid,String password)
	{
		Connection con=null;
		List<UserLoginModel> listUserLoginModel = new ArrayList<UserLoginModel>();
		try{
		con=ConnectionFactory.getConnection1();
		String sql="select id,user_id,user_name,PASSWORD,state,location,role,status"
				+ " from partner_configuration where user_id=? and binary password=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, userid);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		
		
		if(!rs.next())
		{
			logger.info("No Record found regarding to userId {["+userid+"]} and password {["+password+"]}");
			return null;
		}
		
		else
		{
			UserLoginModel login=new UserLoginModel();
			login.setId(rs.getInt(1));
			login.setUserId(rs.getString(2));
			login.setUserName(rs.getString(3));
			login.setPassword(rs.getString(4));
			login.setState(rs.getString(5));
			login.setLocation(rs.getString(6));
			login.setRole(rs.getString(7));
			login.setStatus(rs.getString(8));
			listUserLoginModel.add(login);
		}
		}
		
		catch(Exception e)
		{
			logger.info("::::Connection is not created:::");
			listUserLoginModel.add(null);
			return null;
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				logger.info(e);
			}	
		}
		return listUserLoginModel.get(0);
		}
}
