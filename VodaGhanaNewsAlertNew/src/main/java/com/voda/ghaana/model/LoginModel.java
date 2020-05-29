package com.voda.ghaana.model;

import org.springframework.stereotype.Component;

@Component
public class LoginModel {
	
	private String username;
	private String userrole;
	private String userstatus;
	private String userIpAdd;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	public String getUserstatus() {
		return userstatus;
	}
	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}
	public String getUserIpAdd() {
		return userIpAdd;
	}
	public void setUserIpAdd(String userIpAdd) {
		this.userIpAdd = userIpAdd;
	}
	
	
	
}
