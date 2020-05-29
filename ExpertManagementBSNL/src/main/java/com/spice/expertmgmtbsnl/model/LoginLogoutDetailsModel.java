package com.spice.expertmgmtbsnl.model;

import java.util.Date;

public class LoginLogoutDetailsModel {

	private int sNo;
	private String B_NAME;
	private Date LOGIN_TIME;
	private Date LOGOUT_TIME;
	private String SESSION_ID;
	private String IP_ADDRESS;
	
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	public String getB_NAME() {
		return B_NAME;
	}
	public void setB_NAME(String b_NAME) {
		B_NAME = b_NAME;
	}
	public Date getLOGIN_TIME() {
		return LOGIN_TIME;
	}
	public void setLOGIN_TIME(Date lOGIN_TIME) {
		LOGIN_TIME = lOGIN_TIME;
	}
	public Date getLOGOUT_TIME() {
		return LOGOUT_TIME;
	}
	public void setLOGOUT_TIME(Date lOGOUT_TIME) {
		LOGOUT_TIME = lOGOUT_TIME;
	}
	public String getSESSION_ID() {
		return SESSION_ID;
	}
	public void setSESSION_ID(String sESSION_ID) {
		SESSION_ID = sESSION_ID;
	}
	public String getIP_ADDRESS() {
		return IP_ADDRESS;
	}
	public void setIP_ADDRESS(String iP_ADDRESS) {
		IP_ADDRESS = iP_ADDRESS;
	}
	
}
