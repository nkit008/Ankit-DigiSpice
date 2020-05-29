package com.spice.vchatinterfacebulk.service;

import javax.servlet.http.HttpServletRequest;

import com.spice.vchatinterfacebulk.beans.Login;
import com.spice.vchatinterfacebulk.beans.LoginSessionDetails;

public interface ILoginService {

	public LoginSessionDetails getLoginStatus(Login login,HttpServletRequest request);

}
