package com.spice.vchatinterfacebulk.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spice.vchatinterfacebulk.beans.AgentManagerAllAgents;
import com.spice.vchatinterfacebulk.beans.LoginSessionDetails;
import com.spice.vchatinterfacebulk.dao.IAgentManagerGetRecordsDao;

@Repository
@Transactional
public class AgentManagerGetRecordsDaoImpl implements IAgentManagerGetRecordsDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AgentManagerDaoImpl.class);
	ResultSet rs=null;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	HttpSession httpSession;
	
	@Override
	public List<AgentManagerAllAgents> viewRecords() { 		
			LOGGER.info("Inside the viewRecords method ");
			return (List<AgentManagerAllAgents>) getRecords("NA","NA","ALL");
	}
	
	
	@Override
	public List<AgentManagerAllAgents> getValueByAni(String ani,String hub){
		LOGGER.info("getValueByAni Requested ani is [{}] and hub is [{}]",ani,hub);
		return (List<AgentManagerAllAgents>) getRecords(ani,hub,"UserWise");
		/*try{
			 * Session sessionFact = sessionFactory.getCurrentSession();
			 * 
			 * Criteria crit = sessionFact.createCriteria(AgentManagerUserRecord.class);
			 * crit.add(Restrictions.eq("mobileNo", ani));
			 * 
			 * List<AgentManagerUserRecord> ll=(List<AgentManagerUserRecord>) crit.list();
			 * 
			 * LOGGER.info("inside the getValueByAni method ######   "+ll.toString());
			
			return 	ll; 
		}catch(Exception e){
			LOGGER.info("error while fetching the value [{}]",e);
			return null;
		}*/
	}
	
	public List<AgentManagerAllAgents> getRecords(final String ani,final String hub,final String flag){
		try {
			LOGGER.info("Inside the getRecords");
			LOGGER.info("Request parameters are getRecords ani is [{}] and hub is [{}] and flag is [{}]",ani,hub,flag);
			Session sessionFact=sessionFactory.getCurrentSession();
			sessionFact.doWork(new Work(){
				@Override
				public void execute(Connection connection) throws SQLException {
					LoginSessionDetails loginSessionDetails = (LoginSessionDetails)httpSession.getAttribute("userObj");
					String sqlString ="{call VChat_UserInterface_GetAllAgent(?,?,?,?,?)}";
					CallableStatement cStat=connection.prepareCall(sqlString);
					cStat.setString(1, ani);
					cStat.setString(2, hub);
					cStat.setString(3, flag);
					cStat.setString(4, loginSessionDetails.getRole());
					cStat.setString(5, loginSessionDetails.getUserName().substring(3));
					cStat.execute();
					rs=cStat.getResultSet();
					LOGGER.info("procedure executed !!!!");
				}
			});	

			List<AgentManagerAllAgents> allList= new ArrayList<AgentManagerAllAgents>();
			AgentManagerAllAgents allAgent=new AgentManagerAllAgents();
			while(rs.next()) {
				allAgent=new AgentManagerAllAgents();	
				//LOGGER.info(rs.getString(1)+"####"+rs.getString(2)+"####"+rs.getString(3)+"####"+rs.getString(4)+"####"+rs.getString(5)+"####"+rs.getString(6)+"####"+rs.getString(7)+"####"+rs.getString(8)+"####"+rs.getString(9)+"####"+rs.getString(10)+"####"+rs.getString(11)+"####"+rs.getString(12)+"####"+rs.getString(13)+"####"+rs.getString(14));
				allAgent.setHub(rs.getString(1));
				allAgent.setbAni(rs.getString(2));
				allAgent.setbChatid(rs.getString(3));
				allAgent.setbCircle(rs.getString(4));
				allAgent.setAgentCircle(rs.getString(5));
				allAgent.setAgentCategory(rs.getString(6));
				allAgent.setCenterName(rs.getString(7));
				allAgent.setAgentName(rs.getString(8));
				allAgent.setAgentAge(rs.getString(9));
				allAgent.setAgentLang(rs.getString(10));
				allAgent.setUserDoc(rs.getString(11));
				allAgent.setUserDocNo(rs.getString(12));
				allAgent.setUserDocPath(rs.getString(13));
				allAgent.setCertificatePath(rs.getString(14));
				
				allList.add(allAgent);
			}
			LOGGER.info("after procedure execution");
			
			if(allList.isEmpty()) return null;
			else return allList;
			
		}catch(Exception e){
			LOGGER.error("Getting Error while fetching the Records from viewRecords Method [{}]",e);
			return null;
		}
		
	} 
	
}
