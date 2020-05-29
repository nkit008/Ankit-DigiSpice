package com.spice.vchatinterfacebulk.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spice.vchatinterfacebulk.beans.Login;
import com.spice.vchatinterfacebulk.beans.LoginSessionDetails;
import com.spice.vchatinterfacebulk.dao.ILoginDao;
import com.spice.vchatinterfacebulk.service.ILoginService;



@Service
@Transactional
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginDao loginDao;

	@Override
	public LoginSessionDetails getLoginStatus(Login login,HttpServletRequest request) {
		LoginSessionDetails loginDetails = loginDao.getLoginStatusDao(login);
		if(loginDetails!=null)
		{
			loginDetails.setUserIp(request.getRemoteAddr());
		}
		return loginDetails;
	}


}
