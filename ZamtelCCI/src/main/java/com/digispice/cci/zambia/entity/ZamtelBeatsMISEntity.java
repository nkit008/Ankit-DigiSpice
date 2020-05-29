package com.digispice.cci.zambia.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="TBL_MIS_ZEMTAL_BEATZ")
public class ZamtelBeatsMISEntity {
	
	@Id
	@Column(name="TRANS_ID")
	private String transId;
	
	@Column(name="NON_SUB_VISITOR")
	private int NON_SUB_VISITOR;
	
	@Column(name="SUB_VISITOR")
	private int SUB_VISITOR;
	
	
	@Column(name="TOTAL_VISITOR")
	private int TOTAL_VISITOR;
	
	@Column(name="NON_SUB_UNIQ_VISITOR")
	private int NON_SUB_UNIQ_VISITOR;
	
	@Column(name="SUB_UNIQ_VISITOR")
	private int SUB_UNIQ_VISITOR;
	
	
	@Column(name="UNIQ_VISITOR")
	private int UNIQ_VISITOR;
	
	
	@Column(name="NEW_REG")
	private int NEW_REG;
	
	
	@Column(name="SUB_USER_MIN")
	private int SUB_USER_MIN;
	
	@Column(name="MONTHLY_SUB_MUSIC")
	private int MONTHLY_SUB_MUSIC;
	
	
	@Column(name="WEEKLY_SUB_MUSIC")
	private int WEEKLY_SUB_MUSIC;
	
	
	@Column(name="DAILY_SUB_MUSIC")
	private int DAILY_SUB_MUSIC;
	
	@Column(name="FREE_TRIAL_MUSIC")
	private int FREE_TRIAL_MUSIC;
	
	@Column(name="MONTHLY_SUB_KARAOKE")
	private int MONTHLY_SUB_KARAOKE;
	
	@Column(name="WEEKLY_SUB_KARAOKE")
	private int WEEKLY_SUB_KARAOKE;
	
	@Column(name="DAILY_SUB_KARAOKE")
	private int DAILY_SUB_KARAOKE;
	
	@Column(name="FREE_TRIAL_KARAOKE")
	private int FREE_TRIAL_KARAOKE;
	
	@Column(name="MONTHLY_SUB_BUNDLE")
	private int MONTHLY_SUB_BUNDLE;
	
	@Column(name="WEEKLY_SUB_BUNDLE")
	private int WEEKLY_SUB_BUNDLE;
	
	@Column(name="DAILY_SUB_BUNDLE")
	private int DAILY_SUB_BUNDLE;
	
	@Column(name="FREE_TRIAL_BUNDLE")
	private int FREE_TRIAL_BUNDLE;
	
	@Column(name="SUB_MODE_IVR")
	private int SUB_MODE_IVR;
	
	@Column(name="SUB_MODE_SMS")
	private int SUB_MODE_SMS;
	
	@Column(name="SUB_MODE_WEB")
	private int SUB_MODE_WEB;
	
	@Column(name="SUB_MODE_TPARTY")
	private int SUB_MODE_TPARTY;
	
	
	@Column(name="SUB_MODE_USSD")
	private int SUB_MODE_USSD;
	
	@Column(name="SUB_MODE_ANDROID")
	private int SUB_MODE_ANDROID;
	
	@Column(name="SUB_MODE_IPHONE")
	private int SUB_MODE_IPHONE;
	
	@Column(name="SUB_MODE_APP")
	private int SUB_MODE_APP;
	
	@Column(name="SUB_MODE_OTHERS")
	private int SUB_MODE_OTHERS;
	
	@Column(name="NEW_SUB_MUSIC_MONTHLY")
	private int NEW_SUB_MUSIC_MONTHLY;
	
	@Column(name="NEW_SUB_MUSIC_WEEKLY")
	private int NEW_SUB_MUSIC_WEEKLY;
	
	@Column(name="NEW_SUB_MUSIC_DAILY")
	private int NEW_SUB_MUSIC_DAILY;
	
	@Column(name="NEW_SUB_KARAOKE_MONTHLY")
	private int NEW_SUB_KARAOKE_MONTHLY;
	
	@Column(name="NEW_SUB_KARAOKE_WEEKLY")
	private int NEW_SUB_KARAOKE_WEEKLY;
	
	@Column(name="NEW_SUB_KARAOKE_DAILY")
	private int NEW_SUB_KARAOKE_DAILY;
	
	@Column(name="NEW_SUB_BUNDLE_MONTHLY")
	private int NEW_SUB_BUNDLE_MONTHLY;
	
	@Column(name="NEW_SUB_BUNDLE_WEEKLY")
	private int NEW_SUB_BUNDLE_WEEKLY;
	
	@Column(name="NEW_SUB_BUNDLE_DAILY")
	private int NEW_SUB_BUNDLE_DAILY;
	
	@Column(name="SUB_MUSIC_FAIL_MONTHLY")
	private int SUB_MUSIC_FAIL_MONTHLY;
	
	@Column(name="SUB_MUSIC_FAIL_WEEKLY")
	private int SUB_MUSIC_FAIL_WEEKLY;
	
	@Column(name="SUB_MUSIC_FAIL_DAILY")
	private int SUB_MUSIC_FAIL_DAILY;
	
	@Column(name="SUB_KARAOKE_FAIL_MONTHLY")
	private int SUB_KARAOKE_FAIL_MONTHLY;
	
	@Column(name="SUB_KARAOKE_FAIL_WEEKLY")
	private int SUB_KARAOKE_FAIL_WEEKLY;
	
	@Column(name="SUB_KARAOKE_FAIL_DAILY")
	private int SUB_KARAOKE_FAIL_DAILY;
	
	@Column(name="SUB_BUNDLE_FAIL_MONTHLY")
	private int SUB_BUNDLE_FAIL_MONTHLY;
	
	@Column(name="SUB_BUNDLE_FAIL_WEEKLY")
	private int SUB_BUNDLE_FAIL_WEEKLY;
	
	@Column(name="SUB_BUNDLE_FAIL_DAILY")
	private int SUB_BUNDLE_FAIL_DAILY;
	
	@Column(name="VOL_CHURN")
	private int VOL_CHURN;
	
	@Column(name="INVOL_CHURN")
	private int INVOL_CHURN;
	
	@Column(name="RESUB_MUSIC_MONTHLY")
	private int RESUB_MUSIC_MONTHLY;
	
	@Column(name="RESUB_MUSIC_WEEKLY")
	private int RESUB_MUSIC_WEEKLY;
	
	@Column(name="RESUB_MUSIC_DAILY")
	private int RESUB_MUSIC_DAILY;
	
	@Column(name="RESUB_KARAOKE_MONTHLY")
	private int RESUB_KARAOKE_MONTHLY;
	
	@Column(name="RESUB_KARAOKE_WEEKLY")
	private int RESUB_KARAOKE_WEEKLY;
	
	@Column(name="RESUB_KARAOKE_DAILY")
	private int RESUB_KARAOKE_DAILY;
	
	@Column(name="RESUB_BUNDLE_MONTHLY")
	private int RESUB_BUNDLE_MONTHLY;
	
	@Column(name="RESUB_BUNDLE_WEEKLY")
	private int RESUB_BUNDLE_WEEKLY;
	
	@Column(name="RESUB_BUNDLE_DAILY")
	private int RESUB_BUNDLE_DAILY;
	
	@Column(name="MUSIC_REV_MONTHLY")
	private int MUSIC_REV_MONTHLY;
	
	@Column(name="MUSIC_REV_WEEKLY")
	private int MUSIC_REV_WEEKLY;
	
	@Column(name="MUSIC_REV_DAILY")
	private int MUSIC_REV_DAILY;
	
	@Column(name="MUSIC_REV_LOCAL")
	private int MUSIC_REV_LOCAL;
	
	@Column(name="MUSIC_REV_USD")
	private int MUSIC_REV_USD;
	
	@Column(name="KARAOKE_REV_MONTHLY")
	private int KARAOKE_REV_MONTHLY;
	
	@Column(name="KARAOKE_REV_WEEKLY")
	private int KARAOKE_REV_WEEKLY;
	
	@Column(name="KARAOKE_REV_DAILY")
	private int KARAOKE_REV_DAILY;
	
	@Column(name="KARAOKE_REV_LOCAL")
	private int KARAOKE_REV_LOCAL;
	
	@Column(name="KARAOKE_REV_USD")
	private int KARAOKE_REV_USD;
	
	@Column(name="BUNDLE_REV_MONTHLY")
	private int BUNDLE_REV_MONTHLY;
	
	@Column(name="BUNDLE_REV_DAILY")
	private int BUNDLE_REV_DAILY;
	
	@Column(name="BUNDLE_REV_LOCAL")
	private int BUNDLE_REV_LOCAL;
	
	@Column(name="BUNDLE_REV_USD")
	private int BUNDLE_REV_USD;
	
	@Column(name="TOTAL_REV_LOCAL")
	private int TOTAL_REV_LOCAL;
	
	@Column(name="TOTAL_REV_USD")
	private int TOTAL_REV_USD;
	
	@Column(name="ACTIVE_SUB_MONTHLY")
	private int ACTIVE_SUB_MONTHLY;
	
	@Column(name="ACTIVE_SUB_WEEKLY")
	private int ACTIVE_SUB_WEEKLY;
	
	@Column(name="ACTIVE_SUB_DAILY")
	private int ACTIVE_SUB_DAILY;
	
	@Column(name="ACTIVE_SUB_TOTAL")
	private int ACTIVE_SUB_TOTAL;
	
	@Column(name="GRACE_1TO7")
	private int GRACE_1TO7;
	
	@Column(name="GRACE_8TO14")
	private int GRACE_8TO14;
	
	@Column(name="GRACE_15TO29")
	private int GRACE_15TO29;
	
	@Column(name="GRACE_30TO44")
	private int GRACE_30TO44;
	
	@Column(name="GRACE_45TO60")
	private int GRACE_45TO60;
	
	@Column(name="GRACE_ABOVE60")
	private int GRACE_ABOVE60;
	
	@Column(name="DATETIME")
	@Temporal(TemporalType.DATE)
	private Date DATETIME;
	
	@Column(name="BUNDLE_REV_WEEKLY")
	private int BUNDLE_REV_WEEKLY;
	
	
	@Transient
	private String sDate;
	
	
	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public int getNON_SUB_VISITOR() {
		return NON_SUB_VISITOR;
	}

	public void setNON_SUB_VISITOR(int nON_SUB_VISITOR) {
		NON_SUB_VISITOR = nON_SUB_VISITOR;
	}

	public int getSUB_VISITOR() {
		return SUB_VISITOR;
	}

	public void setSUB_VISITOR(int sUB_VISITOR) {
		SUB_VISITOR = sUB_VISITOR;
	}

	public int getNON_SUB_UNIQ_VISITOR() {
		return NON_SUB_UNIQ_VISITOR;
	}

	public void setNON_SUB_UNIQ_VISITOR(int nON_SUB_UNIQ_VISITOR) {
		NON_SUB_UNIQ_VISITOR = nON_SUB_UNIQ_VISITOR;
	}

	public int getSUB_UNIQ_VISITOR() {
		return SUB_UNIQ_VISITOR;
	}

	public void setSUB_UNIQ_VISITOR(int sUB_UNIQ_VISITOR) {
		SUB_UNIQ_VISITOR = sUB_UNIQ_VISITOR;
	}

	public int getNEW_REG() {
		return NEW_REG;
	}

	public void setNEW_REG(int nEW_REG) {
		NEW_REG = nEW_REG;
	}

	public int getSUB_USER_MIN() {
		return SUB_USER_MIN;
	}

	public void setSUB_USER_MIN(int sUB_USER_MIN) {
		SUB_USER_MIN = sUB_USER_MIN;
	}

	public int getMONTHLY_SUB_MUSIC() {
		return MONTHLY_SUB_MUSIC;
	}

	public void setMONTHLY_SUB_MUSIC(int mONTHLY_SUB_MUSIC) {
		MONTHLY_SUB_MUSIC = mONTHLY_SUB_MUSIC;
	}

	public int getWEEKLY_SUB_MUSIC() {
		return WEEKLY_SUB_MUSIC;
	}

	public void setWEEKLY_SUB_MUSIC(int wEEKLY_SUB_MUSIC) {
		WEEKLY_SUB_MUSIC = wEEKLY_SUB_MUSIC;
	}

	public int getDAILY_SUB_MUSIC() {
		return DAILY_SUB_MUSIC;
	}

	public void setDAILY_SUB_MUSIC(int dAILY_SUB_MUSIC) {
		DAILY_SUB_MUSIC = dAILY_SUB_MUSIC;
	}

	public int getFREE_TRIAL_MUSIC() {
		return FREE_TRIAL_MUSIC;
	}

	public void setFREE_TRIAL_MUSIC(int fREE_TRIAL_MUSIC) {
		FREE_TRIAL_MUSIC = fREE_TRIAL_MUSIC;
	}

	public int getMONTHLY_SUB_KARAOKE() {
		return MONTHLY_SUB_KARAOKE;
	}

	public void setMONTHLY_SUB_KARAOKE(int mONTHLY_SUB_KARAOKE) {
		MONTHLY_SUB_KARAOKE = mONTHLY_SUB_KARAOKE;
	}

	public int getWEEKLY_SUB_KARAOKE() {
		return WEEKLY_SUB_KARAOKE;
	}

	public void setWEEKLY_SUB_KARAOKE(int wEEKLY_SUB_KARAOKE) {
		WEEKLY_SUB_KARAOKE = wEEKLY_SUB_KARAOKE;
	}

	public int getDAILY_SUB_KARAOKE() {
		return DAILY_SUB_KARAOKE;
	}

	public void setDAILY_SUB_KARAOKE(int dAILY_SUB_KARAOKE) {
		DAILY_SUB_KARAOKE = dAILY_SUB_KARAOKE;
	}

	public int getFREE_TRIAL_KARAOKE() {
		return FREE_TRIAL_KARAOKE;
	}

	public void setFREE_TRIAL_KARAOKE(int fREE_TRIAL_KARAOKE) {
		FREE_TRIAL_KARAOKE = fREE_TRIAL_KARAOKE;
	}

	public int getMONTHLY_SUB_BUNDLE() {
		return MONTHLY_SUB_BUNDLE;
	}

	public void setMONTHLY_SUB_BUNDLE(int mONTHLY_SUB_BUNDLE) {
		MONTHLY_SUB_BUNDLE = mONTHLY_SUB_BUNDLE;
	}

	public int getWEEKLY_SUB_BUNDLE() {
		return WEEKLY_SUB_BUNDLE;
	}

	public void setWEEKLY_SUB_BUNDLE(int wEEKLY_SUB_BUNDLE) {
		WEEKLY_SUB_BUNDLE = wEEKLY_SUB_BUNDLE;
	}

	public int getDAILY_SUB_BUNDLE() {
		return DAILY_SUB_BUNDLE;
	}

	public void setDAILY_SUB_BUNDLE(int dAILY_SUB_BUNDLE) {
		DAILY_SUB_BUNDLE = dAILY_SUB_BUNDLE;
	}

	public int getFREE_TRIAL_BUNDLE() {
		return FREE_TRIAL_BUNDLE;
	}

	public void setFREE_TRIAL_BUNDLE(int fREE_TRIAL_BUNDLE) {
		FREE_TRIAL_BUNDLE = fREE_TRIAL_BUNDLE;
	}

	public int getSUB_MODE_IVR() {
		return SUB_MODE_IVR;
	}

	public void setSUB_MODE_IVR(int sUB_MODE_IVR) {
		SUB_MODE_IVR = sUB_MODE_IVR;
	}

	public int getSUB_MODE_SMS() {
		return SUB_MODE_SMS;
	}

	public void setSUB_MODE_SMS(int sUB_MODE_SMS) {
		SUB_MODE_SMS = sUB_MODE_SMS;
	}

	public int getSUB_MODE_WEB() {
		return SUB_MODE_WEB;
	}

	public void setSUB_MODE_WEB(int sUB_MODE_WEB) {
		SUB_MODE_WEB = sUB_MODE_WEB;
	}

	public int getSUB_MODE_TPARTY() {
		return SUB_MODE_TPARTY;
	}

	public void setSUB_MODE_TPARTY(int sUB_MODE_TPARTY) {
		SUB_MODE_TPARTY = sUB_MODE_TPARTY;
	}

	public int getSUB_MODE_USSD() {
		return SUB_MODE_USSD;
	}

	public void setSUB_MODE_USSD(int sUB_MODE_USSD) {
		SUB_MODE_USSD = sUB_MODE_USSD;
	}

	public int getSUB_MODE_ANDROID() {
		return SUB_MODE_ANDROID;
	}

	public void setSUB_MODE_ANDROID(int sUB_MODE_ANDROID) {
		SUB_MODE_ANDROID = sUB_MODE_ANDROID;
	}

	public int getSUB_MODE_IPHONE() {
		return SUB_MODE_IPHONE;
	}

	public void setSUB_MODE_IPHONE(int sUB_MODE_IPHONE) {
		SUB_MODE_IPHONE = sUB_MODE_IPHONE;
	}

	public int getSUB_MODE_APP() {
		return SUB_MODE_APP;
	}

	public void setSUB_MODE_APP(int sUB_MODE_APP) {
		SUB_MODE_APP = sUB_MODE_APP;
	}

	public int getSUB_MODE_OTHERS() {
		return SUB_MODE_OTHERS;
	}

	public void setSUB_MODE_OTHERS(int sUB_MODE_OTHERS) {
		SUB_MODE_OTHERS = sUB_MODE_OTHERS;
	}

	public int getNEW_SUB_MUSIC_MONTHLY() {
		return NEW_SUB_MUSIC_MONTHLY;
	}

	public void setNEW_SUB_MUSIC_MONTHLY(int nEW_SUB_MUSIC_MONTHLY) {
		NEW_SUB_MUSIC_MONTHLY = nEW_SUB_MUSIC_MONTHLY;
	}

	public int getNEW_SUB_MUSIC_WEEKLY() {
		return NEW_SUB_MUSIC_WEEKLY;
	}

	public void setNEW_SUB_MUSIC_WEEKLY(int nEW_SUB_MUSIC_WEEKLY) {
		NEW_SUB_MUSIC_WEEKLY = nEW_SUB_MUSIC_WEEKLY;
	}

	public int getNEW_SUB_MUSIC_DAILY() {
		return NEW_SUB_MUSIC_DAILY;
	}

	public void setNEW_SUB_MUSIC_DAILY(int nEW_SUB_MUSIC_DAILY) {
		NEW_SUB_MUSIC_DAILY = nEW_SUB_MUSIC_DAILY;
	}

	public int getNEW_SUB_KARAOKE_MONTHLY() {
		return NEW_SUB_KARAOKE_MONTHLY;
	}

	public void setNEW_SUB_KARAOKE_MONTHLY(int nEW_SUB_KARAOKE_MONTHLY) {
		NEW_SUB_KARAOKE_MONTHLY = nEW_SUB_KARAOKE_MONTHLY;
	}

	public int getNEW_SUB_KARAOKE_WEEKLY() {
		return NEW_SUB_KARAOKE_WEEKLY;
	}

	public void setNEW_SUB_KARAOKE_WEEKLY(int nEW_SUB_KARAOKE_WEEKLY) {
		NEW_SUB_KARAOKE_WEEKLY = nEW_SUB_KARAOKE_WEEKLY;
	}

	public int getNEW_SUB_KARAOKE_DAILY() {
		return NEW_SUB_KARAOKE_DAILY;
	}

	public void setNEW_SUB_KARAOKE_DAILY(int nEW_SUB_KARAOKE_DAILY) {
		NEW_SUB_KARAOKE_DAILY = nEW_SUB_KARAOKE_DAILY;
	}

	public int getNEW_SUB_BUNDLE_MONTHLY() {
		return NEW_SUB_BUNDLE_MONTHLY;
	}

	public void setNEW_SUB_BUNDLE_MONTHLY(int nEW_SUB_BUNDLE_MONTHLY) {
		NEW_SUB_BUNDLE_MONTHLY = nEW_SUB_BUNDLE_MONTHLY;
	}

	public int getNEW_SUB_BUNDLE_WEEKLY() {
		return NEW_SUB_BUNDLE_WEEKLY;
	}

	public void setNEW_SUB_BUNDLE_WEEKLY(int nEW_SUB_BUNDLE_WEEKLY) {
		NEW_SUB_BUNDLE_WEEKLY = nEW_SUB_BUNDLE_WEEKLY;
	}

	public int getNEW_SUB_BUNDLE_DAILY() {
		return NEW_SUB_BUNDLE_DAILY;
	}

	public void setNEW_SUB_BUNDLE_DAILY(int nEW_SUB_BUNDLE_DAILY) {
		NEW_SUB_BUNDLE_DAILY = nEW_SUB_BUNDLE_DAILY;
	}

	public int getSUB_MUSIC_FAIL_MONTHLY() {
		return SUB_MUSIC_FAIL_MONTHLY;
	}

	public void setSUB_MUSIC_FAIL_MONTHLY(int sUB_MUSIC_FAIL_MONTHLY) {
		SUB_MUSIC_FAIL_MONTHLY = sUB_MUSIC_FAIL_MONTHLY;
	}

	public int getSUB_MUSIC_FAIL_WEEKLY() {
		return SUB_MUSIC_FAIL_WEEKLY;
	}

	public void setSUB_MUSIC_FAIL_WEEKLY(int sUB_MUSIC_FAIL_WEEKLY) {
		SUB_MUSIC_FAIL_WEEKLY = sUB_MUSIC_FAIL_WEEKLY;
	}

	public int getSUB_MUSIC_FAIL_DAILY() {
		return SUB_MUSIC_FAIL_DAILY;
	}

	public void setSUB_MUSIC_FAIL_DAILY(int sUB_MUSIC_FAIL_DAILY) {
		SUB_MUSIC_FAIL_DAILY = sUB_MUSIC_FAIL_DAILY;
	}

	public int getSUB_KARAOKE_FAIL_MONTHLY() {
		return SUB_KARAOKE_FAIL_MONTHLY;
	}

	public void setSUB_KARAOKE_FAIL_MONTHLY(int sUB_KARAOKE_FAIL_MONTHLY) {
		SUB_KARAOKE_FAIL_MONTHLY = sUB_KARAOKE_FAIL_MONTHLY;
	}

	public int getSUB_KARAOKE_FAIL_WEEKLY() {
		return SUB_KARAOKE_FAIL_WEEKLY;
	}

	public void setSUB_KARAOKE_FAIL_WEEKLY(int sUB_KARAOKE_FAIL_WEEKLY) {
		SUB_KARAOKE_FAIL_WEEKLY = sUB_KARAOKE_FAIL_WEEKLY;
	}

	public int getSUB_KARAOKE_FAIL_DAILY() {
		return SUB_KARAOKE_FAIL_DAILY;
	}

	public void setSUB_KARAOKE_FAIL_DAILY(int sUB_KARAOKE_FAIL_DAILY) {
		SUB_KARAOKE_FAIL_DAILY = sUB_KARAOKE_FAIL_DAILY;
	}

	public int getSUB_BUNDLE_FAIL_MONTHLY() {
		return SUB_BUNDLE_FAIL_MONTHLY;
	}

	public void setSUB_BUNDLE_FAIL_MONTHLY(int sUB_BUNDLE_FAIL_MONTHLY) {
		SUB_BUNDLE_FAIL_MONTHLY = sUB_BUNDLE_FAIL_MONTHLY;
	}

	public int getSUB_BUNDLE_FAIL_WEEKLY() {
		return SUB_BUNDLE_FAIL_WEEKLY;
	}

	public void setSUB_BUNDLE_FAIL_WEEKLY(int sUB_BUNDLE_FAIL_WEEKLY) {
		SUB_BUNDLE_FAIL_WEEKLY = sUB_BUNDLE_FAIL_WEEKLY;
	}

	public int getSUB_BUNDLE_FAIL_DAILY() {
		return SUB_BUNDLE_FAIL_DAILY;
	}

	public void setSUB_BUNDLE_FAIL_DAILY(int sUB_BUNDLE_FAIL_DAILY) {
		SUB_BUNDLE_FAIL_DAILY = sUB_BUNDLE_FAIL_DAILY;
	}

	public int getVOL_CHURN() {
		return VOL_CHURN;
	}

	public void setVOL_CHURN(int vOL_CHURN) {
		VOL_CHURN = vOL_CHURN;
	}

	public int getINVOL_CHURN() {
		return INVOL_CHURN;
	}

	public void setINVOL_CHURN(int iNVOL_CHURN) {
		INVOL_CHURN = iNVOL_CHURN;
	}

	public int getRESUB_MUSIC_MONTHLY() {
		return RESUB_MUSIC_MONTHLY;
	}

	public void setRESUB_MUSIC_MONTHLY(int rESUB_MUSIC_MONTHLY) {
		RESUB_MUSIC_MONTHLY = rESUB_MUSIC_MONTHLY;
	}

	public int getRESUB_MUSIC_WEEKLY() {
		return RESUB_MUSIC_WEEKLY;
	}

	public void setRESUB_MUSIC_WEEKLY(int rESUB_MUSIC_WEEKLY) {
		RESUB_MUSIC_WEEKLY = rESUB_MUSIC_WEEKLY;
	}

	public int getRESUB_MUSIC_DAILY() {
		return RESUB_MUSIC_DAILY;
	}

	public void setRESUB_MUSIC_DAILY(int rESUB_MUSIC_DAILY) {
		RESUB_MUSIC_DAILY = rESUB_MUSIC_DAILY;
	}

	public int getRESUB_KARAOKE_MONTHLY() {
		return RESUB_KARAOKE_MONTHLY;
	}

	public void setRESUB_KARAOKE_MONTHLY(int rESUB_KARAOKE_MONTHLY) {
		RESUB_KARAOKE_MONTHLY = rESUB_KARAOKE_MONTHLY;
	}

	public int getRESUB_KARAOKE_WEEKLY() {
		return RESUB_KARAOKE_WEEKLY;
	}

	public void setRESUB_KARAOKE_WEEKLY(int rESUB_KARAOKE_WEEKLY) {
		RESUB_KARAOKE_WEEKLY = rESUB_KARAOKE_WEEKLY;
	}

	public int getRESUB_KARAOKE_DAILY() {
		return RESUB_KARAOKE_DAILY;
	}

	public void setRESUB_KARAOKE_DAILY(int rESUB_KARAOKE_DAILY) {
		RESUB_KARAOKE_DAILY = rESUB_KARAOKE_DAILY;
	}

	public int getRESUB_BUNDLE_MONTHLY() {
		return RESUB_BUNDLE_MONTHLY;
	}

	public void setRESUB_BUNDLE_MONTHLY(int rESUB_BUNDLE_MONTHLY) {
		RESUB_BUNDLE_MONTHLY = rESUB_BUNDLE_MONTHLY;
	}

	public int getRESUB_BUNDLE_WEEKLY() {
		return RESUB_BUNDLE_WEEKLY;
	}

	public void setRESUB_BUNDLE_WEEKLY(int rESUB_BUNDLE_WEEKLY) {
		RESUB_BUNDLE_WEEKLY = rESUB_BUNDLE_WEEKLY;
	}

	public int getRESUB_BUNDLE_DAILY() {
		return RESUB_BUNDLE_DAILY;
	}

	public void setRESUB_BUNDLE_DAILY(int rESUB_BUNDLE_DAILY) {
		RESUB_BUNDLE_DAILY = rESUB_BUNDLE_DAILY;
	}

	public int getMUSIC_REV_MONTHLY() {
		return MUSIC_REV_MONTHLY;
	}

	public void setMUSIC_REV_MONTHLY(int mUSIC_REV_MONTHLY) {
		MUSIC_REV_MONTHLY = mUSIC_REV_MONTHLY;
	}

	public int getMUSIC_REV_WEEKLY() {
		return MUSIC_REV_WEEKLY;
	}

	public void setMUSIC_REV_WEEKLY(int mUSIC_REV_WEEKLY) {
		MUSIC_REV_WEEKLY = mUSIC_REV_WEEKLY;
	}

	public int getMUSIC_REV_DAILY() {
		return MUSIC_REV_DAILY;
	}

	public void setMUSIC_REV_DAILY(int mUSIC_REV_DAILY) {
		MUSIC_REV_DAILY = mUSIC_REV_DAILY;
	}

	public int getMUSIC_REV_LOCAL() {
		return MUSIC_REV_LOCAL;
	}

	public void setMUSIC_REV_LOCAL(int mUSIC_REV_LOCAL) {
		MUSIC_REV_LOCAL = mUSIC_REV_LOCAL;
	}

	public int getMUSIC_REV_USD() {
		return MUSIC_REV_USD;
	}

	public void setMUSIC_REV_USD(int mUSIC_REV_USD) {
		MUSIC_REV_USD = mUSIC_REV_USD;
	}

	public int getKARAOKE_REV_MONTHLY() {
		return KARAOKE_REV_MONTHLY;
	}

	public void setKARAOKE_REV_MONTHLY(int kARAOKE_REV_MONTHLY) {
		KARAOKE_REV_MONTHLY = kARAOKE_REV_MONTHLY;
	}

	public int getKARAOKE_REV_WEEKLY() {
		return KARAOKE_REV_WEEKLY;
	}

	public void setKARAOKE_REV_WEEKLY(int kARAOKE_REV_WEEKLY) {
		KARAOKE_REV_WEEKLY = kARAOKE_REV_WEEKLY;
	}

	public int getKARAOKE_REV_DAILY() {
		return KARAOKE_REV_DAILY;
	}

	public void setKARAOKE_REV_DAILY(int kARAOKE_REV_DAILY) {
		KARAOKE_REV_DAILY = kARAOKE_REV_DAILY;
	}

	public int getKARAOKE_REV_LOCAL() {
		return KARAOKE_REV_LOCAL;
	}

	public void setKARAOKE_REV_LOCAL(int kARAOKE_REV_LOCAL) {
		KARAOKE_REV_LOCAL = kARAOKE_REV_LOCAL;
	}

	public int getKARAOKE_REV_USD() {
		return KARAOKE_REV_USD;
	}

	public void setKARAOKE_REV_USD(int kARAOKE_REV_USD) {
		KARAOKE_REV_USD = kARAOKE_REV_USD;
	}

	public int getBUNDLE_REV_MONTHLY() {
		return BUNDLE_REV_MONTHLY;
	}

	public void setBUNDLE_REV_MONTHLY(int bUNDLE_REV_MONTHLY) {
		BUNDLE_REV_MONTHLY = bUNDLE_REV_MONTHLY;
	}

	public int getBUNDLE_REV_DAILY() {
		return BUNDLE_REV_DAILY;
	}

	public void setBUNDLE_REV_DAILY(int bUNDLE_REV_DAILY) {
		BUNDLE_REV_DAILY = bUNDLE_REV_DAILY;
	}

	public int getBUNDLE_REV_LOCAL() {
		return BUNDLE_REV_LOCAL;
	}

	public void setBUNDLE_REV_LOCAL(int bUNDLE_REV_LOCAL) {
		BUNDLE_REV_LOCAL = bUNDLE_REV_LOCAL;
	}

	public int getBUNDLE_REV_USD() {
		return BUNDLE_REV_USD;
	}

	public void setBUNDLE_REV_USD(int bUNDLE_REV_USD) {
		BUNDLE_REV_USD = bUNDLE_REV_USD;
	}

	public int getTOTAL_REV_LOCAL() {
		return TOTAL_REV_LOCAL;
	}

	public void setTOTAL_REV_LOCAL(int tOTAL_REV_LOCAL) {
		TOTAL_REV_LOCAL = tOTAL_REV_LOCAL;
	}

	public int getTOTAL_REV_USD() {
		return TOTAL_REV_USD;
	}

	public void setTOTAL_REV_USD(int tOTAL_REV_USD) {
		TOTAL_REV_USD = tOTAL_REV_USD;
	}

	public int getACTIVE_SUB_MONTHLY() {
		return ACTIVE_SUB_MONTHLY;
	}

	public void setACTIVE_SUB_MONTHLY(int aCTIVE_SUB_MONTHLY) {
		ACTIVE_SUB_MONTHLY = aCTIVE_SUB_MONTHLY;
	}

	public int getACTIVE_SUB_WEEKLY() {
		return ACTIVE_SUB_WEEKLY;
	}

	public void setACTIVE_SUB_WEEKLY(int aCTIVE_SUB_WEEKLY) {
		ACTIVE_SUB_WEEKLY = aCTIVE_SUB_WEEKLY;
	}

	public int getACTIVE_SUB_DAILY() {
		return ACTIVE_SUB_DAILY;
	}

	public void setACTIVE_SUB_DAILY(int aCTIVE_SUB_DAILY) {
		ACTIVE_SUB_DAILY = aCTIVE_SUB_DAILY;
	}

	public int getACTIVE_SUB_TOTAL() {
		return ACTIVE_SUB_TOTAL;
	}

	public void setACTIVE_SUB_TOTAL(int aCTIVE_SUB_TOTAL) {
		ACTIVE_SUB_TOTAL = aCTIVE_SUB_TOTAL;
	}

	public int getGRACE_1TO7() {
		return GRACE_1TO7;
	}

	public void setGRACE_1TO7(int gRACE_1TO7) {
		GRACE_1TO7 = gRACE_1TO7;
	}

	public int getGRACE_8TO14() {
		return GRACE_8TO14;
	}

	public void setGRACE_8TO14(int gRACE_8TO14) {
		GRACE_8TO14 = gRACE_8TO14;
	}

	public int getGRACE_15TO29() {
		return GRACE_15TO29;
	}

	public void setGRACE_15TO29(int gRACE_15TO29) {
		GRACE_15TO29 = gRACE_15TO29;
	}

	public int getGRACE_30TO44() {
		return GRACE_30TO44;
	}

	public void setGRACE_30TO44(int gRACE_30TO44) {
		GRACE_30TO44 = gRACE_30TO44;
	}

	public int getGRACE_45TO60() {
		return GRACE_45TO60;
	}

	public void setGRACE_45TO60(int gRACE_45TO60) {
		GRACE_45TO60 = gRACE_45TO60;
	}

	public int getGRACE_ABOVE60() {
		return GRACE_ABOVE60;
	}

	public void setGRACE_ABOVE60(int gRACE_ABOVE60) {
		GRACE_ABOVE60 = gRACE_ABOVE60;
	}

	public Date getDATETIME() {
		return DATETIME;
	}

	public void setDATETIME(Date dATETIME) {
		DATETIME = dATETIME;
	}

	public int getBUNDLE_REV_WEEKLY() {
		return BUNDLE_REV_WEEKLY;
	}

	public void setBUNDLE_REV_WEEKLY(int bUNDLE_REV_WEEKLY) {
		BUNDLE_REV_WEEKLY = bUNDLE_REV_WEEKLY;
	}

	public int getTOTAL_VISITOR() {
		return TOTAL_VISITOR;
	}

	public void setTOTAL_VISITOR(int tOTAL_VISITOR) {
		TOTAL_VISITOR = tOTAL_VISITOR;
	}

	public int getUNIQ_VISITOR() {
		return UNIQ_VISITOR;
	}

	public void setUNIQ_VISITOR(int uNIQ_VISITOR) {
		UNIQ_VISITOR = uNIQ_VISITOR;
	}
	
	
	
	
	
	
}
