package com.spice.expertmgmtbsnl.dao;

import java.util.List;

import com.spice.expertmgmtbsnl.model.LoginLogoutSummaryModel;

public interface LoginLogoutSummaryDao {

	public List<LoginLogoutSummaryModel> getSummary(String id);
	public List<LoginLogoutSummaryModel> getSummaryPartner(String id,String partner_name);
}
