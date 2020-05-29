package com.spice.vchatinterfacebulk.dao;

import java.util.List;

import com.spice.vchatinterfacebulk.beans.AgentManagerAgentProfileReq;
import com.spice.vchatinterfacebulk.beans.AgentManagerCreateUserDetailsDTO;
import com.spice.vchatinterfacebulk.beans.AgentManagerProfileUpdateReq;
import com.spice.vchatinterfacebulk.beans.AgentManagerUser;

public interface IAgentManagerDao {

	public String create(AgentManagerUser agentManagerUser);
	
	public List<AgentManagerAgentProfileReq> view();
	
	public String updateReq(AgentManagerProfileUpdateReq profileUpdateReq);
	
	public AgentManagerCreateUserDetailsDTO createUserAjaxReq(String hubName);

	public String updateRecords(AgentManagerAgentProfileReq profileUpdateReq);
	
	public List<AgentManagerAgentProfileReq> viewFinal();
	
	public int resetPassword(String loginId,String newPassword);
	
	public int delUser(String loginId,String userName,String userRole,String password);
}
