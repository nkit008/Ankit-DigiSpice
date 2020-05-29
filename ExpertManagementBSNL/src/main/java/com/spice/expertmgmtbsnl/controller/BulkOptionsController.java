package com.spice.expertmgmtbsnl.controller;


import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.fabric.xmlrpc.base.Array;
import com.spice.expertmgmtbsnl.dao.BulkOptionDao;
import com.spice.expertmgmtbsnl.model.UserLoginModel;

@Controller
public class BulkOptionsController {
	
	Logger logger=Logger.getLogger(BulkOptionsController.class.getName());
	
	@Autowired
	HttpSession session;
	
	@Autowired
	BulkOptionDao dao;

	@RequestMapping(value="/bulkOption")
	public String bulkOptions(Model model){
		
		if(session.getAttribute("loginObj")!=null)
		{
		model.addAttribute("loginObj", session.getAttribute("loginObj"));
		return "bulkOption";
		}
		else
		{
			return "redirect:/logout";
		}
	}
	
	
	
	@RequestMapping(value="/bulkupdate",method=RequestMethod.POST)
	public String bulkupdate(@RequestParam String zone_option,@RequestParam String bulk_option,@RequestParam String bulk_chatid,@RequestParam String call_limit,Model model,RedirectAttributes redir)
	{
		logger.info("Bulk updation for chatId's {["+bulk_chatid+"]} Zone is {["+zone_option+"]} Operation is {["+bulk_option+"]}");
		logger.info("call limit is {["+call_limit+"]}");
		String newChatid=null;
		String[] arr_chatid;
		if(session.getAttribute("loginObj")!=null)
		{
			
				newChatid=bulk_chatid.replace(" ", "");
				arr_chatid=newChatid.split(",");
				logger.info("Chat Id's in array is "+Arrays.toString(arr_chatid));
				if(call_limit=="" && bulk_option.equalsIgnoreCase("Change Call Limit"))
				{
					logger.info("User selects Change Call Limit but didn't enter call limit");
					redir.addFlashAttribute("insert_succ", "Please Enter Call Limit");
					return "redirect:/bulkOption";
				}
				if(call_limit=="")
				{
					String[] res=dao.bulkOptionStatusChanged(arr_chatid, zone_option, bulk_option);
					if(res[0]==null)
					{
						logger.info("Status update successfully " +res.length);
						redir.addFlashAttribute("insert_succ", "Update Successfully");
						return "redirect:/bulkOption";
					}
					else
					{
						logger.info("Status not update successfully "+res.length);
						redir.addFlashAttribute("insert_succ", "Not Update Successfully");
						System.out.println(Arrays.toString(res));
						return "redirect:/bulkOption";
					}
					
				}
				else
				{
					logger.info("update ids where bulk options is Change Call Limit");
					String[] res=dao.bulkOptionCallLimitChanged(arr_chatid, zone_option, bulk_option,call_limit);
					if(res[0]==null)
					{
						logger.info("update successfully with call limit");
						redir.addFlashAttribute("insert_succ", "Update Successfully");
						return "redirect:/bulkOption";
						
					}
					else
					{
						logger.info("not update successfully with call limit");
						redir.addFlashAttribute("insert_succ", "Not Update Successfully");
						return "redirect:/bulkOption";
					}
				}
				
		}
			
		else
		{
			logger.info("Session Timeout");
			return "redirect:/logout";
		}
		
	}
}
