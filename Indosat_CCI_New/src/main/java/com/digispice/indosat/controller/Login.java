package com.digispice.indosat.controller;

import java.sql.Connection;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digispice.indosat.dao.CheckSubscriptionDao;
import com.digispice.indosat.dao.LoginDao;
import com.digispice.indosat.model.UserLogin;

 

@Controller
public class Login {
	
	public static Logger logger=Logger.getLogger(Login.class.getName());
	
	@Autowired
	HttpSession session;
	
	@Autowired
	LoginDao logindao;
	
	@Autowired
	CheckSubscriptionDao checksubscription;
	
	Connection con=null;
	@RequestMapping(value="/")
	public String home(Locale locale)
	{	
		logger.info("---Welcome to Login page--- "+locale);
		return "index";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam String username,@RequestParam String password,Model model,RedirectAttributes redir)
	{
		logger.info("---Username is "+username+" and password is "+password+"---");
		UserLogin login=logindao.checkLogin(username,password);
		
		if (login!=null)
		{
			session.setAttribute("userObj", login);
			logger.info("session object is "+((UserLogin)session.getAttribute("userObj")).getUser_id());
			if(login.getTech_ops().equals("Y"))
			{
				logger.info("---Login as TechOps---");
				logger.info("conection object is "+session.getAttribute("active_connection"));
				return "mis/home";
			}
			
			else if(login.getAdmin().equals("Y"))
			{
				logger.info("---Login as ADMIN---");
				model.addAttribute("forHiding", "no data");
				return "home";
			}
			
			else
			{
				return "redirect:/logout";
			}
		
			
		}
		 else 
		 {
             logger.info("User Name or Password is incorrect,Please try again..");
             redir.addFlashAttribute("wrongmsg", "User Name or Password is incorrect,Please try again");
             return "redirect:/logout";
         }
	}
	
	
	@RequestMapping(value="/home")
	public String home(Model model)
	{
		if((session.getAttribute("userObj"))==null)
		{
			return "redirect:/logout";
		}
		
		else
		{
			model.addAttribute("forHiding", "no data");
			return "home";
		}
	}
	
	@RequestMapping(value="/fetchSubsDetails",method=RequestMethod.POST)
	public String fetchSubsDetails(@RequestParam String mobile,RedirectAttributes redir)
	{
		if((session.getAttribute("userObj"))==null)
		{
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("Checking User Subscription for ["+mobile+"]");
		
			ArrayList<HashMap<String,String>> list = checksubscription.getSubscription(mobile);
			
	        System.out.println("List of data is :: "+ list.size());
	        if(list.size()>0)
	        {
	            //session.setAttribute("SubscriptionList", list);
	            redir.addFlashAttribute("SubscriptionList", list);
	            redir.addFlashAttribute("msg", "Subscription Details of "+  mobile);
	            redir.addFlashAttribute("forHiding", "no data");
	        }
	        else
	        {
	        	logger.info("No Record Found for any Service");
	        	redir.addFlashAttribute("msg", "No Record Found for any Service");
	        	redir.addFlashAttribute("forHiding", "no data");
	        }
	        
	        return "redirect:/home";
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value="showDetails",method=RequestMethod.POST,produces="application/json")
	public ArrayList<HashMap<String,String>> showDetails(String mobile,String main_service)
	{
		logger.info(mobile +"--"+main_service+"--");
		String m=mobile.trim();
		//String s=main_service.trim();
		ArrayList<HashMap<String,String>> list=checksubscription.getBillingDetails(m);
		
		logger.info("---size of list is "+list.size());
		
		return list;
	}
	
	@RequestMapping(value="unSubs",method=RequestMethod.GET)
	public String unSubs(@RequestParam String ani,@RequestParam String mainService,@RequestParam String service,RedirectAttributes redir)
	{
		if((session.getAttribute("userObj"))==null)
		{
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("Un-Subscription received for " + ani + " Main Service " + mainService + " and service "+ service);
		
			String res=checksubscription.doUnsubscribe(ani.trim(), mainService.trim(), service.trim());
			
			
			ArrayList<HashMap<String,String>> list =  checksubscription.getSubscription(ani);
			redir.addFlashAttribute("BillingDetails",list);
			
			if(res.equals("1"))
			{
	            redir.addFlashAttribute("msg","Successfully Un-Subscribed.");
	            redir.addFlashAttribute("forHiding", "no data");
	        }
			else if (res.equals("100"))
			{
	        	redir.addFlashAttribute("msg","Database error, Please contact  SPICE Team.");
	        	redir.addFlashAttribute("forHiding", "no data");
	        }
			
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value="/logout")
	public String logout()
	{
		session.removeAttribute("userObj");
		session.removeAttribute("active_connection");
		session.invalidate();
		return "index";
	}
	
}
