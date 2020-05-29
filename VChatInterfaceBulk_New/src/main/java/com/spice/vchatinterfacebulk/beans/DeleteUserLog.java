package com.spice.vchatinterfacebulk.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_interfaceuser_log")
public class DeleteUserLog {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name="PartnerName")
	private String partnerName;
	
	@Column(name="UserName")
	private String userName;
	
	@Column(name="UserPassword")
	private String userPassword;
	
	@Column(name="UserRole")
	private String userRole;
	
	@Column(name="UserRemoveDateTime")
	private String userRemoveDateTime;
	
	@Column(name="ipAddress")
	private String ipAddress;
	
	@Column(name="UserRemoveBy")
	private String userRemoveBy;
	
	
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserRemoveDateTime() {
		return userRemoveDateTime;
	}
	public void setUserRemoveDateTime(String userRemoveDateTime) {
		this.userRemoveDateTime = userRemoveDateTime;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getUserRemoveBy() {
		return userRemoveBy;
	}
	public void setUserRemoveBy(String userRemoveBy) {
		this.userRemoveBy = userRemoveBy;
	}
	@Override
	public String toString() {
		return "DeleteUserLog [id=" + id + ", partnerName=" + partnerName + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userRole=" + userRole + ", userRemoveDateTime=" + userRemoveDateTime
				+ ", ipAddress=" + ipAddress + ", userRemoveBy=" + userRemoveBy + "]";
	}
	
	
	
	
	
	

}
