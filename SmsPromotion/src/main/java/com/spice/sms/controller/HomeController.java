package com.spice.sms.controller;

import java.io.BufferedOutputStream;



import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spice.sms.dao.HomeControllerDao;
import com.spice.sms.entites.ConnectionFactory;
import com.spice.sms.entites.LoginEntitiy;
import com.spice.sms.entites.SmsCli;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class.getName());
	
	@Autowired
	HomeControllerDao dao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HibernateTemplate template;
	
	final String UPLOAD_DIRECTORY=ConnectionFactory.getProperty("upload_path");
	String filePath=null;
	
	/**
	 * Simply selects the Login page to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("");
		logger.info("");
		logger.info("");
		logger.info("Welcome home! The client locale is {}."+ locale);
		
		return "index";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAction(@RequestParam String username,@RequestParam String password,Model model,RedirectAttributes redir)
	{
		logger.info("");
		logger.info("");
		logger.info("");
		logger.info("");
		try
		{
			logger.info("Login IP is ["+InetAddress.getLocalHost().getHostAddress()+"]");
		}		
		catch(Exception e)
		{
			logger.info(e);
		}
		logger.info("---username and password for login is "+username+" "+password);
		LoginEntitiy login=dao.checkLogin(username, password);
		
		if(login==null)
		{
			logger.info("---username and password are mismatch---");
			redir.addFlashAttribute("wrong","Username and password are inocrrect");
			return "redirect:/";
		}
		
		else
		{
			redir.addFlashAttribute("userObj", login);
			session.setAttribute("userSesseion", login);
			return "redirect:/home";
		}
	}
	
	
	
	@RequestMapping(value="/home")
	public String home(Model model)
	{
		if(session.getAttribute("userSesseion")==null)
		{
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("welcome to homePage");
			model.addAttribute("userObj", ((LoginEntitiy)session.getAttribute("userSesseion")));
			return "home";
		}
	}
	
	
	@RequestMapping(value="/addBase",method=RequestMethod.GET)
	public String addBaseGet()
	{
		if(session.getAttribute("userSesseion")==null)
		{
			return "redirect:/logout";
		}
		
		else
		{
			return "redirect:/home";
		}
	}

	
	
	@RequestMapping(value = "/getCliByCircleName", method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<SmsCli> getCliByCircleName(@RequestParam String cName)
	{
		List<SmsCli> cli=dao.getAllCli(cName);
		
		if(cli==null)
		{
			logger.info("no cli found for circle "+cName);
			return null;
		}
		
		else
		{
			return cli;
		}
		
	}
	
	
		
	@RequestMapping(value="/addBase",method=RequestMethod.POST)
	public String addBase(@RequestParam MultipartFile base,@RequestParam String circle,@RequestParam String cli,
			@RequestParam String smsType,@RequestParam String smsScript,RedirectAttributes redir)
	{
		if(session.getAttribute("userSesseion")==null)
		{
			return "redirect:/logout";
		}
		
		else
		{
			logger.info("uploading base for circle ["+circle+"], cli ["+cli+"], smsType ["+smsType+"], smsScript ["+smsScript+"]");
			
			String ext=base.getOriginalFilename().substring(base.getOriginalFilename().lastIndexOf(".")+1);
			if(ext.equalsIgnoreCase("txt"))
			{
				Calendar cal = Calendar. getInstance();
				Date date=cal. getTime();
				DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
				String formattedDate=dateFormat. format(date);
				logger.info("start Time is "+formattedDate);

				smsScript=smsScript.replace("'", "");
				
				String filepath=copyMetaFile(base,circle);
				String res=dao.baseUpload(filepath,circle,cli,smsType,smsScript);
				
				
				if(res==null)
				{
					logger.info("File is not Uploaded");
					redir.addFlashAttribute("msg","File is not Uploaded");
					
				}
				
				else
				{
					logger.info("File is Uploaded Successfully");
					redir.addFlashAttribute("msg", res+" records Uploaded Successfully");
				}
				
				Calendar cal1 = Calendar. getInstance();
				Date date1=cal1. getTime();
				DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
				String formattedDate1=dateFormat1.format(date1);
				logger.info("End Time is "+formattedDate1);
				
				return "redirect:/home";
			}
			
			else
			{
				redir.addFlashAttribute("msg","File is Incorrect");
				return "redirect:/home";
			}
			
		}
	}
	
	@RequestMapping(value="/logout")
	public String logout()
	{
			session.removeAttribute("userSesseion");
			session.invalidate();
			return "index";
	}
	
	public String copyMetaFile(MultipartFile metafile,String circle) {
		try {
			String filename = metafile.getOriginalFilename().substring(0,metafile.getOriginalFilename().lastIndexOf("."));
			String ext = metafile.getOriginalFilename().substring(metafile.getOriginalFilename().lastIndexOf(".") + 1,
					metafile.getOriginalFilename().length());

			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
			Date date = new Date();

			/*File file=new File(UPLOAD_DIRECTORY + File.separator + File.separator +circle);*/
			File file=new File(UPLOAD_DIRECTORY +circle);
			if(file.exists()==false)
			{
				file.mkdirs();
			}
			filePath = UPLOAD_DIRECTORY + File.separator + circle + File.separator + File.separator +circle+"_"+filename + "_" + formatter.format(date) + "." + ext;
			/*filePath = UPLOAD_DIRECTORY + circle + File.separator +circle+"_"+filename + "_" + formatter.format(date) + "." + ext;*/
			
			byte[] bytes = metafile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
					new File(filePath)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			logger.info("final path of copied file in controller is "+filePath);
			return filePath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
