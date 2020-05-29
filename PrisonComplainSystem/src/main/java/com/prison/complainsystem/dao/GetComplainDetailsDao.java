package com.prison.complainsystem.dao;

import java.util.List;
import java.util.Map;

import com.prison.complainsystem.model.AllComplainModel;
import com.prison.complainsystem.model.ConnectivityComplainModel;
import com.prison.complainsystem.model.HardwareComplainModel;
import com.prison.complainsystem.model.PhysicalDamageModel;
import com.prison.complainsystem.model.SoftwareComplainModel;
import com.prison.complainsystem.model.UpdateComplainModel;

public interface GetComplainDetailsDao {
	
	public List<AllComplainModel> getConnectionCompDetail();
	public Map<String,String> getCompCount();
	
	
	public List<AllComplainModel> getHwCompDetail();
	public List<AllComplainModel> getSwCompDetail();
	public List<AllComplainModel> getPhysicalCompDetail();
	public List<AllComplainModel> getconnCompDetail();
	
/*	public int softwareUpdate(UpdateComplainModel openupdate);
	public int hardwareUpdate(UpdateComplainModel openupdate);
	public int physicalUpdate(UpdateComplainModel openupdate);
	public int connectivityUpdate(UpdateComplainModel openupdate);*/
	
	public List<AllComplainModel> getSingleComplainDetail(String id);
	public List<AllComplainModel> getComplainHistory(String id);

}
