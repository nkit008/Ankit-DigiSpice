package com.voda.ghaana;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.voda.ghaana.daoImpl.LoginControllerDaoImpl;
import com.voda.ghaana.daoImpl.NewsStoreDaoImpl;
import com.voda.ghaana.model.NewsBean;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@Autowired
	LoginControllerDaoImpl loginControllerDaoImpl;
	
	@Autowired
	NewsStoreDaoImpl newsStoreDaoImpl;		
	
	@Autowired
	HttpSession httpsession;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome to login page of Voda Ghanna News Alert New Interface");
		return "login";
	}
	
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(@RequestParam String userid,@RequestParam String password)
	{
		String viewName = null;
		
		logger.info("Checking UserName and password with parameter {} {}",userid,password);
		
		String response = loginControllerDaoImpl.checkLogin(userid, password);
		
		if(response.equalsIgnoreCase("success"))
		{
			viewName = "redirect:/home";
		}
		
		else if(response.equalsIgnoreCase("exception"))
			viewName = "login";
		else
			viewName = "login";
		
		return viewName;
		
	}
	
	
	@RequestMapping(value="/home1",method = RequestMethod.GET)
	public String fetchForm()
	{
		String viewName = null;
		
		logger.info("Checking UserName and password with parameter ");
		
		String response = loginControllerDaoImpl.checkLogin("QUICK_SMS", "QUICK_SMS");
		
		if(response.equalsIgnoreCase("success"))
		{
			viewName = "redirect:/home";
		}
		
		else if(response.equalsIgnoreCase("exception"))
			viewName = "login";
		else
			viewName = "login";
		
		return viewName;
		
	}
	
	
	@RequestMapping(value="/home",method = RequestMethod.GET)
	public String loginGET(Model model,HttpServletRequest request, HttpServletResponse response)
	{
		String viewName = null;
		
		if (request.getParameter("JSESSIONID") != null) {
		    Cookie userCookie = new Cookie("JSESSIONID", request.getParameter("JSESSIONID"));
		    response.addCookie(userCookie);
		} else {
		    String sessionId = httpsession.getId();
		    Cookie userCookie = new Cookie("JSESSIONID", sessionId);
		    response.addCookie(userCookie);
		}
		
		  if(httpsession.getAttribute("loginObj")==null) {
		  logger.info("User Logout Automatically due to Session Expired "); viewName =
		  "redirect:/"; } else {
		 
			model.addAttribute("user",httpsession.getAttribute("loginObj"));
			model.addAttribute("serviceList",httpsession.getAttribute("serviceList"));
			viewName = "home";
			
		}
		
		return viewName;
	}
	
	
	@RequestMapping(value="/storeValue",method = RequestMethod.POST)
	public String storeValue(NewsBean bean,RedirectAttributes redir)
	{
		String viewName = null;
		/*if(httpsession.getAttribute("loginObj")==null)
		{
			logger.info("User Logout Automatically due to Session Expired ");
			viewName = "redirect:/";
		}
		else
		{*/
			logger.info("row to be saved  {}",bean.toString());
			String response = newsStoreDaoImpl.uploadRecord(bean);
			
			if(response.equalsIgnoreCase("success"))
				redir.addFlashAttribute("msg", "Record has been Saved Successfully");
			else
				redir.addFlashAttribute("msg", "Record has not been Saved");
					
			viewName = "redirect:/home";
			
		//}
		return viewName;
	}
	
	@RequestMapping(value = "/logout")
	public String logout() {
		httpsession.removeAttribute("userSesseion");
		httpsession.invalidate();
		return "login";
	}
}
