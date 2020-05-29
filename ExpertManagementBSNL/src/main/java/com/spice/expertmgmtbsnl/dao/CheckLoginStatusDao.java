package com.spice.expertmgmtbsnl.dao;

import java.util.ArrayList;
import java.util.List;

import com.spice.expertmgmtbsnl.model.CheckLoginStatusModel;
import com.spice.expertmgmtbsnl.model.HourlyReportModel;

public interface CheckLoginStatusDao {
	public List<CheckLoginStatusModel> checkLoginStatusModel();
	public List<CheckLoginStatusModel> checkLoginStatusModelPartner(String partner_name);
	public int changeLoginStatus(String p_ani,String p_status);
	public ArrayList<HourlyReportModel> fetchHourlyReport(String fromdate,String toDate);
	public ArrayList<HourlyReportModel> fetchHourlyReportPartner(String fromdate,String toDate);

}
