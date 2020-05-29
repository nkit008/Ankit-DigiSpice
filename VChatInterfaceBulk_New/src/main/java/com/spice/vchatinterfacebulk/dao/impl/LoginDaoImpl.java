package com.spice.vchatinterfacebulk.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spice.vchatinterfacebulk.beans.Login;
import com.spice.vchatinterfacebulk.beans.LoginDetails;
import com.spice.vchatinterfacebulk.beans.LoginSessionDetails;
import com.spice.vchatinterfacebulk.beans.ManageUsers;
import com.spice.vchatinterfacebulk.dao.ILoginDao;


@Repository
@Transactional
public class LoginDaoImpl implements ILoginDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public LoginSessionDetails getLoginStatusDao(Login login) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(LoginDetails.class);
		
		LoginSessionDetails loginSessionDetails =new LoginSessionDetails(); 

		LOGGER.info("user name is " + login.getUsername());
		LOGGER.info("password is " + login.getPassword());

		criteria.add(Restrictions.eq("userName", login.getUsername()));
		criteria.add(Restrictions.eq("password", login.getPassword()));

		if (criteria.list().isEmpty()) {
			LOGGER.info("Login Records not found  !!!!!  ");
			return null;
		} else {
			LOGGER.info("Successful Login");
			LoginDetails loginList= (LoginDetails) criteria.list().get(0);
			
			
			
			loginSessionDetails =new LoginSessionDetails();
			
			loginSessionDetails.setUserName(loginList.getUserName());
			loginSessionDetails.setPassword(loginList.getPassword());
			loginSessionDetails.setRole(loginList.getRole());
			
			if(loginList.getRole().equalsIgnoreCase("limit")){
				login.getUsername().substring(3);
				try{
					String sqlQuery=null,pName=null,hubName=null;
							
					//sqlQuery="select distinct(center) from upeast_db.hutch_bgm.dbo.VCHAT_AGENT_DETAIL where center_id='"+login.getUsername().substring(3)+"'";
					
					/*
					 * sqlQuery =
					 * "select distinct(center),'West' AS hub from westdb1.hutch_bgm.dbo.VCHAT_AGENT_DETAIL  where center_id='"
					 * +login.getUsername().substring(3)+"'" + " union " +
					 * "select distinct(center),'UPEast' AS hub from upeast_db.hutch_bgm.dbo.VCHAT_AGENT_DETAIL where center_id='"
					 * +login.getUsername().substring(3)+"'" + " union " +
					 * "select distinct(center),'North' AS hub from north_db.hutch_bgm.dbo.VCHAT_AGENT_DETAIL where center_id='"
					 * +login.getUsername().substring(3)+"'" + " union " +
					 * "select distinct(center),'East' AS hub from east_db.bgm.dbo.VCHAT_AGENT_DETAIL where center_id='"
					 * +login.getUsername().substring(3)+"'" + " union " +
					 * "select distinct(center),'South' AS hub from south_db.hutch.dbo.VCHAT_AGENT_DETAIL where center_id='"
					 * +login.getUsername().substring(3)+"'";
					 */
							
							
							
					sqlQuery = "select distinct(center_name),'West' AS hub from westdb1.hutch_bgm.dbo.vchat_center_detail where center_id='"+login.getUsername().substring(3)+"'"
							+ " union "
							+ "select distinct(center_name),'UPEast' AS hub from upeast_db.hutch_bgm.dbo.vchat_center_detail where center_id='"+login.getUsername().substring(3)+"'"
							+ " union "
							+ "select distinct(center_name),'North' AS hub from north_db.hutch_bgm.dbo.vchat_center_detail where center_id='"+login.getUsername().substring(3)+"'"
							+ " union "
							+ "select distinct(center_name),'East' AS hub from east_db.bgm.dbo.vchat_center_detail where center_id='"+login.getUsername().substring(3)+"'"
							+ " union "
							+ "select distinct(center_name),'South' AS hub from south_db.hutch.dbo.vchat_center_detail where center_id='"+login.getUsername().substring(3)+"'";
					
					LOGGER.info(sqlQuery);
					
					SQLQuery query=session.createSQLQuery(sqlQuery);
					
					if(query.list().size()>0){
						LOGGER.info("List value is [{}]",query.list());
						
						List<Object[]> chn = query.list();
						List<String> hubList = new ArrayList<String>();
						
						for(Object[] s:chn)
						{
							pName=String.valueOf(s[0]);
							hubName=String.valueOf(s[1]);
							hubList.add(hubName);
						}
						LOGGER.info("HubList is [{}] and partnerName is [{}]",hubList,pName);
						loginSessionDetails.setPartnerName(pName);
						loginSessionDetails.setSessionHubList(hubList);
						
					}else loginSessionDetails.setPartnerName("");
				}catch(Exception e){
					LOGGER.error("Error while getting the centername from link server [{}]",e);
					loginSessionDetails.setPartnerName("");
				}	
			}else if(loginList.getRole().equalsIgnoreCase("superadmin")) loginSessionDetails.setPartnerName("Super Admin");
			else loginSessionDetails.setPartnerName("Admin");
			
			/*return (LoginDetails) criteria.list().get(0);*/
			
			return loginSessionDetails; 
		}
	}
	
	
	
	
	@Override
	public List<ManageUsers> getAllUsers() {
		
		List<ManageUsers> list = new ArrayList<ManageUsers>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			String query = "select a.username,a.userPassword,a.userRole,b.CenterName,cast(STUFF((SELECT ', ' + US.hub "
					+ "FROM TBL_UI_VCHAT_AGENT_DETAIL_ALLHUB US "
					+ "WHERE right(a.username,4)=us.center_id FOR XML PATH('')), 1, 1, '')as text) [HUB] "
					+ "from tbl_interfaceuser a , TBL_UI_VCHAT_AGENT_DETAIL_ALLHUB b "
					+ "where right(a.username,4)=b.center_id and a.userRole='limit' "
					+ "GROUP BY right(a.username,4), a.username,a.userPassword,a.userRole,b.CenterName "
					+ "ORDER BY 1";
			
			LOGGER.info("Query is "+query);
			SQLQuery sqlQuery = session.createSQLQuery(query);
			List<Object[]> rows = sqlQuery.list();
			
			if (rows.isEmpty()) {
				LOGGER.info("Login Records not found  !!!!!  ");
				return null;
			} else {
				for(Object[] s:rows)
				{
					ManageUsers manageUser = new ManageUsers();
					manageUser.setPartnerName(s[3].toString());
					manageUser.setUserName(s[0].toString());
					manageUser.setPassword(s[1].toString());
					manageUser.setRole(s[2].toString());
					manageUser.setHub(s[4].toString());
					list.add(manageUser);
				}
			}
				String adminQuery = "select a.username,a.userPassword,a.userRole,'NA' as CenterName,'NA'"
						+ " as hub from tbl_interfaceuser a where a.userRole='admin'";
				
				SQLQuery adminSqlQuery = session.createSQLQuery(adminQuery);
				List<Object[]> adminQueryList = adminSqlQuery.list();
				
				if (adminQueryList.isEmpty()) {
					LOGGER.info("Login Records not found  !!!!!  ");
					return null;
				} else {
					LOGGER.info("Records Found");
				
					for(Object[] s:adminQueryList)
					{
						ManageUsers manageUser = new ManageUsers();
						manageUser.setPartnerName(s[3].toString());
						manageUser.setUserName(s[0].toString());
						manageUser.setPassword(s[1].toString());
						manageUser.setRole(s[2].toString());
						manageUser.setHub(s[4].toString());
						list.add(manageUser);
					}
				}
						
				return list;
		}
		catch(Exception e)
		{
			LOGGER.error("Exception Occured {[]}",e);	
		}
		return list;
	}

}
