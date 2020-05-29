package com.spice.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.spice.connection.DBConnection;

public class AwccMisBean {

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
		 String query = "select * from awcc_karaoke.tbl_karaoke_mis_summary  where date_time between '"+sdate+"' and '"+edate+"' order by date_time asc";
		 System.out.println("Select Query is --"+query);
		 Map[] s = null;
		 int length = 0;
		 
		 int i = 0;
		 try {
			 conn = DBConnection.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select count(1) as cnt from awcc_karaoke.tbl_karaoke_mis_summary  where date_time between '"+sdate+"' and '"+edate+"' ") ;
			 while(rs.next()) {
				 length = rs.getInt("cnt");
			 }
			 rs = null;
			 rs = stmt.executeQuery(query);
			 s = new HashMap[length];
			 while(rs.next()) {
				 s[i] = new HashMap();
				 s[i].put("date_time", (rs.getString("date_time")).substring(0, 10));
				 s[i].put("ivr_totalCalls", rs.getString("ivr_totalCalls"));
				 s[i].put("ivr_calls_Live_Callers", rs.getString("ivr_calls_Live_Callers"));
				 s[i].put("ivr_calls_NonLive_Callers", rs.getString("ivr_calls_NonLive_Callers"));
				 s[i].put("ivr_total_MOU", rs.getString("ivr_total_MOU"));
				 s[i].put("ivr_mou_Live_Callers", rs.getString("ivr_mou_Live_Callers"));
				 s[i].put("ivr_mou_NonLive_Callers", rs.getString("ivr_mou_NonLive_Callers"));
				 s[i].put("ivr_total_Pulses", rs.getString("ivr_total_Pulses"));
				 s[i].put("ivr_pulses_Live_callers", rs.getString("ivr_pulses_Live_callers"));
				 s[i].put("ivr_pulses_NonLive_Callers", rs.getString("ivr_pulses_NonLive_Callers"));
				 s[i].put("ivr_total_Unique_Callers", rs.getString("ivr_total_Unique_Callers"));
				 s[i].put("ivr_unique_Live_Callers", rs.getString("ivr_unique_Live_Callers"));
				 s[i].put("ivr_unique_NonLive_Callers", rs.getString("ivr_unique_NonLive_Callers"));
				 s[i].put("ivr_unique_Callers_mtd", rs.getString("ivr_unique_Callers_mtd"));	
				 s[i].put("ivr_unique_Live_Callers_mtd", rs.getString("ivr_unique_Live_Callers_mtd"));
				 
				 
				 s[i].put("ISubscription_Requests_80_AFN", rs.getString("ISubscription_Requests_80_AFN"));	
				 s[i].put("ISubscription_Requests_20_AFN", rs.getString("ISubscription_Requests_20_AFN"));	
				 s[i].put("ISubscription_Requests_5_AFN", rs.getString("ISubscription_Requests_5_AFN"));
				 s[i].put("ISuccessful_Subscriptions_80_AFN", rs.getString("ISuccessful_Subscriptions_80_AFN"));	
				 s[i].put("ISuccessful_Subscriptions_20_AFN", rs.getString("ISuccessful_Subscriptions_20_AFN"));	
				 s[i].put("ISuccessful_Subscriptions_5_AFN", rs.getString("ISuccessful_Subscriptions_5_AFN"));
				 s[i].put("ISuccessful_Subscriptions_3_AFN", rs.getString("ISuccessful_Subscriptions_3_AFN"));	
				 s[i].put("ISuccessful_Subscriptions_1_AFN", rs.getString("ISuccessful_Subscriptions_1_AFN"));
				 
				 
				 s[i].put("ASubscription_Requests_80_AFN", rs.getString("ASubscription_Requests_80_AFN"));		
				 s[i].put("ASubscription_Requests_20_AFN", rs.getString("ASubscription_Requests_20_AFN"));		
				 s[i].put("ASubscription_Requests_5_AFN", rs.getString("ASubscription_Requests_5_AFN"));		
				 s[i].put("ASuccessful_Subscriptions_80_AFN", rs.getString("ASuccessful_Subscriptions_80_AFN"));	
				 s[i].put("ASuccessful_Subscriptions_20_AFN", rs.getString("ASuccessful_Subscriptions_20_AFN"));	
				 s[i].put("ASuccessful_Subscriptions_5_AFN", rs.getString("ASuccessful_Subscriptions_5_AFN"));
				 s[i].put("ASuccessful_Subscriptions_3_AFN", rs.getString("ASuccessful_Subscriptions_3_AFN"));	
				 s[i].put("ASuccessful_Subscriptions_1_AFN", rs.getString("ASuccessful_Subscriptions_1_AFN"));

				 
				 s[i].put("OSubscription_Requests_80_AFN", rs.getString("OSubscription_Requests_80_AFN"));	
				 s[i].put("OSubscription_Requests_20_AFN", rs.getString("OSubscription_Requests_20_AFN"));	
				 s[i].put("OSubscription_Requests_5_AFN", rs.getString("OSubscription_Requests_5_AFN"));
				 s[i].put("OSuccessful_Subscriptions_80_AFN", rs.getString("OSuccessful_Subscriptions_80_AFN"));	
				 s[i].put("OSuccessful_Subscriptions_20_AFN", rs.getString("OSuccessful_Subscriptions_20_AFN"));	
				 s[i].put("OSuccessful_Subscriptions_5_AFN", rs.getString("OSuccessful_Subscriptions_5_AFN"));
				 s[i].put("OSuccessful_Subscriptions_3_AFN", rs.getString("OSuccessful_Subscriptions_3_AFN"));
				 s[i].put("OSuccessful_Subscriptions_1_AFN", rs.getString("OSuccessful_Subscriptions_1_AFN"));
				 
				 
				 s[i].put("CSubscription_Requests_80_AFN", rs.getString("CSubscription_Requests_80_AFN"));	
				 s[i].put("CSubscription_Requests_20_AFN", rs.getString("CSubscription_Requests_20_AFN"));	
				 s[i].put("CSubscription_Requests_5_AFN", rs.getString("CSubscription_Requests_5_AFN"));
				 s[i].put("CSuccessful_Subscriptions_80_AFN", rs.getString("CSuccessful_Subscriptions_80_AFN"));	
				 s[i].put("CSuccessful_Subscriptions_20_AFN", rs.getString("CSuccessful_Subscriptions_20_AFN"));	
				 s[i].put("CSuccessful_Subscriptions_5_AFN", rs.getString("CSuccessful_Subscriptions_5_AFN"));
				 s[i].put("CSuccessful_Subscriptions_3_AFN", rs.getString("CSuccessful_Subscriptions_3_AFN"));
				 s[i].put("CSuccessful_Subscriptions_1_AFN", rs.getString("CSuccessful_Subscriptions_1_AFN"));
				 
				 
				 s[i].put("SSubscription_Requests_80_AFN", rs.getString("SSubscription_Requests_80_AFN"));	
				 s[i].put("SSubscription_Requests_20_AFN", rs.getString("SSubscription_Requests_20_AFN"));		
				 s[i].put("SSubscription_Requests_5_AFN", rs.getString("SSubscription_Requests_5_AFN"));	
				 s[i].put("SSuccessful_Subscriptions_80_AFN", rs.getString("SSuccessful_Subscriptions_80_AFN"));	
				 s[i].put("SSuccessful_Subscriptions_20_AFN", rs.getString("SSuccessful_Subscriptions_20_AFN"));
				 s[i].put("SSuccessful_Subscriptions_5_AFN", rs.getString("SSuccessful_Subscriptions_5_AFN"));
				 s[i].put("SSuccessful_Subscriptions_3_AFN", rs.getString("SSuccessful_Subscriptions_3_AFN"));
				 s[i].put("SSuccessful_Subscriptions_1_AFN", rs.getString("SSuccessful_Subscriptions_1_AFN"));
				 
				 
				 s[i].put("USubscription_Requests_80_AFN", rs.getString("USubscription_Requests_80_AFN"));
				 s[i].put("USubscription_Requests_20_AFN", rs.getString("USubscription_Requests_20_AFN"));
				 s[i].put("USubscription_Requests_5_AFN", rs.getString("USubscription_Requests_5_AFN"));
				 s[i].put("USuccessful_Subscriptions_80_AFN", rs.getString("USuccessful_Subscriptions_80_AFN"));	
				 s[i].put("USuccessful_Subscriptions_20_AFN", rs.getString("USuccessful_Subscriptions_20_AFN"));	
				 s[i].put("USuccessful_Subscriptions_5_AFN", rs.getString("USuccessful_Subscriptions_5_AFN"));
				 s[i].put("USuccessful_Subscriptions_3_AFN", rs.getString("USuccessful_Subscriptions_3_AFN"));
				 s[i].put("USuccessful_Subscriptions_1_AFN", rs.getString("USuccessful_Subscriptions_1_AFN"));
				 
				 s[i].put("Subscription_Retry_80_AFN", rs.getString("Subscription_Retry_80_AFN"));	
				 s[i].put("Subscription_Retry_20_AFN", rs.getString("Subscription_Retry_20_AFN"));	
				 s[i].put("Subscription_Retry_5_AFN", rs.getString("Subscription_Retry_5_AFN"));	
				 s[i].put("Retry_Successful_80_AFN", rs.getString("Retry_Successful_80_AFN"));
				 s[i].put("Retry_Successful_20_AFN", rs.getString("Retry_Successful_20_AFN"));
				 s[i].put("Retry_Successful_5_AFN", rs.getString("Retry_Successful_5_AFN"));
				 s[i].put("Retry_Successful_3_AFN", rs.getString("Retry_Successful_3_AFN"));
				 s[i].put("Retry_Successful_1_AFN", rs.getString("Retry_Successful_1_AFN"));
				 s[i].put("Total_Retry_Successful", rs.getString("Total_Retry_Successful"));
				 
				 
				 s[i].put("Total_Subscription_Requests_80_AFN",rs.getString("Total_Subscription_Requests_80_AFN"));
				 s[i].put("Total_Subscription_Requests_20_AFN", rs.getString("Total_Subscription_Requests_20_AFN"));	
				 s[i].put("Total_Subscription_Requests_5_AFN", rs.getString("Total_Subscription_Requests_5_AFN"));	
				 s[i].put("Total_Subscription_Successful_80_AFN", rs.getString("Total_Subscription_Successful_80_AFN"));
				 s[i].put("Total_Subscription_Successful_20_AFN", rs.getString("Total_Subscription_Successful_20_AFN"));
				 s[i].put("Total_Subscription_Successful_5_AFN", rs.getString("Total_Subscription_Successful_5_AFN"));
				 s[i].put("Total_Subscription_Successful_3_AFN", rs.getString("Total_Subscription_Successful_3_AFN"));
				 s[i].put("Total_Subscription_Successful_1_AFN", rs.getString("Total_Subscription_Successful_1_AFN"));
				 s[i].put("Total_Subscription_Successful", rs.getString("Total_Subscription_Successful"));
				 
				 
				 s[i].put("Renewal_Requests_80_AFN", rs.getString("Renewal_Requests_80_AFN"));	
				 s[i].put("Renewal_Requests_20_AFN", rs.getString("Renewal_Requests_20_AFN"));	
				 s[i].put("Renewal_Requests_5_AFN", rs.getString("Renewal_Requests_5_AFN"));	
			//	 s[i].put("Total_Renewal_Requests", rs.getString("Total_Renewal_Requests"));
				 s[i].put("Renewal_Successful_80_AFN", rs.getString("Renewal_Successful_80_AFN"));
				 s[i].put("Renewal_Successful_20_AFN", rs.getString("Renewal_Successful_20_AFN"));
				 s[i].put("Renewal_Successful_5_AFN", rs.getString("Renewal_Successful_5_AFN"));
				 s[i].put("Renewal_Successful_3_AFN", rs.getString("Renewal_Successful_3_AFN"));
				 s[i].put("Renewal_Successful_1_AFN", rs.getString("Renewal_Successful_1_AFN"));
			//	 s[i].put("Total_Renewal_Successful", rs.getString("Total_Renewal_Successful"));
				 
				 
				 s[i].put("ivr",rs.getString("ivr"));
				 s[i].put("cci", rs.getString("cci"));
				 s[i].put("sms", rs.getString("sms"));
				 s[i].put("ussd", rs.getString("ussd"));
				 s[i].put("youth", rs.getString("youth"));
				 s[i].put("api", rs.getString("api"));
				 s[i].put("others", rs.getString("others"));
				 s[i].put("voluntary_Churn", rs.getString("voluntary_Churn"));
				 s[i].put("involuntary_churn", rs.getString("involuntary_churn"));
				 s[i].put("total_churn", rs.getString("total_churn"));
				
				 
				 s[i].put("song_dedication_request_5", rs.getString("song_dedication_request_5"));
				 s[i].put("song_dedication_successful", rs.getString("song_dedication_successful"));
				
				 s[i].put("crbt_request_received", rs.getString("crbt_request_received"));
				 s[i].put("successful_CRBT_Count", rs.getString("successful_CRBT_Count"));
				// s[i].put("facebook_post", rs.getString("facebook_post"));
				
				 s[i].put("top_up_requests_80", rs.getString("top_up_requests_80"));
				 s[i].put("top_up_successful_80", rs.getString("top_up_successful_80"));
				 s[i].put("top_up_requests_20", rs.getString("top_up_requests_20"));
				 s[i].put("top_up_successful_20", rs.getString("top_up_successful_20"));
				 s[i].put("top_up_requests_5", rs.getString("top_up_requests_5"));
				 s[i].put("top_up_successful_5", rs.getString("top_up_successful_5"));
				 
				 s[i].put("total_recordings", rs.getString("total_recordings"));
				 s[i].put("unique_recorders", rs.getString("unique_recorders"));
				 s[i].put("no_of_recordings_authorized", rs.getString("no_of_recordings_authorized"));
				 s[i].put("total_un_authorized_recordings", rs.getString("total_un_authorized_recordings"));
				 s[i].put("no_of_content_shared_to_users", rs.getString("no_of_content_shared_to_users"));
				 s[i].put("total_likes", rs.getString("total_likes"));
				 s[i].put("recording_per_users", rs.getString("recording_per_users"));
				 s[i].put("likes_recording", rs.getString("likes_recording"));
				
				 s[i].put("total_recordings_songs_s", rs.getString("total_recordings_songs_s"));
				 s[i].put("total_songs_authorised_s", rs.getString("total_songs_authorised_s"));
				 s[i].put("total_songs_not_authorised_s", rs.getString("total_songs_not_authorised_s"));
				 s[i].put("total_likes_on_songs_s", rs.getString("total_likes_on_songs_s"));
				 s[i].put("total_calls_on_songs_dac_s", rs.getString("total_calls_on_songs_dac_s"));
				 s[i].put("songs_abuse_reported_s", rs.getString("songs_abuse_reported_s"));
				 s[i].put("total_number_of_songs_shared_dedication_s", rs.getString("total_number_of_songs_shared_dedication_s"));
				 
				 s[i].put("total_recordings_songs_f", rs.getString("total_recordings_songs_f"));
				 s[i].put("total_songs_authorised_f", rs.getString("total_songs_authorised_f"));
				 s[i].put("total_songs_not_authorised_f", rs.getString("total_songs_not_authorised_f"));
				 s[i].put("total_likes_on_songs_f", rs.getString("total_likes_on_songs_f"));
				 s[i].put("total_calls_on_songs_dac_f", rs.getString("total_calls_on_songs_dac_f"));
				 s[i].put("songs_abuse_reported_f", rs.getString("songs_abuse_reported_f"));
				 s[i].put("total_number_of_songs_shared_dedication_f", rs.getString("total_number_of_songs_shared_dedication_f"));
				 
				 s[i].put("Top_Up_Revenue_80_AFN", rs.getString("Top_Up_Revenue_80_AFN"));
				 s[i].put("Top_Up_Revenue_20_AFN", rs.getString("Top_Up_Revenue_20_AFN"));
				 s[i].put("Top_Up_Revenue_5_AFN", rs.getString("Top_Up_Revenue_5_AFN"));
				 s[i].put("Total_Top_Up_Revenue", rs.getString("Total_Top_Up_Revenue"));
				 s[i].put("song_dedication_revenue", rs.getString("song_dedication_revenue"));
				 s[i].put("Subscription_Revenue_80_AFN", rs.getString("Subscription_Revenue_80_AFN"));
				 s[i].put("Subscription_Revenue_20_AFN", rs.getString("Subscription_Revenue_20_AFN"));
				 s[i].put("Subscription_Revenue_5_AFN", rs.getString("Subscription_Revenue_5_AFN"));
				 s[i].put("Subscription_Revenue_3_AFN", rs.getString("Subscription_Revenue_3_AFN"));
				 s[i].put("Subscription_Revenue_1_AFN", rs.getString("Subscription_Revenue_1_AFN"));
				 s[i].put("Total_Subscription_Revenue", rs.getString("Total_Subscription_Revenue"));
				 s[i].put("Renewal_Revenue_80_AFN", rs.getString("Renewal_Revenue_80_AFN"));
				 s[i].put("Renewal_Revenue_20_AFN", rs.getString("Renewal_Revenue_20_AFN"));
				 s[i].put("Renewal_Revenue_5_AFN", rs.getString("Renewal_Revenue_5_AFN"));
				 s[i].put("Renewal_Revenue_3_AFN", rs.getString("Renewal_Revenue_3_AFN"));
				 s[i].put("Renewal_Revenue_1_AFN", rs.getString("Renewal_Revenue_1_AFN"));
				 s[i].put("Total_Renewal_Revenue", rs.getString("Total_Renewal_Revenue"));
				/* s[i].put("gifted_Request_revenue_80", rs.getString("gifted_Request_revenue_80"));
				 s[i].put("gifted_Request_revenue_20", rs.getString("gifted_Request_revenue_20"));
				 s[i].put("gifted_Request_revenue_5", rs.getString("gifted_Request_revenue_5"));
				 s[i].put("total_gifted_Request_revenue", rs.getString("total_gifted_Request_revenue"));*/
				 s[i].put("total_revenue", rs.getString("total_revenue"));
				
				 s[i].put("net_Additions", rs.getString("net_Additions"));
				 s[i].put("active_Base", rs.getString("active_Base"));
				 s[i].put("grace_Base", rs.getString("grace_Base"));
				 s[i].put("retry_base", rs.getString("retry_base"));
				 
				 s[i].put("aon_activebase0_30_days", rs.getString("aon_activebase0_30_days"));
				 s[i].put("aon_activebase31_90_days", rs.getString("aon_activebase31_90_days"));
				 s[i].put("aon_activebase91_180_days", rs.getString("aon_activebase91_180_days"));
				 s[i].put("aon_activebase180_365_days", rs.getString("aon_activebase180_365_days"));
				 s[i].put("aon_activebase365_days", rs.getString("aon_activebase365_days"));
				 
				 s[i].put("aon_churnbase0_10_days", rs.getString("aon_churnbase0_10_days"));
				 s[i].put("aon_churnbase11_30_days", rs.getString("aon_churnbase11_30_days"));
				 s[i].put("aon_churnbase31_60_days", rs.getString("aon_churnbase31_60_days"));
				 s[i].put("aon_churnbase61_90_days", rs.getString("aon_churnbase61_90_days"));
				 s[i].put("aon_churnbase91_days", rs.getString("aon_churnbase91_days"));
				 
				 s[i].put("mou_bucket0_Mins", rs.getString("mou_bucket0_Mins"));
				 s[i].put("mou_bucket0_2_Mins", rs.getString("mou_bucket0_2_Mins"));
				 s[i].put("mou_bucket3_5_Mins", rs.getString("mou_bucket3_5_Mins"));
				 s[i].put("mou_bucket6_10_Mins", rs.getString("mou_bucket6_10_Mins"));
				 s[i].put("mou_bucket11_15_Min", rs.getString("mou_bucket11_15_Min"));
				 s[i].put("mou_bucket16_25_Mins", rs.getString("mou_bucket16_25_Mins"));
				 s[i].put("mou_bucket26_50_Mins", rs.getString("mou_bucket26_50_Mins"));
				 s[i].put("mou_bucket51_Mins", rs.getString("mou_bucket51_Mins"));
				 
				 s[i].put("arpu", rs.getString("arpu"));
				 s[i].put("arpu_Calls_per_Unique_User", rs.getString("arpu_Calls_per_Unique_User"));
				 s[i].put("arpu_Calls_Per_Unique_Live_User", rs.getString("arpu_Calls_Per_Unique_Live_User"));
				 s[i].put("arpu_MOU_Per_Unique_User", rs.getString("arpu_MOU_Per_Unique_User"));
				 s[i].put("arpu_MOU_Per_Unique_Live_User", rs.getString("arpu_MOU_Per_Unique_Live_User"));
				 s[i].put("arpu_MOU_Per_Call", rs.getString("arpu_MOU_Per_Call"));
				 s[i].put("arpu_Pulses_Per_Unique_User",rs.getString("arpu_Pulses_Per_Unique_User"));
				 s[i].put("arpu_Pulses_per_Unique_Live_User", rs.getString("arpu_Pulses_per_Unique_Live_User"));
				 s[i].put("arpu_Pulse_Per_Call", rs.getString("arpu_Pulse_Per_Call"));

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