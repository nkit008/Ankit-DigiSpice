package com.spice.expertmgmtbsnl.dao;

import java.util.List;

import com.spice.expertmgmtbsnl.model.AgentConfigurationModel;

public interface AgentConfigurationDao {

	public String addNewAgent(AgentConfigurationModel agent);
	public List<AgentConfigurationModel> getAllAgent();
	public String editAgentInfo(AgentConfigurationModel agent);
	public String deleteAgentbyAni(String ani);
	public List<String> findAllPartnerName();
}