package com.spice.vchatinterfacebulk.beans;

public class ChatAgentConfigReq {
	
	private String hub;
	private String vender;
	private String ani;
	private String chatid;
	private String priority;
	private String type;
	private String circle;
	private String agentCircle;
	public String getHub() {
		return hub;
	}
	public void setHub(String hub) {
		this.hub = hub;
	}
	public String getVender() {
		return vender;
	}
	public void setVender(String vender) {
		this.vender = vender;
	}
	public String getAni() {
		return ani;
	}
	public void setAni(String ani) {
		this.ani = ani;
	}
	public String getChatid() {
		return chatid;
	}
	public void setChatid(String chatid) {
		this.chatid = chatid;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getAgentCircle() {
		return agentCircle;
	}
	public void setAgentCircle(String agentCircle) {
		this.agentCircle = agentCircle;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatAgentConfigReq [hub=");
		builder.append(hub);
		builder.append(", vender=");
		builder.append(vender);
		builder.append(", ani=");
		builder.append(ani);
		builder.append(", chatid=");
		builder.append(chatid);
		builder.append(", priority=");
		builder.append(priority);
		builder.append(", type=");
		builder.append(type);
		builder.append(", circle=");
		builder.append(circle);
		builder.append(", agentCircle=");
		builder.append(agentCircle);
		builder.append("]");
		return builder.toString();
	}
	
	


}
