package com.spice.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.spice.connection.DBConnection;

public class KaraokeMisBean {

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
		 String query = "select * from awcc_karaoke.karaoke_mis_report  where date_time between '"+sdate+"' and '"+edate+"' order by date_time asc";
		 System.out.println("Select Query is --"+query);
		 Map[] s = null;
		 int length = 0;
		 
		 int i = 0;
		 try {
			 conn = DBConnection.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select count(1) as cnt from awcc_karaoke.karaoke_mis_report  where date_time between '"+sdate+"' and '"+edate+"' ") ;
			 while(rs.next()) {
				 length = rs.getInt("cnt");
			 }
			 rs = null;
			 rs = stmt.executeQuery(query);
			 s = new HashMap[length];
			 while(rs.next()) {
				 s[i] = new HashMap();
				 s[i].put("date_time", (rs.getString("date_time")).substring(0, 10));
				 
				 s[i].put("ASubscription_Requests_80_AFN", rs.getString("ASubscription_Requests_80_AFN"));		
				 s[i].put("ASubscription_Requests_20_AFN", rs.getString("ASubscription_Requests_20_AFN"));		
				 s[i].put("ASubscription_Requests_5_AFN", rs.getString("ASubscription_Requests_5_AFN"));		
				 s[i].put("ASuccessful_Subscriptions_80_AFN", rs.getString("ASuccessful_Subscriptions_80_AFN"));	
				 s[i].put("ASuccessful_Subscriptions_20_AFN", rs.getString("ASuccessful_Subscriptions_20_AFN"));	
				 s[i].put("ASuccessful_Subscriptions_5_AFN", rs.getString("ASuccessful_Subscriptions_5_AFN"));
				 s[i].put("ASuccessful_Subscriptions_3_AFN", rs.getString("ASuccessful_Subscriptions_3_AFN"));
				 s[i].put("ASuccessful_Subscriptions_1_AFN", rs.getString("ASuccessful_Subscriptions_1_AFN"));
				 
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
				 s[i].put("Renewal_Successful_80_AFN", rs.getString("Renewal_Successful_80_AFN"));
				 s[i].put("Renewal_Successful_20_AFN", rs.getString("Renewal_Successful_20_AFN"));
				 s[i].put("Renewal_Successful_5_AFN", rs.getString("Renewal_Successful_5_AFN"));
				 s[i].put("Renewal_Successful_3_AFN", rs.getString("Renewal_Successful_3_AFN"));
				 s[i].put("Renewal_Successful_1_AFN", rs.getString("Renewal_Successful_1_AFN"));
				 
				 s[i].put("app",rs.getString("app"));
				 
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
				 s[i].put("total_revenue", rs.getString("total_revenue"));
				
				 s[i].put("net_Additions", rs.getString("net_Additions"));
				 s[i].put("active_Base", rs.getString("active_Base"));
				 s[i].put("grace_Base", rs.getString("grace_Base"));
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