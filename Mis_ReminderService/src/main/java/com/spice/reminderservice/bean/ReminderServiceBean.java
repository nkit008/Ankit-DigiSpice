package com.spice.reminderservice.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_remainder_mis")
public class ReminderServiceBean {
	
	@Id
	@GeneratedValue
	private int id;
	private String date;
	private long total_hits;
	private long hits_live_call;
	private long hits_nonlive_call;
	private long total_session;
	private long session_live_call;
	private long session_nonlive_call;
	private long total_uniq_call;
	private long uniq_live_call;
	private long uniq_nonlive_call;
	private long uniq_call_mtd;
	private long uniq_live_call_mtd;
	private long obd_sub_req_10;
	private long obd_sub_req_5;
	private long obd_sub_req_2;
	private long obd_succ_sub_10;
	private long obd_succ_sub_5;
	private long obd_succ_sub_2;
	private long ussd_sub_req_10;
	private long ussd_sub_req_5;
	private long ussd_sub_req_2;
	private long ussd_succ_sub_10;
	private long ussd_succ_sub_5;
	private long ussd_succ_sub_2;
	private long total_sub_retry_10;
	private long total_sub_retry_5;
	private long total_sub_retry_2;
	private long total_retry_succ_10;
	private long total_retry_succ_5;
	private long total_retry_succ_2;
	private long total_retry_succ;
	private long total_sub_req_10;
	private long total_sub_req_5;
	private long total_sub_req_2;
	private long total_sub_succ_10;
	private long total_sub_succ_5;
	private long total_sub_succ_2;
	private long total_sub_succ;
	private long renew_req_10;
	private long renew_req_5;
	private long renew_req_2;
	private long renew_succ_10;
	private long renew_succ_5;
	private long renew_succ_2;
	private String cci_churn;
	private String ussd_churn;
	private String others_churn;
	private String voluntary_churn;
	private String involuntary_churn;
	private String total_churn;
	private long total_reminder;
	private long uniq_reminder;
	private long no_of_reminder_set;
	private long no_of_greetings_send_to_user;
	private long reminder_per_user;
	private long sub_revenue_10;
	private long sub_revenue_5;
	private long sub_revenue_2;
	private long total_sub_revenue;
	private long renewal_revenue_10;
	private long renewal_revenue_5;
	private long renewal_revenue_2;
	private long total_renewal_revenue;
	private long total_revenue;
	private String net_addition;
	private String active_base;
	private String grace_base;
	private String retry_base;
	private String arpu;
	private String hits_per_uniq_user;
	private String hits_per_uniq_live_user;
	private String session_per_uniq_user;
	private String session_per_uniq_live_user;
	private String session_per_call;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getTotal_hits() {
		return total_hits;
	}
	public void setTotal_hits(long total_hits) {
		this.total_hits = total_hits;
	}
	public long getHits_live_call() {
		return hits_live_call;
	}
	public void setHits_live_call(long hits_live_call) {
		this.hits_live_call = hits_live_call;
	}
	public long getHits_nonlive_call() {
		return hits_nonlive_call;
	}
	public void setHits_nonlive_call(long hits_nonlive_call) {
		this.hits_nonlive_call = hits_nonlive_call;
	}
	public long getTotal_session() {
		return total_session;
	}
	public void setTotal_session(long total_session) {
		this.total_session = total_session;
	}
	public long getSession_live_call() {
		return session_live_call;
	}
	public void setSession_live_call(long session_live_call) {
		this.session_live_call = session_live_call;
	}
	public long getSession_nonlive_call() {
		return session_nonlive_call;
	}
	public void setSession_nonlive_call(long session_nonlive_call) {
		this.session_nonlive_call = session_nonlive_call;
	}
	public long getTotal_uniq_call() {
		return total_uniq_call;
	}
	public void setTotal_uniq_call(long total_uniq_call) {
		this.total_uniq_call = total_uniq_call;
	}
	public long getUniq_live_call() {
		return uniq_live_call;
	}
	public void setUniq_live_call(long uniq_live_call) {
		this.uniq_live_call = uniq_live_call;
	}
	public long getUniq_nonlive_call() {
		return uniq_nonlive_call;
	}
	public void setUniq_nonlive_call(long uniq_nonlive_call) {
		this.uniq_nonlive_call = uniq_nonlive_call;
	}
	public long getUniq_call_mtd() {
		return uniq_call_mtd;
	}
	public void setUniq_call_mtd(long uniq_call_mtd) {
		this.uniq_call_mtd = uniq_call_mtd;
	}
	public long getUniq_live_call_mtd() {
		return uniq_live_call_mtd;
	}
	public void setUniq_live_call_mtd(long uniq_live_call_mtd) {
		this.uniq_live_call_mtd = uniq_live_call_mtd;
	}
	public long getObd_sub_req_10() {
		return obd_sub_req_10;
	}
	public void setObd_sub_req_10(long obd_sub_req_10) {
		this.obd_sub_req_10 = obd_sub_req_10;
	}
	public long getObd_sub_req_5() {
		return obd_sub_req_5;
	}
	public void setObd_sub_req_5(long obd_sub_req_5) {
		this.obd_sub_req_5 = obd_sub_req_5;
	}
	public long getObd_sub_req_2() {
		return obd_sub_req_2;
	}
	public void setObd_sub_req_2(long obd_sub_req_2) {
		this.obd_sub_req_2 = obd_sub_req_2;
	}
	public long getObd_succ_sub_10() {
		return obd_succ_sub_10;
	}
	public void setObd_succ_sub_10(long obd_succ_sub_10) {
		this.obd_succ_sub_10 = obd_succ_sub_10;
	}
	public long getObd_succ_sub_5() {
		return obd_succ_sub_5;
	}
	public void setObd_succ_sub_5(long obd_succ_sub_5) {
		this.obd_succ_sub_5 = obd_succ_sub_5;
	}
	public long getObd_succ_sub_2() {
		return obd_succ_sub_2;
	}
	public void setObd_succ_sub_2(long obd_succ_sub_2) {
		this.obd_succ_sub_2 = obd_succ_sub_2;
	}
	public long getUssd_sub_req_10() {
		return ussd_sub_req_10;
	}
	public void setUssd_sub_req_10(long ussd_sub_req_10) {
		this.ussd_sub_req_10 = ussd_sub_req_10;
	}
	public long getUssd_sub_req_5() {
		return ussd_sub_req_5;
	}
	public void setUssd_sub_req_5(long ussd_sub_req_5) {
		this.ussd_sub_req_5 = ussd_sub_req_5;
	}
	public long getUssd_sub_req_2() {
		return ussd_sub_req_2;
	}
	public void setUssd_sub_req_2(long ussd_sub_req_2) {
		this.ussd_sub_req_2 = ussd_sub_req_2;
	}
	public long getUssd_succ_sub_10() {
		return ussd_succ_sub_10;
	}
	public void setUssd_succ_sub_10(long ussd_succ_sub_10) {
		this.ussd_succ_sub_10 = ussd_succ_sub_10;
	}
	public long getUssd_succ_sub_5() {
		return ussd_succ_sub_5;
	}
	public void setUssd_succ_sub_5(long ussd_succ_sub_5) {
		this.ussd_succ_sub_5 = ussd_succ_sub_5;
	}
	public long getUssd_succ_sub_2() {
		return ussd_succ_sub_2;
	}
	public void setUssd_succ_sub_2(long ussd_succ_sub_2) {
		this.ussd_succ_sub_2 = ussd_succ_sub_2;
	}
	public long getTotal_sub_retry_10() {
		return total_sub_retry_10;
	}
	public void setTotal_sub_retry_10(long total_sub_retry_10) {
		this.total_sub_retry_10 = total_sub_retry_10;
	}
	public long getTotal_sub_retry_5() {
		return total_sub_retry_5;
	}
	public void setTotal_sub_retry_5(long total_sub_retry_5) {
		this.total_sub_retry_5 = total_sub_retry_5;
	}
	public long getTotal_sub_retry_2() {
		return total_sub_retry_2;
	}
	public void setTotal_sub_retry_2(long total_sub_retry_2) {
		this.total_sub_retry_2 = total_sub_retry_2;
	}
	public long getTotal_retry_succ_10() {
		return total_retry_succ_10;
	}
	public void setTotal_retry_succ_10(long total_retry_succ_10) {
		this.total_retry_succ_10 = total_retry_succ_10;
	}
	public long getTotal_retry_succ_5() {
		return total_retry_succ_5;
	}
	public void setTotal_retry_succ_5(long total_retry_succ_5) {
		this.total_retry_succ_5 = total_retry_succ_5;
	}
	public long getTotal_retry_succ_2() {
		return total_retry_succ_2;
	}
	public void setTotal_retry_succ_2(long total_retry_succ_2) {
		this.total_retry_succ_2 = total_retry_succ_2;
	}
	public long getTotal_retry_succ() {
		return total_retry_succ;
	}
	public void setTotal_retry_succ(long total_retry_succ) {
		this.total_retry_succ = total_retry_succ;
	}
	public long getTotal_sub_req_10() {
		return total_sub_req_10;
	}
	public void setTotal_sub_req_10(long total_sub_req_10) {
		this.total_sub_req_10 = total_sub_req_10;
	}
	public long getTotal_sub_req_5() {
		return total_sub_req_5;
	}
	public void setTotal_sub_req_5(long total_sub_req_5) {
		this.total_sub_req_5 = total_sub_req_5;
	}
	public long getTotal_sub_req_2() {
		return total_sub_req_2;
	}
	public void setTotal_sub_req_2(long total_sub_req_2) {
		this.total_sub_req_2 = total_sub_req_2;
	}
	public long getTotal_sub_succ_10() {
		return total_sub_succ_10;
	}
	public void setTotal_sub_succ_10(long total_sub_succ_10) {
		this.total_sub_succ_10 = total_sub_succ_10;
	}
	public long getTotal_sub_succ_5() {
		return total_sub_succ_5;
	}
	public void setTotal_sub_succ_5(long total_sub_succ_5) {
		this.total_sub_succ_5 = total_sub_succ_5;
	}
	public long getTotal_sub_succ_2() {
		return total_sub_succ_2;
	}
	public void setTotal_sub_succ_2(long total_sub_succ_2) {
		this.total_sub_succ_2 = total_sub_succ_2;
	}
	public long getTotal_sub_succ() {
		return total_sub_succ;
	}
	public void setTotal_sub_succ(long total_sub_succ) {
		this.total_sub_succ = total_sub_succ;
	}
	public long getRenew_req_10() {
		return renew_req_10;
	}
	public void setRenew_req_10(long renew_req_10) {
		this.renew_req_10 = renew_req_10;
	}
	public long getRenew_req_5() {
		return renew_req_5;
	}
	public void setRenew_req_5(long renew_req_5) {
		this.renew_req_5 = renew_req_5;
	}
	public long getRenew_req_2() {
		return renew_req_2;
	}
	public void setRenew_req_2(long renew_req_2) {
		this.renew_req_2 = renew_req_2;
	}
	public long getRenew_succ_10() {
		return renew_succ_10;
	}
	public void setRenew_succ_10(long renew_succ_10) {
		this.renew_succ_10 = renew_succ_10;
	}
	public long getRenew_succ_5() {
		return renew_succ_5;
	}
	public void setRenew_succ_5(long renew_succ_5) {
		this.renew_succ_5 = renew_succ_5;
	}
	public long getRenew_succ_2() {
		return renew_succ_2;
	}
	public void setRenew_succ_2(long renew_succ_2) {
		this.renew_succ_2 = renew_succ_2;
	}
	public String getCci_churn() {
		return cci_churn;
	}
	public void setCci_churn(String cci_churn) {
		this.cci_churn = cci_churn;
	}
	public String getUssd_churn() {
		return ussd_churn;
	}
	public void setUssd_churn(String ussd_churn) {
		this.ussd_churn = ussd_churn;
	}
	public String getOthers_churn() {
		return others_churn;
	}
	public void setOthers_churn(String others_churn) {
		this.others_churn = others_churn;
	}
	public String getVoluntary_churn() {
		return voluntary_churn;
	}
	public void setVoluntary_churn(String voluntary_churn) {
		this.voluntary_churn = voluntary_churn;
	}
	public String getInvoluntary_churn() {
		return involuntary_churn;
	}
	public void setInvoluntary_churn(String involuntary_churn) {
		this.involuntary_churn = involuntary_churn;
	}
	public String getTotal_churn() {
		return total_churn;
	}
	public void setTotal_churn(String total_churn) {
		this.total_churn = total_churn;
	}
	public long getTotal_reminder() {
		return total_reminder;
	}
	public void setTotal_reminder(long total_reminder) {
		this.total_reminder = total_reminder;
	}
	public long getUniq_reminder() {
		return uniq_reminder;
	}
	public void setUniq_reminder(long uniq_reminder) {
		this.uniq_reminder = uniq_reminder;
	}
	public long getNo_of_reminder_set() {
		return no_of_reminder_set;
	}
	public void setNo_of_reminder_set(long no_of_reminder_set) {
		this.no_of_reminder_set = no_of_reminder_set;
	}
	public long getNo_of_greetings_send_to_user() {
		return no_of_greetings_send_to_user;
	}
	public void setNo_of_greetings_send_to_user(long no_of_greetings_send_to_user) {
		this.no_of_greetings_send_to_user = no_of_greetings_send_to_user;
	}
	public long getReminder_per_user() {
		return reminder_per_user;
	}
	public void setReminder_per_user(long reminder_per_user) {
		this.reminder_per_user = reminder_per_user;
	}
	public long getSub_revenue_10() {
		return sub_revenue_10;
	}
	public void setSub_revenue_10(long sub_revenue_10) {
		this.sub_revenue_10 = sub_revenue_10;
	}
	public long getSub_revenue_5() {
		return sub_revenue_5;
	}
	public void setSub_revenue_5(long sub_revenue_5) {
		this.sub_revenue_5 = sub_revenue_5;
	}
	public long getSub_revenue_2() {
		return sub_revenue_2;
	}
	public void setSub_revenue_2(long sub_revenue_2) {
		this.sub_revenue_2 = sub_revenue_2;
	}
	public long getTotal_sub_revenue() {
		return total_sub_revenue;
	}
	public void setTotal_sub_revenue(long total_sub_revenue) {
		this.total_sub_revenue = total_sub_revenue;
	}
	public long getRenewal_revenue_10() {
		return renewal_revenue_10;
	}
	public void setRenewal_revenue_10(long renewal_revenue_10) {
		this.renewal_revenue_10 = renewal_revenue_10;
	}
	public long getRenewal_revenue_5() {
		return renewal_revenue_5;
	}
	public void setRenewal_revenue_5(long renewal_revenue_5) {
		this.renewal_revenue_5 = renewal_revenue_5;
	}
	public long getRenewal_revenue_2() {
		return renewal_revenue_2;
	}
	public void setRenewal_revenue_2(long renewal_revenue_2) {
		this.renewal_revenue_2 = renewal_revenue_2;
	}
	public long getTotal_renewal_revenue() {
		return total_renewal_revenue;
	}
	public void setTotal_renewal_revenue(long total_renewal_revenue) {
		this.total_renewal_revenue = total_renewal_revenue;
	}
	public long getTotal_revenue() {
		return total_revenue;
	}
	public void setTotal_revenue(long total_revenue) {
		this.total_revenue = total_revenue;
	}
	public String getNet_addition() {
		return net_addition;
	}
	public void setNet_addition(String net_addition) {
		this.net_addition = net_addition;
	}
	public String getActive_base() {
		return active_base;
	}
	public void setActive_base(String active_base) {
		this.active_base = active_base;
	}
	public String getGrace_base() {
		return grace_base;
	}
	public void setGrace_base(String grace_base) {
		this.grace_base = grace_base;
	}
	public String getRetry_base() {
		return retry_base;
	}
	public void setRetry_base(String retry_base) {
		this.retry_base = retry_base;
	}
	public String getArpu() {
		return arpu;
	}
	public void setArpu(String arpu) {
		this.arpu = arpu;
	}
	public String getHits_per_uniq_user() {
		return hits_per_uniq_user;
	}
	public void setHits_per_uniq_user(String hits_per_uniq_user) {
		this.hits_per_uniq_user = hits_per_uniq_user;
	}
	public String getHits_per_uniq_live_user() {
		return hits_per_uniq_live_user;
	}
	public void setHits_per_uniq_live_user(String hits_per_uniq_live_user) {
		this.hits_per_uniq_live_user = hits_per_uniq_live_user;
	}
	public String getSession_per_uniq_user() {
		return session_per_uniq_user;
	}
	public void setSession_per_uniq_user(String session_per_uniq_user) {
		this.session_per_uniq_user = session_per_uniq_user;
	}
	public String getSession_per_uniq_live_user() {
		return session_per_uniq_live_user;
	}
	public void setSession_per_uniq_live_user(String session_per_uniq_live_user) {
		this.session_per_uniq_live_user = session_per_uniq_live_user;
	}
	public String getSession_per_call() {
		return session_per_call;
	}
	public void setSession_per_call(String session_per_call) {
		this.session_per_call = session_per_call;
	}

		
}
