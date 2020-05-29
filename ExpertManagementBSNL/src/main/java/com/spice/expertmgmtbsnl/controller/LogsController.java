package com.spice.expertmgmtbsnl.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spice.expertmgmtbsnl.dao.DownloadOutcallDataDao;
import com.spice.expertmgmtbsnl.model.EtalkOutcallModel;

@Controller
public class LogsController {

	Logger logger=Logger.getLogger(LogsController.class.getName());
	
	@Autowired
	HttpSession session;
	
	@Autowired
	DownloadOutcallDataDao dao;
	
	@RequestMapping(value="/logs")
	public String logs(Model model)
	{
		logger.info("in Logs Controller");
		if(session.getAttribute("loginObj")!=null)
		{
			model.addAttribute("loginObj", session.getAttribute("loginObj"));
			return "logs";
		}
		else
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
	}
	
	
	@RequestMapping(value="/downlodByChatId")
	public String downlodByChatId(Model model,String chatId,RedirectAttributes redir)
	{
		if(session.getAttribute("loginObj")!=null)
		{
			logger.info("Retreiving outcall data by chatID");
			List<EtalkOutcallModel> list=dao.getDetailbyChatId(chatId);
			
			try
			{
			if(list.isEmpty())
			{
				logger.info("data is not retrive from logsController(downlodByChatId)");
				redir.addFlashAttribute("insert_succ", "Record not Found");
				return "redirect:/logs";
			}
			else
			{
				logger.info("data is successfully retrive from logsController(downlodByChatId)");
				redir.addFlashAttribute("records", list);
				return "redirect:/logs";
			}
			}
			
			catch(Exception e)
			{
				return "redirect:/logs";
			}
		}
		else
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
		
	}
	
	@RequestMapping(value="/downlodByANI")
	public String downlodByANI(Model model,String ani,RedirectAttributes redir)
	{
		logger.info("Retreiving outcall data by ANI");
		
		if(session.getAttribute("loginObj")!=null)
		{
		logger.info(":::Retreiving outcall data by ANI:::"+ani);
		List<EtalkOutcallModel> list=dao.getDetailbyAni(ani);
		try
		{
		if(list.isEmpty())
		{
			logger.info("data is not retrive from logsController(downlodByANI)");
			redir.addFlashAttribute("insert_succ", "Record not Found");
			return "redirect:/logs";
		}
		else
		{
			logger.info("data retrive from logsController(downlodByANI)");
			redir.addFlashAttribute("records", list);
			return "redirect:/logs";
		}
		}
		
		catch(Exception e)
		{
			return "redirect:/logs";
		}
		}
		else
		{
			logger.info("session timeout");
			return "redirect:/logout";
		}
	}
}