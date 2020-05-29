package com.digispice.ghana.dao;

public interface CheckStatusDao {
	
	public int fetchCountSUBDetail(String msisdn, String userId);
	public int fetchCountCRBTSUBDetail(String msisdn, String userId);
	public int fetchCountUNSUBDetail(String msisdn, String userId);

}
