package com.spice.expertmgmtbsnl.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.spice.expertmgmtbsnl.connection.ConnectionFactory;
import com.spice.expertmgmtbsnl.dao.PartnerConfigurationDao;
import com.spice.expertmgmtbsnl.model.ConfigureNewPartnerModel;

@Repository
@Transactional

public class PartnerConfigurationDaoImpl implements PartnerConfigurationDao{

	Logger logger=Logger.getLogger(PartnerConfigurationDaoImpl.class.getName());
	@Override
	public String addNewPartner(ConfigureNewPartnerModel addPartner)
	{
				logger.info("adding new partner:::::::::");
				Connection con=null;
				try{
					con=ConnectionFactory.getConnection1();
					addPartner.setRole("limit");
					addPartner.setStatus("active");
					int c=0;
					Statement st=con.createStatement();
					ResultSet rs1=st.executeQuery("SELECT COUNT(partner_configuration.user_id) As total FROM partner_configuration WHERE partner_configuration.user_name = '"+addPartner.getUserName()+"'");
					while(rs1.next())
					{
						c=rs1.getInt(1);
						logger.info("values > 1 if username is already exists::: "+c);
					}
					if(c < 1)
					{
					CallableStatement cs=con.prepareCall("{call proc_config_new_partner(?,?,?,?,?,?,?)}");
					cs.setString(1, addPartner.getUserName().toLowerCase());
					cs.setString(2, addPartner.getPassword());
					cs.setString(3, addPartner.getState().toLowerCase());
					cs.setString(4, addPartner.getLocation().toLowerCase());
					cs.setString(5, addPartner.getRole().toLowerCase());
					cs.setString(6, addPartner.getStatus().toLowerCase());
					cs.registerOutParameter(7, Types.VARCHAR);
					int success=cs.executeUpdate();
					if(success > 0)
					{
					String result= String.valueOf(success);
					logger.info("Partner added successfully::::s "+result);
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
					System.out.println(e);
					e.printStackTrace();
					return "error";
				}
				finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
	}
	
	@Override
	public List<ConfigureNewPartnerModel> getAllConfigurepartner()
	{
		logger.info("display all partner details:::::::::");
		
		try{
			Connection con=ConnectionFactory.getConnection1();
			List<ConfigureNewPartnerModel> list=new ArrayList<ConfigureNewPartnerModel>();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select id,user_id,user_name,PASSWORD,state,location,role,status"
					+ " from partner_configuration where role='limit' and status='active'");
			while(rs.next())
			{
				ConfigureNewPartnerModel config=new ConfigureNewPartnerModel();
				config.setId(rs.getInt(1));
				config.setUserId(rs.getString(2));
				config.setUserName(rs.getString(3));
				config.setPassword(rs.getString(4));
				config.setState(rs.getString(5));
				config.setLocation(rs.getString(6));
				config.setRole(rs.getString(7));
				config.setStatus(rs.getString(8));
				list.add(config);

			}
			
			return list;
		}
		
		catch(Exception e)
		{
			logger.info(e);
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public int deletePartner(String partnerId)
	{
		try{
			Connection con=ConnectionFactory.getConnection1();
			int c=0;
			Statement st=con.createStatement();
			c=st.executeUpdate("update partner_configuration set status='nonactive' where user_id='"+partnerId+"'");
			logger.info("value of c "+c);
			return c;
		}
	catch(Exception e)
		{
		logger.info(e);
		e.printStackTrace();
		return 0;
		}
	}
	
	@Override
	public int editPartner(ConfigureNewPartnerModel addPartner,String userId)
	{
		try{
			Connection con=ConnectionFactory.getConnection1();
			int c=0;
			logger.info(":::userid:::"+userId);
			Statement st=con.createStatement();
			CallableStatement cs=con.prepareCall("{call proc_edit_partner_detail(?,?,?,?,?)}");
			cs.setString(1, addPartner.getUserName().toLowerCase());
			cs.setString(2, addPartner.getState().toLowerCase());
			cs.setString(3, addPartner.getLocation().toLowerCase());
			cs.setString(4, addPartner.getPassword());
			cs.setString(5, userId);
			c=cs.executeUpdate();
			logger.info("value of c "+c);
			return c;
		}
	catch(Exception e)
		{
		logger.info(e);
		e.printStackTrace();
		return 0;
		}
	}

}
