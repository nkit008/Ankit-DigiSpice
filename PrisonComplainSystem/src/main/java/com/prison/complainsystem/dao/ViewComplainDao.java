package com.prison.complainsystem.dao;

import java.util.List;

import com.prison.complainsystem.model.AllComplainModel;
import com.prison.complainsystem.model.UpdateComplainModel;

public interface ViewComplainDao {

	public List<AllComplainModel> viewOpenComplain();
	public List<AllComplainModel> viewCloseComplain();
	public List<AllComplainModel> viewAllComplain();
	
	public int openUpdate(UpdateComplainModel openupdate);
	
	public String viewCatagory(String id);

}
