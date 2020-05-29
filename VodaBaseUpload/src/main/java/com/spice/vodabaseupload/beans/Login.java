package com.spice.vodabaseupload.beans;

public class Login {
	
	private String userName;
	private String userPwd;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	@Override
	public String toString() {
		return "Login [userName=" + userName + ", userPwd=" + userPwd + "]";
	}
	
	

}
