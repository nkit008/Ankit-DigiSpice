package com.prison.complainsystem.dao;

import java.util.List;

import org.springframework.ui.Model;

import com.prison.complainsystem.model.UserLogin;

public interface LoginLogoutDao {
	
	public List<UserLogin> checkLoginDetails(String username,String pass);
	public int changepass(String password,String id);
}
