package com.spice.expertmgmtbsnl.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spice.expertmgmtbsnl.dao.LoginLogoutDetailsDao;

@Controller
public class LogoutController {

	Logger logger=Logger.getLogger(LogoutController.class.getName());
	
	@Autowired
	HttpSession session;
	
	@Autowired
	LoginLogoutDetailsDao dao1;
	
	@RequestMapping(value="/sessionLogout")
	public String sessionLogout(String sessionId)
	{
		logger.info("session id in controller"+sessionId);
		dao1.logoutDetails(sessionId);
		session.removeAttribute("loginObj");
		session.invalidate();
		logger.info("Logout sucessfully");
		logger.info("\r\n");
		return "index";
	}
	
	@RequestMapping(value="/logout")
	public String logout()
	{
		String sessionId=session.getId();
		logger.info("session id in controller"+sessionId);
		dao1.logoutDetails(sessionId);
		session.removeAttribute("loginObj");
		session.invalidate();
		logger.info("Logout sucessfully");
		logger.info("\r\n");
		return "index";
	}
}
