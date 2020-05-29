package com.spice.vodabaseupload.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_VodaBaseUpload_Login")
public class LoginEntity {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="userPassword")
	private String userPassword;
	
	@Column(name="userRole")
	private String userRole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "LoginEntity [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", userRole="
				+ userRole + "]";
	}
	
	
	

}
