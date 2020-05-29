package com.spice.vchatinterfacebulk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spice.vchatinterfacebulk.beans.Login;
import com.spice.vchatinterfacebulk.beans.LoginSessionDetails;
import com.spice.vchatinterfacebulk.service.ILoginService;

@Controller
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	ILoginService loginService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(Login login, HttpServletRequest request,RedirectAttributes redir) {
		ModelAndView model;
		
		LOGGER.info(login.toString());
		LOGGER.info("User Ip Address is [{}]",request.getRemoteAddr());
		try
		{
			LoginSessionDetails loginDetails = loginService.getLoginStatus(login,request);
			if (loginDetails != null) {
				LOGGER.info("return " + loginDetails.toString());

				model = new ModelAndView("redirect:/allcircleHome");
				LOGGER.info(loginDetails.toString());
				session.setAttribute("userObj", loginDetails);
				
				redir.addFlashAttribute("userHUbList", ((LoginSessionDetails)session.getAttribute("userObj")).getSessionHubList());
				
				LOGGER.info("All Hub's name for " +((LoginSessionDetails)session.getAttribute("userObj")).getUserName() +" is "+((LoginSessionDetails)session.getAttribute("userObj")).getSessionHubList());

				return model;
			}
		
			else
			{
				model = new ModelAndView("login");
				model.addObject("wrong", "Invalid Credentials");
				return model;
			}
		}
		
		catch(Exception e)
		{
			LOGGER.info("EXception in Login "+e);
			model = new ModelAndView("login");
			model.addObject("wrong", "ERROR! please login after some time");
			return model;
		}
		
	}
	
	@RequestMapping(value = "logout")
	public String logout() {
		
		if (session.getAttribute("userObj") == null) {
			LOGGER.info("--session expired--");
			return "login";
		}

		else {
			LoginSessionDetails loginSessionDetails = (LoginSessionDetails)session.getAttribute("userObj");
			LOGGER.info("Logout UserName is [{}] and IP Address is [{}] and User Role is [{}]",loginSessionDetails.getUserName(),loginSessionDetails.getUserIp(),loginSessionDetails.getRole());
			
			session.removeAttribute("userObj");
			session.invalidate();
			LOGGER.info("---logout successfully!---");
			return "login";
		}
	}
	
}
