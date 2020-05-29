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

import com.spice.vchatinterfacebulk.beans.ChatBulkOptionReq;
import com.spice.vchatinterfacebulk.dao.IChatBulkOptionDao;

@Controller
public class BulkOptionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BulkOptionController.class);

	@Autowired
	HttpSession session;
	
	@Autowired
	IChatBulkOptionDao chatBulkOptionDao;
	
	
	@RequestMapping(value = "/bulkoption", method = RequestMethod.GET)
	public ModelAndView getBulkOption() {
		ModelAndView model;
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		} else {
			model = new ModelAndView("chatbulkoption");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/bulkoption", method = RequestMethod.POST)
	public ModelAndView getBulkOptionPost(ChatBulkOptionReq chatBulkOptionReq, HttpServletRequest request) {
		
		LOGGER.info("Bulk Option Request is ## [{}]",chatBulkOptionReq.toString());
		
		String resp=chatBulkOptionDao.update(chatBulkOptionReq);
		
		LOGGER.info("Bulk option request is [{}] and Update Response is [{}]",chatBulkOptionReq.getBulkType(),resp);
		
		ModelAndView model;
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		} else {
			model = new ModelAndView("chatbulkoption");
			model.addObject("objRes", resp);
		}
		return model;
	}

}
