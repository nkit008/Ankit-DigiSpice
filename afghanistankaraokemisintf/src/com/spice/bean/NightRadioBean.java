package com.spice.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.spice.connection.DBConnection;

public class NightRadioBean {

	public String dateConvert(String tempdate ) {
		String str[] = null;
		if(tempdate!=null){
			 str= tempdate.split("/");
		}
		String date = "";
		if(str!=null && str.length>0){
			date=str[2]+"-"+str[1]+"-"+str[0];
		}
		return date;
	}
	 public Map[] GetData(String startdate, String enddate) throws Exception {
		 ResultSet rs = null;
		 Connection conn = null;
		 Statement stmt = null;
		 String  sdate = dateConvert(startdate);
		 String  edate = dateConvert(enddate);
		 String query = "select * from awcc_nradio.tbl_nradio_mis  where date_time between '"+sdate+"' and '"+edate+"' order by date_time asc";
		 System.out.println("Select Query is --"+query);
		 Map[] s = null;
		 int length = 0;
		 
		 int i = 0;
		 try {
			 conn = DBConnection.getConnectionNradio();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select count(1) as cnt from awcc_nradio.tbl_nradio_mis  where date_time between '"+sdate+"' and '"+edate+"' ") ;
			 while(rs.next()) {
				 length = rs.getInt("cnt");
			 }
			 rs = null;
			 rs = stmt.executeQuery(query);
			 s = new HashMap[length];
			 while(rs.next()) {
				 s[i] = new HashMap();
				 s[i].put("date_time", (rs.getString("date_time")).substring(0, 10));
				 
				 s[i].put("ivr_total_calls", rs.getString("ivr_total_calls"));
				 s[i].put("ivr_calls_live_callers", rs.getString("ivr_calls_live_callers"));
				 s[i].put("ivr_calls_non_live_callers", rs.getString("ivr_calls_non_live_callers"));
				 s[i].put("ivr_total_mous", rs.getString("ivr_total_mous"));
				 s[i].put("ivr_mous_live_callers", rs.getString("ivr_mous_live_callers"));
				 s[i].put("ivr_mous_non_live_callers", rs.getString("ivr_mous_non_live_callers"));
				 s[i].put("ivr_total_pulses", rs.getString("ivr_total_pulses"));
				 s[i].put("ivr_pulses_live_callers", rs.getString("ivr_pulses_live_callers"));
				 s[i].put("ivr_ivr_pulses_non_live_callers", rs.getString("ivr_ivr_pulses_non_live_callers"));
				 s[i].put("ivr_total_unique_callers", rs.getString("ivr_total_unique_callers"));
				 s[i].put("ivr_unique_live_callers", rs.getString("ivr_unique_live_callers"));
				 s[i].put("ivr_unique_non_live_callers", rs.getString("ivr_unique_non_live_callers"));
				 s[i].put("ivr_unique_callers_mtd", rs.getString("ivr_unique_callers_mtd"));
				 s[i].put("ivr_unique_live_callers_mtd", rs.getString("ivr_unique_live_callers_mtd"));
				// s[i].put("", rs.getString(""));
				 s[i].put("obd_total_outdial_base_uploaded", rs.getString("obd_total_outdial_base_uploaded"));
				 s[i].put("obd_total_outdial_attempted", rs.getString("obd_total_outdial_attempted"));
				 s[i].put("obd_success_outdials", rs.getString("obd_success_outdials"));
				 s[i].put("obd_call_patched_on_ivr", rs.getString("obd_call_patched_on_ivr"));
				 s[i].put("obd_mous_via_obd_call_patch", rs.getString("obd_mous_via_obd_call_patch"));
				 s[i].put("obd_pulses_via_obd_call_patch", rs.getString("obd_pulses_via_obd_call_patch"));
				 s[i].put("obd_unique_live_callers_via_obd", rs.getString("obd_unique_live_callers_via_obd"));
				 s[i].put("obd_unique_live_caller_mtd_via_obd", rs.getString("obd_unique_live_caller_mtd_via_obd"));
				// s[i].put("", rs.getString(""));
				 s[i].put("kpi_total_mous", rs.getString("kpi_total_mous"));
				 s[i].put("kpi_total_live_mous", rs.getString("kpi_total_live_mous"));
				 s[i].put("kpi_total_pulses", rs.getString("kpi_total_pulses"));
				 s[i].put("kpi_toatl_live_pulses", rs.getString("kpi_toatl_live_pulses"));
				 s[i].put("kpi_total_unique_callers", rs.getString("kpi_total_unique_callers"));
				 s[i].put("kpi_total_unique_live_callers", rs.getString("kpi_total_unique_live_callers"));
				 s[i].put("kpi_total_unique_calles_mtd", rs.getString("kpi_total_unique_calles_mtd"));
				 s[i].put("kpi_total_unique_live_callers_mtd", rs.getString("kpi_total_unique_live_callers_mtd"));
				// s[i].put("", rs.getString(""));
				 s[i].put("ivr_gross_subscription_requests_3_afn", rs.getString("ivr_gross_subscription_requests_3_afn"));
				 s[i].put("ivr_gross_successful_subscriptions_3_afn", rs.getString("ivr_gross_successful_subscriptions_3_afn"));
				 s[i].put("ivr_gross_successful_subscriptions_2_afn", rs.getString("ivr_gross_successful_subscriptions_2_afn"));
				 s[i].put("ivr_gross_successful_subscriptions_1_afn", rs.getString("ivr_gross_successful_subscriptions_1_afn"));
				 //s[i].put("", rs.getString(""));
				 s[i].put("api_gross_subscription_requests_3_afn", rs.getString("api_gross_subscription_requests_3_afn"));
				 s[i].put("api_gross_successful_subscriptions_3_afn", rs.getString("api_gross_successful_subscriptions_3_afn"));
				 s[i].put("api_gross_successful_subscriptions_2_afn", rs.getString("api_gross_successful_subscriptions_2_afn"));
				 s[i].put("api_gross_successful_subscriptions_1_afn", rs.getString("api_gross_successful_subscriptions_1_afn"));
				 //s[i].put("", rs.getString(""));
				 s[i].put("obd_gross_subscription_requests_3_afn", rs.getString("obd_gross_subscription_requests_3_afn"));
				 s[i].put("obd_gross_successful_subscriptions_3_afn", rs.getString("obd_gross_successful_subscriptions_3_afn"));
				 s[i].put("obd_gross_successful_subscriptions_2_afn", rs.getString("obd_gross_successful_subscriptions_2_afn"));
				 s[i].put("obd_gross_successful_subscriptions_1_afn", rs.getString("obd_gross_successful_subscriptions_1_afn"));
				 //s[i].put("", rs.getString(""));
				 s[i].put("cci_gross_subscription_requests_3_afn", rs.getString("cci_gross_subscription_requests_3_afn"));
				 s[i].put("cci_gross_successful_subscriptions_3_afn", rs.getString("cci_gross_successful_subscriptions_3_afn"));
				 s[i].put("cci_gross_successful_subscriptions_2_afn", rs.getString("cci_gross_successful_subscriptions_2_afn"));
				 s[i].put("cci_gross_successful_subscriptions_1_afn", rs.getString("cci_gross_successful_subscriptions_1_afn"));
				 //s[i].put("", rs.getString(""));
				 s[i].put("sms_gross_subscription_requests_3_afn", rs.getString("sms_gross_subscription_requests_3_afn"));
				 s[i].put("sms_gross_successful_subscriptions_3_afn", rs.getString("sms_gross_successful_subscriptions_3_afn"));
				 s[i].put("sms_gross_successful_subscriptions_2_afn", rs.getString("sms_gross_successful_subscriptions_2_afn"));
				 s[i].put("sms_gross_successful_subscriptions_1_afn", rs.getString("sms_gross_successful_subscriptions_1_afn"));
				 //s[i].put("", rs.getString(""));
				 s[i].put("ussd_gross_subscription_requests_3_afn", rs.getString("ussd_gross_subscription_requests_3_afn"));
				 s[i].put("ussd_gross_successful_subscriptions_3_afn", rs.getString("ussd_gross_successful_subscriptions_3_afn"));
				 s[i].put("ussd_gross_successful_subscriptions_2_afn", rs.getString("ussd_gross_successful_subscriptions_2_afn"));
				 s[i].put("ussd_gross_successful_subscriptions_1_afn", rs.getString("ussd_gross_successful_subscriptions_1_afn"));
				
				 s[i].put("ivr_subscription_retry_3_afn", rs.getString("ivr_subscription_retry_3_afn"));
				 s[i].put("ivr_retry_successful_3_afn", rs.getString("ivr_retry_successful_3_afn"));
				 s[i].put("ivr_retry_successful_2_afn", rs.getString("ivr_retry_successful_2_afn"));
				 s[i].put("ivr_retry_successful_1_afn", rs.getString("ivr_retry_successful_1_afn"));
				 
				 s[i].put("api_subscription_retry_3_afn", rs.getString("api_subscription_retry_3_afn"));
				 s[i].put("api_retry_successful_3_afn", rs.getString("api_retry_successful_3_afn"));
				 s[i].put("api_retry_successful_2_afn", rs.getString("api_retry_successful_2_afn"));
				 s[i].put("api_retry_successful_1_afn", rs.getString("api_retry_successful_1_afn"));
				 
				 s[i].put("obd_subscription_retry_3_afn", rs.getString("obd_subscription_retry_3_afn"));
				 s[i].put("obd_retry_successful_3_afn", rs.getString("obd_retry_successful_3_afn"));
				 s[i].put("obd_retry_successful_2_afn", rs.getString("obd_retry_successful_2_afn"));
				 s[i].put("obd_retry_successful_1_afn", rs.getString("obd_retry_successful_1_afn"));
				 
				 s[i].put("cci_subscription_retry_3_afn", rs.getString("cci_subscription_retry_3_afn"));
				 s[i].put("cci_retry_successful_3_afn", rs.getString("cci_retry_successful_3_afn"));
				 s[i].put("cci_retry_successful_2_afn", rs.getString("cci_retry_successful_2_afn"));
				 s[i].put("cci_retry_successful_1_afn", rs.getString("cci_retry_successful_1_afn"));
				
				 s[i].put("sms_subscription_retry_3_afn", rs.getString("sms_subscription_retry_3_afn"));
				 s[i].put("sms_retry_successful_3_afn", rs.getString("sms_retry_successful_3_afn"));
				 s[i].put("sms_retry_successful_2_afn", rs.getString("sms_retry_successful_2_afn"));
				 s[i].put("sms_retry_successful_1_afn", rs.getString("sms_retry_successful_1_afn"));
				 
				 s[i].put("ussd_subscription_retry_3_afn", rs.getString("ussd_subscription_retry_3_afn"));
				 s[i].put("ussd_retry_successful_3_afn", rs.getString("ussd_retry_successful_3_afn"));
				 s[i].put("ussd_retry_successful_2_afn", rs.getString("ussd_retry_successful_2_afn"));
				 s[i].put("ussd_retry_successful_1_afn", rs.getString("ussd_retry_successful_1_afn"));
				
				 s[i].put("dedication_request_2_afn", rs.getString("dedication_request_2_afn"));
				 s[i].put("dedication_successful_2_afn", rs.getString("dedication_successful_2_afn"));
				 
				 s[i].put("total_subscription_retry_3_afn", rs.getString("total_subscription_retry_3_afn"));
				 s[i].put("total_retry_successful_3_afn", rs.getString("total_retry_successful_3_afn"));
				 s[i].put("total_retry_successful_2_afn", rs.getString("total_retry_successful_2_afn"));
				 s[i].put("total_retry_successful_1_afn", rs.getString("total_retry_successful_1_afn"));
				 s[i].put("total_retry_successful", rs.getString("total_retry_successful"));
				 
				 s[i].put("total_subscription_requests_3_afn", rs.getString("total_subscription_requests_3_afn"));
				 s[i].put("total_subscription_successful_3_afn", rs.getString("total_subscription_successful_3_afn"));
				 s[i].put("total_subscription_successful_2_afn", rs.getString("total_subscription_successful_2_afn"));
				 s[i].put("total_subscription_successful_1_afn", rs.getString("total_subscription_successful_1_afn"));
				 s[i].put("total_subscription_successful", rs.getString("total_subscription_successful"));
				 
				 s[i].put("renewal_requests_3_afn", rs.getString("renewal_requests_3_afn"));
				 s[i].put("renewal_successful_3_afn", rs.getString("renewal_successful_3_afn"));
				 s[i].put("renewal_successful_2_afn", rs.getString("renewal_successful_2_afn"));
				 s[i].put("renewal_successful_1_afn", rs.getString("renewal_successful_1_afn"));
				
				 s[i].put("ivr", rs.getString("ivr"));
				 s[i].put("cci", rs.getString("cci"));
				 s[i].put("sms", rs.getString("sms"));
				 s[i].put("ussd", rs.getString("ussd"));
				 s[i].put("others", rs.getString("others"));
				 s[i].put("voluntary_churn", rs.getString("voluntary_churn"));
				 s[i].put("involuntary_churn", rs.getString("involuntary_churn"));
				 s[i].put("total_churn", rs.getString("total_churn"));
				 
				 s[i].put("subscription_revenue_3_afn", rs.getString("subscription_revenue_3_afn"));
				 s[i].put("subscription_revenue_2_afn", rs.getString("subscription_revenue_2_afn"));
				 s[i].put("subscription_revenue_1_afn", rs.getString("subscription_revenue_1_afn"));
				 s[i].put("total_subscription_revenue", rs.getString("total_subscription_revenue"));
				 s[i].put("renewal_revenue_3_afn", rs.getString("renewal_revenue_3_afn"));
				 s[i].put("renewal_revenue_2_afn", rs.getString("renewal_revenue_2_afn"));
				 s[i].put("renewal_revenue_1_afn", rs.getString("renewal_revenue_1_afn"));
				 s[i].put("total_renewal_revenue", rs.getString("total_renewal_revenue"));
				 s[i].put("total_revenue", rs.getString("total_revenue"));
				 
				 s[i].put("net_additions", rs.getString("net_additions"));
				 s[i].put("active_base", rs.getString("active_base"));
				 s[i].put("grace_base", rs.getString("grace_base"));
				 s[i].put("retry_base", rs.getString("retry_base"));
				 

				 ++i;
			 }
		 } catch(Exception e) {
			 System.out.println("Exception in geting Value im MIS Bean.."+e);
			 e.printStackTrace();
		 } finally {
			 if(rs!= null) {
				 rs.close();
			 }
			 if(stmt != null)  {
				 stmt.close();
			 }
			 if(conn != null) {
				 conn.close();
			 }
		 }
		return s;		 
	 }
}