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

import com.spice.vchatinterfacebulk.beans.ChatBulkOptionReq;
import com.spice.vchatinterfacebulk.beans.LoginSessionDetails;
import com.spice.vchatinterfacebulk.dao.IChatBulkOptionDao;

@Repository
public class ChatBulkOptionDaoImpl implements IChatBulkOptionDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(ChatBulkOptionDaoImpl.class);
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String update(ChatBulkOptionReq req) {
		String status=null;
		LOGGER.info("Bulk option Request is [{}]",req);
		
		String dbLink=getHubDbLink(req.getHub());
    	//LoginSessionDetails loginSessionDetail=getSessionDetails();
    	LoginSessionDetails loginSessionDetails = (LoginSessionDetails)httpSession.getAttribute("userObj");
		
		if(req.getBulkType().equalsIgnoreCase("chatidopt")){
			
			LOGGER.info("Selected hub is  [{}] and Agent Type is [{}] and chat id is [{}]",req.getHub(),req.getAgentType(),req.getChatId());
			if(req.getChatId()==null || req.getChatId()=="" || req.getChatId().length() <= 4){
				LOGGER.info("invalid chat id");
				return "invalid chat id";
			}else{
				String query=null,query1=null,chatIds=null;

				chatIds=req.getChatId().replaceAll("\\s+", "").trim();
				chatIds= "'"+chatIds.replace(",", "','")+"'";
				
            	try{
                	if(req.getAgentType().equalsIgnoreCase("LOGIN"))
	                    query ="update "+dbLink+"bgm.vchat_professional_agents set login_status='"+req.getAgentType().toUpperCase()+"',loginlogout_datetime=getdate() where b_chatid in ("+chatIds+");";
	                else
	                    query ="update "+dbLink+"bgm.vchat_professional_agents set login_status='"+req.getAgentType().toUpperCase()+"',loginlogout_datetime=getdate(),status='FREE' where b_chatid in ("+chatIds+");";
                	
                	LOGGER.info("Uesr IP address is [{}] for Bulk Chatid updated by UserName [{}] for requesting hub is [{}] and Query is [{}]",loginSessionDetails.getUserIp(),loginSessionDetails.getUserName(),req.getHub(),query);
                	
                	int resp=jdbcTemplate.update(query);
                	
                	LOGGER.info("[{}] ##Query update response is [{}]",query,resp);
                	String chatidlist[] = chatIds.split(",");
                	String varAni=null;
                	for(int i = 0; i < chatidlist.length; i++){
                		query1="select b_ani from "+dbLink+"bgm.vchat_professional_agents where b_chatid="+chatidlist[i];
                		
                		List<Map<String, Object>> list = jdbcTemplate.queryForList(query1);
                		
                		if(list.isEmpty())
                			LOGGER.info("varAni is empty");
                		else{
                			for (Map<String, Object> map : list) {
                				varAni=String.valueOf(map.get("b_ani"));
                				
                				varAni=varAni.replaceAll("\\s+", "").trim();
                        		query=null;
                        		LOGGER.info("ANI Length is [{}]",varAni.length());
                        		
                        		if(varAni.length()>0){
                        			query="insert into "+dbLink+"dbo.tbl_loginlogout_history(ani,date_time,type,proc_name) values('"+varAni+"',getdate(),'"+req.getAgentType().toUpperCase()+"','GUI_"+loginSessionDetails.getUserName()+"');";
                        			jdbcTemplate.update(query);
                        			LOGGER.info("Login Query is [{}] ",query);
                        		}
							}
                		}	
                	}	
                status= "success";
                }catch(Exception e){
                	LOGGER.error("Error while updating the chatid in bulk option [{}]",e);
                	status= "error";
                }    
			}
			return status;
		}else if(req.getBulkType().equalsIgnoreCase("statuswiseopt")){
			
			LOGGER.info("Selected hub is  [{}] and StatusFrom is [{}] and StatusTo is [{}]",req.getHub(),req.getStatusFrom(),req.getStatusTo());
			if(req.getStatusFrom()==null || req.getStatusFrom()=="" || req.getStatusFrom().length() <= 4 || req.getStatusTo()==null || req.getStatusTo()=="" || req.getStatusTo().length() <= 4){
				LOGGER.info("Invalid Status");
				return "Invalid Status";
			}else{
				String query=null,query1=null,fromStatus=null,toStatus=null; 
				fromStatus=req.getStatusFrom().replaceAll("\\s+", "").trim();
				toStatus=req.getStatusTo().replaceAll("\\s+", "").trim();
				try{
					query = "insert into "+dbLink+"dbo.tbl_loginlogout_history(ani,date_time,type,proc_name) select b_ani,getdate(),'"+toStatus.toUpperCase()+"','GUI_"+loginSessionDetails.getUserName()+"' from "+dbLink+"bgm.vchat_professional_agents where login_status='"+fromStatus.toUpperCase()+"'";
					int resp=jdbcTemplate.update(query);
					
					LOGGER.info("[{}] is and out Response is [{}]",query,resp);
					
					if(toStatus.equalsIgnoreCase("LOGIN"))
						query1 ="update "+dbLink+"bgm.vchat_professional_agents  set login_status='"+toStatus.toUpperCase()+"',loginlogout_datetime=getdate() where login_status='"+fromStatus.toUpperCase()+"';";
					else
						query1 ="update "+dbLink+"bgm.vchat_professional_agents  set login_status='"+toStatus.toUpperCase()+"',loginlogout_datetime=getdate(),status='FREE' where login_status='"+fromStatus.toUpperCase()+"';";
					
					int updateResp=jdbcTemplate.update(query1);
					
					LOGGER.info("Uesr IP address is [{}] for Bulk Agent Status updated by  UserName [{}] for requesting hub is [{}] and Query is [{}] and response is [{}]",loginSessionDetails.getUserIp(),loginSessionDetails.getUserName(),req.getHub(),query1,updateResp);	
					status= "success";
	            }catch(Exception e){
	            	LOGGER.error("Error while updating the chatid in bulk option [{}]",e);
	            	status= "error";
	            }    
			}
			return status;
		}else if(req.getBulkType().equalsIgnoreCase("priorityopt")){
			LOGGER.info("Selected hub is  [{}] and priority is [{}] and chatid is [{}]",req.getHub(),req.getAgentPriority(),req.getChatId());
			if(req.getChatId()==null || req.getChatId()=="" || req.getChatId().length() <= 4){
				LOGGER.info("Invalid ChatId");
				return "Invalid ChatId";
			}else{
				String query=null,chatIds=null; 
				chatIds=req.getChatId().replaceAll("\\s+", "").trim();
				try{
					query ="update "+dbLink+"bgm.vchat_professional_agents  set priority_flag='"+req.getAgentPriority().toUpperCase()+"' where b_chatid in ("+chatIds+");";
					int resp=jdbcTemplate.update(query);
					
					LOGGER.info("Uesr IP address is [{}] for Bulk priority updated by  UserName [{}] for requesting hub is [{}] and Query is [{}] and response is [{}]",loginSessionDetails.getUserIp(),loginSessionDetails.getUserName(),req.getHub(),query,resp);	
					status= "success";
	            }catch(Exception e){
	            	LOGGER.error("Error while updating the chatid in bulk option [{}]",e);
	            	status= "error";
	            }    
			}
			return status;
		}else if(req.getBulkType().equalsIgnoreCase("chatiddeleteopt")){
			LOGGER.info("Chat Id Deleting hub is [{}] and chatid is [{}]",req.getHub(),req.getChatId());
			if(req.getChatId()==null || req.getChatId()=="" || req.getChatId().length() <= 4){
				LOGGER.info("Invalid ChatId");
				return "Invalid ChatId";
			}else{
				String query=null,query1=null,chatIds=null; 
				chatIds=req.getChatId().replaceAll("\\s+", "").trim();
				chatIds= "'"+chatIds.replace(",", "','")+"'";
				try{
					query ="delete from "+dbLink+"bgm.vchat_professional_agents  where b_chatid in ("+chatIds+");";
					int resp=jdbcTemplate.update(query);
					
					LOGGER.info("Uesr IP address is [{}] for Bulk Delete by UserName [{}] for requesting hub is [{}] and Query is [{}] and response is [{}]",loginSessionDetails.getUserIp(),loginSessionDetails.getUserName(),req.getHub(),query,resp);
					
					query1 ="delete from "+dbLink+"DBO.VCHAT_AGENT_DETAIL where chat_id in ("+chatIds+");";
					int queryResp=jdbcTemplate.update(query1);
					
					LOGGER.info("Uesr IP address is [{}] for Bulk Delete by UserName [{}] for requesting hub is [{}] and Query is [{}] and response is [{}]",loginSessionDetails.getUserIp(),loginSessionDetails.getUserName(),req.getHub(),query1,queryResp);
					
					status= "success";
	            }catch(Exception e){
	            	LOGGER.error("Error while updating the chatid in bulk option [{}]",e);
	            	status= "error";
	            }    
			}
		}
		return status;
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
