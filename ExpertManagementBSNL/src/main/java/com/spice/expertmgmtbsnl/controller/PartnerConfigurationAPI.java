package com.spice.expertmgmtbsnl.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spice.expertmgmtbsnl.dao.PartnerConfigurationDao;
import com.spice.expertmgmtbsnl.model.ConfigureNewPartnerModel;


@RestController
public class PartnerConfigurationAPI {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	PartnerConfigurationDao dao;
	
	/*@RequestMapping(value = "/configureNewPartner",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)*/
	public List<ConfigureNewPartnerModel> configureNewPartner(ConfigureNewPartnerModel newPartner,Model model)
	{
		
		model.addAttribute("loginObj", session.getAttribute("loginObj"));
		String response=dao.addNewPartner(newPartner);
		
		if(response!= null)
		{
		
			if(response.equalsIgnoreCase("exists"))
			{
				model.addAttribute("msg", "**User already exists");
				List<ConfigureNewPartnerModel> partnerList=dao.getAllConfigurepartner();	
				if(partnerList.isEmpty())
				{
					System.out.println("error while retreving data from partner_configuration");
					return partnerList;
				}
				else
				{
					return partnerList;
				}
				
			}
			
			else if(response.equalsIgnoreCase("QueryError"))
			{
				System.out.println("error on insert query");
				List<ConfigureNewPartnerModel> partnerList=dao.getAllConfigurepartner();	
				if(partnerList.isEmpty())
				{
					System.out.println("error while retreving data from partner_configuration");
					return partnerList;
				}
				else
				{
					return partnerList;
				}
				
			}
			
			
			else if(response.equalsIgnoreCase("1"))
			{
				System.out.println("Inserted Successfully");
				model.addAttribute("insert_succ", "Inserted Successfully");
				List<ConfigureNewPartnerModel> partnerList=dao.getAllConfigurepartner();	
				if(partnerList.isEmpty())
				{
					System.out.println("error while retreving data from partner_configuration");
					return partnerList;
				}
				else
				{
					return partnerList;
				}
				
			}
			
			else
			{
			System.out.println("error while calling procedures");
			List<ConfigureNewPartnerModel> partnerList=dao.getAllConfigurepartner();	
			if(partnerList.isEmpty())
			{
				System.out.println("error while retreving data from partner_configuration");
				return partnerList;
			}
			else
			{
				return partnerList;
			}
			}
		} 
		else{
			
			List<ConfigureNewPartnerModel> partnerList=dao.getAllConfigurepartner();	
			if(partnerList.isEmpty())
			{
				System.out.println("error while retreving data from partner_configuration");
				return partnerList;
			}
			else
			{
				return partnerList;
			}
		}
	}
	
/*	@RequestMapping(value="/deletePartner")*/	
	public String deletePartner(Model model,String partnerId)
	{
		
		System.out.println("in controller "+partnerId);
		model.addAttribute("loginObj", session.getAttribute("loginObj"));
		model.addAttribute("sID",session.getId());
		int i=dao.deletePartner(partnerId);
		if(i>0)
		{
			List<ConfigureNewPartnerModel> partnerList=dao.getAllConfigurepartner();	
			if(partnerList.isEmpty())
			{
				System.out.println("Cant retrive data from partner_configuration");
				return "partnerConfiguration";
			}
			else
			{
				model.addAttribute("insert_succ","Partner Deleted");
				model.addAttribute("records",partnerList);
				return "partnerConfiguration";
			}	
		}
		else
		{
			System.out.println("::::status doesen't changed in partner Configuration:::");
			List<ConfigureNewPartnerModel> partnerList=dao.getAllConfigurepartner();	
			if(partnerList.isEmpty())
			{
				System.out.println("error while retreving data from partner_configuration");
				return "partnerConfiguration";
			}
			else
			{
				model.addAttribute("records",partnerList);
				return "partnerConfiguration";
			}	
			
		}
		
		
	}
}