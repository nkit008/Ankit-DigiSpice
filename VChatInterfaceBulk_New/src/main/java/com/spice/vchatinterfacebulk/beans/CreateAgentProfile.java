package com.spice.vchatinterfacebulk.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="tbl_UI_Partner_Change_Request")
public class CreateAgentProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="PartnerName")
	private String partnerName;
	
	@Column(name="AgentAni")
	private String agentAni;
	
	@Column(name="NewAgentName")
	private String newAgentName;
	
	@Column(name="NewAgentAge")
	private String newAgentAge;
	
	@Column(name="NewAgentLang")
	private String newAgentLang;
	
	@Column(name="NewAgentType")
	private String newAgentType;
	
	@Column(name="NewAni")
	private String newAni;
	
	@Column(name="NewChatid")
	private String newChatid;
	
	@Column(name="NewCircle")
	private String newCircle;
	
	@Column(name="NewLocation")
	private String newLocation;
	
	@Column(name="NewState")
	private String newState;
	
	@Column(name="NewUserDoc")
	private String newUserDoc;
	
	@Column(name="NewUserDocNo")
	private String newUserDocNo;
	
	@Column(name="PartnerRemarks")
	private String partnerRemarks;
	
	@Column(name="AdminRemarks")
	private String adminRemarks;
	
	@Column(name="ReqType")
	private String reqType;
	
	@Column(name="AgentStatus")
	private String agentStatus;
	
	@Column(name="CertificatePath")
	private String certificatePath;
	
	@Column(name="UserDocPath")
	private String userDocPath;
	
	@UpdateTimestamp
	@Column(name="ReqInsertdate")
	private Timestamp reqInsertDate;

	@Column(name="hub")
	private String hub;
	
	@Column(name="RequestBy")
	private String requestBy;
	

	public String getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	public Timestamp getReqInsertDate() {
		return reqInsertDate;
	}

	public void setReqInsertDate(Timestamp reqInsertDate) {
		this.reqInsertDate = reqInsertDate;
	}

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

	public String getAgentAni() {
		return agentAni;
	}

	public void setAgentAni(String agentAni) {
		this.agentAni = agentAni;
	}

	public String getNewAgentName() {
		return newAgentName;
	}

	public void setNewAgentName(String newAgentName) {
		this.newAgentName = newAgentName;
	}

	public String getNewAgentAge() {
		return newAgentAge;
	}

	public void setNewAgentAge(String newAgentAge) {
		this.newAgentAge = newAgentAge;
	}

	public String getNewAgentLang() {
		return newAgentLang;
	}

	public void setNewAgentLang(String newAgentLang) {
		this.newAgentLang = newAgentLang;
	}

	public String getNewAgentType() {
		return newAgentType;
	}

	public void setNewAgentType(String newAgentType) {
		this.newAgentType = newAgentType;
	}

	public String getNewAni() {
		return newAni;
	}

	public void setNewAni(String newAni) {
		this.newAni = newAni;
	}

	public String getNewChatid() {
		return newChatid;
	}

	public void setNewChatid(String newChatid) {
		this.newChatid = newChatid;
	}

	public String getNewCircle() {
		return newCircle;
	}

	public void setNewCircle(String newCircle) {
		this.newCircle = newCircle;
	}

	public String getNewLocation() {
		return newLocation;
	}

	public void setNewLocation(String newLocation) {
		this.newLocation = newLocation;
	}

	public String getNewState() {
		return newState;
	}

	public void setNewState(String newState) {
		this.newState = newState;
	}

	public String getNewUserDoc() {
		return newUserDoc;
	}

	public void setNewUserDoc(String newUserDoc) {
		this.newUserDoc = newUserDoc;
	}

	public String getNewUserDocNo() {
		return newUserDocNo;
	}

	public void setNewUserDocNo(String newUserDocNo) {
		this.newUserDocNo = newUserDocNo;
	}

	public String getPartnerRemarks() {
		return partnerRemarks;
	}

	public void setPartnerRemarks(String partnerRemarks) {
		this.partnerRemarks = partnerRemarks;
	}

	public String getAdminRemarks() {
		return adminRemarks;
	}

	public void setAdminRemarks(String adminRemarks) {
		this.adminRemarks = adminRemarks;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getAgentStatus() {
		return agentStatus;
	}

	public void setAgentStatus(String agentStatus) {
		this.agentStatus = agentStatus;
	}

	public String getCertificatePath() {
		return certificatePath;
	}

	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath;
	}

	public String getUserDocPath() {
		return userDocPath;
	}

	public void setUserDocPath(String userDocPath) {
		this.userDocPath = userDocPath;
	}

	public String getHub() {
		return hub;
	}

	public void setHub(String hub) {
		this.hub = hub;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateAgentProfile [id=");
		builder.append(id);
		builder.append(", partnerName=");
		builder.append(partnerName);
		builder.append(", agentAni=");
		builder.append(agentAni);
		builder.append(", newAgentName=");
		builder.append(newAgentName);
		builder.append(", newAgentAge=");
		builder.append(newAgentAge);
		builder.append(", newAgentLang=");
		builder.append(newAgentLang);
		builder.append(", newAgentType=");
		builder.append(newAgentType);
		builder.append(", newAni=");
		builder.append(newAni);
		builder.append(", newChatid=");
		builder.append(newChatid);
		builder.append(", newCircle=");
		builder.append(newCircle);
		builder.append(", newLocation=");
		builder.append(newLocation);
		builder.append(", newState=");
		builder.append(newState);
		builder.append(", newUserDoc=");
		builder.append(newUserDoc);
		builder.append(", newUserDocNo=");
		builder.append(newUserDocNo);
		builder.append(", partnerRemarks=");
		builder.append(partnerRemarks);
		builder.append(", adminRemarks=");
		builder.append(adminRemarks);
		builder.append(", reqType=");
		builder.append(reqType);
		builder.append(", agentStatus=");
		builder.append(agentStatus);
		builder.append(", certificatePath=");
		builder.append(certificatePath);
		builder.append(", userDocPath=");
		builder.append(userDocPath);
		builder.append(", reqInsertDate=");
		builder.append(reqInsertDate);
		builder.append(", hub=");
		builder.append(hub);
		builder.append(", requestBy=");
		builder.append(requestBy);
		builder.append("]");
		return builder.toString();
	}
	
		

}
