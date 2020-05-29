package com.spice.expertmgmtbsnl.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.spice.expertmgmtbsnl.dao.LoginDao;
import com.spice.expertmgmtbsnl.dao.LoginLogoutDetailsDao;
import com.spice.expertmgmtbsnl.model.UserLoginModel;


@Controller

public class LoginController {
	
	Logger logger=Logger.getLogger(LoginController.class.getName());
	
	@Autowired
	LoginDao dao;
	
	@Autowired
	LoginLogoutDetailsDao dao1;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("userid") String userid,@RequestParam("password") String pass,Model model)  throws ClassNotFoundException,SQLException
	{
		String viewName = null;
		logger.info("\r\n\r\n");
		logger.info("In Login Controller");
		UserLoginModel login=null;
		
		logger.info("Checking username/password");
		try
		{
			login=dao.checkLogin(userid, pass);
			
		}
		
		catch(Exception e)
		{
			logger.info("Connection not established with database");
			viewName = "redirect:/logout";
		}
		
		if(login==null)	
		{
			logger.info("Username {["+userid+"]} and password {["+pass+"]} is incorrect");
			model.addAttribute("message", "Username and password is incorrect");
			viewName = "index";
		}
		
		else
		{
			System.out.println("aaaa "+login);
			logger.info("Login Successfully");
			logger.info("Username {["+userid+"]} and password {["+pass+"]} and Role is {["+login.getRole()+"]}");
			
			if(login.getRole().equalsIgnoreCase("admin"))
				viewName = "home";
			else
				viewName = "partnerHome";
			
			session.setAttribute("loginObj", login);
			dao1.loginDetails();
		}
		
		return viewName;
	}
	
	@RequestMapping(value="/home")
	public String home(Model model){
		logger.info("in home controller");
		if(session.getAttribute("loginObj")!=null)
		{
		model.addAttribute("loginObj", session.getAttribute("loginObj"));
		return "home";
		}
		else
		{
			return "redirect:/logout";
		}
	}
	

}
