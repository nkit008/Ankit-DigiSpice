package com.spice.vchatinterfacebulk.beans;

public class CreateUserHubDetails {
	
	private String centerName;
	private String centerId;
	private String extra;
	private String bCircle;
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public String getbCircle() {
		return bCircle;
	}
	public void setbCircle(String bCircle) {
		this.bCircle = bCircle;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateUserHubDetails [centerName=");
		builder.append(centerName);
		builder.append(", centerId=");
		builder.append(centerId);
		builder.append(", extra=");
		builder.append(extra);
		builder.append(", bCircle=");
		builder.append(bCircle);
		builder.append("]");
		return builder.toString();
	}
	
	

}
