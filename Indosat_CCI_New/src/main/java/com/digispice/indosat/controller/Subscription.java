package com.digispice.indosat.controller;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.digispice.indosat.dao.CheckSubscriptionDao;
import com.digispice.indosat.daoImpl.GetMisDao;
import com.digispice.indosat.daoImpl.SummaryRequestDTO;


@Controller
public class Subscription {
	
	public static Logger logger=Logger.getLogger(Subscription.class.getName());
	
	
	@Autowired
	HttpSession session;
	
	@Autowired
	CheckSubscriptionDao checkSubscriptionDao;
	
	@Autowired
	GetMisDao misDao;
	
	@RequestMapping(value="/subscription")
	public String subscription(Model model)
	{
		if(session.getAttribute("userObj")==null)
		{
			return "redirect:/logout";
		}
		else
		{
			return "subscription";
		}
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/showPackType",method=RequestMethod.POST,produces="application/json")
	public HashMap<String, String> getPackType(@RequestParam String serivce_name)
	{
			HashMap<String, String> pack_detail=checkSubscriptionDao.showPackTypeDetails(serivce_name);
			return pack_detail;
	}
	
	
	@RequestMapping(value="/subscribeNumber",method=RequestMethod.POST)
	public String subscribeNumber(String mobile,String service_name,String packType,RedirectAttributes redir)
	{
		if(session.getAttribute("userObj")==null)
		{
			return "redirect:/logout";
		}
		else
		{
			logger.info("---Activating Service Pack-- in [subscribeNumber] controller");
			String cat="NA";
			System.out.println("IN SUBSCRIPTION ACTION ::  ani ---> "+mobile +"  ServiceName --> "+ service_name + " cat-->"+ cat+" Pack Typ---> "+packType);
			String out=checkSubscriptionDao.goSubscription(mobile, service_name.trim(), cat.trim(),packType.trim());
			
			logger.info("Out parameter is "+out);
			
			if(out.equals("0"))
			{
				redir.addFlashAttribute("msg","Already Subscibed for "+ service_name);
			}
			else if(out.equals("100"))
			{
				redir.addFlashAttribute("msg","Subscription failed "+ service_name);
			}
			else
			{
				redir.addFlashAttribute("msg","successfully Subscibed for "+ service_name);
			}
			
		}
		return "redirect:/subscription";
	}
	
	
	@RequestMapping(value="/unSubDetail")
	public String unSubDetail()
	{
		if(session.getAttribute("userObj")==null)
		{
			return "redirect:/logout";
		}
		else
		{
			return "unSubscription";
		}
	}
	
	
	@RequestMapping(value="/unSubscribeNumber")
	public String unSubscribeNumber(String mobile,RedirectAttributes redir)
	{
		if(session.getAttribute("userObj")==null)
		{
			return "redirect:/logout";
		}
		else
		{
			logger.info("ACTION unSub DETAILS :: ANI---> "+ mobile);
			
			ArrayList<HashMap<String,String>> list = checkSubscriptionDao.getUnSubscriptionDetails(mobile);
			if(list.isEmpty())
			{
				redir.addFlashAttribute("msg", "No Details Found");
			}
			else
			{
				redir.addFlashAttribute("unsubDetails", list);
			}
			return "redirect:/unSubDetail";
		}
	}
	
	
	@RequestMapping(value="/showBilling")
	public String showBilling()
	{
		if(session.getAttribute("userObj")==null)
		{
			return "redirect:/logout";
		}
		else
		{
			return "billingDetails";
		}
	}
	
	
	@RequestMapping(value="/showBillingDetails")
	public String showBillingDetails(String mobile,RedirectAttributes redir)
	{
		if(session.getAttribute("userObj")==null)
		{
			return "redirect:/logout";
		}
		else
		{
			logger.info("ACTION BILLING DETAILS :: ANI---> " + mobile);
			
			ArrayList<HashMap<String,String>> list = checkSubscriptionDao.getBillingDetails(mobile.trim());
			if(list.isEmpty())
			{
				redir.addFlashAttribute("msg", "No Details Found");
			}
			else
			{
				redir.addFlashAttribute("billingDetails", list);
			}
			return "redirect:/showBilling";
		}
	}
	
	
	@RequestMapping(value="/promotionstatus")
	public String promotionstatus(Model model)
	{
	    SimpleDateFormat sdfForm = new SimpleDateFormat("yyyy-MM-dd");

		if(session.getAttribute("userObj")==null)
		{
			return "redirect:/logout";
		}
		else
		{
			Calendar c = Calendar.getInstance();
            String startDate = "";
            c.add(Calendar.DAY_OF_MONTH, -1);
            c.set(Calendar.DAY_OF_MONTH, 1);
            startDate = sdfForm.format(c.getTime());
            
            logger.info("------ Showing MIS for IBADAH Promotional Status----");
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new java.util.Date());
            java.util.Date from = calendar.getTime();
            String end = sdfForm.format(from);
            
            ArrayList list = misDao.getActSourceCount(end , end , true);
            System.out.println("start date is "+end);
            session.setAttribute("promotionData", list);
            model.addAttribute("promotionstartDate", end);
            model.addAttribute("promotionendDate", end);
            
            return "promotion";
		}
	}
	
	
	
	@RequestMapping(value="/promotionstatusAction",method=RequestMethod.POST)
	public String promotionstatusAction(String fromDate,String toDate,Model model)
	{
		
		System.out.println("fromdate is "+fromDate+" and end date is "+toDate);
		String fDate=null;
		String tDate=null;
		ArrayList list = null;
		if(session.getAttribute("userObj")==null)
		{
			return "redirect:/logout";
		}
		else
		{
			
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMdd");
			
			try {
				fDate=sdf1.format(sdf.parse(fromDate));
				tDate=sdf1.format(sdf.parse(toDate));
				list = misDao.getActSourceCount(fDate, tDate, false);				
			} catch (ParseException e) {
				logger.info(e);
				e.printStackTrace();
			}
			
            session.setAttribute("promotionData", list);
            model.addAttribute("promotionstartDate", fromDate);
            model.addAttribute("promotionendDate", toDate);
			return "promotion";
		}
	}
	
	@RequestMapping(value="/misDownload")
	public String misDownload()
	{
		if(session.getAttribute("userObj")==null)
		{
			return "redirect:/logout";
		}
		else
		{
			return "mis/DetailedExcel";
		}
	}
	
	@RequestMapping(value="/fetchMIS")
	public String fetchMIS(Model model)
	{
		ArrayList rs = null;
		
		if(session.getAttribute("userObj")==null)
		{
			return "redirect:/logout";
		}
		else
		{
			
			SimpleDateFormat sdfForm = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
			
			Calendar c=Calendar.getInstance();
			c.add(Calendar.DAY_OF_MONTH, -1);
			System.out.println(c.getTime());
			Date toDate = c.getTime();
			String tDate = sdf.format(c.getTime());
			c.set(Calendar.DAY_OF_MONTH, 1);
			String fDate = sdf.format(c.getTime());
			Date fromDate = c.getTime();
			logger.info("---------------Start date is "+fDate +" and end date is "+tDate+"------------------");
			
			try
			{
				rs = SummaryRequestDTO.cust_getRevenueMISData(fDate, tDate);
				model.addAttribute("from", sdf1.format(fromDate));
				model.addAttribute("to", sdf1.format(toDate));
			
			}
			
			catch(Exception e)
			{
				logger.info(e);
			}
			
			session.setAttribute("cust_revenueMISData", rs);
			
		}
		
		return "mis/promotion";
	}
	
	
	@RequestMapping(value="/fetchMisNew",method=RequestMethod.POST)
	public String fetchMisNew(String fromDate,String toDate,Model model)
	{
		ArrayList list =null;
		
		System.out.println("fromdate is "+fromDate+" and end date is "+toDate);
		String fDate=null;
		String tDate=null;
		if(session.getAttribute("userObj")==null)
		{
			return "redirect:/logout";
		}
		else
		{
			
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMdd");
			
			try {
				fDate=sdf1.format(sdf.parse(fromDate));
				tDate=sdf1.format(sdf.parse(toDate));
				list = SummaryRequestDTO.cust_getRevenueMISData(fDate, tDate);
				
			} catch (ParseException e) {
				logger.info(e);
				e.printStackTrace();
			}
			
            session.setAttribute("cust_revenueMISData", list);
			return "mis/promotion";
		}
	}
	

}
