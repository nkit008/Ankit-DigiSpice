package com.digispice.indosat.dao;

import com.digispice.indosat.model.UserLogin;

public interface LoginDao {
	
	public UserLogin checkLogin(String username,String password);

}
