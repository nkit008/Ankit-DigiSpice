package com.spice.vchatinterfacebulk.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spice.vchatinterfacebulk.beans.ChatLoginStatusResp;
import com.spice.vchatinterfacebulk.beans.LoginSessionDetails;
import com.spice.vchatinterfacebulk.dao.IChatLoginStatusDao;

@Controller
public class ChatLoginStatusController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ChatLoginStatusController.class);

	@Autowired
	HttpSession session;
	
	@Autowired 
	IChatLoginStatusDao chatLoginStatusDao; 

	@RequestMapping(value = "/chatloginstatus", method = RequestMethod.GET)
	public ModelAndView getDetails() {
		ModelAndView model;
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		} else {
			model = new ModelAndView("chatloginstatus");
		}
		model.addObject("userHUbList", ((LoginSessionDetails)session.getAttribute("userObj")).getSessionHubList());
		return model;
	}
	
	@RequestMapping(value = "/chatloginstatus", method = RequestMethod.POST)
	public ModelAndView getDetailsPost(@RequestParam(value="reqType") String reqType, @RequestParam(value="hub") String hub, @RequestParam(value="chatId") String chatId) {
		LOGGER.info("reqType is ## [{}] and selected hub is ##  [{}] and chat id is [{}]",reqType,hub,chatId);
		List<ChatLoginStatusResp> resp=null;
		ModelAndView model=null;
		
		if(session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		}
		
		else {
			
			model = new ModelAndView("chatloginstatus");
			if(reqType.equalsIgnoreCase("chatidopt"))
			{
				resp=chatLoginStatusDao.getDetailsByChatid(hub,chatId);
				LOGGER.info("Check Login Status with chat id");
				model.addObject("chatIdOptions", chatId);
			}
			else if(reqType.equalsIgnoreCase("hubwiseopt"))
				resp=chatLoginStatusDao.getDetailsByHub(hub);
			model.addObject("userHUbList", ((LoginSessionDetails)session.getAttribute("userObj")).getSessionHubList());
			
			if(resp==null){
				LOGGER.info("No Result Found");
				model.addObject("objRes","No Result Found");
				model.addObject("objErrorResp", resp);
			}else{	
				LOGGER.info("ChatLoginStatus Resp is [{}]",resp.toString());
				model.addObject("objResp", resp);
			}
		}
		return model;
	}
	
	@RequestMapping(value="edituser",method = RequestMethod.POST)
	public ModelAndView edituser(@RequestParam String userHub,@RequestParam String bAni
			,@RequestParam String loginStatus,@RequestParam String priorityFlag,@RequestParam String chatIdNo,RedirectAttributes redir)
	{
		ModelAndView model;
		List<ChatLoginStatusResp> resp=null;
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		} 
		else
		{
			model = new ModelAndView("chatloginstatus");
			LOGGER.info("userHub is : [{}] and bani is : [{}] and login status is : [{}] and priorityFlag is : [{}] and ChatID is : [{}]",userHub,bAni,loginStatus,priorityFlag,chatIdNo.length());
			int res = chatLoginStatusDao.editUser(userHub,bAni,loginStatus,priorityFlag);
			
			if(res > 0)
			{
				LOGGER.info("when > 0");
				model.addObject("objRes", "login status has been changed successfully");
			}
			else
			{
				LOGGER.info("when < 0");
				model.addObject("objRes", "login status has not been changed successfully");
			}
			if(chatIdNo.length()>0)
			{
				LOGGER.info("Change From  ChatID Options and chat id is "+chatIdNo);
				resp=chatLoginStatusDao.getDetailsByChatid(userHub,chatIdNo);
				model.addObject("chatIdOptions", chatIdNo);
			}
			
			else
			{
				LOGGER.info("Change From  HubWise Options and Hub is "+userHub);
				resp=chatLoginStatusDao.getDetailsByHub(userHub);
			}
			model.addObject("objResp", resp);
			model.addObject("userHUbList", ((LoginSessionDetails)session.getAttribute("userObj")).getSessionHubList());
		}	
		return model;
	}
}
