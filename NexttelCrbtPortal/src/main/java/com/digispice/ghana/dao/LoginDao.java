package com.digispice.ghana.dao;

import java.util.List;

import com.digispice.ghana.bean.UserDetails;

public interface LoginDao {
	
	public List<UserDetails> CheckLogin(String username,String password);

}
