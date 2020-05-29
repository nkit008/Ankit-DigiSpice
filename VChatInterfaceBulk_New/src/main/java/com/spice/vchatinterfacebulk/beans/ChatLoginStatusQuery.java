package com.spice.vchatinterfacebulk.beans;

public class ChatLoginStatusQuery {
	
	private String agentCircle;
	private String lastCallTime;
	private String bChatid;
	private String bAni;
	private String bCircle;
	private String loginStatus;
	private String status;
	private String loginlogoutDatetime;
	private String mint;
	private String priorityFlag;
	private String procName;
	private String centerName;
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
	public String getLoginlogoutDatetime() {
		return loginlogoutDatetime;
	}
	public void setLoginlogoutDatetime(String loginlogoutDatetime) {
		this.loginlogoutDatetime = loginlogoutDatetime;
	}
	public String getMint() {
		return mint;
	}
	public void setMint(String mint) {
		this.mint = mint;
	}
	public String getPriorityFlag() {
		return priorityFlag;
	}
	public void setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
	}
	public String getProcName() {
		return procName;
	}
	public void setProcName(String procName) {
		this.procName = procName;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatLoginStatusQuery [agentCircle=");
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
		builder.append(", loginlogoutDatetime=");
		builder.append(loginlogoutDatetime);
		builder.append(", mint=");
		builder.append(mint);
		builder.append(", priorityFlag=");
		builder.append(priorityFlag);
		builder.append(", procName=");
		builder.append(procName);
		builder.append(", centerName=");
		builder.append(centerName);
		builder.append("]");
		return builder.toString();
	}
	
	

}
