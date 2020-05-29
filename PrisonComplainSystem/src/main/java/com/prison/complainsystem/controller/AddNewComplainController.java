package com.prison.complainsystem.controller;

import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prison.complainsystem.dao.AddNewComplainDao;
import com.prison.complainsystem.dao.GetComplainDetailsDao;
import com.prison.complainsystem.model.AllComplainModel;
import com.prison.complainsystem.model.ConnectivityComplainModel;
import com.prison.complainsystem.model.HardwareComplainModel;
import com.prison.complainsystem.model.PhysicalDamageModel;
import com.prison.complainsystem.model.SoftwareComplainModel;
import com.prison.complainsystem.model.UserLogin;

@Controller
public class AddNewComplainController {

	@Autowired
	HttpSession session;
	
	@Autowired
	AddNewComplainDao dao;
	
	@Autowired
	GetComplainDetailsDao dao1;
	
	private static final Logger logger = Logger.getLogger(AddNewComplainController.class.getName());
	
	@RequestMapping(value="newhardwarecomplain")
	public String newHardwareComplain(Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("create new hardware complain");
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			return "create_hardware_complains";
		}
	}
	
	
	@RequestMapping(value="addNewHardwareComplain",method=RequestMethod.POST)
	public String addNewHardwareComplain(HardwareComplainModel newHw,Model model,RedirectAttributes redir)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("adding new Hardware Complain!");
			
			int i=dao.addNewHwComplain(newHw);
			if(i==0)
			{
				redir.addFlashAttribute("msg", "Complain not submitted");
			}
			
			else
			{
				redir.addFlashAttribute("msg", "New Complain Submitted");
			
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			List<AllComplainModel> connComplainList=dao1.getConnectionCompDetail();
	
			
			Map<String, String> countMap=dao1.getCompCount();
			if(countMap.containsKey("Connectivity"))
			{
				redir.addFlashAttribute("connCount", countMap.get("Connectivity"));
			}
			else
			{
				redir.addFlashAttribute("connCount", 0);
			}

			if(countMap.containsKey("Hardware"))
			{
				redir.addFlashAttribute("hwCount", countMap.get("Hardware"));
			}
			else
			{
				redir.addFlashAttribute("hw", 0);
			}
			
			if(countMap.containsKey("Physical Damage"))
			{
				redir.addFlashAttribute("physicalCount", countMap.get("Physical Damage"));
			}
			else
			{
				redir.addFlashAttribute("physicalCount", 0);
			}
			
			if(countMap.containsKey("Software"))
			{
				redir.addFlashAttribute("swCount", countMap.get("Software"));
			}
			else
			{
				redir.addFlashAttribute("swCount", 0);
			}
			redir.addFlashAttribute("connectData", connComplainList);
			redir.addFlashAttribute("map", countMap);
			return "redirect:/homepage";
		}
		}
		return null;
	}
	
	
	@RequestMapping(value="newsoftwarecomplain")
	public String newSardwareComplain(Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("create new software complain");
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			return "create_software_complains";
		}
	}
	
	
	@RequestMapping(value="addNewSoftwareComplain",method=RequestMethod.POST)
	public String addNewSoftwareComplain(SoftwareComplainModel newSw,Model model,RedirectAttributes redir)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("adding new Hardware Complain!");
			int i=dao.addNewSwComplain(newSw);
			if(i==0)
			{
				redir.addFlashAttribute("msg", "Complain not submitted");
			}
			
			else
			{
				redir.addFlashAttribute("msg", "New Complain Submitted");
			
				redir.addFlashAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
				List<AllComplainModel> connComplainList=dao1.getConnectionCompDetail();
				Map<String, String> countMap=dao1.getCompCount();
				if(countMap.containsKey("Connectivity"))
				{
					redir.addFlashAttribute("connCount", countMap.get("Connectivity"));
				}
				else
				{
					redir.addFlashAttribute("connCount", 0);
				}
	
				if(countMap.containsKey("Hardware"))
				{
					redir.addFlashAttribute("hwCount", countMap.get("Hardware"));
				}
				else
				{
					redir.addFlashAttribute("hw", 0);
				}
				
				if(countMap.containsKey("Physical Damage"))
				{
					redir.addFlashAttribute("physicalCount", countMap.get("Physical Damage"));
				}
				else
				{
					redir.addFlashAttribute("physicalCount", 0);
				}
				
				if(countMap.containsKey("Software"))
				{
					redir.addFlashAttribute("swCount", countMap.get("Software"));
				}
				else
				{
					redir.addFlashAttribute("swCount", 0);
				}
				redir.addFlashAttribute("connectData", connComplainList);
				redir.addFlashAttribute("map", countMap);
				return "redirect:/homepage";
			}
			}
			return null;
		}
	
	
	
	@RequestMapping(value="newphysicaldamage")
	public String newphysicalDamage(Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("creating new physical complain");
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			return "create_report_physical";
		}
	}
	
	@RequestMapping(value="addNewPhysicalDamage",method=RequestMethod.POST)
	public String addNewPhysicalDamage(PhysicalDamageModel newPd,Model model,RedirectAttributes redir)
	{
		if(session.getAttribute("userObj") == null)
		{
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("adding new Hardware Complain!");
			int i=dao.addNewPhysicalDamageComplain(newPd);
			if(i==0)
			{
				redir.addFlashAttribute("msg", "Complain not submitted");
			}
			
			else
			{
				redir.addFlashAttribute("msg", "New Complain Submitted");
			
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			List<AllComplainModel> connComplainList=dao1.getConnectionCompDetail();
	
			Map<String, String> countMap=dao1.getCompCount();
			if(countMap.containsKey("Connectivity"))
			{
				redir.addFlashAttribute("connCount", countMap.get("Connectivity"));
			}
			else
			{
				redir.addFlashAttribute("connCount", 0);
			}

			if(countMap.containsKey("Hardware"))
			{
				redir.addFlashAttribute("hwCount", countMap.get("Hardware"));
			}
			else
			{
				redir.addFlashAttribute("hw", 0);
			}
			
			if(countMap.containsKey("Physical Damage"))
			{
				redir.addFlashAttribute("physicalCount", countMap.get("Physical Damage"));
			}
			else
			{
				redir.addFlashAttribute("physicalCount", 0);
			}
			
			if(countMap.containsKey("Software"))
			{
				redir.addFlashAttribute("swCount", countMap.get("Software"));
			}
			else
			{
				redir.addFlashAttribute("swCount", 0);
			}
			redir.addFlashAttribute("connectData", connComplainList);
			redir.addFlashAttribute("map", countMap);
			return "redirect:/homepage";
		}
			
		}
		return null;
	}
	
	
	@RequestMapping(value="newconncomplain")
	public String newConnComplain(Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("creating new connectivity complain");
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			return "create_connectivity";
		}
	}
	
	
	
	@RequestMapping(value="addNewConnectivityComplain",method=RequestMethod.POST)
	public String addNewConnectivityComplain(ConnectivityComplainModel newCm,Model model,RedirectAttributes redir)
	{
		if(session.getAttribute("userObj") == null)
		{
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("adding new Connectivity Complain!");
			int i=dao.addNewConnectivityComplain(newCm);
			if(i==0)
			{
				redir.addFlashAttribute("msg", "Complain not submitted");
			}
			
			else
			{
				redir.addFlashAttribute("msg", "Complain Submitted");
				redir.addFlashAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
				List<AllComplainModel> connComplainList=dao1.getConnectionCompDetail();
	
			
				Map<String, String> countMap=dao1.getCompCount();
				if(countMap.containsKey("Connectivity"))
				{
					redir.addFlashAttribute("connCount", countMap.get("Connectivity"));
				}
				else
				{
					redir.addFlashAttribute("connCount", 0);
				}
	
				if(countMap.containsKey("Hardware"))
				{
					redir.addFlashAttribute("hwCount", countMap.get("Hardware"));
				}
				else
				{
					redir.addFlashAttribute("hw", 0);
				}
				
				if(countMap.containsKey("Physical Damage"))
				{
					redir.addFlashAttribute("physicalCount", countMap.get("Physical Damage"));
				}
				else
				{
					redir.addFlashAttribute("physicalCount", 0);
				}
				
				if(countMap.containsKey("Software"))
				{
					redir.addFlashAttribute("swCount", countMap.get("Software"));
				}
				else
				{
					redir.addFlashAttribute("swCount", 0);
				}
				redir.addFlashAttribute("connectData", connComplainList);
				redir.addFlashAttribute("map", countMap);
				return "redirect:/homepage";
			}
				return null;
		}
			}
}