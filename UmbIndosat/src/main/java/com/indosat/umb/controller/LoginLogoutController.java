package com.indosat.umb.controller;

import javax.servlet.http.HttpSession;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indosat.umb.model.LoginModel;
import com.indosat.umb.service.LoginLogoutService;



@Controller
public class LoginLogoutController {
	
	private static final Logger LOGGER = Logger.getLogger(LoginLogoutController.class);
	
	@Autowired
	HttpSession session;
	
	@Autowired
	LoginLogoutService loginLogoutService;
	
	@RequestMapping(value="/")
	public String loadFirstPage()
	{
		LOGGER.info("\r\n\r\n-----Welcome to the first page of UMB-Indosat------");
		return "index";
	}
	
	
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String CheckLoginCredential(@RequestParam String username,@RequestParam String password,RedirectAttributes redir)
	{
		String response = loginLogoutService.checkLoginService(username,password);
		if(!response.equalsIgnoreCase("success"))
		{
			redir.addFlashAttribute("msg", response);
			return "redirect:/";
		}
		
		return "redirect:/home";
	}
	
	
	@RequestMapping(value = "/home", method = { RequestMethod.GET, RequestMethod.POST })
	public String homePage(Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			
		}
		
		else
		{
			model.addAttribute("userObj", ((LoginModel)session.getAttribute("userObj")));
		}
		
		return "home";
	}

}
