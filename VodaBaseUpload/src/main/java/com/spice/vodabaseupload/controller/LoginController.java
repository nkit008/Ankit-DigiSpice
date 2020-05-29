package com.spice.vodabaseupload.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spice.vodabaseupload.beans.Login;
import com.spice.vodabaseupload.beans.LoginSessionDetails;
import com.spice.vodabaseupload.dao.IBaseUploadDao;
import com.spice.vodabaseupload.dao.ILoginDao;


@Controller
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	ILoginDao loginDao;
	
	@Autowired
	IBaseUploadDao baseUploadDao; 
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet() {
		ModelAndView model;
		model = new ModelAndView("login");
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(Login login, HttpServletRequest request,RedirectAttributes redir) {
		ModelAndView model;
		
		LOGGER.info(login.toString());
		LOGGER.info("User Ip Address is [{}]",request.getRemoteAddr());
		try{
			LoginSessionDetails loginDetails = loginDao.getLoginStatus(login,request);
			if (loginDetails != null) {
				LOGGER.info("return " + loginDetails.toString());

				model = new ModelAndView("redirect:/home");
				LOGGER.info(loginDetails.toString());
				session.setAttribute("userObj", loginDetails);
				
				return model;
			}else{
				model = new ModelAndView("login");
				model.addObject("wrong", "Invalid Credentials");
				return model;
			}
		}catch(Exception e){
			LOGGER.info("EXception in Login "+e);
			model = new ModelAndView("login");
			model.addObject("wrong", "ERROR! please login after some time");
			return model;
		}
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model;
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
			return model;
		}
		else {
			model = new ModelAndView("home");
			
			/*
			 * List<List<ChatAgentLiveCountCircleWise>>
			 * circleList=chatAgentLiveCountDao.getCircleDetailsHome();
			 * model.addObject("objCircleResp", circleList);
			 */
				return model;
		}
	}
	
	@RequestMapping(value="baseupload", method=RequestMethod.POST)
	public ModelAndView upload(@RequestParam(value = "service") String service, @RequestParam(value ="basefile")MultipartFile basefile, HttpServletRequest request,RedirectAttributes redir) {
		ModelAndView model ;
		String resp=null;
		LOGGER.info("service Name is [{}] and uploaded file name is [{}]",service,basefile.getOriginalFilename());
		
		LOGGER.info("[{}] Uploaded File size is [{}]",basefile.getOriginalFilename(),basefile.getSize());
		
		if(basefile.getSize()>10) {
			resp=baseUploadDao.upload(basefile, service);
		}else resp="file not found!!!";	
		
		LOGGER.info("final resp is [{}]",resp);
		
		model = new ModelAndView("redirect:/home");
		
		if(resp == null)
		{
			redir.addFlashAttribute("objResp", "File not Uploded!!!");
		}
		else	
			redir.addFlashAttribute("objResp", resp);
		
		return model;
	}
	
	@RequestMapping(value="baseupload", method=RequestMethod.GET)
	public ModelAndView uploadGet() {
		ModelAndView model;
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
			return model;
		}
		else {
			model = new ModelAndView("home");
			return model;
		}
	}
	
	@RequestMapping(value = "logout")
	public String logout() {
		
		if (session.getAttribute("userObj") == null) {
			LOGGER.info("--session expired--");
			return "login";
		}else {
			LoginSessionDetails loginSessionDetails = (LoginSessionDetails)session.getAttribute("userObj");
			LOGGER.info("Logout UserName is [{}] and IP Address is [{}] and User Role is [{}]",loginSessionDetails.getUserName(),loginSessionDetails.getUserIp(),loginSessionDetails.getRole());
			
			session.removeAttribute("userObj");
			session.invalidate();
			LOGGER.info("---logout successfully!---");
			return "login";
		}
	}
	
	
	public static String loadProp(String var) {
		InputStream is = null;
		try {
			Properties prop = new Properties();
			is = new FileInputStream(ResourceUtils.getFile("classpath:application.properties"));
			prop.load(is);
			return prop.getProperty(var);
		}

		catch (Exception e) {
			LOGGER.info("exception occured {}", e);
			;
		}

		finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					LOGGER.info("exception occured {}", e);
					;
				}
			}
		}

		return null;
	}
	
}
