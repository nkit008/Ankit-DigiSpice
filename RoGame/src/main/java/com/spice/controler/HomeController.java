package com.spice.controler;


import java.io.InputStream;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spice.bean.MisGamingRobi;
import com.spice.bean.MisGamingAirtel;
import com.spice.bean.MisLogin;
import com.spice.dao.LoginDao;
import com.spice.misreport.MISGamingAirtelPOI;
import com.spice.misreport.MISGamingRobiPOI;
//import com.spice.misreport.MisWapInternalPoi;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	LoginDao loginDao;

	@Autowired
	MISGamingRobiPOI robi_poi;
	
	@Autowired
	MISGamingAirtelPOI airtel_poi;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	private String fromdate;
	private String todate;
	private String aceespage;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,Model model) {
		logger.info("===================" + username + "===============" + password);
		ModelAndView mav;
		Boolean value = loginDao.checkLogin(username, password);
		logger.info("===================" + value + "===============");
		if (value == true)
		{
			/*List<MisGamingRobi> misWapInternal=previousDateData();
			model.addAttribute("reportdata", misWapInternal);*/
			mav=new ModelAndView("home");
			return mav;
		}
		else
		{
			mav=new ModelAndView("index");
			mav.addObject("msg", "Username and Password combination is wrong");
			return mav;
		}	
	}

	@RequestMapping(value = "/GameStoreMIS", method = RequestMethod.POST)
	public String misFunstore(@RequestParam("fromDate") String fDate, @RequestParam("toDate") String endDate,
			@RequestParam("accessService") String service,Model model) throws ParseException {
		
		aceespage=service;
		Date from_date;
		Date end_date;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
	try{
		from_date = df.parse(fDate);
		end_date=df.parse(endDate);
		
		fromdate = changeFormat(fDate);
		todate = changeFormat(endDate);
		
		logger.info("====Comparing first date and last date===");
		
		if(from_date.after(end_date))
		{
			model.addAttribute("message", "Start Date Must be Less Then End Date");
			model.addAttribute("accesspage", aceespage);
			return "home";
		}
		else{
			if(aceespage.equals("gamingMis_robi"))
			{
		List<MisGamingRobi> misWapInternal = loginDao.getMis(fromdate, todate,aceespage);
		model.addAttribute("reportdata", misWapInternal);
			}
			
			else if(aceespage.equals("gamingMis_airtel"))
			{
				
				List<MisGamingAirtel> misWapInternal = loginDao.getMis_airtel(fromdate, todate,aceespage);
				model.addAttribute("reportdata", misWapInternal);
				model.addAttribute("accesspage", aceespage);
				
			}
			
			model.addAttribute("accesspage", aceespage);
			return "home";

		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		model.addAttribute("message", "Please Enter Start Date and End Date");
		model.addAttribute("accesspage", aceespage);
		return "home";
	}
	}
	
	
	
	@RequestMapping(value = "/SpiceClubMIS", method = RequestMethod.POST)
	public String misspiceclub(@RequestParam("fromDate") String fDate, @RequestParam("toDate") String endDate,
			@RequestParam("accessService") String service,Model model) throws ParseException {
		
		aceespage=service;
		Date from_date;
		Date end_date;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
	try{
		from_date = df.parse(fDate);
		end_date=df.parse(endDate);
		
		fromdate = changeFormat(fDate);
		todate = changeFormat(endDate);
		
		logger.info("====Comparing first date and last date===");
		
		if(from_date.after(end_date))
		{
			model.addAttribute("message", "Start Date Must be Less Then End Date");
			model.addAttribute("accesspage", aceespage);
			return "spiceclub";
		}
		else{
			if(aceespage.equals("gamingMis_robi"))
			{
				List<MisGamingRobi> misWapInternal = loginDao.getMis(fromdate, todate,aceespage);
				model.addAttribute("reportdata", misWapInternal);
				model.addAttribute("accesspage", aceespage);
			}
			
			else if(aceespage.equals("gamingMis_airtel"))
			{
				List<MisGamingAirtel> misWapInternal = loginDao.getMis_airtel(fromdate, todate,aceespage);
				model.addAttribute("reportdata", misWapInternal);
				model.addAttribute("accesspage", aceespage);
			}
		
			
			return "spiceclub";
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		model.addAttribute("message", "Please Enter Start Date and End Date");
		return "spiceclub";
	}
	}
	
	
	@RequestMapping(value = "/logout")
	public String logout() {
		fromdate=null;
		todate=null;
		return "index";
	}
	

	@RequestMapping(value = "/reportxls")
	public String reportFunstoreXls(HttpServletRequest request, HttpServletResponse response, Model model,RedirectAttributes redir)
			throws ParseException {
		if(fromdate!=null && todate!=null)
		{
			String service_name="GameStore";
		ClassPathResource resource = null;
		System.out.println("from date::::::" + fromdate + " To date:::::: "+todate);
		
		if(aceespage.equalsIgnoreCase("gamingMis_airtel"))
		{
		List<MisGamingAirtel> misWapInternal = loginDao.getMis_airtel(fromdate, todate,aceespage);
		if(misWapInternal.size()!=0)
		{
			
			resource = new ClassPathResource("/excel/Game_StoreMIS_Airtel.xlsx");
		InputStream is = null;
		try {
				is = ((InputStreamSource) resource).getInputStream();
				int startRowIndex = 0;
				int startColIndex = 2;
				airtel_poi.genrateXLS(is, startRowIndex, startColIndex, response, misWapInternal,fromdate, todate,service_name);
				is.close();
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
			model.addAttribute("accesspage", aceespage);
			return "home";
		}
		}
		
		else if(aceespage.equalsIgnoreCase("gamingMis_robi"))
			{
			List<MisGamingRobi> misWapInternal = loginDao.getMis(fromdate, todate,aceespage);
			if(misWapInternal.size()!=0)
			{
				
				resource = new ClassPathResource("/excel/Game_StoreMIS_Robi.xlsx");
			InputStream is = null;
			try {
				is = ((InputStreamSource) resource).getInputStream();
				int startRowIndex = 0;
				int startColIndex = 2;
				robi_poi.genrateXLS(is, startRowIndex, startColIndex, response, misWapInternal,fromdate, todate,service_name);
			is.close();
			}
			catch (Throwable e)
			{
			e.printStackTrace();
			}
			model.addAttribute("accesspage", aceespage);
			return "home";
			}
			}
		
		}
		
		else
		{
			redir.addFlashAttribute("msg", "Please Select Dates");
			model.addAttribute("accesspage", aceespage);
			return "home";
		}
		return "home";
	}
	
	

	
	
	
	@RequestMapping(value = "/reportxls1")
	public String reportFunstoreXls1(HttpServletRequest request, HttpServletResponse response, Model model,RedirectAttributes redir)
			throws ParseException {
		if(fromdate!=null && todate!=null)
		{
			String service_name="SpiceClub24";
		ClassPathResource resource = null;
		System.out.println("from date::::::" + fromdate + " To date:::::: "+todate);
		
		if(aceespage.equalsIgnoreCase("gamingMis_airtel"))
		{
		List<MisGamingAirtel> misWapInternal = loginDao.getMis_airtel(fromdate, todate,aceespage);
		if(misWapInternal.size()!=0)
		{
			
			resource = new ClassPathResource("/excel/Game_StoreMIS_Airtel.xlsx");
		InputStream is = null;
		try {
				is = ((InputStreamSource) resource).getInputStream();
				int startRowIndex = 0;
				int startColIndex = 2;
				airtel_poi.genrateXLS(is, startRowIndex, startColIndex, response, misWapInternal,fromdate, todate,service_name);
				is.close();
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
			model.addAttribute("accesspage", aceespage);
			return "spiceclub";
		}
		}
		
		else if(aceespage.equalsIgnoreCase("gamingMis_robi"))
			{
			List<MisGamingRobi> misWapInternal = loginDao.getMis(fromdate, todate,aceespage);
			if(misWapInternal.size()!=0)
			{
				
				resource = new ClassPathResource("/excel/Game_StoreMIS_Robi.xlsx");
			InputStream is = null;
			try {
				is = ((InputStreamSource) resource).getInputStream();
				int startRowIndex = 0;
				int startColIndex = 2;
				robi_poi.genrateXLS(is, startRowIndex, startColIndex, response, misWapInternal,fromdate, todate,service_name);
			is.close();
			}
			catch (Throwable e)
			{
			e.printStackTrace();
			}
			model.addAttribute("accesspage", aceespage);
			return "spiceclub";
			}
			}
		
		}
		
		else
		{
			redir.addFlashAttribute("msg", "Please Select Dates");
			model.addAttribute("accesspage", aceespage);
			return "spiceclub";
		}
		return "spiceclub";
	}
	
	
	
	@RequestMapping(value = "/gamingStore")
	public String homeHeader(@RequestParam("accesspage") String accesspage,Model model) {
		
		model.addAttribute("accesspage", accesspage);
		todate=null;
		aceespage=null;
		return "home";
	}
	
	
	@RequestMapping(value = "/spiceclub")
	public String spiceclub(@RequestParam("accesspage") String accesspage,Model model) {
		
		model.addAttribute("accesspage", accesspage);
		todate=null;
		aceespage=null;
		return "spiceclub";
	}


	public String changeFormat(String dateString) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		date = df.parse(dateString);
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		return df1.format(date);

	}	
	public List<MisGamingRobi> previousDateData() {
		
		logger.info("============finding previous date from today=======");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.add(cal.DATE, -1);
		fromdate=df.format(cal.getTime());
		todate=df.format(cal.getTime());
		System.out.println(fromdate+"   "+todate);
		
		List<MisGamingRobi> misWapInternal = loginDao.getMis(fromdate, todate,aceespage);
		return misWapInternal;
	}
}