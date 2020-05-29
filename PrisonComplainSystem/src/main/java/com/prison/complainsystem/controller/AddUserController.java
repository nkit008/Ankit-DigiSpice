package com.prison.complainsystem.controller;

import java.util.ArrayList;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prison.complainsystem.dao.AddNewUserDao;
import com.prison.complainsystem.dao.GetComplainDetailsDao;
import com.prison.complainsystem.dao.ViewComplainDao;
import com.prison.complainsystem.model.AddNewUserModel;
import com.prison.complainsystem.model.AllComplainModel;
import com.prison.complainsystem.model.UpdateComplainModel;
import com.prison.complainsystem.model.UserLogin;

@Controller
public class AddUserController {
	
	private static final Logger logger = Logger.getLogger(AddUserController.class.getName());

	@Autowired
	HttpSession session;
	
	@Autowired
	AddNewUserDao dao;
	
	@Autowired
	ViewComplainDao dao1;
	
	@Autowired
	GetComplainDetailsDao dao2;
	
	@RequestMapping(value="adduser")
	public String addUser(Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("Adding new User");
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			return "add_user";
		}
	}
	
	
	
	@RequestMapping(value="updateUser")
	public String updateUser(Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("fetching User details");
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			return "update_user";
		}
	}
	
	
	
	
	
	@RequestMapping(value="addNewUser",method=RequestMethod.POST)
	public String addNewUser(AddNewUserModel user,Model model,RedirectAttributes redir)
	{
		if(session.getAttribute("userObj") == null)
		{
			return "redirect:/logout";
		}
		
		else
		{
			int i=dao.addNewUserRecord(user);
			if(i==0)
			{
				logger.info("User not Added");
				redir.addFlashAttribute("msg", "User not Added");
			}
			
			else
			{
				logger.info("User Added Successfully");
				redir.addFlashAttribute("msg", "User Added Successfully");
			}
			redir.addFlashAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			return "redirect:/adduser";
		}
	}
	
	
	
	
	
	@RequestMapping(value="updateUserAction",method=RequestMethod.POST)
	public String updateUserAction(String userId,Model model,RedirectAttributes redir)
	{
		if(session.getAttribute("userObj") == null)
		{
			return "redirect:/logout";
		}
		
		else
		{
			UserLogin user=dao.updateUserRecord(userId);
			if(user==null)
			{
				logger.info("No record found");
				redir.addFlashAttribute("msg", "User not Exists");
			}
			
			else
			{
				logger.info("User Details fetched Successfully");
			}
			redir.addFlashAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			redir.addFlashAttribute("userD", user);
			return "redirect:/updateUser";
		}
	}
	
	
	@RequestMapping(value="updateUserAction",method=RequestMethod.GET)
	public String updateUserAction1(String userId,String msg,Model model,RedirectAttributes redir)
	{
		logger.info("in get() of updateUserAction and user id is "+userId);
		if(session.getAttribute("userObj") == null)
		{
			return "redirect:/logout";
		}
		
		else
		{
			UserLogin user=dao.updateUserRecord(userId);
			if(user==null)
			{
				logger.info("No record found");
			}
			
			else
			{
				logger.info("User Details fetched Successfully");
			}
			redir.addFlashAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			redir.addFlashAttribute("userD", user);
			redir.addFlashAttribute("msg",msg);
			return "redirect:/updateUser";
		}
	}
	
	
	@RequestMapping(value="editUserDetailsAction",method=RequestMethod.POST)
	public String editUserDetailsAction(UserLogin user,Model model,RedirectAttributes redir)
	{
		System.out.println(user.toString());
		//UserLogin user1=null;
		if(session.getAttribute("userObj") == null)
		{
			return "redirect:/logout";
		}
		
		else
		{
			int i=dao.updateUserRecordAction(user);
			if(i==0)
			{
				logger.info("User details not updated");
				redir.addAttribute("msg", "User Details not Updated");
				
			}
			
			else
			{
				logger.info("User Details updated Successfully");
				redir.addAttribute("msg", "User Edit Successfully");
				
			}
			redir.addFlashAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			redir.addAttribute("userId", String.valueOf(user.getId()));
			return "redirect:/updateUserAction";
				
			
		}
	}
	
	
	
	@RequestMapping(value="opencomlains")
	public String opencomlains(Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("View All Open Complains");
			List<AllComplainModel> list=dao1.viewOpenComplain();
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			model.addAttribute("openData",list);
			return "all_open_complain";
		}
	}
	
	
	@RequestMapping(value="editOpenComplain")
	public String editOpenComplain(UpdateComplainModel openupdate,Model model,RedirectAttributes redir)
	{
		logger.info("edit open complain id is "+openupdate.getSno());
		if(session.getAttribute("userObj") == null)
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("Edit Open Complain");
			int i=dao1.openUpdate(openupdate);
			if(i==0)
			{
				logger.info("Complain not Edit");
				redir.addFlashAttribute("msg", "Complain not Updated");
			}
			
			else
			{
				logger.info("Complain Added Succssfully");
				redir.addFlashAttribute("msg", "Complain Updated Successfully");
			}
			//List<AllComplainModel> list=dao1.viewOpenComplain();
			redir.addFlashAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			//redir.addFlashAttribute("openData",list);
			return "redirect:/opencomlains";
		}
	}
	
	

	
	
	
	@RequestMapping(value="closecomplains")
	public String closecomplains(UpdateComplainModel openupdate,Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("View All Close Complain");
			List<AllComplainModel> list=dao1.viewCloseComplain();
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			model.addAttribute("openData",list);
			return "all_close_complain";
		}
	}
	
	
	
	@RequestMapping(value="editCloseComplain")
	public String editCloseComplain(UpdateComplainModel openupdate,Model model,RedirectAttributes redir)
	{
		logger.info("edit close complain id is "+openupdate.getSno());
		if(session.getAttribute("userObj") == null)
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("Edit Close Complain");
			int i=dao1.openUpdate(openupdate);
			if(i==0)
			{
				logger.info("Complain not Edit");
				redir.addFlashAttribute("msg", "Complain not Updated");
			}
			
			else
			{
				logger.info("Complain Edit Successfully");
				redir.addFlashAttribute("msg", "Complain Updated Successfully");
			}
			List<AllComplainModel> list=dao1.viewCloseComplain();
			redir.addFlashAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			redir.addFlashAttribute("openData",list);
			return "redirect:/closecomplains";
		}
	}
	
	
	@RequestMapping(value="allcomplain")
	public String allcomplain(UpdateComplainModel openupdate,Model model)
	{
		if(session.getAttribute("userObj") == null)
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("View ALl Complain");
			List<AllComplainModel> list=dao1.viewAllComplain();
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			model.addAttribute("openData",list);
			return "all_complain";
		}
	}
	
	
	@RequestMapping(value="editAllComplain")
	public String editAllComplain(UpdateComplainModel openupdate,Model model,RedirectAttributes redir)
	{
		logger.info("edit complain id is "+openupdate.getSno());
		if(session.getAttribute("userObj") == null)
		{
			logger.info("session timeout");
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
				logger.info("complain edit Successfully");
				redir.addFlashAttribute("msg", "Complain Updated Successfully");
			}
			List<AllComplainModel> list=dao1.viewAllComplain();
			redir.addFlashAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			redir.addFlashAttribute("openData",list);
			return "redirect:/allcomplain";
		}
	}
	

	
	@ResponseBody
	@RequestMapping(value="/getDetailsByPrisonId",method=RequestMethod.GET,produces="application/json")
	public AllComplainModel getDetailsByPrisonId(@RequestParam String prisonId)
	{
		System.out.println("id is---------"+prisonId);
		AllComplainModel model=dao.findDetailsByPrisonId(prisonId);
		return model;
		
	}
	
	
	@RequestMapping(value="viewAllUser")
	public String viewAllUser(Model model)
	{
		logger.info("Viewing all user");
		if(session.getAttribute("userObj") == null)
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
		else
		{
			List<UserLogin> list=dao.getAllUsers();
			if(list==null)
			{
				logger.info("No User details found");
			}
			
			else
			{
				logger.info(list.size()+" User details found");
				model.addAttribute("openData",list);
			}
			model.addAttribute("userObj", ((UserLogin)session.getAttribute("userObj")));
			return "view_user";
		}
	}
	
	
	
}