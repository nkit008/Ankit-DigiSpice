package com.spice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_gamingportal_mis_robi")

public class MisGamingRobi {

	@Id
	private int id;
	
	  private String date_time;
	  private String total_sub_revenue;
	  private String total_resub_revenue;
	  
	  private String grand_total;
	  private String sub_req_200;
	  private String sub_succ_200;
	  private String sub_req_700;
	  private String sub_succ_700;
	  private String sub_req_2800;
	  private String sub_succ_2800;
	  private String total_new_user;
	  private String sms_user;
	  private String total_sms_user;
	  private String ussd_user;
	  private String total_ussd_user;
	  private String total_renewal_200;
	  private String total_renewal_700;
	  private String total_renewal_2800;
	  private String succ_renewal_200;
	  private String succ_renewal_700;
	  private String succ_renewal_2800;
	  private String fail_renewal_200;
	  private String fail_renewal_700;
	  private String fail_renewal_2800;
	  private String total_succ_renewal_users;
	  private String total_retry_req;
	  private String total_retry_succ;
	  private String total_retry_fail;
	  private String voluntary_churn;
	  private String involuntary_churn;
	  private String sms_churn;
	  private String ussd_churn;
	  private String total_churn;
	  
	  private String ppu_req;
	  private String ppu_succ;
	  private String ppu_fail;
	  private String download_req;
	  private String download_succ;
	  private String download_fail;
	  private String page_view;
	  private String unique_visitor;
	  private String total_visitor;
	  
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	public String getTotal_sub_revenue() {
		return total_sub_revenue;
	}
	public void setTotal_sub_revenue(String total_sub_revenue) {
		this.total_sub_revenue = total_sub_revenue;
	}
	public String getTotal_resub_revenue() {
		return total_resub_revenue;
	}
	public void setTotal_resub_revenue(String total_resub_revenue) {
		this.total_resub_revenue = total_resub_revenue;
	}
	public String getGrand_total() {
		return grand_total;
	}
	public void setGrand_total(String grand_total) {
		this.grand_total = grand_total;
	}
	public String getSub_req_200() {
		return sub_req_200;
	}
	public void setSub_req_200(String sub_req_200) {
		this.sub_req_200 = sub_req_200;
	}
	public String getSub_succ_200() {
		return sub_succ_200;
	}
	public void setSub_succ_200(String sub_succ_200) {
		this.sub_succ_200 = sub_succ_200;
	}
	public String getSub_req_700() {
		return sub_req_700;
	}
	public void setSub_req_700(String sub_req_700) {
		this.sub_req_700 = sub_req_700;
	}
	public String getSub_succ_700() {
		return sub_succ_700;
	}
	public void setSub_succ_700(String sub_succ_700) {
		this.sub_succ_700 = sub_succ_700;
	}
	public String getSub_req_2800() {
		return sub_req_2800;
	}
	public void setSub_req_2800(String sub_req_2800) {
		this.sub_req_2800 = sub_req_2800;
	}
	public String getSub_succ_2800() {
		return sub_succ_2800;
	}
	public void setSub_succ_2800(String sub_succ_2800) {
		this.sub_succ_2800 = sub_succ_2800;
	}
	public String getTotal_new_user() {
		return total_new_user;
	}
	public void setTotal_new_user(String total_new_user) {
		this.total_new_user = total_new_user;
	}
	public String getSms_user() {
		return sms_user;
	}
	public void setSms_user(String sms_user) {
		this.sms_user = sms_user;
	}
	public String getTotal_sms_user() {
		return total_sms_user;
	}
	public void setTotal_sms_user(String total_sms_user) {
		this.total_sms_user = total_sms_user;
	}
	public String getUssd_user() {
		return ussd_user;
	}
	public void setUssd_user(String ussd_user) {
		this.ussd_user = ussd_user;
	}
	public String getTotal_ussd_user() {
		return total_ussd_user;
	}
	public void setTotal_ussd_user(String total_ussd_user) {
		this.total_ussd_user = total_ussd_user;
	}
	public String getTotal_renewal_200() {
		return total_renewal_200;
	}
	public void setTotal_renewal_200(String total_renewal_200) {
		this.total_renewal_200 = total_renewal_200;
	}
	public String getTotal_renewal_700() {
		return total_renewal_700;
	}
	public void setTotal_renewal_700(String total_renewal_700) {
		this.total_renewal_700 = total_renewal_700;
	}
	public String getTotal_renewal_2800() {
		return total_renewal_2800;
	}
	public void setTotal_renewal_2800(String total_renewal_2800) {
		this.total_renewal_2800 = total_renewal_2800;
	}
	public String getSucc_renewal_200() {
		return succ_renewal_200;
	}
	public void setSucc_renewal_200(String succ_renewal_200) {
		this.succ_renewal_200 = succ_renewal_200;
	}
	public String getSucc_renewal_700() {
		return succ_renewal_700;
	}
	public void setSucc_renewal_700(String succ_renewal_700) {
		this.succ_renewal_700 = succ_renewal_700;
	}
	public String getSucc_renewal_2800() {
		return succ_renewal_2800;
	}
	public void setSucc_renewal_2800(String succ_renewal_2800) {
		this.succ_renewal_2800 = succ_renewal_2800;
	}
	public String getFail_renewal_200() {
		return fail_renewal_200;
	}
	public void setFail_renewal_200(String fail_renewal_200) {
		this.fail_renewal_200 = fail_renewal_200;
	}
	public String getFail_renewal_700() {
		return fail_renewal_700;
	}
	public void setFail_renewal_700(String fail_renewal_700) {
		this.fail_renewal_700 = fail_renewal_700;
	}
	public String getFail_renewal_2800() {
		return fail_renewal_2800;
	}
	public void setFail_renewal_2800(String fail_renewal_2800) {
		this.fail_renewal_2800 = fail_renewal_2800;
	}
	public String getTotal_succ_renewal_users() {
		return total_succ_renewal_users;
	}
	public void setTotal_succ_renewal_users(String total_succ_renewal_users) {
		this.total_succ_renewal_users = total_succ_renewal_users;
	}
	public String getTotal_retry_req() {
		return total_retry_req;
	}
	public void setTotal_retry_req(String total_retry_req) {
		this.total_retry_req = total_retry_req;
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
	public String getSms_churn() {
		return sms_churn;
	}
	public void setSms_churn(String sms_churn) {
		this.sms_churn = sms_churn;
	}
	public String getUssd_churn() {
		return ussd_churn;
	}
	public void setUssd_churn(String ussd_churn) {
		this.ussd_churn = ussd_churn;
	}
	public String getTotal_churn() {
		return total_churn;
	}
	public void setTotal_churn(String total_churn) {
		this.total_churn = total_churn;
	}
	public String getPpu_req() {
		return ppu_req;
	}
	public void setPpu_req(String ppu_req) {
		this.ppu_req = ppu_req;
	}
	public String getPpu_succ() {
		return ppu_succ;
	}
	public void setPpu_succ(String ppu_succ) {
		this.ppu_succ = ppu_succ;
	}
	public String getPpu_fail() {
		return ppu_fail;
	}
	public void setPpu_fail(String ppu_fail) {
		this.ppu_fail = ppu_fail;
	}
	public String getDownload_req() {
		return download_req;
	}
	public void setDownload_req(String download_req) {
		this.download_req = download_req;
	}
	public String getDownload_succ() {
		return download_succ;
	}
	public void setDownload_succ(String download_succ) {
		this.download_succ = download_succ;
	}
	public String getDownload_fail() {
		return download_fail;
	}
	public void setDownload_fail(String download_fail) {
		this.download_fail = download_fail;
	}
	public String getPage_view() {
		return page_view;
	}
	public void setPage_view(String page_view) {
		this.page_view = page_view;
	}
	public String getUnique_visitor() {
		return unique_visitor;
	}
	public void setUnique_visitor(String unique_visitor) {
		this.unique_visitor = unique_visitor;
	}
	public String getTotal_visitor() {
		return total_visitor;
	}
	public void setTotal_visitor(String total_visitor) {
		this.total_visitor = total_visitor;
	}
	  
	  
	  
	  

	  	  }
