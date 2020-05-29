package com.spice.vchatinterfacebulk.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_UI_Partner_Agent")
public class AgentManagerUserRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="PartnerName")
	private String partnerName;
	
	@Column(name="MobileNo")
	private String mobileNo;
	
	@Column(name="ChatId")
	private String chatId;
	
	@Column(name="AgentName")
	private String agentName;
	
	@Column(name="AgentAge")
	private String agentAge;
	
	@Column(name="AgentLang")
	private String agentLang;
	
	@Column(name="AgentType")
	private String agentType;
	
	@Column(name="Circle")
	private String circle;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="State")
	private String state;
	
	@Column(name="UserDoc")
	private String userDoc;
	
	@Column(name="UserDocNo")
	private String userDocNo;
	
	@Column(name="UserDocPath")
	private String userDocPath;
	
	@Column(name="CertificatePath")
	private String certificatePath;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
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

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
		builder.append("AgentManagerUserRecord [id=");
		builder.append(id);
		builder.append(", partnerName=");
		builder.append(partnerName);
		builder.append(", mobileNo=");
		builder.append(mobileNo);
		builder.append(", chatId=");
		builder.append(chatId);
		builder.append(", agentName=");
		builder.append(agentName);
		builder.append(", agentAge=");
		builder.append(agentAge);
		builder.append(", agentLang=");
		builder.append(agentLang);
		builder.append(", agentType=");
		builder.append(agentType);
		builder.append(", circle=");
		builder.append(circle);
		builder.append(", location=");
		builder.append(location);
		builder.append(", state=");
		builder.append(state);
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
