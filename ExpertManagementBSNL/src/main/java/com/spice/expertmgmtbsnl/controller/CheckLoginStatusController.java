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

import com.spice.expertmgmtbsnl.dao.CheckLoginStatusDao;
import com.spice.expertmgmtbsnl.model.CheckLoginStatusModel;
import com.spice.expertmgmtbsnl.model.HourlyReportModel;
import com.spice.expertmgmtbsnl.model.UserLoginModel;

@Controller
public class CheckLoginStatusController {
	
	Logger logger=Logger.getLogger(CheckLoginStatusController.class.getName());

	@Autowired
	HttpSession session;
	
	@Autowired
	CheckLoginStatusDao dao2;
	
	@RequestMapping(value="/checkLoginStatus")
	public String checkLoginStatus(Model model)
	{
		if(session.getAttribute("loginObj")!=null)
		{
		logger.info("-----Display Login Status of All Agents");
		List<CheckLoginStatusModel> list=dao2.checkLoginStatusModel();
		if(list.isEmpty())
		{
			logger.info("No records found from checkLoginStatusModel");
			return "checkLoginStatus";
		}
		else
		
		{
		
		for(CheckLoginStatusModel obj:list)
		{
			if(obj.getLastCallTime() == null || obj.getLastCallTime().trim().isEmpty())
			{
				obj.setLastCallTime("0000-00-00 00:00:00");
			}
			model.addAttribute("record", list);
			model.addAttribute("loginObj", session.getAttribute("loginObj"));
			
		}
		
		return "checkLoginStatus";
	}
		}
		
		else
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
	}
	
	
	
	@RequestMapping(value="/checkLoginStatusPartner")
	public String checkLoginStatusPartner(Model model)
	{
		String partner_name=((UserLoginModel)session.getAttribute("loginObj")).getUserName();
		logger.info("Fetching All Agent details where partner name {["+partner_name+"}]");
		if(session.getAttribute("loginObj")!=null)
		{
		List<CheckLoginStatusModel> list=dao2.checkLoginStatusModelPartner(partner_name);
		if(list.isEmpty())
		{
			logger.info("No records found from checkLoginStatusModel");
			logger.info("no record found");
			return "checkLoginStatus_partner";
		}
		else
		
		{
		
		for(CheckLoginStatusModel obj:list)
		{
			if(obj.getLastCallTime() == null || obj.getLastCallTime().trim().isEmpty())
			{
				obj.setLastCallTime("0000-00-00 00:00:00");
			}
			model.addAttribute("record", list);
			
			model.addAttribute("loginObj", session.getAttribute("loginObj"));
			
		}
		
		return "checkLoginStatus_partner";
	}
		}
		
		else
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
	}
	
	
	@RequestMapping(value="/editLoginStatus",method=RequestMethod.POST)
	public String editLoginStatus(@RequestParam String p_ani,@RequestParam String p_status,Model model,RedirectAttributes redir)
	{
		logger.info("Edit Login Status into {["+p_status+"}] for ANI {["+p_ani+"]}");
		if(session.getAttribute("loginObj")!=null)
		{
			int i=dao2.changeLoginStatus(p_ani,p_status);
			if(i > 0)
			{
				logger.info("Status has been changed");
				redir.addFlashAttribute("insert_succ", "Status Updated Successfully");
				return "redirect:/checkLoginStatus";
			}
			else
			{
				logger.info("Status has not been changed");
				redir.addFlashAttribute("insert_succ", "Status not Updated");
				return "redirect:/checkLoginStatus";
			}
		
		}
		
		else
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
	}
	
	
	@RequestMapping(value="/editLoginStatusPartner")
	public String editLoginStatus_partner(@RequestParam String p_ani,@RequestParam String p_status,Model model,RedirectAttributes redir)
	{
		logger.info("editLoginStatus");
		if(session.getAttribute("loginObj")!=null)
		{
		logger.info("ANI is "+p_ani+" status is "+p_status);
		int i=dao2.changeLoginStatus(p_ani,p_status);
		if(i > 0)
		{
			logger.info("Status has been changed");
			redir.addFlashAttribute("insert_succ", "Status Updated Successfully");
			return "redirect:/checkLoginStatusPartner";
		}
		else
		{
			logger.info("Status has not been changed");
			redir.addFlashAttribute("insert_succ", "Status not Updated");
			return "redirect:/checkLoginStatusPartner";
		}
		
		}
		
		else
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
	}
		
}