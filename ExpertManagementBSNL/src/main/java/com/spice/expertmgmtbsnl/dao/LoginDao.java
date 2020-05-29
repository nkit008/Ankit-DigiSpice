package com.spice.expertmgmtbsnl.dao;

import java.sql.SQLException;

import com.spice.expertmgmtbsnl.model.UserLoginModel;

public interface LoginDao {

	public UserLoginModel checkLogin(String username,String password);

}
