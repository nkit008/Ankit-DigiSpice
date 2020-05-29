package com.spice.expertmgmtbsnl.dao;

public interface BulkOptionDao {
	
	public String[] bulkOptionStatusChanged(String[] chatid,String zone,String operation);
	
	public String[] bulkOptionCallLimitChanged(String[] chatid,String zone,String operation,String call_limit);

}
