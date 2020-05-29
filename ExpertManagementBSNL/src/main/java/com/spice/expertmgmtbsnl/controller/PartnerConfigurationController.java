package com.spice.expertmgmtbsnl.controller;


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
import com.spice.expertmgmtbsnl.dao.PartnerConfigurationDao;
import com.spice.expertmgmtbsnl.model.ConfigureNewPartnerModel;

@Controller
public class PartnerConfigurationController {

	Logger logger=Logger.getLogger(PartnerConfigurationController.class.getName());
	
	@Autowired
	HttpSession session;
	
	@Autowired
	PartnerConfigurationDao dao;
	
	@RequestMapping(value="/partnerConfiguration")
	public String partnerConfiguration(Model model)
	{
		logger.info("in partnerConfiguration");
		System.out.println("session value is "+session.getAttribute("loginObj"));
		if(session.getAttribute("loginObj")!=null)
		{
			model.addAttribute("loginObj", session.getAttribute("loginObj"));
			model.addAttribute("sID",session.getId());
			logger.info("getting all partner detail");
			List<ConfigureNewPartnerModel> partnerList=dao.getAllConfigurepartner();	
			model.addAttribute("records",partnerList);
			return "partnerConfiguration";
		}
		else
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
	}
	
	@RequestMapping(value="/configureNewPartner",method=RequestMethod.POST)
	public String configureNewPartner(ConfigureNewPartnerModel newPartner,Model model,RedirectAttributes redir)
	{
		logger.info("in configureNewPartner");
		if(session.getAttribute("loginObj")!=null)
		{
			model.addAttribute("loginObj", session.getAttribute("loginObj"));
			logger.info("adding new partner details");
			String response=dao.addNewPartner(newPartner);
		
			if(response!= null)
			{
				if(response.equalsIgnoreCase("exists"))
				{
					logger.info("partner already exists");
					redir.addFlashAttribute("insert_succ", "**User already exists");
					return "redirect:/partnerConfiguration";
				}
				
				else if(response.equalsIgnoreCase("QueryError"))
				{
					logger.info("error on insert query");
					redir.addFlashAttribute("insert_succ", "Partner not Added Successfully");
					return "redirect:/partnerConfiguration";
				
				}
			
				else if(response.equalsIgnoreCase("1"))
				{
					logger.info("Partner Added Successfully");
					redir.addFlashAttribute("insert_succ", "Partner Added Successfully");
					return "redirect:/partnerConfiguration";
				}
				
			}
			else
			{
				logger.info("Exception occured while adding new Partner");
				redir.addFlashAttribute("insert_succ", "Partner not Added Successfully");
				return "redirect:/partnerConfiguration";
			
			}
		}
		else
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
		return "redirect:/partnerConfiguration";
	}
	
	
	@RequestMapping(value="/deletePartner")
	public String deletePartner(Model model,String partnerId,RedirectAttributes redir)
	{
		logger.info("in deletePartner");
		if(session.getAttribute("loginObj")!=null)
		{
			model.addAttribute("loginObj", session.getAttribute("loginObj"));
			model.addAttribute("sID",session.getId());
			logger.info("deleting partner whose id is "+partnerId);
			int i=dao.deletePartner(partnerId);
			if(i>0)
			{
				logger.info("Partner deleted Successfully");
				redir.addFlashAttribute("insert_succ","Partner Deleted");
				return "redirect:/partnerConfiguration";
			}
			else
			{
				logger.info("Partner not deleted");
				redir.addFlashAttribute("insert_succ","Partner not Deleted");
				return "redirect:/partnerConfiguration";	
			
			}
		}
		else
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
	}
	
	@RequestMapping(value="/editPartner")
	public String editPartner(ConfigureNewPartnerModel newPartner,Model model,@RequestParam String userId,RedirectAttributes redir)
	{
		logger.info("edit partner details");
		if(session.getAttribute("loginObj")!=null)
		{
			model.addAttribute("loginObj", session.getAttribute("loginObj"));
			int response=dao.editPartner(newPartner,userId);
			
			if(response > 0)
			{
				logger.info("partner details update successfully");
				redir.addFlashAttribute("insert_succ","Partner Details Updated");
				
			}
			else
			{
				logger.info("partner details not update successfully");
				redir.addFlashAttribute("insert_succ","Partner Details not Updated");
				logger.info(":::No record is updated:::");
			}
			
			return "redirect:/partnerConfiguration";
				
		}
		else
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
	}

}