package com.spice.vchatinterfacebulk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spice.vchatinterfacebulk.beans.ChatAgentConfigReq;
import com.spice.vchatinterfacebulk.dao.IChatAgentConfigDao;

@Controller
public class AgentConfigController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AgentConfigController.class);

	@Autowired
	HttpSession session;
	
	@Autowired
	IChatAgentConfigDao chatAgentConfigDao;
	
	@RequestMapping(value = "/agentconfig", method = RequestMethod.GET)
	public ModelAndView getAgentConfig() {
		ModelAndView model;
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		} else {
			model = new ModelAndView("chatagentconfig");
		}
		
		return model;
	}
	@RequestMapping(value = "/agentconfig", method = RequestMethod.POST)
	public ModelAndView agentConfigPost(ChatAgentConfigReq chatAgentConfigReq, HttpServletRequest request) {
		
		LOGGER.info("Agent Configuration is ## [{}]",chatAgentConfigReq.toString());
		
		String resp=chatAgentConfigDao.save(chatAgentConfigReq);
		
		LOGGER.info("Agent Config Response is [{}]",resp);
		
		ModelAndView model;
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		} else {
			model = new ModelAndView("chatagentconfig");
			model.addObject("objResp", resp);
		}
		return model;
	}

}
