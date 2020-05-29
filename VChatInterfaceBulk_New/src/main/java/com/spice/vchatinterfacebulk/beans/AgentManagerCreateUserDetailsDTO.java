package com.spice.vchatinterfacebulk.beans;

import java.util.LinkedHashMap;

public class AgentManagerCreateUserDetailsDTO {
	
	LinkedHashMap<String,String> venderMap;
	LinkedHashMap<String,String> priorityMap;
	LinkedHashMap<String,String> circleMap;
	LinkedHashMap<String,String> typeMap;
	LinkedHashMap<String,String> agentLocationMap;
	
	
	public LinkedHashMap<String, String> getVenderMap() {
		return venderMap;
	}
	public void setVenderMap(LinkedHashMap<String, String> venderMap) {
		this.venderMap = venderMap;
	}
	public LinkedHashMap<String, String> getPriorityMap() {
		return priorityMap;
	}
	public void setPriorityMap(LinkedHashMap<String, String> priorityMap) {
		this.priorityMap = priorityMap;
	}
	public LinkedHashMap<String, String> getCircleMap() {
		return circleMap;
	}
	public void setCircleMap(LinkedHashMap<String, String> circleMap) {
		this.circleMap = circleMap;
	}
	public LinkedHashMap<String, String> getTypeMap() {
		return typeMap;
	}
	public void setTypeMap(LinkedHashMap<String, String> typeMap) {
		this.typeMap = typeMap;
	}
	public LinkedHashMap<String, String> getAgentLocationMap() {
		return agentLocationMap;
	}
	public void setAgentLocationMap(LinkedHashMap<String, String> agentLocationMap) {
		this.agentLocationMap = agentLocationMap;
	}
	
		
	

}
