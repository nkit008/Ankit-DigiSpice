package com.digispice.cci.zambia.entity;

import org.springframework.stereotype.Component;

@Component
public class UserStatusBean {
	
	private String mobileNumber;
	private String packType;
	private String quantity;
	private String subDate;
	private String lastBillingDate;
	private String nextBillingDate;
	private String actSource;
	private String status;
	private String popUpmessage;
	
	
	public String getPopUpmessage() {
		return popUpmessage;
	}
	public void setPopUpmessage(String popUpmessage) {
		this.popUpmessage = popUpmessage;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPackType() {
		return packType;
	}
	public void setPackType(String packType) {
		this.packType = packType;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSubDate() {
		return subDate;
	}
	public void setSubDate(String subDate) {
		this.subDate = subDate;
	}
	public String getLastBillingDate() {
		return lastBillingDate;
	}
	public void setLastBillingDate(String lastBillingDate) {
		this.lastBillingDate = lastBillingDate;
	}
	public String getNextBillingDate() {
		return nextBillingDate;
	}
	public void setNextBillingDate(String nextBillingDate) {
		this.nextBillingDate = nextBillingDate;
	}
	public String getActSource() {
		return actSource;
	}
	public void setActSource(String actSource) {
		this.actSource = actSource;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "UserStatusBean [mobileNumber=" + mobileNumber + ", packType=" + packType + ", quantity=" + quantity
				+ ", subDate=" + subDate + ", lastBillingDate=" + lastBillingDate + ", nextBillingDate="
				+ nextBillingDate + ", actSource=" + actSource + ", status=" + status + "]";
	}
	
	
	

}
