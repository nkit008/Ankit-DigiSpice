package com.digispice.ghana.bean;

public class NextVoiceSubDetails {

	private String MOBILE_NUMBER;
	private int STATUS;
	private String SUB_DATE;
	private String RENEW_DATE;
	private String BILLING_DATE;
	private int PRE_POST;
	private int TIME_LIMIT;
	private String PACK_TYPE;
	private String LANGUAGE;
	private String ACT_SOURCE;
	private int GRACE_DAYS;
	private String SUBS_ID;
	private String TRANS_ID;
	private int USER_COUNTER;
	private int AMOUNT;

	public String getMOBILE_NUMBER() {
		return MOBILE_NUMBER;
	}

	public void setMOBILE_NUMBER(String mOBILE_NUMBER) {
		MOBILE_NUMBER = mOBILE_NUMBER;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
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

	public int getPRE_POST() {
		return PRE_POST;
	}

	public void setPRE_POST(int pRE_POST) {
		PRE_POST = pRE_POST;
	}

	public int getTIME_LIMIT() {
		return TIME_LIMIT;
	}

	public void setTIME_LIMIT(int tIME_LIMIT) {
		TIME_LIMIT = tIME_LIMIT;
	}

	public String getPACK_TYPE() {
		return PACK_TYPE;
	}

	public void setPACK_TYPE(String pACK_TYPE) {
		PACK_TYPE = pACK_TYPE;
	}

	public String getLANGUAGE() {
		return LANGUAGE;
	}

	public void setLANGUAGE(String lANGUAGE) {
		LANGUAGE = lANGUAGE;
	}

	public String getACT_SOURCE() {
		return ACT_SOURCE;
	}

	public void setACT_SOURCE(String aCT_SOURCE) {
		ACT_SOURCE = aCT_SOURCE;
	}

	public int getGRACE_DAYS() {
		return GRACE_DAYS;
	}

	public void setGRACE_DAYS(int gRACE_DAYS) {
		GRACE_DAYS = gRACE_DAYS;
	}

	public String getSUBS_ID() {
		return SUBS_ID;
	}

	public void setSUBS_ID(String sUBS_ID) {
		SUBS_ID = sUBS_ID;
	}

	public String getTRANS_ID() {
		return TRANS_ID;
	}

	public void setTRANS_ID(String tRANS_ID) {
		TRANS_ID = tRANS_ID;
	}

	public int getUSER_COUNTER() {
		return USER_COUNTER;
	}

	public void setUSER_COUNTER(int uSER_COUNTER) {
		USER_COUNTER = uSER_COUNTER;
	}

	public int getAMOUNT() {
		return AMOUNT;
	}

	public void setAMOUNT(int aMOUNT) {
		AMOUNT = aMOUNT;
	}

	@Override
	public String toString() {
		return "ModSubDetails [MOBILE_NUMBER=" + MOBILE_NUMBER + ", STATUS=" + STATUS + ", SUB_DATE=" + SUB_DATE
				+ ", RENEW_DATE=" + RENEW_DATE + ", BILLING_DATE=" + BILLING_DATE + ", PRE_POST=" + PRE_POST
				+ ", TIME_LIMIT=" + TIME_LIMIT + ", PACK_TYPE=" + PACK_TYPE + ", LANGUAGE=" + LANGUAGE + ", ACT_SOURCE="
				+ ACT_SOURCE + ", GRACE_DAYS=" + GRACE_DAYS + ", SUBS_ID=" + SUBS_ID + ", TRANS_ID=" + TRANS_ID
				+ ", USER_COUNTER=" + USER_COUNTER + ", AMOUNT=" + AMOUNT + "]";
	}

}
