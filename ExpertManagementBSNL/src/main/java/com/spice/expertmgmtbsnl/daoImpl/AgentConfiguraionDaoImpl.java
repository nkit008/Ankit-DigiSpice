package com.spice.expertmgmtbsnl.daoImpl;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spice.expertmgmtbsnl.connection.ConnectionFactory;
import com.spice.expertmgmtbsnl.dao.AgentConfigurationDao;
import com.spice.expertmgmtbsnl.model.AgentConfigurationModel;
import com.spice.expertmgmtbsnl.model.AgentConfiguration_LogModel;
import com.spice.expertmgmtbsnl.model.UserLoginModel;

@Repository
@Transactional
public class AgentConfiguraionDaoImpl implements AgentConfigurationDao{

	Logger logger=Logger.getLogger(AgentConfiguraionDaoImpl.class.getName());
	
	@Autowired
	HttpSession session;
	
	@Override
	public String addNewAgent(AgentConfigurationModel agent)
	{
		try{
		Connection con=ConnectionFactory.getConnection();
		Date date=new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		int c=0;
		String fDate=df.format(date);
		agent.setConfigure_date(fDate);
		agent.setConfigure_by(((UserLoginModel)session.getAttribute("loginObj")).getUserName());
		
		
		Statement st=con.createStatement();
		ResultSet rs1=st.executeQuery("SELECT COUNT(tbl_partner_detail.ani) as total FROM tbl_partner_detail WHERE tbl_partner_detail.ani = "+ agent.getAni());
		while(rs1.next())
		{
			c=rs1.getInt(1);
			logger.info(":::values => 1 if username is already exists::: "+c);
		}
		if(c < 1)
		{
		CallableStatement cs=con.prepareCall("{call proc_config_new_agent(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cs.setString(1, agent.getAni());
		cs.setString(2, agent.getPartner_name().toLowerCase());
		cs.setString(3, agent.getExpert_name().toLowerCase());
		cs.setString(4, agent.getHub().toLowerCase());
		cs.setString(5, agent.getCircle().toLowerCase());
		cs.setString(6, agent.getLocation().toLowerCase());
		cs.setString(7, agent.getAgent_type().toLowerCase());
		cs.setInt(8, agent.getAge());
		cs.setString(9, agent.getGender().toLowerCase());
		cs.setString(10, agent.getLanguage().toLowerCase());
		cs.setInt(11, agent.getMax_calls());
		cs.	setLong(12, agent.getAdhaar_card());
		cs.setString(13, agent.getConfigure_date());
		cs.setString(14, agent.getConfigure_by().toLowerCase());
		cs.setString(15, agent.getSubcategory().toLowerCase());
		int success=cs.executeUpdate();
		if(success > 0)
		{
			String result= String.valueOf(success);
			logger.info("::::New Agent added successfully:::: ");
			return result;
		}
		else
		{
			return "QueryError";
		}
		}
		
		else
		{
			return "exists";
		}
	}
		
	catch(Exception e)
	{
		logger.info(e);
		System.out.println(e.getStackTrace());
		return "error";
	}
		
}
	
	@Override
	public List<AgentConfigurationModel> getAllAgent()
	{
		
		logger.info("::::::::display all Agent details:::::::::");
		
		try{
			Connection con=ConnectionFactory.getConnection();
			List<AgentConfigurationModel> list=new ArrayList<AgentConfigurationModel>();
			Statement st=con.createStatement();
			String query="select ani,chatid,partner_name,expert_name,hub,circle,"
					+ "location,agent_type,age,gender,max_calls,adhar_card_number,configure_date,all_lang,sub_category from tbl_partner_detail";
			logger.info("{["+query+"}]");
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				AgentConfigurationModel config=new AgentConfigurationModel();
				config.setAni(rs.getString(1));
				config.setChatId(rs.getString(2));
				config.setPartner_name(rs.getString(3));
				config.setExpert_name(rs.getString(4));
				config.setHub(rs.getString(5));
				config.setCircle(rs.getString(6));
				config.setLocation(rs.getString(7));
				config.setAgent_type(rs.getString(8));
				config.setAge(rs.getInt(9));
				config.setGender(rs.getString(10));
				config.setMax_calls(rs.getInt(11));
				config.setAdhaar_card(rs.getLong(12));
				config.setConfigure_date(rs.getString(13));
				config.setLanguage(rs.getString(14));
				config.setSubcategory(rs.getString(15));
				list.add(config);
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
	public String editAgentInfo(AgentConfigurationModel agent)
	{
		try{
		Connection con=ConnectionFactory.getConnection();
		Date date=new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String fDate=df.format(date);
		agent.setUpdated_at(fDate);
		agent.setUpdated_by(((UserLoginModel)session.getAttribute("loginObj")).getUserName());
		CallableStatement cs=con.prepareCall("{call proc_edit_agent_detail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		logger.info("{call proc_edit_agent_detail()}");
		cs.setString(1, agent.getAni());
		cs.setString(2, agent.getPartner_name().toLowerCase());
		cs.setString(3, agent.getExpert_name().toLowerCase());
		cs.setString(4, agent.getHub().toLowerCase());
		cs.setString(5, agent.getCircle().toLowerCase());
		cs.setString(6, agent.getLocation().toLowerCase());
		cs.setString(7, agent.getAgent_type().toLowerCase());
		cs.setInt(8, agent.getAge());
		cs.setString(9, agent.getGender().toLowerCase());
		cs.setString(10, agent.getLanguage().toLowerCase());
		cs.setInt(11, agent.getMax_calls());
		cs.setLong(12, agent.getAdhaar_card());
		cs.setString(13, agent.getUpdated_at());
		cs.setString(14, agent.getUpdated_by().toLowerCase());
		cs.setString(15, agent.getSubcategory().toLowerCase());
		int c=cs.executeUpdate();
		if(c > 0)
		{
			return "successfull";
		}
		else
		{
			return "edit uncessfull";
		}
		}
		catch(Exception e)
		{
			logger.info(e);
			return "error";
		}
	}
	
	@Override
	public String deleteAgentbyAni(String ani)
	{
		try{
		Connection con=ConnectionFactory.getConnection();
		Date date=new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String fDate=df.format(date);
		
		AgentConfiguration_LogModel agentLog=new AgentConfiguration_LogModel();
		agentLog.setDeleted_at(fDate);
		agentLog.setDeleted_by(((UserLoginModel)session.getAttribute("loginObj")).getUserName());
		
		CallableStatement cs=con.prepareCall("{call proc_delete_agent_detail_log(?,?,?)}");
		cs.setString(1, ani);
		cs.setString(2, agentLog.getDeleted_at());
		cs.setString(3, agentLog.getDeleted_by());
		int c=cs.executeUpdate();
		if(c > 0)
		{
			return "deleted";
		}
		else
		{
			return "not deleted";
		}
		
		}
		
		catch(Exception e)
		{
			logger.info(e);
			return "QueryError";
		}
	}
	
	@Override
	public List<String> findAllPartnerName()
	{
		List<String> list=new ArrayList<String>();
		try{
			Connection con=ConnectionFactory.getConnection1();
			Statement st=con.createStatement();
			String query = "Select user_name from partner_configuration where role='limit' and status='active'";
			ResultSet rs=st.executeQuery(query);
			logger.info(query);
			while(rs.next())
			{
				list.add(rs.getString(1));
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
