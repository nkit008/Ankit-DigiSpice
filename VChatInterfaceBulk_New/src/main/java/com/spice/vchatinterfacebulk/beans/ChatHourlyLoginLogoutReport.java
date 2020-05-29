package com.spice.vchatinterfacebulk.beans;

public class ChatHourlyLoginLogoutReport {
	
	private String circle; 
	private String agentLocation;
	private String reportDateTime;
	private String detailHour; 
	private String loginLogoutTime; 
	private String chatId;
	private String loginLogoutStatus; 
	private String ani; 
	private String vendor; 
	private String location;
	private String loginLogoutTimeMin; 
	private String status; 
	private String category;
	private String priority;
	private String totalCalls; 
	private String succCalls;
	private String failCalls; 
	private String pulses; 
	private String mou; 
	private String other;
	private String aPartyDisconnect; 
	private String noAnswer; 
	private String switchOff;
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getAgentLocation() {
		return agentLocation;
	}
	public void setAgentLocation(String agentLocation) {
		this.agentLocation = agentLocation;
	}
	public String getReportDateTime() {
		return reportDateTime;
	}
	public void setReportDateTime(String reportDateTime) {
		this.reportDateTime = reportDateTime;
	}
	public String getDetailHour() {
		return detailHour;
	}
	public void setDetailHour(String detailHour) {
		this.detailHour = detailHour;
	}
	public String getLoginLogoutTime() {
		return loginLogoutTime;
	}
	public void setLoginLogoutTime(String loginLogoutTime) {
		this.loginLogoutTime = loginLogoutTime;
	}
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	public String getLoginLogoutStatus() {
		return loginLogoutStatus;
	}
	public void setLoginLogoutStatus(String loginLogoutStatus) {
		this.loginLogoutStatus = loginLogoutStatus;
	}
	public String getAni() {
		return ani;
	}
	public void setAni(String ani) {
		this.ani = ani;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLoginLogoutTimeMin() {
		return loginLogoutTimeMin;
	}
	public void setLoginLogoutTimeMin(String loginLogoutTimeMin) {
		this.loginLogoutTimeMin = loginLogoutTimeMin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getTotalCalls() {
		return totalCalls;
	}
	public void setTotalCalls(String totalCalls) {
		this.totalCalls = totalCalls;
	}
	public String getSuccCalls() {
		return succCalls;
	}
	public void setSuccCalls(String succCalls) {
		this.succCalls = succCalls;
	}
	public String getFailCalls() {
		return failCalls;
	}
	public void setFailCalls(String failCalls) {
		this.failCalls = failCalls;
	}
	public String getPulses() {
		return pulses;
	}
	public void setPulses(String pulses) {
		this.pulses = pulses;
	}
	public String getMou() {
		return mou;
	}
	public void setMou(String mou) {
		this.mou = mou;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getaPartyDisconnect() {
		return aPartyDisconnect;
	}
	public void setaPartyDisconnect(String aPartyDisconnect) {
		this.aPartyDisconnect = aPartyDisconnect;
	}
	public String getNoAnswer() {
		return noAnswer;
	}
	public void setNoAnswer(String noAnswer) {
		this.noAnswer = noAnswer;
	}
	public String getSwitchOff() {
		return switchOff;
	}
	public void setSwitchOff(String switchOff) {
		this.switchOff = switchOff;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatHourlyLoginLogoutReport [circle=");
		builder.append(circle);
		builder.append(", agentLocation=");
		builder.append(agentLocation);
		builder.append(", reportDateTime=");
		builder.append(reportDateTime);
		builder.append(", detailHour=");
		builder.append(detailHour);
		builder.append(", loginLogoutTime=");
		builder.append(loginLogoutTime);
		builder.append(", chatId=");
		builder.append(chatId);
		builder.append(", loginLogoutStatus=");
		builder.append(loginLogoutStatus);
		builder.append(", ani=");
		builder.append(ani);
		builder.append(", vendor=");
		builder.append(vendor);
		builder.append(", location=");
		builder.append(location);
		builder.append(", loginLogoutTimeMin=");
		builder.append(loginLogoutTimeMin);
		builder.append(", status=");
		builder.append(status);
		builder.append(", category=");
		builder.append(category);
		builder.append(", priority=");
		builder.append(priority);
		builder.append(", totalCalls=");
		builder.append(totalCalls);
		builder.append(", succCalls=");
		builder.append(succCalls);
		builder.append(", failCalls=");
		builder.append(failCalls);
		builder.append(", pulses=");
		builder.append(pulses);
		builder.append(", mou=");
		builder.append(mou);
		builder.append(", other=");
		builder.append(other);
		builder.append(", aPartyDisconnect=");
		builder.append(aPartyDisconnect);
		builder.append(", noAnswer=");
		builder.append(noAnswer);
		builder.append(", switchOff=");
		builder.append(switchOff);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
