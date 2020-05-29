package com.spice.reminderservice.controller;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

import com.spice.reminderservice.bean.ReminderServiceBean;
import com.spice.reminderservice.dao.ReminderServiceDao;
import com.spice.reminderservice.poi.MisReminderServicePoi;



@Controller
public class MisController {
	
	@Autowired
	ReminderServiceDao dao;
	
	@Autowired
	MisReminderServicePoi misWapInternalPoi;
	

	private static final Logger logger = LoggerFactory.getLogger(MisController.class);
	
	private String fromdate;
	private String todate;
	
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
		logger.	info("===================" + username + "===============" + password);
		ModelAndView mav;
		Boolean value = dao.checkLogin(username, password);
		logger.info("===================" + value + "===============");
		if (value == true)
		{
			/*List<ReminderServiceBean> misWapInternal=previousDateData();
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
	
	@RequestMapping(value = "/mis", method = RequestMethod.POST)
	public String misFunstore(@RequestParam("fromDate") String fDate, @RequestParam("toDate") String endDate,
			Model model) throws ParseException {
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
			return "home";
		}
		
		else
		{
			System.out.println("Fetching records");
		List<ReminderServiceBean> misWapInternal = dao.getMis(fromdate, todate);
		model.addAttribute("reportdata", misWapInternal);
		
		return "home";
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		model.addAttribute("message", "Please Enter Start Date and End Date");
		return "home";
	}
	}
	
	

	@RequestMapping(value = "/logout")
	public String logout() {
		fromdate=null;
		todate=null;
		return "index";
	}
	

	@RequestMapping(value = "/reportxls")
	public String reportFunstoreXls(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ParseException {
		if(fromdate!=null && todate!=null)
		{
		ClassPathResource resource = null;
		System.out.println("from date::::::" + fromdate + " To date:::::: "+todate);
		
		List<ReminderServiceBean> misWapInternal = dao.getMis(fromdate, todate);
		if(misWapInternal.size()!=0)
		{
			resource = new ClassPathResource("/excel/MIS_reminder_service.xlsx");
		InputStream is = null;
		try {
			is = ((InputStreamSource) resource).getInputStream();
		

		int startRowIndex = 0;
		int startColIndex = 2;
		misWapInternalPoi.genrateXLS(is, startRowIndex, startColIndex, response, misWapInternal,fromdate, todate);
		is.close();
		}
		catch (Throwable e)
		{
		e.printStackTrace();
		}
		}
		return "home";
		}
		
		else
		{
/*			List<ReminderServiceBean> misWapInternal=previousDateData();
			model.addAttribute("reportdata", misWapInternal);*/
			model.addAttribute("result","wrong ani");
			model.addAttribute("msg", "Please Select Dates");
			return "home";
		}
	}

	@RequestMapping(value = "/homeheader")
	public String homeHeader(Model model) {
	/*	List<ReminderServiceBean> misWapInternal=previousDateData();
		model.addAttribute("reportdata", misWapInternal);*/
		return "home";
	}


	public String changeFormat(String dateString) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		date = df.parse(dateString);
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		return df1.format(date);
	}	
	
	
/*public List<ReminderServiceBean> previousDateData() {
		
		logger.info("============finding previous date from today=======");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.add(cal.DATE, -1);
		fromdate=df.format(cal.getTime());
		todate=df.format(cal.getTime());
		System.out.println(fromdate+"   "+todate);
		
		List<ReminderServiceBean> misWapInternal = dao.getMis(fromdate, todate);
		
		System.out.println("size of "+misWapInternal.size());
		return misWapInternal;
	}*/
}