package com.spice.expertmgmtbsnl.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spice.expertmgmtbsnl.connection.ConnectionFactory;
import com.spice.expertmgmtbsnl.dao.LoginLogoutSummaryDao;
import com.spice.expertmgmtbsnl.model.LoginLogoutSummaryModel;

@Repository
@Transactional

public class LoginLogoutSummaryDaoImpl implements LoginLogoutSummaryDao{

	
	Logger logger=Logger.getLogger(LoginLogoutSummaryDaoImpl.class.getName());
	
	@Override
	public List<LoginLogoutSummaryModel> getSummary(String id)
	{
		
		try{
			List<LoginLogoutSummaryModel> list=new ArrayList<LoginLogoutSummaryModel>();
			Connection con=ConnectionFactory.getConnection();
			if(con!=null)
			{
			String sql="select ANI,CHAT_ID,PARTNER_NAME,AGENT_TYPE,HUB,CIRCLE,LAST_DATE_TIME,ACTION"
					+ " from tbl_login_logout_summary where chat_id='"+id+"'";
			
			logger.info("Query is {["+sql+"]}");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				LoginLogoutSummaryModel summary = new LoginLogoutSummaryModel();
				summary.setAni(rs.getLong(1));
				summary.setChat_id(rs.getString(2));
				summary.setPartner_name(rs.getString(3));
				summary.setAgent_type(rs.getString(4));
				summary.setHub(rs.getString(5));
				summary.setCircle(rs.getString(6));
				summary.setLast_date_time(rs.getString(7));
				summary.setAction(rs.getString(8));
				list.add(summary);
			}
			}
			return list;
		}
			catch(Exception e)
			{
				logger.info(e);
				return null;
			}
	}
	
	
	
	@Override
	public List<LoginLogoutSummaryModel> getSummaryPartner(String id,String partner_name)
	{
		
		try{
			logger.info("in getSummaryPartner");
			List<LoginLogoutSummaryModel> list=new ArrayList<LoginLogoutSummaryModel>();
			Connection con=ConnectionFactory.getConnection();
			if(con!=null)
			{
			String sql="select ANI,CHAT_ID,PARTNER_NAME,AGENT_TYPE,HUB,CIRCLE,LAST_DATE_TIME,ACTION"
					+ " from tbl_login_logout_summary where chat_id='"+id+"' and PARTNER_NAME='"+partner_name+"'";
			logger.info("Query is {["+sql+"}]");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				LoginLogoutSummaryModel summary = new LoginLogoutSummaryModel();
				summary.setAni(rs.getLong(1));
				summary.setChat_id(rs.getString(2));
				summary.setPartner_name(rs.getString(3));
				summary.setAgent_type(rs.getString(4));
				summary.setHub(rs.getString(5));
				summary.setCircle(rs.getString(6));
				summary.setLast_date_time(rs.getString(7));
				summary.setAction(rs.getString(8));
				list.add(summary);
			}
			}
			return list;
		}
			catch(Exception e)
			{
				logger.info(e);
				return null;
			}
	}
	
	

}
