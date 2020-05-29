package com.spice.vchatinterfacebulk.beans;

public class ChatAgentLiveCountZoneWise {
	
	private String zone;
	private String loginId;
	private String logout;   
	private String aLogout;
	private String bLogout;
	private String fLogout;
	private String sLogout;
	private String vLogout;
	private String busy;
	private String free;
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLogout() {
		return logout;
	}
	public void setLogout(String logout) {
		this.logout = logout;
	}
	public String getaLogout() {
		return aLogout;
	}
	public void setaLogout(String aLogout) {
		this.aLogout = aLogout;
	}
	public String getbLogout() {
		return bLogout;
	}
	public void setbLogout(String bLogout) {
		this.bLogout = bLogout;
	}
	public String getfLogout() {
		return fLogout;
	}
	public void setfLogout(String fLogout) {
		this.fLogout = fLogout;
	}
	public String getsLogout() {
		return sLogout;
	}
	public void setsLogout(String sLogout) {
		this.sLogout = sLogout;
	}
	public String getvLogout() {
		return vLogout;
	}
	public void setvLogout(String vLogout) {
		this.vLogout = vLogout;
	}
	public String getBusy() {
		return busy;
	}
	public void setBusy(String busy) {
		this.busy = busy;
	}
	public String getFree() {
		return free;
	}
	public void setFree(String free) {
		this.free = free;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatAgentLiveCountZoneWise [zone=");
		builder.append(zone);
		builder.append(", loginId=");
		builder.append(loginId);
		builder.append(", logout=");
		builder.append(logout);
		builder.append(", aLogout=");
		builder.append(aLogout);
		builder.append(", bLogout=");
		builder.append(bLogout);
		builder.append(", fLogout=");
		builder.append(fLogout);
		builder.append(", sLogout=");
		builder.append(sLogout);
		builder.append(", vLogout=");
		builder.append(vLogout);
		builder.append(", busy=");
		builder.append(busy);
		builder.append(", free=");
		builder.append(free);
		builder.append("]");
		return builder.toString();
	}
	
	

}
