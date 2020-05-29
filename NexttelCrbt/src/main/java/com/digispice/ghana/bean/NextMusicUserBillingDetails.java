package com.digispice.ghana.bean;

public class NextMusicUserBillingDetails {

	private String ANI;
	private String BILL_STATUS;
	private String SUB_DATE;
	private String RENEW_DATE;
	private String BILLING_DATE;
	private String PRE_POST;
	private String AMT_DEDUCTED;
	private String PACK_TYPE;
	private String ACT_SOURCE;
	private String TID;
	private String SERVICE_NAME;
	private String VALIDITY;

	public String getVALIDITY() {
		return VALIDITY;
	}

	public void setVALIDITY(String vALIDITY) {
		VALIDITY = vALIDITY;
	}

	public String getANI() {
		return ANI;
	}

	public void setANI(String aNI) {
		ANI = aNI;
	}

	public String getBILL_STATUS() {
		return BILL_STATUS;
	}

	public void setBILL_STATUS(String bILL_STATUS) {
		BILL_STATUS = bILL_STATUS;
	}

	public String getSUB_DATE() {
		return SUB_DATE;
	}

	public void setSUB_DATE(String sUB_DATE) {
		SUB_DATE = sUB_DATE;
	}

	public String getRENEW_DATE() {
		return RENEW_DATE;
	}

	public void setRENEW_DATE(String rENEW_DATE) {
		RENEW_DATE = rENEW_DATE;
	}

	public String getBILLING_DATE() {
		return BILLING_DATE;
	}

	public void setBILLING_DATE(String bILLING_DATE) {
		BILLING_DATE = bILLING_DATE;
	}

	public String getPRE_POST() {
		return PRE_POST;
	}

	public void setPRE_POST(String pRE_POST) {
		PRE_POST = pRE_POST;
	}

	public String getAMT_DEDUCTED() {
		return AMT_DEDUCTED;
	}

	public void setAMT_DEDUCTED(String aMT_DEDUCTED) {
		AMT_DEDUCTED = aMT_DEDUCTED;
	}

	public String getPACK_TYPE() {
		return PACK_TYPE;
	}

	public void setPACK_TYPE(String pACK_TYPE) {
		PACK_TYPE = pACK_TYPE;
	}

	public String getACT_SOURCE() {
		return ACT_SOURCE;
	}

	public void setACT_SOURCE(String aCT_SOURCE) {
		ACT_SOURCE = aCT_SOURCE;
	}

	public String getTID() {
		return TID;
	}

	public void setTID(String tID) {
		TID = tID;
	}

	public String getSERVICE_NAME() {
		return SERVICE_NAME;
	}

	public void setSERVICE_NAME(String sERVICE_NAME) {
		SERVICE_NAME = sERVICE_NAME;
	}

	@Override
	public String toString() {
		return "ModUserBillingDetails [ANI=" + ANI + ", BILL_STATUS=" + BILL_STATUS + ", SUB_DATE=" + SUB_DATE
				+ ", RENEW_DATE=" + RENEW_DATE + ", BILLING_DATE=" + BILLING_DATE + ", PRE_POST=" + PRE_POST
				+ ", AMT_DEDUCTED=" + AMT_DEDUCTED + ", PACK_TYPE=" + PACK_TYPE + ", ACT_SOURCE=" + ACT_SOURCE
				+ ", TID=" + TID + ", SERVICE_NAME=" + SERVICE_NAME + "]";
	}

}
