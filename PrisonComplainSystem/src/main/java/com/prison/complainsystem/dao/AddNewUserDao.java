package com.prison.complainsystem.dao;

import java.util.List;

import com.prison.complainsystem.model.AddNewUserModel;
import com.prison.complainsystem.model.AllComplainModel;
import com.prison.complainsystem.model.UserLogin;

public interface AddNewUserDao {

	public int addNewUserRecord(AddNewUserModel user);
	public AllComplainModel findDetailsByPrisonId(String id);
	public UserLogin updateUserRecord(String id);
	public int updateUserRecordAction(UserLogin user);
	public List<UserLogin> getAllUsers();
	
}
