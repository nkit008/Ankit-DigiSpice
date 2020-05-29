package com.spice.vchatinterfacebulk.dao;

import java.util.List;

import com.spice.vchatinterfacebulk.beans.AgentManagerAllAgents;

public interface IAgentManagerGetRecordsDao {
	
	//public List<AgentManagerUserRecord> viewRecords();
		public List<AgentManagerAllAgents> viewRecords();
		
		public List<AgentManagerAllAgents> getValueByAni(String ani,String hub);

}
