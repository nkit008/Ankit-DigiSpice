package com.spice.expertmgmtbsnl.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spice.expertmgmtbsnl.dao.AgentConfigurationDao;
import com.spice.expertmgmtbsnl.model.AgentConfigurationModel;

@Controller
public class AgentConfigureController {
	
	Logger logger=Logger.getLogger(AgentConfigureController.class.getName());
	
	@Autowired
	HttpSession session;
	
	@Autowired
	AgentConfigurationDao dao;
	
	@RequestMapping(value="/configureExpert")
	public String configureExpert(Model model)
	{
		if(session.getAttribute("loginObj")!=null)
		{
			List<AgentConfigurationModel> agentList=dao.getAllAgent();
			List<String> pName=dao.findAllPartnerName();
			model.addAttribute("pname", pName);
			model.addAttribute("sID",session.getId());
			model.addAttribute("loginObj", session.getAttribute("loginObj"));
			model.addAttribute("records",agentList);
			return "agentConfigure";
		
		}
		else
		{
			logger.warn("Session timeout");
			return "redirect:/logout";
		}
	}
	
	
	
	@RequestMapping(value="/configureNewAgent")
	public String configureNewAgent(AgentConfigurationModel agent,Model model,RedirectAttributes redir)
	{
		logger.info("Adding New Agent details {["+agent.toString()+"]}");
		if(session.getAttribute("loginObj")!=null)
		{
			if(agent.getAdhaar_card()==null)
			{
				agent.setAdhaar_card(0L);
			}
			String response=dao.addNewAgent(agent);
			if(response!= null)
			{
				if(response.equalsIgnoreCase("exists"))
				{
					logger.info("Agent already exists");
					redir.addFlashAttribute("insert_succ", "Agent Already Exists");
					return "redirect:/configureExpert";
				}
				else if(response.equalsIgnoreCase("QueryError"))
				{
					logger.info("Error on query");
					redir.addFlashAttribute("insert_succ", "Agent not Inserted Successfully");
					return "redirect:/configureExpert";
				}
			
				else if(response.equalsIgnoreCase("3"))
				{
					logger.info("Agent added succeddfully");
					redir.addFlashAttribute("insert_succ", "Agent Inserted Successfully");
					return "redirect:/configureExpert";	
				}
				else
				{
					logger.info("error while calling procedures");
					redir.addFlashAttribute("insert_succ", "Agent not Inserted Successfully");
					return "redirect:/configureExpert";
				}
			}
		
			else
			{
				logger.info("response found null from addNewAgent(agent)");
				redir.addFlashAttribute("insert_succ", "Agent not Inserted Successfully");
				return "redirect:/configureExpert";		
			}
		}
		else
		{
			logger.info("session is timeout");
			redir.addFlashAttribute("insert_succ", "Agent not Inserted Successfully");
			return "redirect:/logout";
		}
		
	}
	
	
	@RequestMapping(value="/editAgent")
	public String editAgent(AgentConfigurationModel agent,Model model,RedirectAttributes redir)
	{
		logger.info("Changing request data {["+agent.toString()+"]}");
		
		if(session.getAttribute("loginObj")!=null)
		{
			if(agent.getAdhaar_card()==0)
			{
				agent.setAdhaar_card(0L);
			}
			String res=dao.editAgentInfo(agent);
			if(res.equalsIgnoreCase("successfull"))
			{
				logger.info("Details updated Successfully");
				redir.addFlashAttribute("insert_succ", "Agent Details Updated Successfully");
				return "redirect:/configureExpert";
			}
			else if(res.equalsIgnoreCase("error"))
			{
				logger.info("Details not edit Successfully----- Exception occured into editAgentInfo");
				redir.addFlashAttribute("insert_succ", "Agent Details not Updated");
				return "redirect:/configureExpert";	
			}
			else
			{
				logger.info("Details not edit Successfully");
				redir.addFlashAttribute("insert_succ", "Agent Details not Updated");
				return "redirect:/configureExpert";	
			}
		}
		else
		{
			logger.info("Session timout");
			redir.addFlashAttribute("insert_succ", "Agent Details not Updated");
			return "redirect:/logout";
		}
		
	}
	
	
	@RequestMapping(value="/deleteAgent")
	public String deleteAgent(@RequestParam String p_ani,Model model,RedirectAttributes redir)
	{
		logger.info("in deleteAgent");
		if(session.getAttribute("loginObj")!=null)
		{
			logger.info("Ani on deletion "+p_ani);
			logger.info("Deleting Agent");
			String res=dao.deleteAgentbyAni(p_ani);
			if(res.equalsIgnoreCase("deleted"))
			{
				logger.info("Agent Deleted Succssfully");
				redir.addFlashAttribute("insert_succ", "Agent Deleted Successfully");
				return "redirect:/configureExpert";
			}
			
			else if(res.equalsIgnoreCase("not deleted"))
			{
				logger.info("Agent not deleted");
				redir.addFlashAttribute("insert_succ", "Agent not Deleted Successfully");
				return "redirect:/configureExpert";		
			}
			
			else
			{
				logger.info("Agent not deleted--- Exception occured in deleteAgentbyAni");
				redir.addFlashAttribute("insert_succ", "Agent not Deleted Successfully");
				return "redirect:/configureExpert";		
				
			}
	
		}
		else
		{
			logger.info("Session timeout");
			return "redirect:/logout";
		}
	}
	
}