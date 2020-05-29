package com.spice.vchatinterfacebulk.beans;

import org.springframework.web.multipart.MultipartFile;

public class AgentManagerUser {
	
	private String hub;
	private String vender;
	private String priority;
	private String type;
	private String circle;
	private String agentLocation;
	private String ani;
	private String agentDoc;
	private String agentDocNo;
	private MultipartFile agentDocImage ;
	private String agentName;
	private String agentAge;
	private String agentLang;
	private MultipartFile venderCertificateImage;
	private String userRemarks;
	
	
	
	
	public String getUserRemarks() {
		return userRemarks;
	}
	public void setUserRemarks(String userRemarks) {
		this.userRemarks = userRemarks;
	}
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
	
	
	
	public String getAgentLocation() {
		return agentLocation;
	}
	public void setAgentLocation(String agentLocation) {
		this.agentLocation = agentLocation;
	}
	public String getAni() {
		return ani;
	}
	public void setAni(String ani) {
		this.ani = ani;
	}
	public String getAgentDoc() {
		return agentDoc;
	}
	public void setAgentDoc(String agentDoc) {
		this.agentDoc = agentDoc;
	}
	public String getAgentDocNo() {
		return agentDocNo;
	}
	public void setAgentDocNo(String agentDocNo) {
		this.agentDocNo = agentDocNo;
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
	
	public MultipartFile getAgentDocImage() {
		return agentDocImage;
	}
	public void setAgentDocImage(MultipartFile agentDocImage) {
		this.agentDocImage = agentDocImage;
	}
	public MultipartFile getVenderCertificateImage() {
		return venderCertificateImage;
	}
	public void setVenderCertificateImage(MultipartFile venderCertificateImage) {
		this.venderCertificateImage = venderCertificateImage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AgentManagerUser [hub=");
		builder.append(hub);
		builder.append(", vender=");
		builder.append(vender);
		builder.append(", priority=");
		builder.append(priority);
		builder.append(", type=");
		builder.append(type);
		builder.append(", circle=");
		builder.append(circle);
		builder.append(", agentLocation=");
		builder.append(agentLocation);
		builder.append(", ani=");
		builder.append(ani);
		builder.append(", agentDoc=");
		builder.append(agentDoc);
		builder.append(", agentDocNo=");
		builder.append(agentDocNo);
		builder.append(", agentDocImage=");
		builder.append(agentDocImage);
		builder.append(", agentName=");
		builder.append(agentName);
		builder.append(", agentAge=");
		builder.append(agentAge);
		builder.append(", agentLang=");
		builder.append(agentLang);
		builder.append(", venderCertificateImage=");
		builder.append(venderCertificateImage);
		builder.append(", userRemarks=");
		builder.append(userRemarks);
		builder.append("]");
		return builder.toString();
	}

	
	
	/*private String ani;
	private String circle;
	private String location;
	private String state;
	private String agentType;
	private String userDoc;
	private File declDoc;
	private String userDocNo;
	private String agentName;
	private String agentAge;
	private String agentLang;
	private File declCert;
*/	
	


}
