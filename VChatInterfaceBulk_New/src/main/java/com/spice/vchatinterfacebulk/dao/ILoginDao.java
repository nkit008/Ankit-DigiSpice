package com.spice.vchatinterfacebulk.dao;

import java.util.List;

import com.spice.vchatinterfacebulk.beans.Login;
import com.spice.vchatinterfacebulk.beans.LoginSessionDetails;
import com.spice.vchatinterfacebulk.beans.ManageUsers;

public interface ILoginDao {

	public LoginSessionDetails getLoginStatusDao(Login login);
	public List<ManageUsers> getAllUsers();

}
