package com.indosat.umb.service;

import java.util.StringTokenizer;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indosat.umb.daoImpl.LoginLogoutDaoImpl;
import com.indosat.umb.model.LoginModel;

@Service
public class LoginLogoutService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginLogoutService.class);
	
	@Autowired
	LoginLogoutDaoImpl loginLogoutDaoImpl;
	
	@Autowired
	HttpSession session;
	
	public String checkLoginService(String username, String password)
	{
		String response = loginLogoutDaoImpl.checkUserAuthentication(username, password);
		
		
		
		if(response.contains("User Found"))
		{
			StringTokenizer st = new StringTokenizer(response," ");
			st.nextToken();
			st.nextToken();
			LoginModel loginModel = new LoginModel();
			loginModel.setLoginId(st.nextToken()); 
			loginModel.setUserName(st.nextToken());
			loginModel.setUserPassword(st.nextToken());
			loginModel.setUserRole(st.nextToken());
			loginModel.setCreatedOn(st.nextToken());
			loginModel.setUserStatus(st.nextToken());
			loginModel.setLastPasswordChangedOn(st.nextToken());
			loginModel.setResetFlag(st.nextToken());
			loginModel.setCurrentStatus(st.nextToken());
			
			session.setAttribute("userObj", loginModel);
			
			return "success";
		}
		
		else
		{
			return response;
		}
		
	}

}
