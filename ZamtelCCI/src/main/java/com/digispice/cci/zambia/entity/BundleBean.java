package com.digispice.cci.zambia.entity;

import org.springframework.stereotype.Component;

@Component
public class BundleBean {
	
	private String packageId;
	private String packageName;
	private String packagePrice;
	private String msisdn;
	private String status;
	private String packageSubDate;
	private String packageRenewDate;
	private String packageBillingDate;
	
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getPackagePrice() {
		return packagePrice;
	}
	public void setPackagePrice(String packagePrice) {
		this.packagePrice = packagePrice;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getpackageSubDate() {
		return packageSubDate;
	}
	public void setpackageSubDate(String packageSubDate) {
		this.packageSubDate = packageSubDate;
	}
	public String getpackageRenewDate() {
		return packageRenewDate;
	}
	public void setpackageRenewDate(String packageRenewDate) {
		this.packageRenewDate = packageRenewDate;
	}
	public String getpackageBillingDate() {
		return packageBillingDate;
	}
	public void setpackageBillingDate(String packageBillingDate) {
		this.packageBillingDate = packageBillingDate;
	}
	@Override
	public String toString() {
		return "BundleBean [packageId=" + packageId + ", packageName=" + packageName + ", packagePrice=" + packagePrice
				+ ", msisdn=" + msisdn + ", status=" + status + ", packageSubDate=" + packageSubDate
				+ ", packageRenewDate=" + packageRenewDate + ", packageBillingDate=" + packageBillingDate + "]";
	}
	
	
	


}
