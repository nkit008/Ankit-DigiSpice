package com.indosat.mis.bean;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "iGamesMisKpi")

public class IGamePojo {

	@Id
	private int id;
	
	  private String date_time;
	  private String active_base;
	  private String total_sub_req_rec;
	  private String total_sub_req_proc;
	  private String total_gross_add;
	  private String total_churn;
	  private String net_add;
	  private String gross_adds_revenue;
	  private String renewal_revenue;
	  private String grand_total;
	  private String sub_req_rec_2200;
	  private String succ_sub_2200;
	  private String sub_req_rec_5500;
	  private String succ_sub_5500;
	  private String sub_req_rec_11000;
	  private String succ_sub_11000;
	  private String total_new_users;
	  private String users_paid_sms;
	  private String total_users_sms;
	  private String users_paid_ussd;
	  private String total_users_ussd;
	  private String total_ren_2200;
	  private String total_ren_5500;
	  private String total_ren_11000;
	  private String succ_ren_2200;
	  private String succ_ren_5500;
	  private String succ_ren_11000;
	  private String fail_ren_2200;
	  private String fail_ren_5500;
	  private String fail_ren_11000;
	  private String total_ren_user;
	  private String total_retry_attmpt;
	  private String total_retry_succ;
	  private String total_retry_fail;
	  private String voluntary_deactivations;
	  private String involuntary_deactivations;
	  private String total_sms_user;
	  private String total_ussd_user;
	  //private String total_churn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	public String getActive_base() {
		return active_base;
	}
	public void setActive_base(String active_base) {
		this.active_base = active_base;
	}
	public String getTotal_sub_req_rec() {
		return total_sub_req_rec;
	}
	public void setTotal_sub_req_rec(String total_sub_req_rec) {
		this.total_sub_req_rec = total_sub_req_rec;
	}
	public String getTotal_sub_req_proc() {
		return total_sub_req_proc;
	}
	public void setTotal_sub_req_proc(String total_sub_req_proc) {
		this.total_sub_req_proc = total_sub_req_proc;
	}
	public String getTotal_gross_add() {
		return total_gross_add;
	}
	public void setTotal_gross_add(String total_gross_add) {
		this.total_gross_add = total_gross_add;
	}
	public String getTotal_churn() {
		return total_churn;
	}
	public void setTotal_churn(String total_churn) {
		this.total_churn = total_churn;
	}
	public String getNet_add() {
		return net_add;
	}
	public void setNet_add(String net_add) {
		this.net_add = net_add;
	}
	public String getGross_adds_revenue() {
		return gross_adds_revenue;
	}
	public void setGross_adds_revenue(String gross_adds_revenue) {
		this.gross_adds_revenue = gross_adds_revenue;
	}
	public String getRenewal_revenue() {
		return renewal_revenue;
	}
	public void setRenewal_revenue(String renewal_revenue) {
		this.renewal_revenue = renewal_revenue;
	}
	public String getGrand_total() {
		return grand_total;
	}
	public void setGrand_total(String grand_total) {
		this.grand_total = grand_total;
	}
	public String getSub_req_rec_2200() {
		return sub_req_rec_2200;
	}
	public void setSub_req_rec_2200(String sub_req_rec_2200) {
		this.sub_req_rec_2200 = sub_req_rec_2200;
	}
	public String getSucc_sub_2200() {
		return succ_sub_2200;
	}
	public void setSucc_sub_2200(String succ_sub_2200) {
		this.succ_sub_2200 = succ_sub_2200;
	}
	public String getSub_req_rec_5500() {
		return sub_req_rec_5500;
	}
	public void setSub_req_rec_5500(String sub_req_rec_5500) {
		this.sub_req_rec_5500 = sub_req_rec_5500;
	}
	public String getSucc_sub_5500() {
		return succ_sub_5500;
	}
	public void setSucc_sub_5500(String succ_sub_5500) {
		this.succ_sub_5500 = succ_sub_5500;
	}
	public String getSub_req_rec_11000() {
		return sub_req_rec_11000;
	}
	public void setSub_req_rec_11000(String sub_req_rec_11000) {
		this.sub_req_rec_11000 = sub_req_rec_11000;
	}
	public String getSucc_sub_11000() {
		return succ_sub_11000;
	}
	public void setSucc_sub_11000(String succ_sub_11000) {
		this.succ_sub_11000 = succ_sub_11000;
	}
	public String getTotal_new_users() {
		return total_new_users;
	}
	public void setTotal_new_users(String total_new_users) {
		this.total_new_users = total_new_users;
	}
	public String getUsers_paid_sms() {
		return users_paid_sms;
	}
	public void setUsers_paid_sms(String users_paid_sms) {
		this.users_paid_sms = users_paid_sms;
	}
	public String getTotal_users_sms() {
		return total_users_sms;
	}
	public void setTotal_users_sms(String total_users_sms) {
		this.total_users_sms = total_users_sms;
	}
	public String getUsers_paid_ussd() {
		return users_paid_ussd;
	}
	public void setUsers_paid_ussd(String users_paid_ussd) {
		this.users_paid_ussd = users_paid_ussd;
	}
	public String getTotal_users_ussd() {
		return total_users_ussd;
	}
	public void setTotal_users_ussd(String total_users_ussd) {
		this.total_users_ussd = total_users_ussd;
	}
	public String getTotal_ren_2200() {
		return total_ren_2200;
	}
	public void setTotal_ren_2200(String total_ren_2200) {
		this.total_ren_2200 = total_ren_2200;
	}
	public String getTotal_ren_5500() {
		return total_ren_5500;
	}
	public void setTotal_ren_5500(String total_ren_5500) {
		this.total_ren_5500 = total_ren_5500;
	}
	public String getTotal_ren_11000() {
		return total_ren_11000;
	}
	public void setTotal_ren_11000(String total_ren_11000) {
		this.total_ren_11000 = total_ren_11000;
	}
	public String getSucc_ren_2200() {
		return succ_ren_2200;
	}
	public void setSucc_ren_2200(String succ_ren_2200) {
		this.succ_ren_2200 = succ_ren_2200;
	}
	public String getSucc_ren_5500() {
		return succ_ren_5500;
	}
	public void setSucc_ren_5500(String succ_ren_5500) {
		this.succ_ren_5500 = succ_ren_5500;
	}
	public String getSucc_ren_11000() {
		return succ_ren_11000;
	}
	public void setSucc_ren_11000(String succ_ren_11000) {
		this.succ_ren_11000 = succ_ren_11000;
	}
	public String getFail_ren_2200() {
		return fail_ren_2200;
	}
	public void setFail_ren_2200(String fail_ren_2200) {
		this.fail_ren_2200 = fail_ren_2200;
	}
	public String getFail_ren_5500() {
		return fail_ren_5500;
	}
	public void setFail_ren_5500(String fail_ren_5500) {
		this.fail_ren_5500 = fail_ren_5500;
	}
	public String getFail_ren_11000() {
		return fail_ren_11000;
	}
	public void setFail_ren_11000(String fail_ren_11000) {
		this.fail_ren_11000 = fail_ren_11000;
	}
	public String getTotal_ren_user() {
		return total_ren_user;
	}
	public void setTotal_ren_user(String total_ren_user) {
		this.total_ren_user = total_ren_user;
	}
	public String getTotal_retry_attmpt() {
		return total_retry_attmpt;
	}
	public void setTotal_retry_attmpt(String total_retry_attmpt) {
		this.total_retry_attmpt = total_retry_attmpt;
	}
	public String getTotal_retry_succ() {
		return total_retry_succ;
	}
	public void setTotal_retry_succ(String total_retry_succ) {
		this.total_retry_succ = total_retry_succ;
	}
	public String getTotal_retry_fail() {
		return total_retry_fail;
	}
	public void setTotal_retry_fail(String total_retry_fail) {
		this.total_retry_fail = total_retry_fail;
	}
	public String getVoluntary_deactivations() {
		return voluntary_deactivations;
	}
	public void setVoluntary_deactivations(String voluntary_deactivations) {
		this.voluntary_deactivations = voluntary_deactivations;
	}
	public String getInvoluntary_deactivations() {
		return involuntary_deactivations;
	}
	public void setInvoluntary_deactivations(String involuntary_deactivations) {
		this.involuntary_deactivations = involuntary_deactivations;
	}
	public String getTotal_sms_user() {
		return total_sms_user;
	}
	public void setTotal_sms_user(String total_sms_user) {
		this.total_sms_user = total_sms_user;
	}
	public String getTotal_ussd_user() {
		return total_ussd_user;
	}
	public void setTotal_ussd_user(String total_ussd_user) {
		this.total_ussd_user = total_ussd_user;
	}
	  
	  
	  
	  
	  	  }
