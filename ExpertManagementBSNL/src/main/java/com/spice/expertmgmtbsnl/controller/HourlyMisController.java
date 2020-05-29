package com.spice.expertmgmtbsnl.controller;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spice.expertmgmtbsnl.dao.CheckLoginStatusDao;
import com.spice.expertmgmtbsnl.daoImpl.HourlyMisDataExcel;
import com.spice.expertmgmtbsnl.model.HourlyReportModel;


@Controller
public class HourlyMisController {
	
	Logger logger=Logger.getLogger(HourlyMisController.class.getName());
	
	@Autowired
	CheckLoginStatusDao dao2;
	
	@Autowired
	HourlyMisDataExcel hourlyMisDataExcel;
	
	@RequestMapping(value="/downloadHourlyreportxls")
	public void downloadHourlyreportxls(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redir)
	{
		
			logger.info("----Downloading Hourly Basis MIS-----");
			ClassPathResource resource = null;
			
			Date date = new Date();
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, -1);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String todate  = sdf.format(date);
			String fromdate = sdf.format(c.getTime());
			
			ArrayList<HourlyReportModel> list = dao2.fetchHourlyReport(fromdate,todate);
			
			if(list!=null)
			{
				resource = new ClassPathResource("Hourly_MOD_MIS.xlsx");
				InputStream is = null;
				try {
					is = ((InputStreamSource)resource).getInputStream();
				} catch (Throwable e) {
					e.printStackTrace();
				}
				
				int startRowIndex = 1;
				int startColIndex = 0;
				hourlyMisDataExcel.genrateXLS(is, startRowIndex, startColIndex, response, list,fromdate,todate);
				logger.info("-----MIS downloaded Successfully-----");
			}
			else
			{
				logger.info("No Record found in Hourly table");
			}

	}
	
	
	
	@RequestMapping(value="/downloadParnterHourlyreportxls")
	public void downloadParnterHourlyreportxls(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redir)
	{
		
			logger.info("----Downloading Hourly Basis MIS-----");
			ClassPathResource resource = null;
			
			Date date = new Date();
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, -1);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String todate  = sdf.format(date);
			String fromdate = sdf.format(c.getTime());
			
			ArrayList<HourlyReportModel> list = dao2.fetchHourlyReportPartner(fromdate,todate);
			
			if(list!=null)
			{
				resource = new ClassPathResource("Hourly_MOD_MIS.xlsx");
				InputStream is = null;
				try {
					is = ((InputStreamSource)resource).getInputStream();
				} catch (Throwable e) {
					e.printStackTrace();
				}
				
				int startRowIndex = 1;
				int startColIndex = 0;
				hourlyMisDataExcel.genrateXLS(is, startRowIndex, startColIndex, response, list,fromdate,todate);
				logger.info("-----MIS downloaded Successfully-----");
			}
			else
			{
				logger.info("No Record found in Hourly table");
			}

	}	

}
