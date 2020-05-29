package com.spice.vchatinterfacebulk.beans;

public class ChatOutDialLog {

	private String productName;
	private String dateTime;
	private String ani;
	private String aGender;
	private String aChatid;
	private String bAni;
	private String bCircle;
	private String bChatid;
	private String category;
	private String duration;
	private String callValue;
	private String callCode;
	private String reason;
	private String dnis;
	private String disconnect;
	private String flow;
	private String status;
	
	
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getAni() {
		return ani;
	}
	public void setAni(String ani) {
		this.ani = ani;
	}
	public String getaGender() {
		return aGender;
	}
	public void setaGender(String aGender) {
		this.aGender = aGender;
	}
	public String getaChatid() {
		return aChatid;
	}
	public void setaChatid(String aChatid) {
		this.aChatid = aChatid;
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
	public String getbChatid() {
		return bChatid;
	}
	public void setbChatid(String bChatid) {
		this.bChatid = bChatid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getCallValue() {
		return callValue;
	}
	public void setCallValue(String callValue) {
		this.callValue = callValue;
	}
	public String getCallCode() {
		return callCode;
	}
	public void setCallCode(String callCode) {
		this.callCode = callCode;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDnis() {
		return dnis;
	}
	public void setDnis(String dnis) {
		this.dnis = dnis;
	}
	public String getDisconnect() {
		return disconnect;
	}
	public void setDisconnect(String disconnect) {
		this.disconnect = disconnect;
	}
	public String getFlow() {
		return flow;
	}
	public void setFlow(String flow) {
		this.flow = flow;
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
		builder.append("ChatOutDialLog [productName=");
		builder.append(productName);
		builder.append(", dateTime=");
		builder.append(dateTime);
		builder.append(", ani=");
		builder.append(ani);
		builder.append(", aGender=");
		builder.append(aGender);
		builder.append(", aChatid=");
		builder.append(aChatid);
		builder.append(", bAni=");
		builder.append(bAni);
		builder.append(", bCircle=");
		builder.append(bCircle);
		builder.append(", bChatid=");
		builder.append(bChatid);
		builder.append(", category=");
		builder.append(category);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", callValue=");
		builder.append(callValue);
		builder.append(", callCode=");
		builder.append(callCode);
		builder.append(", reason=");
		builder.append(reason);
		builder.append(", dnis=");
		builder.append(dnis);
		builder.append(", disconnect=");
		builder.append(disconnect);
		builder.append(", flow=");
		builder.append(flow);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
