package com.spice.vchatinterfacebulk.dao.impl;

import java.util.ArrayList;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spice.vchatinterfacebulk.beans.ChatAgentLiveCountCircleWise;
import com.spice.vchatinterfacebulk.beans.ChatAgentLiveCountPartnerWise;
import com.spice.vchatinterfacebulk.beans.ChatAgentLiveCountZoneWise;
import com.spice.vchatinterfacebulk.beans.LoginSessionDetails;
import com.spice.vchatinterfacebulk.dao.IChatAgentLiveCountDao;

@Repository
public class ChatAgentLiveCountDaoImpl implements IChatAgentLiveCountDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(ChatAgentLiveCountDaoImpl.class);	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	HttpSession httpSession;

	@Override
	public List<ChatAgentLiveCountZoneWise> getZoneDetails(String hub) {
		String sql=null,dbLink=null;
		try{
			dbLink=getHubDbLink(hub);			
			List<ChatAgentLiveCountZoneWise> ll =new ArrayList<ChatAgentLiveCountZoneWise>();
			ChatAgentLiveCountZoneWise zoneWise=new ChatAgentLiveCountZoneWise();
			
			
			sql ="select cnt,status from (select count(1) as 'cnt',login_status as 'status' from "+dbLink+"bgm.VCHAT_PROFESSIONAL_AGENTS group by login_status union all select count(1) as 'cnt',status from "+dbLink+"bgm.VCHAT_PROFESSIONAL_AGENTS  where login_status='LOGIN' group by status) abc";
			LOGGER.info("ZoneDetails SQL query is [{}]",sql );
			List<Map<String, Object>> zoneList = jdbcTemplate.queryForList(sql);
			String status=null,count=null;
			for (Map<String, Object> map : zoneList) {
				status=String.valueOf(map.get("status"));
				count=String.valueOf(map.get("cnt"));
				
				//LOGGER.info("status is [{}] and count is [{}]",status,count);
				
				if(status.equalsIgnoreCase("ALOGOUT")){
					zoneWise.setaLogout(count);
				}else if(status.equalsIgnoreCase("BLOGOUT")){
					zoneWise.setbLogout(count);
				}else if(status.equalsIgnoreCase("FLOGOUT")){
					zoneWise.setfLogout(count);
				}else if(status.equalsIgnoreCase("LOGIN")){
					zoneWise.setLoginId(count);
				}else if(status.equalsIgnoreCase("LOGOUT")){
					zoneWise.setLogout(count);
				}else if(status.equalsIgnoreCase("BUSY")){
					zoneWise.setBusy(count);
				}else if(status.equalsIgnoreCase("FREE")){
					zoneWise.setFree(count);
				}else if(status.equalsIgnoreCase("SLOGOUT")){
					zoneWise.setsLogout(count);
				}else if(status.equalsIgnoreCase("VLOGOUT")){
					zoneWise.setvLogout(count);
				}
				
			}zoneWise.setZone(hub);
			ll.add(zoneWise);
			return ll;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<ChatAgentLiveCountCircleWise> getCircleDetails(String hub) {
		String sql=null,dbLink=null;
		try{
			dbLink=getHubDbLink(hub);
			List<ChatAgentLiveCountCircleWise> llCircle =new ArrayList<ChatAgentLiveCountCircleWise>();
			ChatAgentLiveCountCircleWise circleWise=new ChatAgentLiveCountCircleWise();
				
			sql ="select cnt,b_circle,status from (select count(1) as 'cnt',b_circle,login_status as 'status' from "+dbLink+"bgm.VCHAT_PROFESSIONAL_AGENTS group by b_circle,login_status union all select count(1) as 'cnt',b_circle,status from "+dbLink+"bgm.VCHAT_PROFESSIONAL_AGENTS where login_status='LOGIN' group by b_circle,status) abc order by b_circle asc";
			LOGGER.info("CircleDetails SQL query is [{}]",sql );
			List<Map<String, Object>> cirList = jdbcTemplate.queryForList(sql);
			String status=null,count=null,circle=null,varCir=null;
			for (Map<String, Object> map : cirList) {
				
				status=String.valueOf(map.get("status"));
				count=String.valueOf(map.get("cnt"));
				circle=String.valueOf(map.get("b_circle")).substring(6);
				
				//LOGGER.info("status is [{}] and count is [{}]",status,count);
				
				if(varCir==null || varCir.length() <= 1){
					varCir=circle;
				}if(varCir != null && varCir.length() > 1 && !varCir.equalsIgnoreCase(circle)){
					circleWise.setCircle(varCir);
					llCircle.add(circleWise);
					circleWise=new ChatAgentLiveCountCircleWise();
					varCir=circle;
				}
				
				if(status.equalsIgnoreCase("ALOGOUT")){
					circleWise.setaLogout(count);
				}else if(status.equalsIgnoreCase("BLOGOUT")){
					circleWise.setbLogout(count);
				}else if(status.equalsIgnoreCase("FLOGOUT")){
					circleWise.setfLogout(count);
				}else if(status.equalsIgnoreCase("LOGIN")){
					circleWise.setLogin(count);
				}else if(status.equalsIgnoreCase("LOGOUT")){
					circleWise.setLogout(count);
				}else if(status.equalsIgnoreCase("BUSY")){
					circleWise.setBusy(count);
				}else if(status.equalsIgnoreCase("FREE")){
					circleWise.setFree(count);
				}else if(status.equalsIgnoreCase("SLOGOUT")){
					circleWise.setsLogout(count);
				}else if(status.equalsIgnoreCase("VLOGOUT")){
					circleWise.setvLogout(count);
				}
			}circleWise.setCircle(circle);
			llCircle.add(circleWise);
			return llCircle;
		}catch(Exception e){
			return null;
		}
	}
	
	@Override
	public List<ChatAgentLiveCountPartnerWise> getPartnerDetails(String hub) {
		String sql=null,dbLink=null;
		try{
			dbLink=getHubDbLink(hub);
			List<ChatAgentLiveCountPartnerWise> llPartner= new ArrayList<ChatAgentLiveCountPartnerWise>();
			ChatAgentLiveCountPartnerWise partnerWise=new ChatAgentLiveCountPartnerWise();
			
			sql="select count(1) as 'cnt',isnull(b.center,'NA') as 'centerName',a.login_status as 'status' from "+dbLink+"bgm.VCHAT_PROFESSIONAL_AGENTS a, "+dbLink+"dbo.VCHAT_AGENT_DETAIL b where b.chat_id =a.b_chatid group by b.center,a.login_status union all select count(1) as 'cnt',isnull(b.center,'NA') as 'centerName',a.status as 'status' from "+dbLink+"bgm.VCHAT_PROFESSIONAL_AGENTS a, "+dbLink+"dbo.VCHAT_AGENT_DETAIL b where b.chat_id =a.b_chatid and a.login_status='LOGIN' group by b.center,a.status order by centerName";
			LOGGER.info("PartnerDetails SQL query is [{}]",sql );
			List<Map<String, Object>> cirList = jdbcTemplate.queryForList(sql);
			String status=null,count=null,varPar=null,partner=null;
			for (Map<String, Object> map : cirList) {
				status=String.valueOf(map.get("status"));
				count=String.valueOf(map.get("cnt"));
				partner=String.valueOf(map.get("centerName"));
				
				//LOGGER.info("status is [{}] and count is [{}]",status,count);
				
				if(varPar==null || varPar.length() <= 1){
					varPar=partner;
				}if(varPar != null && varPar.length() > 1 && !varPar.equalsIgnoreCase(partner)){
					partnerWise.setPartnerName(varPar);
					partnerWise.setHub(hub);
					llPartner.add(partnerWise);
					partnerWise=new ChatAgentLiveCountPartnerWise();
					varPar=partner;
				}
				
				if(status.equalsIgnoreCase("ALOGOUT")){
					partnerWise.setaLogout(count);
				}else if(status.equalsIgnoreCase("BLOGOUT")){
					partnerWise.setbLogout(count);
				}else if(status.equalsIgnoreCase("FLOGOUT")){
					partnerWise.setfLogout(count);
				}else if(status.equalsIgnoreCase("LOGIN")){
					partnerWise.setLogin(count);
				}else if(status.equalsIgnoreCase("LOGOUT")){
					partnerWise.setLogout(count);
				}else if(status.equalsIgnoreCase("BUSY")){
					partnerWise.setBusy(count);
				}else if(status.equalsIgnoreCase("FREE")){
					partnerWise.setFree(count);
				}else if(status.equalsIgnoreCase("SLOGOUT")){
					partnerWise.setsLogout(count);
				}else if(status.equalsIgnoreCase("VLOGOUT")){
					partnerWise.setvLogout(count);
				}
				
			}partnerWise.setPartnerName(partner);
			partnerWise.setHub(hub);
			llPartner.add(partnerWise);
			
			return llPartner;
		}catch(Exception e){
			return null;
		}
	}
	
	
	@Override
	public List<ChatAgentLiveCountCircleWise> getPartnerCircleDetails(String hub,String pName) {
		String sql=null,dbLink=null;
		try{
			dbLink=getHubDbLink(hub);
			List<ChatAgentLiveCountCircleWise> llCircle =new ArrayList<ChatAgentLiveCountCircleWise>();
			ChatAgentLiveCountCircleWise circleWise=new ChatAgentLiveCountCircleWise();
			
			sql ="select count(1) as 'cnt',a.b_circle as 'b_circle',a.login_status as 'status' from "+dbLink+"bgm.VCHAT_PROFESSIONAL_AGENTS a, "+dbLink+"dbo.VCHAT_AGENT_DETAIL b where b.chat_id =a.b_chatid  and b.center=ltrim(rtrim('"+pName+"'))  group by a.b_circle,a.login_status union all select count(1) as 'cnt',a.b_circle as 'circle',a.status as 'status' from "+dbLink+"bgm.VCHAT_PROFESSIONAL_AGENTS a, "+dbLink+"dbo.VCHAT_AGENT_DETAIL b where b.chat_id =a.b_chatid and a.login_status='LOGIN' and b.center=ltrim(rtrim('"+pName+"')) group by a.b_circle,a.status order by b_circle";
			
			LOGGER.info("PartnerCircleDetails SQL query is [{}]",sql );
			List<Map<String, Object>> cirList = jdbcTemplate.queryForList(sql);
			String status=null,count=null,circle=null,varCir=null;
			
			LOGGER.info("cirList size from getting HubWise Partner Circle "+cirList.size());
			
			if(cirList.size() > 0)
			{
			for (Map<String, Object> map : cirList) {
				
				status=String.valueOf(map.get("status"));
				count=String.valueOf(map.get("cnt"));
				circle=String.valueOf(map.get("b_circle")).substring(6);
				
				LOGGER.info(" status is [{}] and count is [{}]",status,count);
				
				if(varCir==null || varCir.length() <= 1){
					varCir=circle;
				}if(varCir != null && varCir.length() > 1 && !varCir.equalsIgnoreCase(circle)){
					circleWise.setCircle(varCir);
					llCircle.add(circleWise);
					circleWise=new ChatAgentLiveCountCircleWise();
					varCir=circle;
				}
				
				if(status.equalsIgnoreCase("ALOGOUT")){
					circleWise.setaLogout(count);
				}else if(status.equalsIgnoreCase("BLOGOUT")){
					circleWise.setbLogout(count);
				}else if(status.equalsIgnoreCase("FLOGOUT")){
					circleWise.setfLogout(count);
				}else if(status.equalsIgnoreCase("LOGIN")){
					circleWise.setLogin(count);
				}else if(status.equalsIgnoreCase("LOGOUT")){
					circleWise.setLogout(count);
				}else if(status.equalsIgnoreCase("BUSY")){
					circleWise.setBusy(count);
				}else if(status.equalsIgnoreCase("FREE")){
					circleWise.setFree(count);
				}else if(status.equalsIgnoreCase("SLOGOUT")){
					circleWise.setsLogout(count);
				}else if(status.equalsIgnoreCase("VLOGOUT")){
					circleWise.setvLogout(count);
				}
			}circleWise.setCircle(circle);
			llCircle.add(circleWise);
			}
			return llCircle;
		}catch(Exception e){
			return null;
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
	
	
	
	
	@Override
	public List<List<ChatAgentLiveCountCircleWise>> getCircleDetailsHome() {
		try{
			
			String[] hublist  = {"north","East","West","Upeast","South"};
			List<List<ChatAgentLiveCountCircleWise>> llCircle =new ArrayList<List<ChatAgentLiveCountCircleWise>>();
			List<ChatAgentLiveCountCircleWise> pcircle =new ArrayList<ChatAgentLiveCountCircleWise>();
			
			String userRole=((LoginSessionDetails)httpSession.getAttribute("userObj")).getRole();
			String pName = ((LoginSessionDetails)httpSession.getAttribute("userObj")).getPartnerName();
			LOGGER.info("User Role to getting all circle wise Agent Count is "+userRole);
			
			if(userRole.equalsIgnoreCase("admin") || userRole.equalsIgnoreCase("superadmin")){
				for(String s: hublist){
					String hub = s;
					LOGGER.info("Hub is "+hub);
					llCircle.add(getCircleDetails(hub));
				}
			}
				
			if(userRole.equalsIgnoreCase("limit"))
			{
				LOGGER.info("Getting all Circle live Agent Count regarding to Partner "+pName);
				for(String s: hublist){
					String hub = s;
					LOGGER.info("Hub is "+hub);
					pcircle = getPartnerCircleDetails(hub,pName);
					LOGGER.info("------------- "+pcircle);
					if(!pcircle.isEmpty())
						llCircle.add(pcircle);
				}
			}
			LOGGER.info("size of List is "+llCircle.size());
			return llCircle;
		}catch(Exception e){
			return null;
		}
	}
	
	
	@Override
	public List<ChatAgentLiveCountPartnerWise> getCirclewisePartnerDetails(String hub,String circle) {
		String sql=null,dbLink=null;
		try{
			dbLink=getHubDbLink(hub);
			List<ChatAgentLiveCountPartnerWise> llPartner= new ArrayList<ChatAgentLiveCountPartnerWise>();
			ChatAgentLiveCountPartnerWise partnerWise=new ChatAgentLiveCountPartnerWise();
			
			sql ="select count(1) as 'cnt',isnull(b.center,'NA') as 'centerName',a.login_status as 'status' from "+dbLink+"bgm.VCHAT_PROFESSIONAL_AGENTS a,"
					+ ""+dbLink+"dbo.VCHAT_AGENT_DETAIL b where b.chat_id =a.b_chatid and a.b_circle like '%"+circle+"' group by b.center,a.login_status "
					+ "union all select count(1) as 'cnt',isnull(b.center,'NA') as 'centerName',a.status as 'status' from "+dbLink+"bgm.VCHAT_PROFESSIONAL_AGENTS a,"
					+ ""+dbLink+"dbo.VCHAT_AGENT_DETAIL b where b.chat_id =a.b_chatid and a.login_status='LOGIN' and a.b_circle like '%"+circle+"' group by b.center,a.status order by centerName";
			LOGGER.info("PartnerDetails SQL query is [{}]",sql );
			List<Map<String, Object>> cirList = jdbcTemplate.queryForList(sql);
			String status=null,count=null,varPar=null,partner=null;
			for (Map<String, Object> map : cirList) {
				status=String.valueOf(map.get("status"));
				count=String.valueOf(map.get("cnt"));
				partner=String.valueOf(map.get("centerName"));
				
				
				if(varPar==null || varPar.length() <= 1){
					varPar=partner;
				}if(varPar != null && varPar.length() > 1 && !varPar.equalsIgnoreCase(partner)){
					partnerWise.setPartnerName(varPar);
					partnerWise.setHub(hub);
					llPartner.add(partnerWise);
					partnerWise=new ChatAgentLiveCountPartnerWise();
					varPar=partner;
				}
				
				if(status.equalsIgnoreCase("ALOGOUT")){
					partnerWise.setaLogout(count);
				}else if(status.equalsIgnoreCase("BLOGOUT")){
					partnerWise.setbLogout(count);
				}else if(status.equalsIgnoreCase("FLOGOUT")){
					partnerWise.setfLogout(count);
				}else if(status.equalsIgnoreCase("LOGIN")){
					partnerWise.setLogin(count);
				}else if(status.equalsIgnoreCase("LOGOUT")){
					partnerWise.setLogout(count);
				}else if(status.equalsIgnoreCase("BUSY")){
					partnerWise.setBusy(count);
				}else if(status.equalsIgnoreCase("FREE")){
					partnerWise.setFree(count);
				}else if(status.equalsIgnoreCase("SLOGOUT")){
					partnerWise.setsLogout(count);
				}else if(status.equalsIgnoreCase("VLOGOUT")){
					partnerWise.setvLogout(count);
				}
				
			}partnerWise.setPartnerName(partner);
			partnerWise.setHub(hub);
			llPartner.add(partnerWise);
			
			return llPartner;
		}catch(Exception e){
			LOGGER.info("Exception occured "+e);
			return null;
		}
	}

}
