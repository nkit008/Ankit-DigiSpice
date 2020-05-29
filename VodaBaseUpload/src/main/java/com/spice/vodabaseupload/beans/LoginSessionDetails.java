package com.spice.vodabaseupload.beans;


import java.util.List;

public class LoginSessionDetails {
	
	private String userName;
	private String password;
	private String role;
	private String userIp;
	
	
	
	
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginSessionDetails [userName=");
		builder.append(userName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", role=");
		builder.append(role);
		builder.append(", userIp=");
		builder.append(userIp);
		builder.append("]");
		return builder.toString();
	}
	
	

}
