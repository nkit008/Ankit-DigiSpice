package com.digispice.cci.zambia.entity;

import java.util.Date;

import org.springframework.stereotype.Component;


@Component
public class ZamtelGamesBillingHistory {
	
	
	private String tid;
	private String ani;
	private String status;
	private String subDate;
	private String renewDate;
	private String billingDate;
	private String prePost;
	private String amtDeducted;
	private String packType;
	private String actSource;
	private String serviceType;
	private String vendorName;
	private String clickId;
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getAni() {
		return ani;
	}
	public void setAni(String ani) {
		this.ani = ani;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubDate() {
		return subDate;
	}
	public void setSubDate(String subDate) {
		this.subDate = subDate;
	}
	public String getRenewDate() {
		return renewDate;
	}
	public void setRenewDate(String renewDate) {
		this.renewDate = renewDate;
	}
	public String getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(String billingDate) {
		this.billingDate = billingDate;
	}
	public String getPrePost() {
		return prePost;
	}
	public void setPrePost(String prePost) {
		this.prePost = prePost;
	}
	public String getAmtDeducted() {
		return amtDeducted;
	}
	public void setAmtDeducted(String amtDeducted) {
		this.amtDeducted = amtDeducted;
	}
	public String getPackType() {
		return packType;
	}
	public void setPackType(String packType) {
		this.packType = packType;
	}
	public String getActSource() {
		return actSource;
	}
	public void setActSource(String actSource) {
		this.actSource = actSource;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getClickId() {
		return clickId;
	}
	public void setClickId(String clickId) {
		this.clickId = clickId;
	}
	

	

}
