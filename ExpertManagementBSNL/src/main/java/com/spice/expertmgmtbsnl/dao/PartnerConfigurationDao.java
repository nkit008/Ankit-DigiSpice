package com.spice.expertmgmtbsnl.dao;

import java.util.List;

import com.spice.expertmgmtbsnl.model.ConfigureNewPartnerModel;

public interface PartnerConfigurationDao {

	public String addNewPartner(ConfigureNewPartnerModel addPartner);
	public List<ConfigureNewPartnerModel> getAllConfigurepartner();
	public int deletePartner(String partnerId);
	public int editPartner(ConfigureNewPartnerModel addPartner,String userId);
}
