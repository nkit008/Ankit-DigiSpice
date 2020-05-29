package com.prison.complainsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prison.complainsystem.dao.GetComplainDetailsDao;
import com.prison.complainsystem.dao.ViewComplainDao;
import com.prison.complainsystem.model.AllComplainModel;
import com.prison.complainsystem.model.UpdateComplainModel;
import com.prison.complainsystem.model.UserLogin;

@Controller
public class ViewComplainController {
	
	public final static Logger logger=Logger.getLogger(ViewComplainController.class.getName()); 

	@Autowired
	HttpSession session;
	
	@Autowired
	GetComplainDetailsDao dao;
	
	@Autowired
	ViewComplainDao dao1;
	

	@RequestMapping(value="viewsoftwarecomplain")
	public String viewsoftwarecomplain(Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("View Software's related complain");
			List<AllComplainModel> list=dao.getSwCompDetail();
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			model.addAttribute("openData",list);
			return "view_software_complain";
		}
	}
	
	
	@RequestMapping(value="viewhardwarecomplain")
	public String viewhardwarecomplain(Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("View Hardware's related complain");
			List<AllComplainModel> list=dao.getHwCompDetail();
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			model.addAttribute("openData",list);
			return "view_hardware_complain";
		}
	}
	
	
	@RequestMapping(value="viewphysicalcomplain")
	public String viewphysicalcomplain(Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("View Physical Damage's related complain");
			List<AllComplainModel> list=dao.getPhysicalCompDetail();
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			model.addAttribute("openData",list);
			return "view_physical_complain";
		}
	}
	
	
	@RequestMapping(value="viewconnectioncomplain")
	public String viewconnectioncomplain(Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session Timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("View Conection's related complain");
			List<AllComplainModel> list=dao.getconnCompDetail();
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			model.addAttribute("openData",list);
			return "view_connectivity_complain";
		}
	}
	
	
	@RequestMapping(value="view_single_complain")
	public String view_single_complain(@RequestParam String category,@RequestParam String id,Model model,RedirectAttributes redir)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session Timeout");
			return "redirect:/logout";
		}
		
		else
		{
			List<AllComplainModel> list=dao.getSingleComplainDetail(id);
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			model.addAttribute("openData",list.get(0));
			if(category.equals("Hardware"))
			{
				logger.info("View Single Hardware's related complain");
				model.addAttribute("sno", id);
				return "view_single_hw_complain";
			}

			if(category.equalsIgnoreCase("Software"))
			{
				model.addAttribute("sno", id);
				logger.info("View Single Software's related complain");
				return "view_single_sw_complain";
			}
			
			if(category.equalsIgnoreCase("Physical_Damage"))
			{
				logger.info("View Single Physical Damage's related complain");
				model.addAttribute("sno", id);
				return "view_single_physical_complain";
			}

			if(category.equalsIgnoreCase("Connectivity"))
			{
				model.addAttribute("sno", id);
				logger.info("View Single Connectivity's related complain");
				return "view_single_conn_complain";
			}
			
			return null;
		}
	}
	
	@RequestMapping(value="editSinglehwComplain")
	public String editSinglehwComplain(UpdateComplainModel openupdate,Model model,RedirectAttributes redir)
	{
		logger.info("Single hw edit id is "+openupdate.getSno());
		String id=String.valueOf(openupdate.getSno());
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			int i=dao1.openUpdate(openupdate);
			if(i==0)
			{
				logger.info("Complain not edit");
				redir.addFlashAttribute("msg", "Complain not Updated");
			}
			
			else
			{
				logger.info("Complain edit Successfully");
				redir.addFlashAttribute("msg", "Complain Updated Successfully");
			}
			redir.addAttribute("id", openupdate.getSno());
			redir.addAttribute("category", "Hardware");
			return "redirect:/view_single_complain";
		}
	}
	
	
	@RequestMapping(value="editSingleConnComplain")
	public String editSingleConnComplain(UpdateComplainModel openupdate,Model model,RedirectAttributes redir)
	{
		logger.info("Single conn edit id is "+openupdate.getSno());
		String id=String.valueOf(openupdate.getSno());
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session Timeout");
			return "redirect:/logout";
		}
		
		else
		{
			int i=dao1.openUpdate(openupdate);
			if(i==0)
			{
				logger.info("Complain not edit");
				redir.addFlashAttribute("msg", "Complain not Updated");
			}
			
			else
			{
				logger.info("Complain edit Successfully");
				redir.addFlashAttribute("msg", "Complain Updated Successfully");
			}
			
			redir.addAttribute("id", openupdate.getSno());
			redir.addAttribute("category", "Connectivity");
			return "redirect:/view_single_complain";
		}
	}
	
	
	@RequestMapping(value="editSinglePhysicalComplain")
	public String editSinglePhysicalComplain(UpdateComplainModel openupdate,Model model,RedirectAttributes redir)
	{
		logger.info("Single Physical edit id is "+openupdate.getSno());
		String id=String.valueOf(openupdate.getSno());
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session Timeout");
			return "redirect:/logout";
		}
		
		else
		{
			int i=dao1.openUpdate(openupdate);
			if(i==0)
			{
				logger.info("Complain not Edit");
				redir.addFlashAttribute("msg", "Complain not Updated");
			}
			
			else
			{
				logger.info("Physical Complain edit Successfully");
				redir.addFlashAttribute("msg", "Complain Updated Successfully");
			}
			
			redir.addAttribute("id", openupdate.getSno());
			redir.addAttribute("category", "Physical_Damage");
			return "redirect:/view_single_complain";
		}
	}

	
	
	@RequestMapping(value="editSingleSftwareComplain")
	public String editSingleSftwareComplain(UpdateComplainModel openupdate,Model model,RedirectAttributes redir)
	{
		logger.info("Single Sw edit id is "+openupdate.getSno());
		String id=String.valueOf(openupdate.getSno());
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session Timeout");
			return "redirect:/logout";
		}
		
		else
		{
			int i=dao1.openUpdate(openupdate);
			if(i==0)
			{
				logger.info("Software Complain not Edit");
				redir.addFlashAttribute("msg", "Complain not Updated");
			}
			
			else
			{
				logger.info("Software Complain Edit Successfully");
				redir.addFlashAttribute("msg", "Complain Updated Successfully");
			}
			redir.addAttribute("id", openupdate.getSno());
			redir.addAttribute("category", "Software");
			return "redirect:/view_single_complain";
		}
	}
	
	
	@RequestMapping(value="view_complain_history")
	public String view_complain_history(@RequestParam String id,Model model,RedirectAttributes redir)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("Session Timeout");
			return "redirect:/logout";
		}
		
		else
		{
			List<AllComplainModel> list=dao.getComplainHistory(id);
			if(list.isEmpty())
			{
				logger.info("size of list fetching history of complain id "+id+" is "+0);
				model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
				model.addAttribute("id",id);
				String cat =dao1.viewCatagory(id);
				if(cat.equalsIgnoreCase("Physical Damage"))
				{
					cat="Physical_Damage";
				}
				model.addAttribute("cat",cat);
				return "view_complain_history";
			}
			else
			{
			logger.info("size of list fetching history of complain id "+id+" is "+list.size());
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			model.addAttribute("list",list);
			model.addAttribute("openData1",list.get(0));
			model.addAttribute("id",id);
			model.addAttribute("id1",id);
			String cat =dao1.viewCatagory(id);
			if(cat.equalsIgnoreCase("Physical Damage"))
			{
				cat="Physical_Damage";
			}
			model.addAttribute("cat",cat);
			return "view_complain_history";
			}
		}
	}
	

	
}