package com.digispice.ghana.dao;

import java.util.HashMap;
import java.util.List;

import com.digispice.ghana.bean.CreateUserBean;
import com.digispice.ghana.bean.UserDetails;

public interface LoginDao {
	
	public List<CreateUserBean> CheckLogin(String username,String password);
	
	public int createUser(CreateUserBean bean);
	public int checkUserId(String userId);
	public List<CreateUserBean> viewUser();
	
	public int editUser(CreateUserBean bean);
	public int deleteUser(String id);
	public HashMap<String,String> getAllPack();

}
