package com.spice.vchatinterfacebulk.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spice.vchatinterfacebulk.beans.ChatOutDialLog;
import com.spice.vchatinterfacebulk.dao.IChatDownloadReportDao;


@Controller
public class DownLoadReportController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DownLoadReportController.class);

	@Autowired
	HttpSession session;
	
	@Autowired
	IChatDownloadReportDao chatDownloadReportDao;
	
	@RequestMapping(value = "/outdiallogs", method = RequestMethod.GET)
	public ModelAndView getOutdialLogs() {
		ModelAndView model;
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		} else {
			model = new ModelAndView("chatdownloadreport");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/outdiallogs", method = RequestMethod.POST)
	public ModelAndView getOutdialLogsPost(@RequestParam(value="hub") String hub,@RequestParam(value="dataType") 
		String dataType, @RequestParam(value="number") String number){
		LOGGER.info("selected hub is ##  [{}] and data Type is [{}] and chat id is [{}]",hub,dataType,number);
		ModelAndView model;
		
		if (session.getAttribute("userObj") == null) {
			model = new ModelAndView("redirect:/logout");
		} else {
			model = new ModelAndView("chatdownloadreport");
		}
		
		List<ChatOutDialLog> outdialReport=null;	
		outdialReport= chatDownloadReportDao.getOutdialLog(hub,dataType,number);
		LOGGER.info("Outdial reports are [{}]",outdialReport);
		
		model.addObject("objResp", outdialReport);
		
		return model;
	}
	
	@RequestMapping(value = "/downloadreport", method = RequestMethod.GET)
	public void getDownloadReportPost(@RequestParam(value="hub") String hub, HttpServletResponse resp){
		LOGGER.info("reqType is ## [{}] and selected hub is ##  [{}] and data Type is [{}] and chat id is [{}]",hub);

		String reportFile = "Hourly_LoginLogout_Report_" + hub + ".xls";
		InputStream inputStream =null;
		try{
			inputStream =chatDownloadReportDao.getReport(hub);
			LOGGER.info("Chat Hourly Login Logout reports are [{}]");
			
			resp.setContentType("application/vnd.ms-excel");
			resp.setHeader("Content-Disposition", String.format("inline; filename=\"" + reportFile +"\""));
			org.apache.commons.io.IOUtils.copy(inputStream, resp.getOutputStream());
			resp.flushBuffer();
			LOGGER.info("Hourly_LoginLogout_Report Downloaded Successfully !!!!! ");
		 }catch (IOException ex) {
			LOGGER.error("Error writing file to output stream. Filename was '{}'", ex);
			throw new RuntimeException("IOError writing file to output stream");
		 }		
	}
	
	@RequestMapping(value = "/downloadpartnerreport", method = RequestMethod.GET)
	public void getDownloadPartnerReportPost(@RequestParam(value="hub") String hub, HttpServletResponse resp){
		LOGGER.info("reqType is ## [{}] and selected hub is ##  [{}] and data Type is [{}] and chat id is [{}]",hub);

		String reportFile = "Partner_Report_" + hub + "(Last_7_Days).xls";
		InputStream inputStream =null;
		try{
			inputStream =chatDownloadReportDao.getPartnerReport(hub);
			LOGGER.info("Partner reports are [{}]");
			
			resp.setContentType("application/vnd.ms-excel");
			resp.setHeader("Content-Disposition", String.format("inline; filename=\"" + reportFile +"\""));
			org.apache.commons.io.IOUtils.copy(inputStream, resp.getOutputStream());
			resp.flushBuffer();
			LOGGER.info("Partner_Report Downloaded Successfully !!!!! ");
		 }catch (IOException ex) {
			LOGGER.error("Error writing file to output stream. Filename was '{}'", ex);
			throw new RuntimeException("IOError writing file to output stream");
		 }		
	}
	
	/*public void reportDownload(String hub, HttpServletResponse resp){
		String reportFile = "Hourly_LoginLogout_Report_" + hub + ".xls";
		InputStream inputStream =null;
		try{
			inputStream =chatDownloadReportDao.getReport(hub);
			LOGGER.info("Chat Hourly Login Logout reports are [{}]");
			
			resp.setContentType("application/vnd.ms-excel");
			resp.setHeader("Content-Disposition", String.format("inline; filename=\"" + reportFile +"\""));
			org.apache.commons.io.IOUtils.copy(inputStream, resp.getOutputStream());
			resp.flushBuffer();
			LOGGER.info("Hourly_LoginLogout_Report Downloaded Successfully !!!!! ");
		 }catch (IOException ex) {
			LOGGER.error("Error writing file to output stream. Filename was '{}'", ex);
			throw new RuntimeException("IOError writing file to output stream");
		 }
		//return "success";
	}*/

}
