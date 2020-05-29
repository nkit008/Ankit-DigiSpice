package com.digispice.cci.zambia.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="TBL_BILLING_MIS_DATA")
public class ZamtelGamesMISEntity {
	
	@Id
	@Column(name="TRANS_ID")
	private int id;
	
	@Column(name="INSERT_DATE_TIME")
	private Date date;
	
	@Column(name="VAR_TOTAL_BASE")
	private int totalBase;
	
	@Column(name="VAR_ACTIVE_BASE")
	private int activeBase;
	
	@Column(name="VAR_TOTAL_REQ")
	private int totalSubscriptionRequestsReceived;
	
	@Column(name="TOTAL_SEC_CONSENT")
	private int totalSecondConsentReceived;
	
	@Column(name="VAR_TOTAL_REQ_PROCESSED_WAP")
	private int totalRequestProcessWAP;
	
	@Column(name="VAR_TOTAL_REQ_PROCESSED_SMS")
	private int totalRequestProcessSMS;
	
	@Column(name="VAR_TOTAL_REQ_PROCESSED_USSD")
	private int totalRequestProcessUSSD;
	
	@Column(name="VAR_TOTAL_REQ_PROCESSED")
	private int totalSubscriptionRequestsProcessed;
	
	@Column(name="VAR_GROSS_ADDS")
	private int totalGrossAdds;
	
	@Column(name="VAR_TOTAL_UNSUB_VOL")
	private int voluntaryChurn;
	
	@Column(name="VAR_TOTAL_UNSUB_WAP")
	private int wapMode;
	
	@Column(name="VAR_TOTAL_UNSUB_SMS")
	private int smsMode;
	
	@Column(name="VAR_TOTAL_UNSUB_USSD")
	private int ussdMode;
	
	@Column(name="VAR_TOTAL_UNSUB_INV")
	private int involuntaryChurn;
	
	@Column(name="VAR_TOTAL_UNSUB_TOTAL")
	private int totalChurn;
	
	@Column(name="VAR_NET_ADDS")
	private int netAdds;
	
	@Column(name="VAR_TOTAL_REV")
	private int totalRevenueInZK;
	
	@Column(name="VAR_TOTAL_SUB_REV")
	private int subscriptionRevenue;
	
	@Column(name="VAR_TOTAL_RESUB_REV")
	private int resubscriptionRevenue;
	
	@Column(name="VAR_TOTAL_SUB_REV_SMS")
	private int subRevenueFromSMS;
	
	@Column(name="VAR_TOTAL_SUB_REV_WAP")
	private int subRevenueFromWAP;
	
	@Column(name="VAR_TOTAL_SUB_REV_USSD")
	private int subRevenueFromUSSD;
	
	@Column(name="TOTAL_PAGE_VIEW")
	private int totalPageViews;
	
	@Column(name="TOTAL_VISIT")
	private int totalVisits;
	
	@Column(name="TOTAL_UNIQUE_VISIT")
	private int uniqueVisitors;
	
	@Column(name="VAR_TOTAL_SUB_REV_DAILY")
	private int dailySubscription;
	
	@Column(name="VAR_TOTAL_SUB_REV_WEEKLY")
	private int weeklySubscription;
	
	@Column(name="VAR_TOTAL_SUB_REV_MONTHLY")
	private int monthlySubscription;
	
	@Column(name="VAR_TOTAL_RESUB_REV_DAILY")
	private int dailyReSubscription;
	
	@Column(name="VAR_TOTAL_RESUB_REV_WEEKLY")
	private int weeklyReSubscription;
	
	@Column(name="VAR_TOTAL_RESUB_REV_MONTHLY")
	private int monthlyReSubscription;
	
	@Column(name="CAT_DOWN_REQ")
	private int totalCategoryWiseDownloadRequest;
	
	@Column(name="ANDROID_GAME_REQ")
	private int androidGamesRequest;
	
	@Column(name="HTML_GAME_REQ")
	private int HTML5GamesRequest;
	
	@Column(name="CAT_DOWN_SUCCESS")
	private int totalCategoryWiseDownloadSuccess;
	
	@Column(name="ANDROID_GAME_SUCCESS")
	private int androidGamesSuccess;
	
	@Column(name="HTML_GAME_SUCCESS")
	private int html5GamesSuccess;
	
	@Transient
	private String sDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotalBase() {
		return totalBase;
	}

	public void setTotalBase(int totalBase) {
		this.totalBase = totalBase;
	}

	public int getActiveBase() {
		return activeBase;
	}

	public void setActiveBase(int activeBase) {
		this.activeBase = activeBase;
	}

	public int getTotalSubscriptionRequestsReceived() {
		return totalSubscriptionRequestsReceived;
	}

	public void setTotalSubscriptionRequestsReceived(int totalSubscriptionRequestsReceived) {
		this.totalSubscriptionRequestsReceived = totalSubscriptionRequestsReceived;
	}

	public int getTotalSecondConsentReceived() {
		return totalSecondConsentReceived;
	}

	public void setTotalSecondConsentReceived(int totalSecondConsentReceived) {
		this.totalSecondConsentReceived = totalSecondConsentReceived;
	}

	public int getTotalRequestProcessWAP() {
		return totalRequestProcessWAP;
	}

	public void setTotalRequestProcessWAP(int totalRequestProcessWAP) {
		this.totalRequestProcessWAP = totalRequestProcessWAP;
	}

	public int getTotalRequestProcessSMS() {
		return totalRequestProcessSMS;
	}

	public void setTotalRequestProcessSMS(int totalRequestProcessSMS) {
		this.totalRequestProcessSMS = totalRequestProcessSMS;
	}

	public int getTotalRequestProcessUSSD() {
		return totalRequestProcessUSSD;
	}

	public void setTotalRequestProcessUSSD(int totalRequestProcessUSSD) {
		this.totalRequestProcessUSSD = totalRequestProcessUSSD;
	}

	public int getTotalSubscriptionRequestsProcessed() {
		return totalSubscriptionRequestsProcessed;
	}

	public void setTotalSubscriptionRequestsProcessed(int totalSubscriptionRequestsProcessed) {
		this.totalSubscriptionRequestsProcessed = totalSubscriptionRequestsProcessed;
	}

	public int getTotalGrossAdds() {
		return totalGrossAdds;
	}

	public void setTotalGrossAdds(int totalGrossAdds) {
		this.totalGrossAdds = totalGrossAdds;
	}

	public int getVoluntaryChurn() {
		return voluntaryChurn;
	}

	public void setVoluntaryChurn(int voluntaryChurn) {
		this.voluntaryChurn = voluntaryChurn;
	}

	public int getWapMode() {
		return wapMode;
	}

	public void setWapMode(int wapMode) {
		this.wapMode = wapMode;
	}

	public int getSmsMode() {
		return smsMode;
	}

	public void setSmsMode(int smsMode) {
		this.smsMode = smsMode;
	}

	public int getUssdMode() {
		return ussdMode;
	}

	public void setUssdMode(int ussdMode) {
		this.ussdMode = ussdMode;
	}

	public int getInvoluntaryChurn() {
		return involuntaryChurn;
	}

	public void setInvoluntaryChurn(int involuntaryChurn) {
		this.involuntaryChurn = involuntaryChurn;
	}

	public int getTotalChurn() {
		return totalChurn;
	}

	public void setTotalChurn(int totalChurn) {
		this.totalChurn = totalChurn;
	}

	public int getNetAdds() {
		return netAdds;
	}

	public void setNetAdds(int netAdds) {
		this.netAdds = netAdds;
	}

	public int getTotalRevenueInZK() {
		return totalRevenueInZK;
	}

	public void setTotalRevenueInZK(int totalRevenueInZK) {
		this.totalRevenueInZK = totalRevenueInZK;
	}

	public int getSubscriptionRevenue() {
		return subscriptionRevenue;
	}

	public void setSubscriptionRevenue(int subscriptionRevenue) {
		this.subscriptionRevenue = subscriptionRevenue;
	}

	public int getResubscriptionRevenue() {
		return resubscriptionRevenue;
	}

	public void setResubscriptionRevenue(int resubscriptionRevenue) {
		this.resubscriptionRevenue = resubscriptionRevenue;
	}

	public int getSubRevenueFromSMS() {
		return subRevenueFromSMS;
	}

	public void setSubRevenueFromSMS(int subRevenueFromSMS) {
		this.subRevenueFromSMS = subRevenueFromSMS;
	}

	public int getSubRevenueFromWAP() {
		return subRevenueFromWAP;
	}

	public void setSubRevenueFromWAP(int subRevenueFromWAP) {
		this.subRevenueFromWAP = subRevenueFromWAP;
	}

	public int getSubRevenueFromUSSD() {
		return subRevenueFromUSSD;
	}

	public void setSubRevenueFromUSSD(int subRevenueFromUSSD) {
		this.subRevenueFromUSSD = subRevenueFromUSSD;
	}

	public int getTotalPageViews() {
		return totalPageViews;
	}

	public void setTotalPageViews(int totalPageViews) {
		this.totalPageViews = totalPageViews;
	}

	public int getTotalVisits() {
		return totalVisits;
	}

	public void setTotalVisits(int totalVisits) {
		this.totalVisits = totalVisits;
	}

	public int getUniqueVisitors() {
		return uniqueVisitors;
	}

	public void setUniqueVisitors(int uniqueVisitors) {
		this.uniqueVisitors = uniqueVisitors;
	}

	public int getDailySubscription() {
		return dailySubscription;
	}

	public void setDailySubscription(int dailySubscription) {
		this.dailySubscription = dailySubscription;
	}

	public int getWeeklySubscription() {
		return weeklySubscription;
	}

	public void setWeeklySubscription(int weeklySubscription) {
		this.weeklySubscription = weeklySubscription;
	}

	public int getMonthlySubscription() {
		return monthlySubscription;
	}

	public void setMonthlySubscription(int monthlySubscription) {
		this.monthlySubscription = monthlySubscription;
	}

	public int getDailyReSubscription() {
		return dailyReSubscription;
	}

	public void setDailyReSubscription(int dailyReSubscription) {
		this.dailyReSubscription = dailyReSubscription;
	}

	public int getWeeklyReSubscription() {
		return weeklyReSubscription;
	}

	public void setWeeklyReSubscription(int weeklyReSubscription) {
		this.weeklyReSubscription = weeklyReSubscription;
	}

	public int getMonthlyReSubscription() {
		return monthlyReSubscription;
	}

	public void setMonthlyReSubscription(int monthlyReSubscription) {
		this.monthlyReSubscription = monthlyReSubscription;
	}

	public int getTotalCategoryWiseDownloadRequest() {
		return totalCategoryWiseDownloadRequest;
	}

	public void setTotalCategoryWiseDownloadRequest(int totalCategoryWiseDownloadRequest) {
		this.totalCategoryWiseDownloadRequest = totalCategoryWiseDownloadRequest;
	}

	public int getAndroidGamesRequest() {
		return androidGamesRequest;
	}

	public void setAndroidGamesRequest(int androidGamesRequest) {
		this.androidGamesRequest = androidGamesRequest;
	}

	public int getHTML5GamesRequest() {
		return HTML5GamesRequest;
	}

	public void setHTML5GamesRequest(int hTML5GamesRequest) {
		HTML5GamesRequest = hTML5GamesRequest;
	}

	public int getTotalCategoryWiseDownloadSuccess() {
		return totalCategoryWiseDownloadSuccess;
	}

	public void setTotalCategoryWiseDownloadSuccess(int totalCategoryWiseDownloadSuccess) {
		this.totalCategoryWiseDownloadSuccess = totalCategoryWiseDownloadSuccess;
	}

	public int getAndroidGamesSuccess() {
		return androidGamesSuccess;
	}

	public void setAndroidGamesSuccess(int androidGamesSuccess) {
		this.androidGamesSuccess = androidGamesSuccess;
	}

	public int getHtml5GamesSuccess() {
		return html5GamesSuccess;
	}

	public void setHtml5GamesSuccess(int html5GamesSuccess) {
		this.html5GamesSuccess = html5GamesSuccess;
	}
	
	

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	@Override
	public String toString() {
		return "ZamtelGamesMISEntity [id=" + id + ", date=" + date + ", totalBase=" + totalBase + ", activeBase="
				+ activeBase + ", totalSubscriptionRequestsReceived=" + totalSubscriptionRequestsReceived
				+ ", totalSecondConsentReceived=" + totalSecondConsentReceived + ", totalRequestProcessWAP="
				+ totalRequestProcessWAP + ", totalRequestProcessSMS=" + totalRequestProcessSMS
				+ ", totalRequestProcessUSSD=" + totalRequestProcessUSSD + ", totalSubscriptionRequestsProcessed="
				+ totalSubscriptionRequestsProcessed + ", totalGrossAdds=" + totalGrossAdds + ", voluntaryChurn="
				+ voluntaryChurn + ", wapMode=" + wapMode + ", smsMode=" + smsMode + ", ussdMode=" + ussdMode
				+ ", involuntaryChurn=" + involuntaryChurn + ", totalChurn=" + totalChurn + ", netAdds=" + netAdds
				+ ", totalRevenueInZK=" + totalRevenueInZK + ", subscriptionRevenue=" + subscriptionRevenue
				+ ", resubscriptionRevenue=" + resubscriptionRevenue + ", subRevenueFromSMS=" + subRevenueFromSMS
				+ ", subRevenueFromWAP=" + subRevenueFromWAP + ", subRevenueFromUSSD=" + subRevenueFromUSSD
				+ ", totalPageViews=" + totalPageViews + ", totalVisits=" + totalVisits + ", uniqueVisitors="
				+ uniqueVisitors + ", dailySubscription=" + dailySubscription + ", weeklySubscription="
				+ weeklySubscription + ", monthlySubscription=" + monthlySubscription + ", dailyReSubscription="
				+ dailyReSubscription + ", weeklyReSubscription=" + weeklyReSubscription + ", monthlyReSubscription="
				+ monthlyReSubscription + ", totalCategoryWiseDownloadRequest=" + totalCategoryWiseDownloadRequest
				+ ", androidGamesRequest=" + androidGamesRequest + ", HTML5GamesRequest=" + HTML5GamesRequest
				+ ", totalCategoryWiseDownloadSuccess=" + totalCategoryWiseDownloadSuccess + ", androidGamesSuccess="
				+ androidGamesSuccess + ", html5GamesSuccess=" + html5GamesSuccess + "]";
	}
	

	
	

}
