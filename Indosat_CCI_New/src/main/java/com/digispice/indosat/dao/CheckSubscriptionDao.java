package com.digispice.indosat.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public interface CheckSubscriptionDao {
	
	ArrayList<HashMap<String,String>> getSubscription(String mobile);
	public ArrayList<HashMap<String,String>> getBillingDetails(String ani);
	public String doUnsubscribe(String ani , String MainService, String service);
	public HashMap<String, String> showPackTypeDetails(String service_name);
	public String goSubscription(String mobile,String service_name,String cat,String packType);
	public ArrayList<HashMap<String,String>> getUnSubscriptionDetails(String ani);
	
	public ResultSet getMISSummaryData(String fromDate, String toDate);
	

}
