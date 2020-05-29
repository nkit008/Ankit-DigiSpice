package com.spice.vchatinterfacebulk.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spice.vchatinterfacebulk.beans.AgentManagerAgentProfileReq;
import com.spice.vchatinterfacebulk.beans.LoginSessionDetails;
import com.spice.vchatinterfacebulk.dao.IAgentManagerUpdateRecordDao;

@Repository
public class AgentManagerUpdateRecordDaoImpl implements IAgentManagerUpdateRecordDao{
	private static final Logger LOGGER = LoggerFactory.getLogger(AgentManagerUpdateRecordDaoImpl.class);
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public String updateRecords(AgentManagerAgentProfileReq profileUpdateReq) {
		String resp=null;
		
		resp=updateAgentRecords(profileUpdateReq);
		LOGGER.info("update Response is [{}]",resp);	
			
		return resp;
	}
	public String updateAgentRecords(final AgentManagerAgentProfileReq agentManagerAgentProfileReq) {
		try {
			String outResp=null;
			
			LOGGER.info("Inside the updateAgentRecords");
			LOGGER.info("Request parameters are updateAgentRecords [{}]", agentManagerAgentProfileReq.toString());
			LoginSessionDetails loginSessionDetails = (LoginSessionDetails) httpSession.getAttribute("userObj");
			
			Connection connection = jdbcTemplate.getDataSource().getConnection();
			String sqlString = "{call VChat_UserInterface_PartnerReqUpdate(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement cStat = connection.prepareCall(sqlString);
			  
			String insertDate = String.valueOf(agentManagerAgentProfileReq.getInsertDate());
			LOGGER.info(insertDate);
			
			
  			cStat.setString(1, String.valueOf(agentManagerAgentProfileReq.getHub()));
			cStat.setString(2, String.valueOf(agentManagerAgentProfileReq.getReqType()));
			cStat.setString(3, String.valueOf(insertDate));
			cStat.setString(4, String.valueOf(agentManagerAgentProfileReq.getPartnerName()));
			cStat.setString(5, String.valueOf(agentManagerAgentProfileReq.getNumber()));
			cStat.setString(6, String.valueOf(agentManagerAgentProfileReq.getNewNumber()));
			cStat.setString(7, String.valueOf(agentManagerAgentProfileReq.getAllocatedCircle()));
			cStat.setString(8, String.valueOf(agentManagerAgentProfileReq.getChatId()));
			cStat.setString(9, String.valueOf(agentManagerAgentProfileReq.getLocation()));
			cStat.setString(10, String.valueOf(agentManagerAgentProfileReq.getType()));
			cStat.setString(11, String.valueOf(agentManagerAgentProfileReq.getDocument()));
			cStat.setString(12, String.valueOf(agentManagerAgentProfileReq.getDocumentNumber()));
			cStat.setString(13, String.valueOf(agentManagerAgentProfileReq.getAgentName()));
			cStat.setString(14, String.valueOf(agentManagerAgentProfileReq.getAge()));
			cStat.setString(15, String.valueOf(agentManagerAgentProfileReq.getLanguages()));
			cStat.setString(16, String.valueOf(agentManagerAgentProfileReq.getPartnerRemarks().replace("'", "").replace(System.getProperty("line.separator"), " ")));
			cStat.setString(17, String.valueOf(agentManagerAgentProfileReq.getAdminRemarks().replace("'", "").replace(System.getProperty("line.separator"), " ")));
			cStat.setString(18, String.valueOf(agentManagerAgentProfileReq.getStatus()));
			cStat.setString(19, String.valueOf(agentManagerAgentProfileReq.getDocumentPath()));
			cStat.setString(20, String.valueOf(agentManagerAgentProfileReq.getCertificatePath()));
			cStat.setString(21, String.valueOf(loginSessionDetails.getUserName()));
			cStat.setInt(22, agentManagerAgentProfileReq.getId());
			cStat.registerOutParameter(23, java.sql.Types.VARCHAR);
			
			cStat.executeUpdate();

			outResp = cStat.getString(23);
			LOGGER.info("procedure executed !!!!");

			LOGGER.info(outResp);
			LOGGER.info("procedure Out response !!!!");
				
			LOGGER.info("after procedure execution");

			return outResp;

		} catch (Exception e) {
			LOGGER.error("Getting Error while fetching the Records from viewRecords Method [{}]", e);
			return null;
		}

	}

}
