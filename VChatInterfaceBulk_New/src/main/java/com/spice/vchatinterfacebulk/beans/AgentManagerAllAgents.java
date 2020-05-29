package com.spice.vchatinterfacebulk.beans;

public class AgentManagerAllAgents{
	
	
	private String hub,bAni,bChatid,bCircle,agentCircle,agentCategory,centerName,agentName,agentAge,agentLang,userDoc,userDocNo,userDocPath,certificatePath;

	public String getHub() {
		return hub;
	}

	public void setHub(String hub) {
		this.hub = hub;
	}

	public String getbAni() {
		return bAni;
	}

	public void setbAni(String bAni) {
		this.bAni = bAni;
	}

	public String getbChatid() {
		return bChatid;
	}

	public void setbChatid(String bChatid) {
		this.bChatid = bChatid;
	}

	public String getbCircle() {
		return bCircle;
	}

	public void setbCircle(String bCircle) {
		this.bCircle = bCircle;
	}

	public String getAgentCircle() {
		return agentCircle;
	}

	public void setAgentCircle(String agentCircle) {
		this.agentCircle = agentCircle;
	}

	public String getAgentCategory() {
		return agentCategory;
	}

	public void setAgentCategory(String agentCategory) {
		this.agentCategory = agentCategory;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentAge() {
		return agentAge;
	}

	public void setAgentAge(String agentAge) {
		this.agentAge = agentAge;
	}

	public String getAgentLang() {
		return agentLang;
	}

	public void setAgentLang(String agentLang) {
		this.agentLang = agentLang;
	}

	public String getUserDoc() {
		return userDoc;
	}

	public void setUserDoc(String userDoc) {
		this.userDoc = userDoc;
	}

	public String getUserDocNo() {
		return userDocNo;
	}

	public void setUserDocNo(String userDocNo) {
		this.userDocNo = userDocNo;
	}

	public String getUserDocPath() {
		return userDocPath;
	}

	public void setUserDocPath(String userDocPath) {
		this.userDocPath = userDocPath;
	}

	public String getCertificatePath() {
		return certificatePath;
	}

	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AgentManagerAllAgents [hub=");
		builder.append(hub);
		builder.append(", bAni=");
		builder.append(bAni);
		builder.append(", bChatid=");
		builder.append(bChatid);
		builder.append(", bCircle=");
		builder.append(bCircle);
		builder.append(", agentCircle=");
		builder.append(agentCircle);
		builder.append(", agentCategory=");
		builder.append(agentCategory);
		builder.append(", centerName=");
		builder.append(centerName);
		builder.append(", agentName=");
		builder.append(agentName);
		builder.append(", agentAge=");
		builder.append(agentAge);
		builder.append(", agentLang=");
		builder.append(agentLang);
		builder.append(", userDoc=");
		builder.append(userDoc);
		builder.append(", userDocNo=");
		builder.append(userDocNo);
		builder.append(", userDocPath=");
		builder.append(userDocPath);
		builder.append(", certificatePath=");
		builder.append(certificatePath);
		builder.append("]");
		return builder.toString();
	}

	
	
	}
