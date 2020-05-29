package com.spice.vchatinterfacebulk.beans;

public class ChatAgentLiveCountPartnerWise {

	private String partnerName;
	private String login;
	private String logout;
	private String aLogout;
	private String bLogout;   
	private String fLogout;
	private String sLogout;
	private String vLogout;
	private String busy;
	private String free;
	private String hub;
	
	public String getHub() {
		return hub;
	}
	public void setHub(String hub) {
		this.hub = hub;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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
		builder.append("ChatAgentLiveCountPartnerWise [partnerName=");
		builder.append(partnerName);
		builder.append(", login=");
		builder.append(login);
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
		builder.append(", hub=");
		builder.append(hub);
		builder.append("]");
		return builder.toString();
	}
	
	
}
