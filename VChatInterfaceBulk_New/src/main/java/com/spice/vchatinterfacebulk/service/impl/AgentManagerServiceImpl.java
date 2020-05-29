package com.spice.vchatinterfacebulk.service.impl;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spice.vchatinterfacebulk.beans.AgentManagerCreateUserDetailsDTO;
import com.spice.vchatinterfacebulk.dao.IAgentManagerDao;
import com.spice.vchatinterfacebulk.service.IAgentManagerService;

@Service
public class AgentManagerServiceImpl implements IAgentManagerService {

	@Autowired
	IAgentManagerDao agentManagerDao;

	@Override
	public AgentManagerCreateUserDetailsDTO createUserAjaxReq(String hubName) {
		
		AgentManagerCreateUserDetailsDTO userDetailsService=agentManagerDao.createUserAjaxReq(hubName);
		
		LinkedHashMap<String,String> agentLocationDetails = new LinkedHashMap<String,String>();
		LinkedHashMap<String,String> priorityDetails = new LinkedHashMap<String,String>();
		agentLocationDetails.clear();
		priorityDetails.clear();
		
		agentLocationDetails.put("", "Click to Choose..");
		agentLocationDetails.put("HUTCH_AP", "HUTCH_AP");
		agentLocationDetails.put("HUTCH_AS", "HUTCH_AS");
		agentLocationDetails.put("HUTCH_ASAM", "HUTCH_ASAM");
		agentLocationDetails.put("HUTCH_BANG", "HUTCH_BANG");
		agentLocationDetails.put("HUTCH_BHR", "HUTCH_BHR");
		agentLocationDetails.put("HUTCH_CHN", "HUTCH_CHN");
		agentLocationDetails.put("HUTCH_DEL", "HUTCH_DEL");
		agentLocationDetails.put("HUTCH_GUJ", "HUTCH_GUJ");
		agentLocationDetails.put("HUTCH_HAR", "HUTCH_HAR");
		agentLocationDetails.put("HUTCH_HP", "HUTCH_HP");
		agentLocationDetails.put("HUTCH_JK", "HUTCH_JK");
		agentLocationDetails.put("HUTCH_KER", "HUTCH_KER");
		agentLocationDetails.put("HUTCH_KOL", "HUTCH_KOL");
		agentLocationDetails.put("HUTCH_MP", "HUTCH_MP");
		agentLocationDetails.put("HUTCH_MUM", "HUTCH_MUM");
		agentLocationDetails.put("HUTCH_NE", "HUTCH_NE");
		agentLocationDetails.put("HUTCH_ORS", "HUTCH_ORS");
		agentLocationDetails.put("HUTCH_PUN", "HUTCH_PUN");
		agentLocationDetails.put("HUTCH_PUNE", "HUTCH_PUNE");
		agentLocationDetails.put("HUTCH_RAJ", "HUTCH_RAJ");
		agentLocationDetails.put("HUTCH_TN", "HUTCH_TN");
		agentLocationDetails.put("HUTCH_UPE", "HUTCH_UPE");
		agentLocationDetails.put("HUTCH_UPW", "HUTCH_UPW");
		
		userDetailsService.setAgentLocationMap(agentLocationDetails);
		/*priorityDetails.put("", "Select Priority");*/
		priorityDetails.put("1", "1");
		priorityDetails.put("2", "2");
		priorityDetails.put("3", "3");
		priorityDetails.put("4", "4");
		
		userDetailsService.setPriorityMap(priorityDetails);
		
		return userDetailsService;
	}
}
