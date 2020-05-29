package com.spice.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.spice.connection.DBConnection;

public class UssdIslamicBean {
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
		 int total_sub_req_rec_15=0;
		 int total_sub_req_rec_5=0;
		 int total_sub_req_rec_2=0;
		 int total_sub_suc_15=0;
		 int total_sub_suc_5=0;
		 int total_sub_suc_2=0;
		 int total_resub_req_rec_15=0;
		 int total_resub_req_rec_5=0;
		 int total_resub_req_rec_2=0;
		 int total_resub_suc_15=0;
		 int total_resub_suc_5=0;
		 int total_resub_suc_2=0;
		 int total_sub_revenue=0;
		 int total_resub_revenue=0;
		 String query = "select * from ussd_islamic.tbl_ussd_islamic_mis_summary1  where date_time between '"+sdate+"' and '"+edate+"' order by date_time asc";
		 System.out.println("Select Query is --"+query);
		 Map[] s = null;
		 int length = 0;
		 
		 int i = 0;
		 try {
			 conn = DBConnection.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select count(1) as cnt from ussd_islamic.tbl_ussd_islamic_mis_summary1  where date_time between '"+sdate+"' and '"+edate+"' ") ;
			 while(rs.next()) {
				 length = rs.getInt("cnt");
			 }
			 rs = null;
			 rs = stmt.executeQuery(query);
			 s = new HashMap[length];
			 while(rs.next()) {
				 s[i] = new HashMap();
				 total_sub_req_rec_15=rs.getInt("subscription_requests_received__15_afn_ih")+rs.getInt("subscription_requests_received__15_afn_id")+rs.getInt("subscription_requests_received__15_afn_ia")+rs.getInt("subscription_requests_received__15_afn_is")+rs.getInt("subscription_requests_received__15_afn_if")+rs.getInt("subscription_requests_received__15_afn_iq")+rs.getInt("subscription_requests_received__15_afn_ii")+rs.getInt("subscription_requests_received__15_afn_iaz");
				 total_sub_req_rec_5=rs.getInt("subscription_requests_received__5_afn_ih")+rs.getInt("subscription_requests_received__5_afn_id")+rs.getInt("subscription_requests_received__5_afn_ia")+rs.getInt("subscription_requests_received__5_afn_is")+rs.getInt("subscription_requests_received__5_afn_if")+rs.getInt("subscription_requests_received__5_afn_iq")+rs.getInt("subscription_requests_received__5_afn_ii")+rs.getInt("subscription_requests_received__5_afn_iaz");
				 total_sub_req_rec_2=rs.getInt("subscription_requests_received__2_afn_ih")+rs.getInt("subscription_requests_received__2_afn_id")+rs.getInt("subscription_requests_received__2_afn_ia")+rs.getInt("subscription_requests_received__2_afn_is")+rs.getInt("subscription_requests_received__2_afn_if")+rs.getInt("subscription_requests_received__2_afn_iq")+rs.getInt("subscription_requests_received__2_afn_ii")+rs.getInt("subscription_requests_received__2_afn_iaz");
				 total_sub_suc_15=rs.getInt("successful_subscriptions__15_afn_ih")+rs.getInt("successful_subscriptions__15_afn_id")+rs.getInt("successful_subscriptions__15_afn_ia")+rs.getInt("successful_subscriptions__15_afn_is")+rs.getInt("successful_subscriptions__15_afn_if")+rs.getInt("successful_subscriptions__15_afn_iq")+rs.getInt("successful_subscriptions__15_afn_ii")+rs.getInt("successful_subscriptions__15_afn_iaz");
				 total_sub_suc_5=rs.getInt("successful_subscriptions__5_afn_ih")+rs.getInt("successful_subscriptions__5_afn_id")+rs.getInt("successful_subscriptions__5_afn_ia")+rs.getInt("successful_subscriptions__5_afn_is")+rs.getInt("successful_subscriptions__5_afn_if")+rs.getInt("successful_subscriptions__5_afn_iq")+rs.getInt("successful_subscriptions__5_afn_ii")+rs.getInt("successful_subscriptions__5_afn_iaz");
				 total_sub_suc_2=rs.getInt("successful_subscriptions__2_afn_ih")+rs.getInt("successful_subscriptions__2_afn_id")+rs.getInt("successful_subscriptions__2_afn_ia")+rs.getInt("successful_subscriptions__2_afn_is")+rs.getInt("successful_subscriptions__2_afn_if")+rs.getInt("successful_subscriptions__2_afn_iq")+rs.getInt("successful_subscriptions__2_afn_ii")+rs.getInt("successful_subscriptions__2_afn_iaz");
				 total_resub_req_rec_15=rs.getInt("subscription_retry__15_afn_ih")+rs.getInt("subscription_retry__15_afn_id")+rs.getInt("subscription_retry__15_afn_ia")+rs.getInt("subscription_retry__15_afn_is")+rs.getInt("subscription_retry__15_afn_if")+rs.getInt("subscription_retry__15_afn_iq")+rs.getInt("subscription_retry__15_afn_ii")+rs.getInt("subscription_retry__15_afn_iaz");
				 total_resub_req_rec_5=rs.getInt("subscription_retry__5_afn_ih")+rs.getInt("subscription_retry__5_afn_id")+rs.getInt("subscription_retry__5_afn_ia")+rs.getInt("subscription_retry__5_afn_is")+rs.getInt("subscription_retry__5_afn_if")+rs.getInt("subscription_retry__5_afn_iq")+rs.getInt("subscription_retry__5_afn_ii")+rs.getInt("subscription_retry__5_afn_iaz");
				 total_resub_req_rec_2=rs.getInt("subscription_retry__2_afn_ih")+rs.getInt("subscription_retry__2_afn_id")+rs.getInt("subscription_retry__2_afn_ia")+rs.getInt("subscription_retry__2_afn_is")+rs.getInt("subscription_retry__2_afn_if")+rs.getInt("subscription_retry__2_afn_iq")+rs.getInt("subscription_retry__2_afn_ii")+rs.getInt("subscription_retry__2_afn_iaz");
				 total_resub_suc_15=rs.getInt("retry_successfull__15_afn_ih")+rs.getInt("retry_successfull__15_afn_id")+rs.getInt("retry_successfull__15_afn_ia")+rs.getInt("retry_successfull__15_afn_is")+rs.getInt("retry_successfull__15_afn_if")+rs.getInt("retry_successfull__15_afn_iq")+rs.getInt("retry_successfull__15_afn_ii")+rs.getInt("retry_successfull__15_afn_iaz");
				 total_resub_suc_5=rs.getInt("retry_successfull__5_afn_ih")+rs.getInt("retry_successfull__5_afn_id")+rs.getInt("retry_successfull__5_afn_ia")+rs.getInt("retry_successfull__5_afn_is")+rs.getInt("retry_successfull__5_afn_if")+rs.getInt("retry_successfull__5_afn_iq")+rs.getInt("retry_successfull__5_afn_ii")+rs.getInt("retry_successfull__5_afn_iaz");
				 total_resub_suc_2=rs.getInt("retry_successfull__2_afn_ih")+rs.getInt("retry_successfull__2_afn_id")+rs.getInt("retry_successfull__2_afn_ia")+rs.getInt("retry_successfull__2_afn_is")+rs.getInt("retry_successfull__2_afn_if")+rs.getInt("retry_successfull__2_afn_iq")+rs.getInt("retry_successfull__2_afn_ii")+rs.getInt("retry_successfull__2_afn_iaz");
				 total_sub_revenue=rs.getInt("total_subscription_revenue_ih")+rs.getInt("total_subscription_revenue_id")+rs.getInt("total_subscription_revenue_ia")+rs.getInt("total_subscription_revenue_is")+rs.getInt("total_subscription_revenue_if")+rs.getInt("total_subscription_revenue_iq")+rs.getInt("total_subscription_revenue_ii")+rs.getInt("total_subscription_revenue_iaz");
				 total_resub_revenue=rs.getInt("total_resubscription_revenue_ih")+rs.getInt("total_resubscription_revenue_id")+rs.getInt("total_resubscription_revenue_ia")+rs.getInt("total_resubscription_revenue_is")+rs.getInt("total_resubscription_revenue_if")+rs.getInt("total_resubscription_revenue_iq")+rs.getInt("total_resubscription_revenue_ii")+rs.getInt("total_resubscription_revenue_iaz");
				 s[i].put("subscription_requests_received__15_afn_ih", rs.getString("subscription_requests_received__15_afn_ih"));
				 s[i].put("subscription_requests_received__5_afn_ih", rs.getString("subscription_requests_received__5_afn_ih"));
				 s[i].put("subscription_requests_received__2_afn_ih", rs.getString("subscription_requests_received__2_afn_ih"));
				 s[i].put("successful_subscriptions__15_afn_ih", rs.getString("successful_subscriptions__15_afn_ih"));
				 s[i].put("successful_subscriptions__5_afn_ih", rs.getString("successful_subscriptions__5_afn_ih"));
				 s[i].put("successful_subscriptions__2_afn_ih", rs.getString("successful_subscriptions__2_afn_ih"));
				 s[i].put("subscription_retry__15_afn_ih", rs.getString("subscription_retry__15_afn_ih"));
				 s[i].put("subscription_retry__5_afn_ih", rs.getString("subscription_retry__5_afn_ih"));
				 s[i].put("subscription_retry__2_afn_ih", rs.getString("subscription_retry__2_afn_ih"));
				 s[i].put("retry_successfull__15_afn_ih", rs.getString("retry_successfull__15_afn_ih"));
				 s[i].put("retry_successfull__5_afn_ih", rs.getString("retry_successfull__5_afn_ih"));
				 s[i].put("retry_successfull__2_afn_ih", rs.getString("retry_successfull__2_afn_ih"));
				 s[i].put("total_subscription_revenue_ih", rs.getString("total_subscription_revenue_ih"));
				 s[i].put("total_resubscription_revenue_ih", rs.getString("total_resubscription_revenue_ih"));
				 s[i].put("subscription_requests_received__15_afn_id", rs.getString("subscription_requests_received__15_afn_id"));
				 s[i].put("subscription_requests_received__5_afn_id", rs.getString("subscription_requests_received__5_afn_id"));
				 s[i].put("subscription_requests_received__2_afn_id", rs.getString("subscription_requests_received__2_afn_id"));
				 s[i].put("successful_subscriptions__15_afn_id", rs.getString("successful_subscriptions__15_afn_id"));
				 s[i].put("successful_subscriptions__5_afn_id", rs.getString("successful_subscriptions__5_afn_id"));
				 s[i].put("successful_subscriptions__2_afn_id", rs.getString("successful_subscriptions__2_afn_id"));
				 s[i].put("subscription_retry__15_afn_id", rs.getString("subscription_retry__15_afn_id"));
				 s[i].put("subscription_retry__5_afn_id", rs.getString("subscription_retry__5_afn_id"));
				 s[i].put("subscription_retry__2_afn_id", rs.getString("subscription_retry__2_afn_id"));
				 s[i].put("retry_successfull__15_afn_id", rs.getString("retry_successfull__15_afn_id"));
				 s[i].put("retry_successfull__5_afn_id", rs.getString("retry_successfull__5_afn_id"));
				 s[i].put("retry_successfull__2_afn_id", rs.getString("retry_successfull__2_afn_id"));
				 s[i].put("total_subscription_revenue_id", rs.getString("total_subscription_revenue_id"));
				 s[i].put("total_resubscription_revenue_id", rs.getString("total_resubscription_revenue_id"));
				 s[i].put("subscription_requests_received__15_afn_ia", rs.getString("subscription_requests_received__15_afn_ia"));
				 s[i].put("subscription_requests_received__5_afn_ia", rs.getString("subscription_requests_received__5_afn_ia"));
				 s[i].put("subscription_requests_received__2_afn_ia", rs.getString("subscription_requests_received__2_afn_ia"));
				 s[i].put("successful_subscriptions__15_afn_ia", rs.getString("successful_subscriptions__15_afn_ia"));
				 s[i].put("successful_subscriptions__5_afn_ia", rs.getString("successful_subscriptions__5_afn_ia"));
				 s[i].put("successful_subscriptions__2_afn_ia", rs.getString("successful_subscriptions__2_afn_ia"));
				 s[i].put("subscription_retry__15_afn_ia", rs.getString("subscription_retry__15_afn_ia"));
				 s[i].put("subscription_retry__5_afn_ia", rs.getString("subscription_retry__5_afn_ia"));
				 s[i].put("subscription_retry__2_afn_ia", rs.getString("subscription_retry__2_afn_ia"));
				 s[i].put("retry_successfull__15_afn_ia", rs.getString("retry_successfull__15_afn_ia"));
				 s[i].put("retry_successfull__5_afn_ia", rs.getString("retry_successfull__5_afn_ia"));
				 s[i].put("retry_successfull__2_afn_ia", rs.getString("retry_successfull__2_afn_ia"));
				 s[i].put("total_subscription_revenue_ia", rs.getString("total_subscription_revenue_ia"));
				 s[i].put("total_resubscription_revenue_ia", rs.getString("total_resubscription_revenue_ia"));
				 s[i].put("subscription_requests_received__15_afn_is", rs.getString("subscription_requests_received__15_afn_is"));
				 s[i].put("subscription_requests_received__5_afn_is", rs.getString("subscription_requests_received__5_afn_is"));
				 s[i].put("subscription_requests_received__2_afn_is", rs.getString("subscription_requests_received__2_afn_is"));
				 s[i].put("successful_subscriptions__15_afn_is", rs.getString("successful_subscriptions__15_afn_is"));
				 s[i].put("successful_subscriptions__5_afn_is", rs.getString("successful_subscriptions__5_afn_is"));
				 s[i].put("successful_subscriptions__2_afn_is", rs.getString("successful_subscriptions__2_afn_is"));
				 s[i].put("subscription_retry__15_afn_is", rs.getString("subscription_retry__15_afn_is"));
				 s[i].put("subscription_retry__5_afn_is", rs.getString("subscription_retry__5_afn_is"));
				 s[i].put("subscription_retry__2_afn_is", rs.getString("subscription_retry__2_afn_is"));
				 s[i].put("retry_successfull__15_afn_is", rs.getString("retry_successfull__15_afn_is"));
				 s[i].put("retry_successfull__5_afn_is", rs.getString("retry_successfull__5_afn_is"));
				 s[i].put("retry_successfull__2_afn_is", rs.getString("retry_successfull__2_afn_is"));
				 s[i].put("total_subscription_revenue_is", rs.getString("total_subscription_revenue_is"));
				 s[i].put("total_resubscription_revenue_is", rs.getString("total_resubscription_revenue_is"));
				 s[i].put("subscription_requests_received__15_afn_if", rs.getString("subscription_requests_received__15_afn_if"));
				 s[i].put("subscription_requests_received__5_afn_if", rs.getString("subscription_requests_received__5_afn_if"));
				 s[i].put("subscription_requests_received__2_afn_if", rs.getString("subscription_requests_received__2_afn_if"));
				 s[i].put("successful_subscriptions__15_afn_if", rs.getString("successful_subscriptions__15_afn_if"));
				 s[i].put("successful_subscriptions__5_afn_if", rs.getString("successful_subscriptions__5_afn_if"));
				 s[i].put("successful_subscriptions__2_afn_if", rs.getString("successful_subscriptions__2_afn_if"));
				 s[i].put("subscription_retry__15_afn_if", rs.getString("subscription_retry__15_afn_if"));
				 s[i].put("subscription_retry__5_afn_if", rs.getString("subscription_retry__5_afn_if"));
				 s[i].put("subscription_retry__2_afn_if", rs.getString("subscription_retry__2_afn_if"));
				 s[i].put("retry_successfull__15_afn_if", rs.getString("retry_successfull__15_afn_if"));
				 s[i].put("retry_successfull__5_afn_if", rs.getString("retry_successfull__5_afn_if"));
				 s[i].put("retry_successfull__2_afn_if", rs.getString("retry_successfull__2_afn_if"));
				 s[i].put("total_subscription_revenue_if", rs.getString("total_subscription_revenue_if"));
				 s[i].put("total_resubscription_revenue_if", rs.getString("total_resubscription_revenue_if"));
				 s[i].put("subscription_requests_received__15_afn_iq", rs.getString("subscription_requests_received__15_afn_iq"));
				 s[i].put("subscription_requests_received__5_afn_iq", rs.getString("subscription_requests_received__5_afn_iq"));
				 s[i].put("subscription_requests_received__2_afn_iq", rs.getString("subscription_requests_received__2_afn_iq"));
				 s[i].put("successful_subscriptions__15_afn_iq", rs.getString("successful_subscriptions__15_afn_iq"));
				 s[i].put("successful_subscriptions__5_afn_iq", rs.getString("successful_subscriptions__5_afn_iq"));
				 s[i].put("successful_subscriptions__2_afn_iq", rs.getString("successful_subscriptions__2_afn_iq"));
				 s[i].put("subscription_retry__15_afn_iq", rs.getString("subscription_retry__15_afn_iq"));
				 s[i].put("subscription_retry__5_afn_iq", rs.getString("subscription_retry__5_afn_iq"));
				 s[i].put("subscription_retry__2_afn_iq", rs.getString("subscription_retry__2_afn_iq"));
				 s[i].put("retry_successfull__15_afn_iq", rs.getString("retry_successfull__15_afn_iq"));
				 s[i].put("retry_successfull__5_afn_iq", rs.getString("retry_successfull__5_afn_iq"));
				 s[i].put("retry_successfull__2_afn_iq", rs.getString("retry_successfull__2_afn_iq"));
				 s[i].put("total_subscription_revenue_iq", rs.getString("total_subscription_revenue_iq"));
				 s[i].put("total_resubscription_revenue_iq", rs.getString("total_resubscription_revenue_iq"));
				 s[i].put("subscription_requests_received__15_afn_ii", rs.getString("subscription_requests_received__15_afn_ii"));
				 s[i].put("subscription_requests_received__5_afn_ii", rs.getString("subscription_requests_received__5_afn_ii"));
				 s[i].put("subscription_requests_received__2_afn_ii", rs.getString("subscription_requests_received__2_afn_ii"));
				 s[i].put("successful_subscriptions__15_afn_ii", rs.getString("successful_subscriptions__15_afn_ii"));
				 s[i].put("successful_subscriptions__5_afn_ii", rs.getString("successful_subscriptions__5_afn_ii"));
				 s[i].put("successful_subscriptions__2_afn_ii", rs.getString("successful_subscriptions__2_afn_ii"));
				 s[i].put("subscription_retry__15_afn_ii", rs.getString("subscription_retry__15_afn_ii"));
				 s[i].put("subscription_retry__5_afn_ii", rs.getString("subscription_retry__5_afn_ii"));
				 s[i].put("subscription_retry__2_afn_ii", rs.getString("subscription_retry__2_afn_ii"));
				 s[i].put("retry_successfull__15_afn_ii", rs.getString("retry_successfull__15_afn_ii"));
				 s[i].put("retry_successfull__5_afn_ii", rs.getString("retry_successfull__5_afn_ii"));
				 s[i].put("retry_successfull__2_afn_ii", rs.getString("retry_successfull__2_afn_ii"));
				 s[i].put("total_subscription_revenue_ii", rs.getString("total_subscription_revenue_ii"));
				 s[i].put("total_resubscription_revenue_ii", rs.getString("total_resubscription_revenue_ii"));
				 s[i].put("subscription_requests_received__15_afn_iaz", rs.getString("subscription_requests_received__15_afn_iaz"));
				 s[i].put("subscription_requests_received__5_afn_iaz", rs.getString("subscription_requests_received__5_afn_iaz"));
				 s[i].put("subscription_requests_received__2_afn_iaz", rs.getString("subscription_requests_received__2_afn_iaz"));
				 s[i].put("successful_subscriptions__15_afn_iaz", rs.getString("successful_subscriptions__15_afn_iaz"));
				 s[i].put("successful_subscriptions__5_afn_iaz", rs.getString("successful_subscriptions__5_afn_iaz"));
				 s[i].put("successful_subscriptions__2_afn_iaz", rs.getString("successful_subscriptions__2_afn_iaz"));
				 s[i].put("subscription_retry__15_afn_iaz", rs.getString("subscription_retry__15_afn_iaz"));
				 s[i].put("subscription_retry__5_afn_iaz", rs.getString("subscription_retry__5_afn_iaz"));
				 s[i].put("subscription_retry__2_afn_iaz", rs.getString("subscription_retry__2_afn_iaz"));
				 s[i].put("retry_successfull__15_afn_iaz", rs.getString("retry_successfull__15_afn_iaz"));
				 s[i].put("retry_successfull__5_afn_iaz", rs.getString("retry_successfull__5_afn_iaz"));
				 s[i].put("retry_successfull__2_afn_iaz", rs.getString("retry_successfull__2_afn_iaz"));
				 s[i].put("total_subscription_revenue_iaz", rs.getString("total_subscription_revenue_iaz"));
				 s[i].put("total_resubscription_revenue_iaz", rs.getString("total_resubscription_revenue_iaz"));
				 
				 s[i].put("total_subscription_requests_15_afn", rs.getString("total_subscription_requests_15_afn"));
				 s[i].put("total_subscription_requests_5_afn", rs.getString("total_subscription_requests_5_afn"));
				 s[i].put("total_subscription_requests_2_afn", rs.getString("total_subscription_requests_2_afn"));
				 s[i].put("total_subscription_successfull_15_afn", rs.getString("total_subscription_successfull_15_afn"));
				 s[i].put("total_subscription_successfull_5_afn", rs.getString("total_subscription_successfull_5_afn"));
				 s[i].put("total_subscription_successfull_2_afn", rs.getString("total_subscription_successfull_2_afn"));
				 s[i].put("total_subscription_successfull", rs.getString("total_subscription_successfull"));
				 
				 s[i].put("active_Base", rs.getString("active_Base"));
				 s[i].put("grace_Base", rs.getString("grace_Base"));
				 s[i].put("retry_base", rs.getString("retry_base"));
				 
				 s[i].put("cci", rs.getString("cci"));
				 s[i].put("sms", rs.getString("sms"));
				 s[i].put("ussd", rs.getString("ussd"));
				 s[i].put("voluntary_Churn", rs.getString("voluntary_Churn"));
				 s[i].put("involuntary_churn", rs.getString("involuntary_churn"));
				 s[i].put("total_churn", rs.getString("total_churn"));
				 
				 s[i].put("total_sub_req_rec_15", total_sub_req_rec_15);
				 s[i].put("total_sub_req_rec_5", total_sub_req_rec_5);
				 s[i].put("total_sub_req_rec_2", total_sub_req_rec_2);
				 s[i].put("total_sub_suc_15", total_sub_suc_15);
				 s[i].put("total_sub_suc_5", total_sub_suc_5);
				 s[i].put("total_sub_suc_2", total_sub_suc_2);
				 s[i].put("total_resub_req_rec_15", total_resub_req_rec_15);
				 s[i].put("total_resub_req_rec_5", total_resub_req_rec_5);
				 s[i].put("total_resub_req_rec_2", total_resub_req_rec_2);
				 s[i].put("total_resub_suc_15", total_resub_suc_15);
				 s[i].put("total_resub_suc_5", total_resub_suc_5);
				 s[i].put("total_resub_suc_2", total_resub_suc_2);
				 s[i].put("total_sub_revenue", total_sub_revenue);
				 s[i].put("total_resub_revenue", total_resub_revenue);
				 s[i].put("total_grand_revenue", rs.getString("total_grand_revenue"));
				 s[i].put("total_grand_subscription_revenue", rs.getString("total_grand_subscription_revenue"));
				 s[i].put("total_grand_resubscription_revenue", rs.getString("total_grand_resubscription_revenue"));
				 s[i].put("date_time", (rs.getString("date_time")).substring(0, 10));
				 
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