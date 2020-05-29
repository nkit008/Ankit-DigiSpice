package com.spice.vchatinterfacebulk.beans;

public class ChatLoginStatusResp {
	
	private String agentCircle;
	private String lastCallTime;
	private String bChatid ;
	private String bAni ;
	private String bCircle;
	private String loginStatus;
	private String status;
	private String update;
	private String priorityFlag;
	private String loginLogoutDatetime;
	private String updateStatus;
	private String centerName;
	private String mnt;
	
	private String hub;
	
	
	
	public String getHub() {
		return hub;
	}
	public void setHub(String hub) {
		this.hub = hub;
	}
	public String getAgentCircle() {
		return agentCircle;
	}
	public void setAgentCircle(String agentCircle) {
		this.agentCircle = agentCircle;
	}
	public String getLastCallTime() {
		return lastCallTime;
	}
	public void setLastCallTime(String lastCallTime) {
		this.lastCallTime = lastCallTime;
	}
	public String getbChatid() {
		return bChatid;
	}
	public void setbChatid(String bChatid) {
		this.bChatid = bChatid;
	}
	public String getbAni() {
		return bAni;
	}
	public void setbAni(String bAni) {
		this.bAni = bAni;
	}
	public String getbCircle() {
		return bCircle;
	}
	public void setbCircle(String bCircle) {
		this.bCircle = bCircle;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public String getPriorityFlag() {
		return priorityFlag;
	}
	public void setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
	}
	public String getLoginLogoutDatetime() {
		return loginLogoutDatetime;
	}
	public void setLoginLogoutDatetime(String loginLogoutDatetime) {
		this.loginLogoutDatetime = loginLogoutDatetime;
	}
	public String getUpdateStatus() {
		return updateStatus;
	}
	public void setUpdateStatus(String updateStatus) {
		this.updateStatus = updateStatus;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getMnt() {
		return mnt;
	}
	public void setMnt(String mnt) {
		this.mnt = mnt;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatLoginStatusResp [agentCircle=");
		builder.append(agentCircle);
		builder.append(", lastCallTime=");
		builder.append(lastCallTime);
		builder.append(", bChatid=");
		builder.append(bChatid);
		builder.append(", bAni=");
		builder.append(bAni);
		builder.append(", bCircle=");
		builder.append(bCircle);
		builder.append(", loginStatus=");
		builder.append(loginStatus);
		builder.append(", status=");
		builder.append(status);
		builder.append(", update=");
		builder.append(update);
		builder.append(", priorityFlag=");
		builder.append(priorityFlag);
		builder.append(", loginLogoutDatetime=");
		builder.append(loginLogoutDatetime);
		builder.append(", updateStatus=");
		builder.append(updateStatus);
		builder.append(", centerName=");
		builder.append(centerName);
		builder.append(", mnt=");
		builder.append(mnt);
		builder.append(", hub=");
		builder.append(hub);
		builder.append("]");
		return builder.toString();
	}
	
	

}
