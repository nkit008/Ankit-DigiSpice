package com.spice.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.spice.connection.DBConnection;

public class ShayariBean {
	
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
		 String query = "select * from tbl_shayariportal_mis_summary  where date_time between '"+sdate+"' and '"+edate+"' order by date_time asc";
		 System.out.println("Select Query is --"+query);
		 Map[] s = null;
		 int length = 0;
		 
		 int i = 0;
		 try {
			 conn = DBConnection.getConnectionShayari();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select count(1) as cnt from tbl_shayariportal_mis_summary where date_time between '"+sdate+"' and '"+edate+"' ") ;
			 while(rs.next()) {
				 length = rs.getInt("cnt");
			 }
			 rs = null;
			 rs = stmt.executeQuery(query);
			 s = new HashMap[length];
			 while(rs.next()) {
				 s[i] = new HashMap();
				 s[i].put("date_time", (rs.getString("date_time")).substring(0, 10));
				 System.out.println(i+" date "+rs.getString("date_time"));
				 s[i].put("ivr_totalCalls", rs.getString("ivr_totalCalls"));
				 s[i].put("ivr_calls_Live_Callers", rs.getString("ivr_calls_Live_Callers"));
				 s[i].put("ivr_calls_NonLive_Callers", rs.getString("ivr_calls_NonLive_Callers"));
				 s[i].put("ivr_total_MOU", rs.getString("ivr_total_MOU"));
				 s[i].put("ivr_mou_Live_Callers", rs.getString("ivr_mou_Live_Callers"));
				 
				 s[i].put("ivr_mou_NonLive_Callers", rs.getString("ivr_mou_NonLive_Callers"));
				 
				 s[i].put("ivr_unique_Users_mtd", rs.getString("ivr_unique_Users_mtd"));
				 
				 s[i].put("ivr_unique_Live_Users", rs.getString("ivr_unique_Live_Users"));
				 s[i].put("ivr_unique_NonLive_Users", rs.getString("ivr_unique_NonLive_Users"));
				 
				 s[i].put("ivr_total_Unique_Users", rs.getString("ivr_total_Unique_Users"));
				 s[i].put("ISingle_Consent_User", rs.getString("ISingle_Consent_User"));
				 
				 s[i].put("ISubscription_Requests_2_AFN", rs.getString("ISubscription_Requests_2_AFN"));
				 
				 s[i].put("ISubscription_Requests_30_AFN", rs.getString("ISubscription_Requests_30_AFN"));
				 
				 s[i].put("ISuccessful_Subscriptions_2_AFN", rs.getString("ISuccessful_Subscriptions_2_AFN"));
				 

				 s[i].put("ISuccessful_Subscriptions_30_AFN", rs.getString("ISuccessful_Subscriptions_30_AFN"));
				 
				 s[i].put("SSingle_Consent_User", rs.getString("SSingle_Consent_User"));
				 
				 s[i].put("SSubscription_Requests_2_AFN", rs.getString("SSubscription_Requests_2_AFN"));
				 
				 s[i].put("SSubscription_Requests_30_AFN", rs.getString("SSubscription_Requests_30_AFN"));
				 
				 s[i].put("SSuccessful_Subscriptions_2_AFN", rs.getString("SSuccessful_Subscriptions_2_AFN"));
				 
				 s[i].put("SSuccessful_Subscriptions_30_AFN", rs.getString("SSuccessful_Subscriptions_30_AFN"));
				 
				 s[i].put("CSubscription_Requests_2_AFN", rs.getString("CSubscription_Requests_2_AFN"));
				 
				 s[i].put("CSubscription_Requests_30_AFN", rs.getString("CSubscription_Requests_30_AFN"));
				 
				 s[i].put("CSuccessful_Subscriptions_2_AFN", rs.getString("CSuccessful_Subscriptions_2_AFN"));
				 
				 s[i].put("CSuccessful_Subscriptions_30_AFN", rs.getString("CSuccessful_Subscriptions_30_AFN"));
				 
				 s[i].put("Total_Gross_Adds", rs.getString("Total_Gross_Adds"));
				 
				 s[i].put("Renewal_Successful_2_AFN", rs.getString("Renewal_Successful_2_AFN"));
				 
				 s[i].put("Renewal_Successful_30_AFN", rs.getString("Renewal_Successful_30_AFN"));
				 
				 s[i].put("Total_Renewal_Successful", rs.getString("Total_Renewal_Successful"));
				 
				 s[i].put("ivr", rs.getString("ivr"));
				 
				 s[i].put("sms", rs.getString("sms"));
				 
				 s[i].put("cci", rs.getString("cci"));
				 
				 s[i].put("others", rs.getString("others"));
				 
				 s[i].put("voluntary_Churn", rs.getString("voluntary_Churn"));
				 
				 s[i].put("involuntary_churn", rs.getString("involuntary_churn"));
				 
				 s[i].put("total_churn", rs.getString("total_churn"));
				 
				 s[i].put("net_Additions", rs.getString("net_Additions"));
				 
				 s[i].put("active_Base", rs.getString("active_Base"));
				 
				 s[i].put("grace_Base", rs.getString("grace_Base"));
				 
				 s[i].put("retry_base", rs.getString("retry_base"));
				 
				 s[i].put("total_base", rs.getString("total_base"));
				 
				 s[i].put("sms_sent_daily", rs.getString("sms_sent_daily"));
				 
				 s[i].put("sms_delivered_daily", rs.getString("sms_delivered_daily"));
				 
				 s[i].put("Total_Subscription_Revenue", rs.getString("Total_Subscription_Revenue"));
				 
				 s[i].put("Subscription_Revenue_2_AFN", rs.getString("Subscription_Revenue_2_AFN"));
				 
				 s[i].put("Subscription_Revenue_30_AFN", rs.getString("Subscription_Revenue_30_AFN"));
				 
				 s[i].put("Total_Renewal_Revenue", rs.getString("Total_Renewal_Revenue"));
				 
				 s[i].put("Renewal_Revenue_2_AFN", rs.getString("Renewal_Revenue_2_AFN"));
				 
				 s[i].put("Renewal_Revenue_30_AFN", rs.getString("Renewal_Revenue_30_AFN"));
				 
				 s[i].put("grand_total", rs.getString("grand_total"));
				 
				 s[i].put("mou_bucket0_2_User", rs.getString("mou_bucket0_2_User"));
				 
				 s[i].put("mou_bucket0_2_Mins", rs.getString("mou_bucket0_2_Mins"));
				 
				 s[i].put("mou_bucket2_5_User", rs.getString("mou_bucket2_5_User"));
				 
				 s[i].put("mou_bucket2_5_Mins", rs.getString("mou_bucket2_5_Mins"));
				 
				 s[i].put("mou_bucket5_15_User", rs.getString("mou_bucket5_15_User"));
				
				 s[i].put("mou_bucket5_15_Mins", rs.getString("mou_bucket5_15_Mins"));
				 
				 s[i].put("mou_bucket15_30_User", rs.getString("mou_bucket15_30_User"));
				 
				 s[i].put("mou_bucket15_30_Mins", rs.getString("mou_bucket15_30_Mins"));
				 
				 s[i].put("mou_bucket30_50_User", rs.getString("mou_bucket30_50_User"));
				 
				 
				 s[i].put("mou_bucket30_50_Min", rs.getString("mou_bucket30_50_Min"));
				 
				 s[i].put("mou_bucket50_100_User", rs.getString("mou_bucket50_100_User"));
				 
				 s[i].put("mou_bucket50_100_Mins", rs.getString("mou_bucket50_100_Mins"));
				 
				 s[i].put("mou_bucket101_User", rs.getString("mou_bucket101_User"));
				 
				 s[i].put("mou_bucket101_Mins", rs.getString("mou_bucket101_Mins"));
				 
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
