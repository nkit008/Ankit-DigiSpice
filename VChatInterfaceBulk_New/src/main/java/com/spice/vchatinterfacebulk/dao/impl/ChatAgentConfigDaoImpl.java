package com.spice.vchatinterfacebulk.dao.impl;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spice.vchatinterfacebulk.beans.ChatAgentConfigReq;
import com.spice.vchatinterfacebulk.beans.LoginSessionDetails;
import com.spice.vchatinterfacebulk.dao.IChatAgentConfigDao;

@Repository
public class ChatAgentConfigDaoImpl implements IChatAgentConfigDao{
	private static final Logger LOGGER = LoggerFactory.getLogger(ChatAgentConfigDaoImpl.class);
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String save(ChatAgentConfigReq chatAgentConfigReq) {
		String ani=null,chatId=null,hub=null,vender=null,circle=null,location=null,priority=null,type=null,hubLocation=null,dbLocation=null,dbLink=null;
		boolean flag=false;
		LOGGER.info(chatAgentConfigReq.toString());
		try{
			ani=chatAgentConfigReq.getAni();
			chatId=chatAgentConfigReq.getChatid();
			hub=chatAgentConfigReq.getHub();
			vender=chatAgentConfigReq.getVender();
			circle=chatAgentConfigReq.getCircle();
			location=chatAgentConfigReq.getAgentCircle();
			priority=chatAgentConfigReq.getPriority();
			type=chatAgentConfigReq.getType();
			
			if(!circle.equals(location)){
				hubLocation="";
				if(location.equals("HUTCH_MUM") || location.equals("HUTCH_MP") || location.equals("HUTCH_PUNE") || location.equals("HUTCH_GUJ")) hubLocation="West";
				if(location.equals("HUTCH_UPE")) hubLocation="Upeast";
				if(location.equals("HUTCH_DEL") || location.equals("HUTCH_HAR") || location.equals("HUTCH_HP") || location.equals("HUTCH_JK") || location.equals("HUTCH_RAJ") || location.equals("HUTCH_UPW") || location.equals("HUTCH_PUN")) hubLocation="North";
				if(location.equals("HUTCH_AP") || location.equals("HUTCH_CHN") || location.equals("HUTCH_TN") || location.equals("HUTCH_BANG") || location.equals("HUTCH_KER")) hubLocation="South";
				if(location.equals("HUTCH_ASAM") || location.equals("HUTCH_AS") || location.equals("HUTCH_ORS") || location.equals("HUTCH_BHR") || location.equals("HUTCH_KOL") || location.equals("HUTCH_NE")) hubLocation="East";

				dbLocation=getHubDbLink(hubLocation);
				LOGGER.info("Db location is [{}]",dbLocation);
				flag=true;
			}
			
			dbLink=getHubDbLink(hub);
			String query=null,centerName=null;
			query="select center_name from "+dbLink+"dbo.VCHAT_CENTER_DETAIL where center_id='"+vender+"'";
			List<Map<String, Object>> list = jdbcTemplate.queryForList(query);
			
			if(list.isEmpty())
    			LOGGER.info("varAni is empty");
    		else{
    			for (Map<String, Object> map : list) {
    				centerName=String.valueOf(map.get("center_name"));
    				
    				//centerName=centerName.replaceAll("\\s+", "").trim();
            		query=null;
            		LOGGER.info("centerName Length is [{}]",centerName.length());
				}
    		}
			
			String profAgentQuery="DELETE FROM "+dbLink+"bgm.vchat_professional_agents where b_chatid='"+chatId+"' or b_ani='"+ani+"'";
			int resp=jdbcTemplate.update(profAgentQuery);
			LOGGER.info("Prof Agent Query is [{}] and Response is [{}]",profAgentQuery,resp);
			
			String agentDetailQuery="DELETE FROM "+dbLink+"dbo.VCHAT_AGENT_DETAIL where chat_id='"+chatId+"' or agent_ani='"+ani+"'";
			int agentDetailQueryResp=jdbcTemplate.update(agentDetailQuery);
			LOGGER.info("AgentDetail Query is [{}] and Response is [{}]",agentDetailQuery,agentDetailQueryResp);
			
			String agentDetailInsertQuery="insert into "+dbLink+"dbo.VCHAT_AGENT_DETAIL(agent_ani,chat_id,center,center_id) values('"+ani+"','"+chatId+"',ltrim(rtrim('"+centerName+"')),'"+vender+"')";
			int agentDetailInsertQueryResp=jdbcTemplate.update(agentDetailInsertQuery);
			LOGGER.info("AgentDetailInsertQuery Query is [{}] and Response is [{}]",agentDetailInsertQuery,agentDetailInsertQueryResp);
			
			String profAgentInsertquery="insert into "+dbLink+"bgm.vchat_professional_agents(b_ani,b_chatid,b_circle,agent_category,agent_circle,priority_flag,login_status,loginlogout_datetime) values('"+ani+"','"+chatId+"','"+circle+"','"+type+"','"+location+"','"+priority+"','LOGOUT',getdate())";
			int profAgentInsertqueryResp=jdbcTemplate.update(profAgentInsertquery);
			LOGGER.info("Prof Agent Insert Resp Query is [{}] and Response is [{}]",profAgentInsertquery,profAgentInsertqueryResp);
			
			if(flag){
				String checkAniQuery="DELETE FROM "+dbLocation+"dbo.VCHAT_CHECK_ANI_AGENTS where b_chatid='"+chatId+"' or b_ani='"+ani+"'";
				int checkAniQueryResp=jdbcTemplate.update(checkAniQuery);
				LOGGER.info("Check Ani Query is [{}] and Response is [{}]",checkAniQuery,checkAniQueryResp);
				
				String checkAniInsertQuery="insert into "+dbLocation+"dbo.VCHAT_CHECK_ANI_AGENTS(b_ani,b_chatid,b_circle,agent_category,agent_circle,priority_flag) values('"+ani+"','"+chatId+"','"+circle+"','"+type+"','"+location+"','"+priority+"')";
				int checkAniInsertQueryResp=jdbcTemplate.update(checkAniInsertQuery);
				LOGGER.info("Check Ani Insert Query is [{}] and Response is [{}]",checkAniInsertQuery,checkAniInsertQueryResp);
			}
			return "success";
		}catch(Exception e){
			LOGGER.error("Getting error while insert the records in tables [{}]",e);
			return "Error";
		}
	}
	
	public LoginSessionDetails getSessionDetails(){
		try{
			LoginSessionDetails loginSessionDetails= new LoginSessionDetails();
			
			Enumeration<String> e = httpSession.getAttributeNames();
			while (e.hasMoreElements()){
				String s = e.nextElement();
				loginSessionDetails=(LoginSessionDetails) httpSession.getAttribute(s);
			}
			return loginSessionDetails;
		}catch(Exception e){
			LOGGER.error("Error while getting the value from http session [{}]",e);
			return null;
		}
	}
	public String getHubDbLink(String hubname){
		if (hubname.equalsIgnoreCase("West")) {
			return "westdb1.hutch_bgm.";
		} else if (hubname.equalsIgnoreCase("Upeast")) {
			return "upeast_db.hutch_bgm.";
		} else if (hubname.equalsIgnoreCase("North")) {
			return "north_db.hutch_bgm.";
		} else if (hubname.equalsIgnoreCase("East")) {
			return "east_db.bgm.";
		} else if (hubname.equalsIgnoreCase("South")) {
			return "south_db.hutch.";
		} else {
			return "no record";
		}
	}

}
