package com.spice.vchatinterfacebulk.beans;

public class ChatBulkOptionReq {
	private String bulkType;
	private String hub;
	private String agentType;
	private String agentPriority;
	private String chatId;
	private String statusFrom;
	private String statusTo;
	public String getBulkType() {
		return bulkType;
	}
	public void setBulkType(String bulkType) {
		this.bulkType = bulkType;
	}
	public String getHub() {
		return hub;
	}
	public void setHub(String hub) {
		this.hub = hub;
	}
	public String getAgentType() {
		return agentType;
	}
	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}
	public String getAgentPriority() {
		return agentPriority;
	}
	public void setAgentPriority(String agentPriority) {
		this.agentPriority = agentPriority;
	}
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	public String getStatusFrom() {
		return statusFrom;
	}
	public void setStatusFrom(String statusFrom) {
		this.statusFrom = statusFrom;
	}
	public String getStatusTo() {
		return statusTo;
	}
	public void setStatusTo(String statusTo) {
		this.statusTo = statusTo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatBulkOptionReq [bulkType=");
		builder.append(bulkType);
		builder.append(", hub=");
		builder.append(hub);
		builder.append(", agentType=");
		builder.append(agentType);
		builder.append(", agentPriority=");
		builder.append(agentPriority);
		builder.append(", chatId=");
		builder.append(chatId);
		builder.append(", statusFrom=");
		builder.append(statusFrom);
		builder.append(", statusTo=");
		builder.append(statusTo);
		builder.append("]");
		return builder.toString();
	}
	
	

}
