package com.prison.complainsystem.controller;

import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prison.complainsystem.dao.GetComplainDetailsDao;
import com.prison.complainsystem.dao.LoginLogoutDao;
import com.prison.complainsystem.model.AllComplainModel;
import com.prison.complainsystem.model.ConnectivityComplainModel;
import com.prison.complainsystem.model.UserLogin;



@Controller
public class LoginLogoutController {
	private static final Logger logger = Logger.getLogger(LoginLogoutController.class.getName());
	
	@Autowired
	HttpSession session;
	
	@Autowired
	LoginLogoutDao dao;
	
	@Autowired
	GetComplainDetailsDao dao1;

	
	@RequestMapping(value="login")
	public String checkLogin(String username,String password,Model model)
	{
		logger.info("Welcome to login page!");
		List<UserLogin> list=dao.checkLoginDetails(username,password);
		if(list.isEmpty())
		{
			logger.info("Username/Password is incorrect!");
			model.addAttribute("wrong", "Username/Password is incorrect");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("login successfully!");
			session.setAttribute("userObj", list.get(0));
			return "redirect:/homepage";			
		}
	}
	
	
	@RequestMapping(value="/homepage")
	public String home(Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session timeout");
			return "redirect:/logout";
		}
		else
		{
			logger.info("in home page");
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			List<AllComplainModel> connComplainList=dao1.getConnectionCompDetail();
			Map<String, String> countMap=dao1.getCompCount();
			if(countMap.containsKey("Connectivity"))
			{
				model.addAttribute("connCount", countMap.get("Connectivity"));
			}
			else
			{
				model.addAttribute("connCount", 0);
			}

			if(countMap.containsKey("Hardware"))
			{
				model.addAttribute("hwCount", countMap.get("Hardware"));
			}
			else
			{
				model.addAttribute("hw", 0);
			}
			
			if(countMap.containsKey("Physical Damage"))
			{
				model.addAttribute("physicalCount", countMap.get("Physical Damage"));
			}
			else
			{
				model.addAttribute("physicalCount", 0);
			}
			
			if(countMap.containsKey("Software"))
			{
				model.addAttribute("swCount", countMap.get("Software"));
			}
			else
			{
				model.addAttribute("swCount", 0);
			}
			model.addAttribute("connectData", connComplainList);
			model.addAttribute("map", countMap);
			return "home";
		}
	}
	
	@RequestMapping(value="logout")
	public String logout()
	{
		session.removeAttribute("userObj");
		session.invalidate();
		logger.info("Logout Successfully!");
		return "index";
	}
	
	
	@RequestMapping(value="changePassword")
	public String changePassword(Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session Timeout");
			return "redirect:/logout";
		}
		
		else
		{
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			return "chnage_password";
		}
	}
	
	
	@RequestMapping(value="changepasswordAction")
	public String changepasswordAction(@RequestParam String password,@RequestParam String id,RedirectAttributes redir)
	{
		
		System.out.println("passs is "+password);
		System.out.println("id is "+id);
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session Timeout");
			return "redirect:/logout";
		}
		
		else
		{
			int i=dao.changepass(password,id);
			if(i==0)
			{
				redir.addFlashAttribute("msg", "Password not Changed");
			}
			
			else
			{
				redir.addFlashAttribute("msg", "Password changed Successfully");
			}
			return "redirect:/homepage";
		}
	}
	
}