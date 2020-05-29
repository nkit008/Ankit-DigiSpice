package com.spice.vchatinterfacebulk.beans;

public class AgentManagerProfileUpdateReq {
	
	private String newAgentType;
	private String newLocation;
	private String newCircle;
	private String newChatid;
	private String newAni;
	private String userRemarks;
	private String userNumber;
	private String reqType;
	private String vender;
	private String hub;
	
	
	public String getVender() {
		return vender;
	}
	public void setVender(String vender) {
		this.vender = vender;
	}
	public String getHub() {
		return hub;
	}
	public void setHub(String hub) {
		this.hub = hub;
	}
	public String getNewAgentType() {
		return newAgentType;
	}
	public void setNewAgentType(String newAgentType) {
		this.newAgentType = newAgentType;
	}
	public String getNewLocation() {
		return newLocation;
	}
	public void setNewLocation(String newLocation) {
		this.newLocation = newLocation;
	}
	public String getNewCircle() {
		return newCircle;
	}
	public void setNewCircle(String newCircle) {
		this.newCircle = newCircle;
	}
	public String getNewChatid() {
		return newChatid;
	}
	public void setNewChatid(String newChatid) {
		this.newChatid = newChatid;
	}
	public String getNewAni() {
		return newAni;
	}
	public void setNewAni(String newAni) {
		this.newAni = newAni;
	}
	public String getUserRemarks() {
		return userRemarks;
	}
	public void setUserRemarks(String userRemarks) {
		this.userRemarks = userRemarks;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AgentManagerProfileUpdateReq [newAgentType=");
		builder.append(newAgentType);
		builder.append(", newLocation=");
		builder.append(newLocation);
		builder.append(", newCircle=");
		builder.append(newCircle);
		builder.append(", newChatid=");
		builder.append(newChatid);
		builder.append(", newAni=");
		builder.append(newAni);
		builder.append(", userRemarks=");
		builder.append(userRemarks);
		builder.append(", userNumber=");
		builder.append(userNumber);
		builder.append(", reqType=");
		builder.append(reqType);
		builder.append(", vender=");
		builder.append(vender);
		builder.append(", hub=");
		builder.append(hub);
		builder.append("]");
		return builder.toString();
	}
	
	

}
