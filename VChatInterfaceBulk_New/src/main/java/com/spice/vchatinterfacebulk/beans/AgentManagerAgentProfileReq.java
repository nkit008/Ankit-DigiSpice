package com.spice.vchatinterfacebulk.beans;

import java.sql.Timestamp;

public class AgentManagerAgentProfileReq {
	
	private int id;
	private String operator;
	private String partnerName;
	private String number;
	private String newNumber;
	private String allocatedCircle;
	private String chatId;
	private String location;
	private String state;
	private String type;
	private String document;
	private String documentNumber;
	private String agentName;
	private String age;
	private String languages;
	private String status;
	private String partnerRemarks;
	private String adminRemarks;
	private String reqType;
	private String documentPath;
	private String certificatePath;
	private Timestamp insertDate;
	private String hub;
	
	
	public String getHub() {
		return hub;
	}
	public void setHub(String hub) {
		this.hub = hub;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Timestamp getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}
	public String getDocumentPath() {
		return documentPath;
	}
	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}
	public String getCertificatePath() {
		return certificatePath;
	}
	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getNewNumber() {
		return newNumber;
	}
	public void setNewNumber(String newNumber) {
		this.newNumber = newNumber;
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
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAllocatedCircle() {
		return allocatedCircle;
	}
	public void setAllocatedCircle(String allocatedCircle) {
		this.allocatedCircle = allocatedCircle;
	}
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AgentManagerAgentProfileReq [id=");
		builder.append(id);
		builder.append(", operator=");
		builder.append(operator);
		builder.append(", partnerName=");
		builder.append(partnerName);
		builder.append(", number=");
		builder.append(number);
		builder.append(", newNumber=");
		builder.append(newNumber);
		builder.append(", allocatedCircle=");
		builder.append(allocatedCircle);
		builder.append(", chatId=");
		builder.append(chatId);
		builder.append(", location=");
		builder.append(location);
		builder.append(", state=");
		builder.append(state);
		builder.append(", type=");
		builder.append(type);
		builder.append(", document=");
		builder.append(document);
		builder.append(", documentNumber=");
		builder.append(documentNumber);
		builder.append(", agentName=");
		builder.append(agentName);
		builder.append(", age=");
		builder.append(age);
		builder.append(", languages=");
		builder.append(languages);
		builder.append(", status=");
		builder.append(status);
		builder.append(", partnerRemarks=");
		builder.append(partnerRemarks);
		builder.append(", adminRemarks=");
		builder.append(adminRemarks);
		builder.append(", reqType=");
		builder.append(reqType);
		builder.append(", documentPath=");
		builder.append(documentPath);
		builder.append(", certificatePath=");
		builder.append(certificatePath);
		builder.append(", insertDate=");
		builder.append(insertDate);
		builder.append(", hub=");
		builder.append(hub);
		builder.append("]");
		return builder.toString();
	}

	
	
}
