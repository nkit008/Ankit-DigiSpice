package com.spice.vchatinterfacebulk.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spice.vchatinterfacebulk.beans.AgentManagerAgentProfileReq;
import com.spice.vchatinterfacebulk.beans.AgentManagerAllAgents;
import com.spice.vchatinterfacebulk.beans.AgentManagerCreateUserDetailsDTO;
import com.spice.vchatinterfacebulk.beans.AgentManagerProfileUpdateReq;
import com.spice.vchatinterfacebulk.beans.AgentManagerUser;
import com.spice.vchatinterfacebulk.beans.LoginSessionDetails;
import com.spice.vchatinterfacebulk.beans.ManageUsers;
import com.spice.vchatinterfacebulk.dao.IAgentManagerDao;
import com.spice.vchatinterfacebulk.dao.IAgentManagerGetRecordsDao;
import com.spice.vchatinterfacebulk.dao.IAgentManagerUpdateRecordDao;
import com.spice.vchatinterfacebulk.dao.ILoginDao;
import com.spice.vchatinterfacebulk.service.IAgentManagerService;



@Controller
public class MainController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@Autowired
	IAgentManagerDao agentManagerDao;
	
	@Autowired
	IAgentManagerUpdateRecordDao agentManagerUpdateRecordDao;
	
	@Autowired
	IAgentManagerGetRecordsDao agentManagerGetRecordsDao;
	
	@Autowired
	IAgentManagerService agentManagerService;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ILoginDao dao;
	
	@RequestMapping(value = "/agentmanagercreate", method = RequestMethod.GET)
	public ModelAndView createAgent() {
		ModelAndView model;
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		} else {
			model = new ModelAndView("agentmanagercreate");
		}
		model.addObject("userHUbList", ((LoginSessionDetails)session.getAttribute("userObj")).getSessionHubList());
		return model;
	}
	
	@RequestMapping(value = "/agentmanagercreate", method = RequestMethod.POST)
	public ModelAndView createAgentPost(AgentManagerUser agentManagerUser, HttpServletRequest request,RedirectAttributes redir) {
		ModelAndView model;
		LOGGER.info("agentManagerUser is "+agentManagerUser.toString());
		
		model = new ModelAndView("redirect:/agentmanagerview");
		String resp=agentManagerDao.create(agentManagerUser);
		
		LOGGER.info("Save response is [{}]",resp);		
		model.addObject("objRes", resp);
		
		
		return model;
	}
	
	@RequestMapping(value = "/updateProfileReq", method = RequestMethod.POST)
	public ModelAndView updateAgentPost(AgentManagerProfileUpdateReq profileUpdateReq, HttpServletRequest request) {
		ModelAndView model;
		LOGGER.info("agentManagerUser is "+profileUpdateReq.toString());
		
		model = new ModelAndView("redirect:/agentmanagerview");
		String resp=agentManagerDao.updateReq(profileUpdateReq);
		
		LOGGER.info("Save response is [{}]",resp);		
		model.addObject("objRes", resp);
		
		return model;
	}

	@RequestMapping(value = "/agentmanagerupdate/{hub}/{mobileNo}/{partnerName}/{chatId}/{agentType}/{circle}/{location}", method = RequestMethod.GET)
	public String updateUser(@PathVariable("hub") String hub,@PathVariable("mobileNo") String number,@PathVariable("partnerName") String partnerName,@PathVariable("chatId") String chatId,@PathVariable("agentType") String agentType,@PathVariable("circle") String circle,@PathVariable("location") String location, HttpServletRequest request,RedirectAttributes redir) {
	
	//@RequestMapping(value = "/agentmanagerupdate/", method = RequestMethod.GET)
	//public String updateUser(AgentManagerUserRecord userObj, HttpServletRequest request,RedirectAttributes redir) {
	
		LOGGER.info("user records are $$$$$$$$$$  [{}] and [{}] and [{}] and [{}] and [{}] and [{}] and [{}]",hub,number,partnerName,chatId,agentType,circle,location);
		
		
		if (session.getAttribute("userObj") == null) {
			return "redirect:/logout";
		} else {
			LOGGER.info("session.getAttribute is not null");
			redir.addFlashAttribute("hub", hub);
			redir.addFlashAttribute("userNumber", number);
			redir.addFlashAttribute("vender", partnerName);
			redir.addFlashAttribute("userChat", chatId);
			redir.addFlashAttribute("usertype", agentType);
			redir.addFlashAttribute("userCir", circle);
			redir.addFlashAttribute("userLoc", location);
			return "redirect:/agentmanagerupdate";
		}
	}
	
	@RequestMapping("/agentmanagerupdate")
	public ModelAndView updateredirect() {
		LOGGER.info("agentmanagerupdate ");
		ModelAndView model;
		
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		} else {
			model = new ModelAndView("agentmanagerupdate");
		}
		return model;
	 }
	
	@RequestMapping(value ="/agentmanagerupdateAction", method = RequestMethod.POST)
	public String updateAgentAction(AgentManagerAgentProfileReq agentProfileReq, HttpServletRequest request,RedirectAttributes redir) {
		LOGGER.info(agentProfileReq.toString());
		
		ModelAndView model;
		model = new ModelAndView("redirect:/agentmanagerview");
		//String resp=agentManagerDao.updateRecords(agentProfileReq);
		
		String resp=agentManagerUpdateRecordDao.updateRecords(agentProfileReq);
		
		LOGGER.info("update resp is [{}]",resp);
		
		redir.addFlashAttribute("objRes", resp);
		return "redirect:/agentmanagerview";
		
		
		//model.addObject("objRes", resp);
		
		//return model;
	}
	
	@RequestMapping(value = "/agentmanagerview", method = RequestMethod.GET)
	public ModelAndView viewUser() {
		ModelAndView model;
		model = new ModelAndView("agentmanagerview");
		List<AgentManagerAgentProfileReq> resp=agentManagerDao.view();
		
		if(null==resp){
			model.addObject("objRes", "No record Found");
		}else{
			model.addObject("objList", resp);
		}
		return model;
	}
	
	@RequestMapping(value = "/agentmanagerrecords", method = RequestMethod.GET)
	public ModelAndView userRecord() {
		ModelAndView model;
		model = new ModelAndView("agentmanagerrecords");
		//List<AgentManagerUserRecord> resp=agentManagerDao.viewRecords();
		
		List<AgentManagerAllAgents> resp=agentManagerGetRecordsDao.viewRecords();
		
		if(null==resp){
			model.addObject("objRes", "No record Found");
		}else{
			model.addObject("objList", resp);
		}	
		return model;
	}
	@RequestMapping(value = "/agentmanagerrecordsbyani", method = RequestMethod.GET)
	/*public ModelAndView userRecordByAni(@PathVariable(value = "ani") String mobileNo,@PathVariable(value = "hub") String hub ) {*/
	public ModelAndView userRecordByAni(@RequestParam(value = "ani") String mobileNo,@RequestParam(value = "hub") String hub ) {
		
		
		LOGGER.info("agentmanagerrecordsbyani Mobile Number [{}] and hub is [{}]",mobileNo,hub);
		ModelAndView model;
		model = new ModelAndView("agentmanageragentrecord");
		List<AgentManagerAllAgents> resp=agentManagerGetRecordsDao.getValueByAni(mobileNo,hub);
		
		//LOGGER.info("Main controller page ::  "+resp.toString());
		
		model.addObject("objList", resp);	
		return model;
	}
	
	@RequestMapping(value = "ajaxAction", method = RequestMethod.GET)
	public @ResponseBody AgentManagerCreateUserDetailsDTO add(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String hubName = request.getParameter("hubName");
		LOGGER.info("Hubname is [{}]",hubName);
		AgentManagerCreateUserDetailsDTO createUserDetails=agentManagerService.createUserAjaxReq(hubName);
		
		return createUserDetails;
	}
	
	
	
	@RequestMapping("userDoc/{imageFileCode:.+}")
	@ResponseBody
	public HttpEntity<byte[]> getUserDoc(@PathVariable String imageFileCode) throws IOException {
		
		LOGGER.info("Requested Image name :--" +imageFileCode);
		byte[] image = org.apache.commons.io.FileUtils.readFileToByteArray(new File(
				"F:"+File.separator+"vchatinterface_DoNotDelete"+File.separator+"PartnerAgentRecords"+ File.separator +"AgentDocImage" + File.separator + imageFileCode));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		headers.setContentLength(image.length);
		return new HttpEntity<byte[]>(image, headers);
	}
	
	@RequestMapping("venderCert/{imageFileCode:.+}")
	@ResponseBody
	public HttpEntity<byte[]> getVenderCert(@PathVariable String imageFileCode) throws IOException {
		LOGGER.info("Requested Image name :--" +imageFileCode);
		
		byte[] image = org.apache.commons.io.FileUtils.readFileToByteArray(new File(
				"F:"+File.separator+"vchatinterface_DoNotDelete"+File.separator+"PartnerAgentRecords"+ File.separator +"VenderCertificateImage" + File.separator + imageFileCode));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		headers.setContentLength(image.length);
		return new HttpEntity<byte[]>(image, headers);
	}
	
	
	@RequestMapping(value = "/agentmanagerviewfinal", method = RequestMethod.GET)
	public ModelAndView viewUserFinal() {
		ModelAndView model;
		model = new ModelAndView("agentmanagerview");
		List<AgentManagerAgentProfileReq> resp=agentManagerDao.viewFinal();
		
		if(null==resp){
			model.addObject("objRes", "No record Found");
		}else{
			model.addObject("objList", resp);
			model.addObject("reqType", "completed");
		}
		return model;
	}

	
	/*@RequestMapping(value = "/agentmanagercreate", method = RequestMethod.POST)
	public ModelAndView createAgentPost(AgentManagerUser agentManagerUser, HttpServletRequest request) {
		ModelAndView model;
		LOGGER.info("agentManagerUser is "+agentManagerUser.toString());
		
		model = new ModelAndView("agentmanagercreate");
		String resp=userDao.create(agentManagerUser);
		
		LOGGER.info("Save response is [{}]",resp);		
		model.addObject("objRes", resp);
		
		return model;
	}*/
	
	@RequestMapping(value = "/manageUsers", method = RequestMethod.GET)
	public ModelAndView passwordChange() {
		ModelAndView model;
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		} else {
			model = new ModelAndView("manageUsers");
		}
		
		List<ManageUsers> list = dao.getAllUsers();
		model.addObject("objCircleResp",list);
		model.addObject("userHUbList", ((LoginSessionDetails)session.getAttribute("userObj")).getSessionHubList());
		return model;
	}
	
	
	
	@RequestMapping(value = "/resetpasswordAction", method = RequestMethod.POST)
	public String resetpasswordAction(@RequestParam String userName,@RequestParam String newPassword,RedirectAttributes redir) {
		
		if (session.getAttribute("userObj") == null) {
			return "redirect:/logout";
		}
		
		else
		{
			LOGGER.info("Password Changing request for id "+userName+" and new password is "+newPassword);
			int resp = agentManagerDao.resetPassword(userName,newPassword);
			String adminName = ((LoginSessionDetails)session.getAttribute("userObj")).getUserName();
			String adminIp = ((LoginSessionDetails)session.getAttribute("userObj")).getUserIp();
			if(resp==1)
			{
				LOGGER.info("Password is Successfully Reset for UserId "+userName+" by "+adminName+
						" ip of "+ adminName +"is "+adminIp+" and new Password of "+userName+" is "+newPassword);
				
				redir.addFlashAttribute("msg","Password Reset Successfully");
				
			}
			else
			{
				LOGGER.info("Password is not Reset for UserId "+userName+" by "+((LoginSessionDetails)session.getAttribute("userObj")).getUserName());
				redir.addFlashAttribute("msg","Password not Reset");
			}
		}
		
		return "redirect:/manageUsers";
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String delUserAction(@RequestParam String pName,@RequestParam String userName,@RequestParam String userRole,@RequestParam String password,RedirectAttributes redir) {
		
		if (session.getAttribute("userObj") == null) {
			return "redirect:/logout";
		}
		
		else
		{
			LOGGER.info("Deleting User having  id [{}], Name [{}], Password [{}] and having role [{}]",userName,pName,password,userRole);
			int resp = agentManagerDao.delUser(userName,pName,userRole,password);
			
			if(resp==2)
			{
				
				redir.addFlashAttribute("msg","User Deleted Successfully");
				
			}
			else
			{
				redir.addFlashAttribute("msg","User not Deleted");
			}
		}
		
		return "redirect:/manageUsers";
	}
	
	
}
