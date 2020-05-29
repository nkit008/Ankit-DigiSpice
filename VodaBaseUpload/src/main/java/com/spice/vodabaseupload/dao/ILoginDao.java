package com.spice.vodabaseupload.dao;

import javax.servlet.http.HttpServletRequest;

import com.spice.vodabaseupload.beans.Login;
import com.spice.vodabaseupload.beans.LoginSessionDetails;

public interface ILoginDao {

	public LoginSessionDetails getLoginStatus(Login login, HttpServletRequest request);

}
