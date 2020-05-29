package com.spice.expertmgmtbsnl.model;

import java.sql.Date;

public class CheckLoginStatusModel {

	private String bCategory;
	private long bAni;
	private String bChatId;
	private String bCircle;
	private String bGender;
	private String bName;
	private String loginStatus;
	private String status;
	private int totalCount;
	private int sucessCount;
	private int failCount;
	private int prorityFlag;
	private String outLine;
	private String ip;
	private long  aAni;
	private long aChatId;
	private String aCircle;
	private String inLine;
	private String lastCallTime;
	private String agentCircle;
	private String loginLogoutDateTime;
	private String hub;
	private String partnerName;
	
	
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getbCategory() {
		return bCategory;
	}
	public void setbCategory(String bCategory) {
		this.bCategory = bCategory;
	}
	public long getbAni() {
		return bAni;
	}
	public void setbAni(long bAni) {
		this.bAni = bAni;
	}
	public String getbChatId() {
		return bChatId;
	}
	public void setbChatId(String bChatId) {
		this.bChatId = bChatId;
	}
	public String getbCircle() {
		return bCircle;
	}
	public void setbCircle(String bCircle) {
		this.bCircle = bCircle;
	}
	public String getbGender() {
		return bGender;
	}
	public void setbGender(String bGender) {
		this.bGender = bGender;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getSucessCount() {
		return sucessCount;
	}
	public void setSucessCount(int sucessCount) {
		this.sucessCount = sucessCount;
	}
	public int getFailCount() {
		return failCount;
	}
	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}
	public int getProrityFlag() {
		return prorityFlag;
	}
	public void setProrityFlag(int prorityFlag) {
		this.prorityFlag = prorityFlag;
	}
	public String getOutLine() {
		return outLine;
	}
	public void setOutLine(String outLine) {
		this.outLine = outLine;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public long getaAni() {
		return aAni;
	}
	public void setaAni(long aAni) {
		this.aAni = aAni;
	}
	public long getaChatId() {
		return aChatId;
	}
	public void setaChatId(long aChatId) {
		this.aChatId = aChatId;
	}
	public String getaCircle() {
		return aCircle;
	}
	public void setaCircle(String aCircle) {
		this.aCircle = aCircle;
	}
	public String getInLine() {
		return inLine;
	}
	public void setInLine(String inLine) {
		this.inLine = inLine;
	}
	public String getLastCallTime() {
		return lastCallTime;
	}
	public void setLastCallTime(String lastCallTime) {
		this.lastCallTime = lastCallTime;
	}
	public String getAgentCircle() {
		return agentCircle;
	}
	public void setAgentCircle(String agentCircle) {
		this.agentCircle = agentCircle;
	}
	public String getLoginLogoutDateTime() {
		return loginLogoutDateTime;
	}
	public void setLoginLogoutDateTime(String loginLogoutDateTime) {
		this.loginLogoutDateTime = loginLogoutDateTime;
	}
	public String getHub() {
		return hub;
	}
	public void setHub(String hub) {
		this.hub = hub;
	}
	@Override
	public String toString() {
		return "CheckLoginStatusModel [bCategory=" + bCategory + ", bAni=" + bAni + ", bChatId=" + bChatId
				+ ", bCircle=" + bCircle + ", bGender=" + bGender + ", bName=" + bName + ", loginStatus=" + loginStatus
				+ ", status=" + status + ", totalCount=" + totalCount + ", sucessCount=" + sucessCount + ", failCount="
				+ failCount + ", prorityFlag=" + prorityFlag + ", outLine=" + outLine + ", ip=" + ip + ", aAni=" + aAni
				+ ", aChatId=" + aChatId + ", aCircle=" + aCircle + ", inLine=" + inLine + ", lastCallTime="
				+ lastCallTime + ", agentCircle=" + agentCircle + ", loginLogoutDateTime=" + loginLogoutDateTime
				+ ", hub=" + hub + ", partnerName=" + partnerName + "]";
	}
	

	
}
