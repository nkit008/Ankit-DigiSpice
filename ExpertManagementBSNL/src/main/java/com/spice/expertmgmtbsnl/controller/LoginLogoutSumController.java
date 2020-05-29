package com.spice.expertmgmtbsnl.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spice.expertmgmtbsnl.dao.LoginLogoutSummaryDao;
import com.spice.expertmgmtbsnl.model.LoginLogoutSummaryModel;
import com.spice.expertmgmtbsnl.model.UserLoginModel;

@Controller
public class LoginLogoutSumController {

	Logger logger=Logger.getLogger(LoginLogoutSumController.class.getName());
	
	@Autowired
	HttpSession session;
	
	@Autowired
	LoginLogoutSummaryDao dao;
	
	@RequestMapping(value="/checkLoginLogoutsummary")
	public String checkLoginLogoutsummary(Model model)
	{
		if(session.getAttribute("loginObj")!=null)
		{
		model.addAttribute("loginObj", session.getAttribute("loginObj"));
		return "checkLoginLogoutSummary";
		}
		else
		{
			return "redirect:/logout";
		}
	}
	
	
	@RequestMapping(value="/checkLoginLogoutsummaryPartner")
	public String checkLoginLogoutsummaryPartner(Model model)
	{
		if(session.getAttribute("loginObj")!=null)
		{
		model.addAttribute("loginObj", session.getAttribute("loginObj"));
		return "checkLoginLogoutSummaryPartner";
		}
		else
		{
			return "redirect:/logout";
		}
	}
	
	
	@RequestMapping(value="/chatidWiseSummary")
	public String chatidWiseSummary(Model model,@RequestParam("chatid") String id,RedirectAttributes redir)
	{
		logger.info("Getting summary by Chat Id Wise from chatidWiseSummary");
		if(session.getAttribute("loginObj")!=null)
		{
			logger.info("Trying to fetch Login/Logout history for ChatId {["+id+"}]");
			List<LoginLogoutSummaryModel> list=dao.getSummary(id);
			if(list.isEmpty())
			{
				logger.info("Wrong chat id {["+id+"}]");
				redir.addFlashAttribute("insert_succ", "Wrong ChatId");
				return "redirect:/checkLoginLogoutsummary";	
			}
		
			else
			{
				logger.info("Login/Logout Details found for chatId {["+id+"}]");
				redir.addFlashAttribute("records", list);
				return "redirect:/checkLoginLogoutsummary";
			}
		
		}
		else
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
	}
	
	
	@RequestMapping(value="/chatidWiseSummaryPartner")
	public String chatidWiseSummaryPartner(Model model,@RequestParam("chatid") String id,RedirectAttributes redir)
	{
		logger.info("Getting summary by Chat Id Wise from chatidWiseSummary");
		if(session.getAttribute("loginObj")!=null)
		{
			String partner_name=((UserLoginModel)session.getAttribute("loginObj")).getUserName();
			logger.info("Trying to fetch Login/Logout history for ChatId {["+id+"}] and partner {["+partner_name+"}]");
			List<LoginLogoutSummaryModel> list=dao.getSummaryPartner(id,partner_name);
			if(list.isEmpty())
			{
				logger.info("Wrong chat id {["+id+"}]");
				redir.addFlashAttribute("insert_succ", "Wrong ChatId");
				return "redirect:/checkLoginLogoutsummaryPartner";	
			}
		
			else
			{
				logger.info("Login/Logout Details found for chatId {["+id+"}] and partner {["+partner_name+"}]");;
				redir.addFlashAttribute("records", list);
				return "redirect:/checkLoginLogoutsummaryPartner";
			}
		
		}
		else
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
	}
}
