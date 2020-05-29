package com.spice.vchatinterfacebulk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spice.vchatinterfacebulk.beans.ChatAgentLiveCountCircleWise;
import com.spice.vchatinterfacebulk.beans.ChatAgentLiveCountPartnerWise;
import com.spice.vchatinterfacebulk.beans.ChatAgentLiveCountZoneWise;
import com.spice.vchatinterfacebulk.dao.IChatAgentLiveCountDao;

@Controller
public class AgentLiveCountController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AgentLiveCountController.class);

	@Autowired
	HttpSession session;
	
	@Autowired
	IChatAgentLiveCountDao chatAgentLiveCountDao;
	
	
	@RequestMapping(value = "/agentlivecount", method = RequestMethod.GET)
	public ModelAndView getAgentLiveCount() {
		ModelAndView model;
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		} else {
			model = new ModelAndView("chatagentlivecount");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/agentlivecountAction", method = RequestMethod.GET)
	public ModelAndView getAgentLiveCountPost(@RequestParam(value="hub") String hub) {
		
		LOGGER.info("Agent Live Count hub is ## [{}]",hub);
		
		List<ChatAgentLiveCountPartnerWise> partnerList= chatAgentLiveCountDao.getPartnerDetails(hub);
		List<ChatAgentLiveCountZoneWise>	zoneList=chatAgentLiveCountDao.getZoneDetails(hub);
		List<ChatAgentLiveCountCircleWise>	circleList=chatAgentLiveCountDao.getCircleDetails(hub);
		
		
		ModelAndView model;
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		} else {
			model = new ModelAndView("chatagentlivecount");
			model.addObject("objPartnerResp", partnerList);
			model.addObject("hubName", hub);
			model.addObject("objZoneResp", zoneList);
			model.addObject("objCircleResp", circleList);
		}
		return model;
	}
	
	@RequestMapping(value = "/getPartnerDetails", method = RequestMethod.GET)
	public ModelAndView getPartnerDetailsGet(@RequestParam(value="hub") String hub,@RequestParam(value="partnerName") String partnerName,HttpServletRequest request ){		
		LOGGER.info("HUB is [{}] and partner name is [{}]",hub,partnerName);
		
		List<ChatAgentLiveCountCircleWise> partnerDetailsList= chatAgentLiveCountDao.getPartnerCircleDetails(hub,partnerName);
		
		LOGGER.info("partnerDetailsList are [{}]",partnerDetailsList.toString());
			
		ModelAndView model;
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		} else {
			model = new ModelAndView("chatagentlivecountpartnerhub");
			model.addObject("objCircleResp", partnerDetailsList);
			model.addObject("objHubResp", hub);
			model.addObject("objPNResp", partnerName);
		}
		return model;		
	}

	
	
	@RequestMapping(value = "/allcircleHome", method = RequestMethod.GET)
	public ModelAndView allcircleHome() {
		ModelAndView model;
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
			return model;
		}
		else {
			model = new ModelAndView("allcircleHome");
			
			List<List<ChatAgentLiveCountCircleWise>> circleList=chatAgentLiveCountDao.getCircleDetailsHome();
				model.addObject("objCircleResp", circleList);
				return model;
		}
	}
	
	@RequestMapping(value = "/circlewiseAgentdetails", method = RequestMethod.GET)
	public ModelAndView getcirclewiseAgentdetails(@RequestParam String hub,@RequestParam String circle) {
		
		LOGGER.info("Getting all partner details related to hub ## [{}] and circle ## [{}]",hub,circle);
		
		List<ChatAgentLiveCountPartnerWise>	partnerList=chatAgentLiveCountDao.getCirclewisePartnerDetails(hub,circle);
		
		ModelAndView model;
		model = new ModelAndView("circelwiseAegntdetails");
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		} else {
			
			model.addObject("objPartnerResp", partnerList);
		}
		return model;
	}

}
