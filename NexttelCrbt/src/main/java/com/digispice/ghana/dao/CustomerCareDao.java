package com.digispice.ghana.dao;

import java.util.ArrayList;
import java.util.Map;

public interface CustomerCareDao {
	
	public String unSubsCustomer(String ani);
	public ArrayList<Map<String, String>> fetchSUBDetail(String msisdn, String userId, String IP);
	public ArrayList<Map<String, String>> fetchCRBTSUBDetail(String msisdn, String userId, String IP);
	public ArrayList<Map<String, String>> fetchUNSUBDetail(String msisdn, String userId, String IP);
	public ArrayList<Map<String, String>> fetchSMSRenewalDetail(String msisdn, String userId, String IP);
	public ArrayList<Map<String, String>> fetchRESUBDetail(String msisdn, String userId, String IP);
	public ArrayList<Map<String, String>> fetchDownloadDetail(String msisdn, String userId, String IP);
	public ArrayList<Map<String, String>> fetchDedicationDetail(String msisdn, String userId, String IP);
	public ArrayList<Map<String, String>> fetchBrowsingDetail(String msisdn, String userId, String IP);
	public ArrayList<Map<String, String>> fetchCustomerSummaryDetail(String msisdn, String userId, String IP);
	public ArrayList<String> fetchSubcategory(String cat);
	public ArrayList<Map<String, String>> getSearchMethod(String searchType,String searchString,String cat,String subCategory);
	public String setRBTCustomer(String mobile_number,String song_ID,String pack,String rbt_name);
	public String delTone(String mobile_number,String tone_code);
}
