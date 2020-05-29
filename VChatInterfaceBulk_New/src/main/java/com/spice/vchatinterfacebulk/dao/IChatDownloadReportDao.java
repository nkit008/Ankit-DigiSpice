package com.spice.vchatinterfacebulk.dao;

import java.io.InputStream;
import java.util.List;

import com.spice.vchatinterfacebulk.beans.ChatOutDialLog;

public interface IChatDownloadReportDao {
	
	public InputStream getReport(String hub);
	
	public InputStream getPartnerReport(String hub);
	
	public List<ChatOutDialLog> getOutdialLog(String hub,String dataType,String number);

}
