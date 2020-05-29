package com.spice.expertmgmtbsnl.daoImpl;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.spice.expertmgmtbsnl.connection.ConnectionFactory;
import com.spice.expertmgmtbsnl.dao.CheckLoginStatusDao;
import com.spice.expertmgmtbsnl.model.CheckLoginStatusModel;
import com.spice.expertmgmtbsnl.model.HourlyReportModel;
import com.spice.expertmgmtbsnl.model.UserLoginModel;

@Repository
@Transactional

public class CheckLoginStatusDaoImpl implements CheckLoginStatusDao{
	
	
	@Autowired
	HttpSession session;
	
	Logger logger=Logger.getLogger(CheckLoginStatusDaoImpl.class.getName());
	
	public List<CheckLoginStatusModel> checkLoginStatusModel()
	{
		
		List<CheckLoginStatusModel> list=new ArrayList<CheckLoginStatusModel>();
		
		try{
			Connection con=ConnectionFactory.getConnection();
			if(con!=null)
			{
			String sql="select B_CATEGORY,B_ANI,B_CHATID,B_CIRCLE,B_GENDER,B_NAME,LOGIN_STATUS,STATUS,TOTAL_COUNT,"
					+ "SUCCESS_COUNT,FAIL_COUNT,PRIORITY_FLAG,OUT_LINE,IP,A_ANI,A_CHATID,"
					+ "A_CIRCLE,IN_LINE,LAST_CALL_TIME,AGENT_CIRCLE,LOGINLOGOUT_DATETIME,HUB,PARTNER_NAME from tbl_etalk_expert";
			
			logger.info("Query is {["+sql+"}]");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				CheckLoginStatusModel obj=new CheckLoginStatusModel();
				obj.setbCategory(rs.getString(1));
				obj.setbAni(rs.getLong(2));
				obj.setbChatId(rs.getString(3));
				obj.setbCircle(rs.getString(4));
				obj.setbGender(rs.getString(5));
				obj.setbName(rs.getString(6));
				obj.setLoginStatus(rs.getString(7));
				obj.setStatus(rs.getString(8));
				obj.setTotalCount(rs.getInt(9));
				obj.setSucessCount(rs.getInt(10));
				obj.setFailCount(rs.getInt(11));
				obj.setProrityFlag(rs.getInt(12));
				obj.setOutLine(rs.getString(13));
				obj.setIp(rs.getString(14));
				obj.setaAni(rs.getLong(15));
				obj.setaChatId(rs.getInt(16));
				obj.setaCircle(rs.getString(17));
				obj.setInLine(rs.getString(18));
				obj.setLastCallTime(rs.getString(19));
				obj.setAgentCircle(rs.getString(20));
				obj.setLoginLogoutDateTime(rs.getString(21));
				obj.setHub(rs.getString(22));
				obj.setPartnerName(rs.getString(23));
				list.add(obj);				
			}
		}
			return list;		
					}
			catch(Exception e)
			{
				logger.info("Exception!!! ", e);
				return null;
			}
			}
	
	
	
	
	public List<CheckLoginStatusModel> checkLoginStatusModelPartner(String partner_name)
	{
		
		List<CheckLoginStatusModel> list=new ArrayList<CheckLoginStatusModel>();
		
		try{
			Connection con=ConnectionFactory.getConnection();
			if(con!=null)
			{
			String sql="select B_CATEGORY,B_ANI,B_CHATID,B_CIRCLE,B_GENDER,B_NAME,LOGIN_STATUS,STATUS,TOTAL_COUNT,"
					+ "SUCCESS_COUNT,FAIL_COUNT,PRIORITY_FLAG,OUT_LINE,IP,A_ANI,A_CHATID,"
					+ "A_CIRCLE,IN_LINE,LAST_CALL_TIME,AGENT_CIRCLE,LOGINLOGOUT_DATETIME,HUB,PARTNER_NAME from tbl_etalk_expert "
					+ "where PARTNER_NAME='"+partner_name+"'";
			logger.info("Query is --- {["+sql+"}]");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				CheckLoginStatusModel obj=new CheckLoginStatusModel();
				obj.setbCategory(rs.getString(1));
				obj.setbAni(rs.getLong(2));
				obj.setbChatId(rs.getString(3));
				obj.setbCircle(rs.getString(4));
				obj.setbGender(rs.getString(5));
				obj.setbName(rs.getString(6));
				obj.setLoginStatus(rs.getString(7));
				obj.setStatus(rs.getString(8));
				obj.setTotalCount(rs.getInt(9));
				obj.setSucessCount(rs.getInt(10));
				obj.setFailCount(rs.getInt(11));
				obj.setProrityFlag(rs.getInt(12));
				obj.setOutLine(rs.getString(13));
				obj.setIp(rs.getString(14));
				obj.setaAni(rs.getLong(15));
				obj.setaChatId(rs.getInt(16));
				obj.setaCircle(rs.getString(17));
				obj.setInLine(rs.getString(18));
				obj.setLastCallTime(rs.getString(19));
				obj.setAgentCircle(rs.getString(20));
				obj.setLoginLogoutDateTime(rs.getString(21));
				obj.setHub(rs.getString(22));
				obj.setPartnerName(rs.getString(23));
				list.add(obj);				
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
	
	
	public int changeLoginStatus(String p_ani,String p_status)
	{
		try{
			Connection con=ConnectionFactory.getConnection();
			if(con!=null)
			{
				CallableStatement st=con.prepareCall("{call proc_edit_login_status(?,?)}");
				st.setString(1, p_ani);
				st.setString(2, p_status);
				
				int i=st.executeUpdate();
				return i;
			}
			}
			
			catch(Exception e)
			{
				logger.info(e);
				return 0;
			}
			
		return 0;
	}

	
	public ArrayList<HourlyReportModel> fetchHourlyReport(String fromDate,String toDate)
	{
		ArrayList<HourlyReportModel> list = new ArrayList<HourlyReportModel>();
		try
		{
			
			Connection con=ConnectionFactory.getConnection();
			if(con!=null)
			{
				Statement st=con.createStatement();
				String query="select date(MIS_DATE),circle,agent_location,MIS_HOUR,chat_ids,login_logout,ani,vendor,"
						+ "location,status,category,total_Calls,succ_Calls,fail_calls,mous,org_cancel_call_less_20sec,"
						+ "org_cancel_call_gret_20sec,no_answer,switch_off from tbl_pcs_productivity_hourly_mis "
						+ "where DATE(MIS_DATE) between '"+fromDate+"' and '"+toDate+"' order by MIS_DATE ASC";
				ResultSet rs= st.executeQuery(query);
				logger.info("Exceuted Query is {["+query+"]}");
				
				if(rs.next()==false)
				{
					logger.info("No record found");
				}
				
				else
				{
					rs.previous();
					
					while(rs.next())
					{
						HourlyReportModel model = new HourlyReportModel();
						model.setMIS_DATE(rs.getString(1));
						model.setCircle(rs.getString(2));
						model.setAgent_location(rs.getString(3));
						model.setMIS_HOUR(String.valueOf(rs.getInt(4)));
						model.setChat_ids(String.valueOf(rs.getInt(5)));
						model.setLogin_logout(rs.getString(6));
						model.setAni(rs.getString(7));
						model.setVendor(rs.getString(8));
						model.setLocation(rs.getString(9));
						model.setStatus(rs.getString(10));
						model.setCategory(rs.getString(11));
						model.setTotal_Calls(String.valueOf(rs.getInt(12)));
						model.setSucc_Calls(String.valueOf(rs.getInt(13)));
						model.setFail_calls(String.valueOf(rs.getInt(14)));
						model.setMous(String.valueOf(rs.getInt(15)));
						model.setOrg_cancel_call_less_20sec(String.valueOf(rs.getInt(16)));
						model.setOrg_cancel_call_gret_20sec(String.valueOf(rs.getInt(17)));
						model.setNo_answer(String.valueOf(rs.getInt(18)));
						model.setSwitch_off(String.valueOf(rs.getInt(19)));
						list.add(model);
					}
				}
			}
		}
			
		catch(Exception e)
		{
			logger.info(e);
		}
		
		return list;
	}
	
	
	
	public ArrayList<HourlyReportModel> fetchHourlyReportPartner(String fromDate,String toDate)
	{
		ArrayList<HourlyReportModel> list = new ArrayList<HourlyReportModel>();
		try
		{
			UserLoginModel login = (UserLoginModel)session.getAttribute("loginObj");
			String vendor_name = login.getUserName();
			logger.info("---Partner name is {["+login.getUserName()+"]}");
			
			Connection con=ConnectionFactory.getConnection();
			if(con!=null)
			{
				Statement st=con.createStatement();
				String query="select date(MIS_DATE),circle,agent_location,MIS_HOUR,chat_ids,login_logout,ani,vendor,"
						+ "location,status,category,total_Calls,succ_Calls,fail_calls,mous,org_cancel_call_less_20sec,"
						+ "org_cancel_call_gret_20sec,no_answer,switch_off from tbl_pcs_productivity_hourly_mis "
						+ "where DATE(MIS_DATE) between '"+fromDate+"' and '"+toDate+"' and "
								+ "vendor='"+vendor_name+"' order by MIS_DATE ASC";
				ResultSet rs= st.executeQuery(query);
				logger.info("Exceuted Query is {["+query+"]}");
				
				if(rs.next()==false)
				{
					logger.info("No record found");
				}
				
				else
				{
					rs.previous();
					
					while(rs.next())
					{
						HourlyReportModel model = new HourlyReportModel();
						model.setMIS_DATE(rs.getString(1));
						model.setCircle(rs.getString(2));
						model.setAgent_location(rs.getString(3));
						model.setMIS_HOUR(String.valueOf(rs.getInt(4)));
						model.setChat_ids(String.valueOf(rs.getInt(5)));
						model.setLogin_logout(rs.getString(6));
						model.setAni(rs.getString(7));
						model.setVendor(rs.getString(8));
						model.setLocation(rs.getString(9));
						model.setStatus(rs.getString(10));
						model.setCategory(rs.getString(11));
						model.setTotal_Calls(String.valueOf(rs.getInt(12)));
						model.setSucc_Calls(String.valueOf(rs.getInt(13)));
						model.setFail_calls(String.valueOf(rs.getInt(14)));
						model.setMous(String.valueOf(rs.getInt(15)));
						model.setOrg_cancel_call_less_20sec(String.valueOf(rs.getInt(16)));
						model.setOrg_cancel_call_gret_20sec(String.valueOf(rs.getInt(17)));
						model.setNo_answer(String.valueOf(rs.getInt(18)));
						model.setSwitch_off(String.valueOf(rs.getInt(19)));
						list.add(model);
					}
				}
			}
		}
			
		catch(Exception e)
		{
			logger.info(e);
		}
		
		return list;
	}	
	
}