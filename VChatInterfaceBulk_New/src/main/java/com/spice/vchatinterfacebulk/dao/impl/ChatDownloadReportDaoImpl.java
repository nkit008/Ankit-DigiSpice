package com.spice.vchatinterfacebulk.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spice.vchatinterfacebulk.beans.ChatOutDialLog;
import com.spice.vchatinterfacebulk.beans.LoginSessionDetails;
import com.spice.vchatinterfacebulk.dao.IChatDownloadReportDao;

@Repository
public class ChatDownloadReportDaoImpl implements IChatDownloadReportDao{
private static final Logger LOGGER = LoggerFactory.getLogger(ChatDownloadReportDaoImpl.class);	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	HttpSession httpSession;
	
	/*@Autowired
	DataBaseHubLink dbaseHubLink; */

	@Override
	public InputStream getReport(String hub) {		
		InputStream inputStream=null;
		HSSFWorkbook myWorkBook = new HSSFWorkbook();
		HSSFSheet mySheet = myWorkBook.createSheet();
		try {
			Row headerRow = mySheet.createRow(0);
			headerRow.setHeightInPoints(20);
			
			String stt=generateReport(mySheet, hub);
			LOGGER.info("generate Report Status is [{}] ",stt);
			try {
				ByteArrayOutputStream boas = new ByteArrayOutputStream();
				myWorkBook.write(boas);
				inputStream=(new ByteArrayInputStream(boas.toByteArray()));
				
				return inputStream;
			} catch (IOException e) {
				LOGGER.error("getting error while converting the file into stream [{}]",e);
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("getting error while fetching the downloading data [{}]",e);
			return null;
		}
	}	
	public String generateReport(HSSFSheet mySheet, String hub){	
		/*List<ChatHourlyLoginLogoutReport> llReport =new ArrayList<ChatHourlyLoginLogoutReport>();*/
		String sqlQuery=null,dbLink=null;
		try{
			
			String colname[] = { "Circle", "Agent_Location",
					"Report_DateTime","Detail_Hour", "LoginLogout_Time", "Chat_id",
					"LoginLogout_Status", "ANI", "Vendor", "Location",
					"LoginLogout_Time(In Minutes)", "Status", "Category","priority",
					 "Total_Calls", "Succ_Calls",
					"Fail_calls", "Pulses", "Mou", "Other",
					"A_party_Disconnect", "No_Answer", "Switch_Off"};
			int rowNum = 1;
			HSSFRow myRow = null;
			
			Row header = mySheet.createRow(0);
			for (int i = 0; i < colname.length; i++) {
				Cell monthCell = header.createCell(i);
				monthCell.setCellValue(colname[i]);
			}
			LoginSessionDetails loginSessionDetails = (LoginSessionDetails)httpSession.getAttribute("userObj");
			
			if(loginSessionDetails.getRole().equalsIgnoreCase("limit")){
				if(hub.equalsIgnoreCase("all")){
					sqlQuery = "select  circle,agent_location,convert(varchar,date_time,106) as 'date_time',cast((datepart(hh,date_time)+1) as varchar(50)) as curHour,Login_Logout_Date,chat_id,login_status,ani,vendor,location,isnull(mints,0) as mint,call_status,category,priority,total_calls,Succ_calls,fail_calls,pulse,mou,Network_issue,A_Party_Dis,No_Answer,Switch_Off from UpEast_DB.hutch_bgm.dbo.tbl_loginLogout_hourly where vendor='"+loginSessionDetails.getPartnerName()+"' union all select  circle,agent_location,convert(varchar,date_time,106) as 'date_time',cast((datepart(hh,date_time)+1) as varchar(50)) as curHour,Login_Logout_Date,chat_id,login_status,ani,vendor,location,isnull(mints,0) as mint,call_status,category,priority,total_calls,Succ_calls,fail_calls,pulse,mou,Network_issue,A_Party_Dis,No_Answer,Switch_Off from north_DB.hutch_bgm.dbo.tbl_loginLogout_hourly where vendor='"+ loginSessionDetails.getPartnerName()+ "'	union all select  circle,agent_location,convert(varchar,date_time,106) as 'date_time',cast((datepart(hh,date_time)+1) as varchar(50)) as curHour,Login_Logout_Date,chat_id,login_status,ani,vendor,location,isnull(mints,0) as mint,call_status,category,priority,total_calls,Succ_calls,fail_calls,pulse,mou,Network_issue,A_Party_Dis,No_Answer,Switch_Off from south_DB.hutch.dbo.tbl_loginLogout_hourly where vendor='"+ loginSessionDetails.getPartnerName()+ "' union all select circle,agent_location,convert(varchar,date_time,106) as 'date_time',cast((datepart(hh,date_time)+1) as varchar(50)) as curHour,Login_Logout_Date,chat_id,login_status,ani,vendor,location,isnull(mints,0) as mint,call_status,category,priority,total_calls,Succ_calls,fail_calls,pulse,mou,Network_issue,A_Party_Dis,No_Answer,Switch_Off from east_DB.bgm.dbo.tbl_loginLogout_hourly where vendor='"+loginSessionDetails.getPartnerName()+"' union all select  circle,agent_location,convert(varchar,date_time,106) as 'date_time',cast((datepart(hh,date_time)+1) as varchar(50)) as curHour,Login_Logout_Date,chat_id,login_status,ani,vendor,location,isnull(mints,0) as mint,call_status,category,priority,total_calls,Succ_calls,fail_calls,pulse,mou,Network_issue,A_Party_Dis,No_Answer,Switch_Off from westdb1.hutch_bgm.dbo.tbl_loginLogout_hourly where vendor='"+loginSessionDetails.getPartnerName()+"'";
				}else{
					dbLink=getHubDbLink(hub);
					sqlQuery = "select  circle,agent_location,convert(varchar,date_time,106) as 'date_time',cast((datepart(hh,date_time)+1) as varchar(50)) as curHour,Login_Logout_Date,chat_id,login_status,ani,vendor,location,isnull(mints,0) as mint,call_status,category,priority,total_calls,Succ_calls,fail_calls,pulse,mou,Network_issue,A_Party_Dis,No_Answer,Switch_Off from "+dbLink+ "dbo.tbl_loginLogout_hourly where vendor='"+ loginSessionDetails.getPartnerName() + "'";
				}
			}else{
				if(hub.equalsIgnoreCase("all")){
					sqlQuery = "select  circle,agent_location,convert(varchar,date_time,106) as 'date_time',cast((datepart(hh,date_time)+1) as varchar(50)) as curHour,Login_Logout_Date,chat_id,login_status,ani,vendor,location,isnull(mints,0) as mint,call_status,category,priority,total_calls,Succ_calls,fail_calls,pulse,mou,Network_issue,A_Party_Dis,No_Answer,Switch_Off from UpEast_DB.hutch_bgm.dbo.tbl_loginLogout_hourly union all select  circle,agent_location,date_time,cast((datepart(hh,date_time)+1) as varchar(50)) as curHour,Login_Logout_Date,chat_id,login_status,ani,vendor,location,isnull(mints,0) as mint,call_status,category,priority,total_calls,Succ_calls,fail_calls,pulse,mou,Network_issue,A_Party_Dis,No_Answer,Switch_Off from north_DB.hutch_bgm.dbo.tbl_loginLogout_hourly	union all select  isnull(circle,0) as circle,isnull(agent_location,0) as agent_location,date_time,cast((datepart(hh,date_time)+1) as varchar(50)) as curHour,Login_Logout_Date,isnull(chat_id,0) as chat_id,isnull(login_status,0) as login_status,isnull(ani,0) as ani,isnull(vendor,0) as vendor,isnull(location,0) as location,isnull(mints,0) as mint,isnull(call_status,0) as call_status,isnull(category,0) as category,isnull(priority,0) as priority,isnull(total_calls,0) as total_calls,isnull(Succ_calls,0) as Succ_calls,isnull(fail_calls,0) as fail_calls,isnull(pulse,0) as pulse,isnull(mou,0) as mou,isnull(Network_issue,0) as Network_issue,isnull(A_Party_Dis,0) as A_Party_Dis,isnull(No_Answer,0) as No_Answer,isnull(Switch_Off,0) as Switch_Off from south_DB.hutch.dbo.tbl_loginLogout_hourly	union all select circle,agent_location,date_time,cast((datepart(hh,date_time)+1) as varchar(50)) as curHour,Login_Logout_Date,chat_id,login_status,ani,vendor,location,isnull(mints,0) as mint,call_status,category,priority,total_calls,Succ_calls,fail_calls,pulse,mou,Network_issue,A_Party_Dis,No_Answer,Switch_Off from east_DB.bgm.dbo.tbl_loginLogout_hourly union all select  circle,agent_location,date_time,cast((datepart(hh,date_time)+1) as varchar(50)) as curHour,Login_Logout_Date,chat_id,login_status,ani,vendor,location,isnull(mints,0) as mint,call_status,category,priority,total_calls,Succ_calls,fail_calls,pulse,mou,Network_issue,A_Party_Dis,No_Answer,Switch_Off from westdb1.hutch_bgm.dbo.tbl_loginLogout_hourly";
				}else{
					dbLink=getHubDbLink(hub);
					sqlQuery = "select  circle,agent_location,convert(varchar,date_time,106) as 'date_time',cast((datepart(hh,date_time)+1) as varchar(50)) as curHour,Login_Logout_Date,chat_id,login_status,ani,vendor,location,isnull(mints,0) as mint,call_status,category,priority,total_calls,Succ_calls,fail_calls,pulse,mou,Network_issue,A_Party_Dis,No_Answer,Switch_Off from " + dbLink+ "dbo.tbl_loginLogout_hourly";
				}
			}
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Timestamp llDate=null;
			
			LOGGER.info("Query is [{}]",sqlQuery);
			
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlQuery);
			
			for (Map<String, Object> map : list) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(String.valueOf(map.get("circle")));
				myRow.createCell(1).setCellValue(String.valueOf(map.get("agent_location")));
				myRow.createCell(2).setCellValue(String.valueOf(map.get("date_time")));
				myRow.createCell(3).setCellValue(String.valueOf(map.get("curHour")));
				
				llDate= (Timestamp) map.get("Login_Logout_Date");
				
				myRow.createCell(4).setCellValue(String.valueOf(llDate));
				myRow.createCell(5).setCellValue(String.valueOf(map.get("chat_id")));
				myRow.createCell(6).setCellValue(String.valueOf(map.get("login_status")));
				myRow.createCell(7).setCellValue(String.valueOf(map.get("ani")));
				myRow.createCell(8).setCellValue(String.valueOf(map.get("vendor")));
				myRow.createCell(9).setCellValue(String.valueOf(map.get("location")));
				myRow.createCell(10).setCellValue(String.valueOf(map.get("mint")));
				myRow.createCell(11).setCellValue(String.valueOf(map.get("call_status")));
				myRow.createCell(12).setCellValue(String.valueOf(map.get("category")));
				if(loginSessionDetails.getRole().equalsIgnoreCase("limit")){
					if(map.get("priority").equals("11")){
						myRow.createCell(13).setCellValue("1");
					}else{
						myRow.createCell(13).setCellValue(String.valueOf(map.get("priority")));
					}
				}else{
					myRow.createCell(13).setCellValue(String.valueOf(map.get("priority")));
				}
				
				/*myRow.createCell(13).setCellValue(rs.getString("priority"));*/
				myRow.createCell(14).setCellValue(String.valueOf(map.get("total_calls")));
				myRow.createCell(15).setCellValue(String.valueOf(map.get("Succ_calls")));
				myRow.createCell(16).setCellValue(String.valueOf(map.get("fail_calls")));
				myRow.createCell(17).setCellValue(String.valueOf(map.get("pulse")));
				myRow.createCell(18).setCellValue(String.valueOf(map.get("mou")));
				myRow.createCell(19).setCellValue(String.valueOf(map.get("Network_issue")));
				myRow.createCell(20).setCellValue(String.valueOf(map.get("A_Party_Dis")));
				myRow.createCell(21).setCellValue(String.valueOf(map.get("No_Answer")));
				myRow.createCell(22).setCellValue(String.valueOf(map.get("Switch_Off")));
			}
			return "success";
		}catch(Exception e){
			LOGGER.error("Error while fetch the data for downloaded file [{}]",e);
			return null;
		}
	}
	
	@Override
	public InputStream getPartnerReport(String hub) {
		InputStream inputStream=null;
		HSSFWorkbook myWorkBook = new HSSFWorkbook();
		HSSFSheet mySheet = myWorkBook.createSheet();
		try {
			Row headerRow = mySheet.createRow(0);
			headerRow.setHeightInPoints(20);
			
			String stt=generatePartnerReport(mySheet, hub);
			LOGGER.info("generate Report Status is [{}] ",stt);
			try {
				ByteArrayOutputStream boas = new ByteArrayOutputStream();
				myWorkBook.write(boas);
				inputStream=(new ByteArrayInputStream(boas.toByteArray()));
				
				return inputStream;
			} catch (IOException e) {
				LOGGER.error("getting error while converting the file into stream [{}]",e);
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("getting error while fetching the downloading data [{}]",e);
			return null;
		}
	}
	
	public String generatePartnerReport(HSSFSheet mySheet, String hub){	
		/*List<ChatHourlyLoginLogoutReport> llReport =new ArrayList<ChatHourlyLoginLogoutReport>();*/
		String sqlQuery=null,dbLink=null;
		try{
			
			String colname[] = { "Date", "Operator", "Updated Partner Name", "LOCATION", "BNI", "MIS_chatID", "CIRCLE_ID", "Zone", "Type", "Total Call", "Total Failed Call", "NOT ANSWERED", "SWITCH OFF", "USER BUSY", "Ans_Call", "Duration", "Pulse", "Mous", "HRS", "ATT", "Fail call %", "Call Less than 1 Min", "Mous Less than 1 Min", "Login Hour"};
			int rowNum = 1;
			HSSFRow myRow = null;
			
			Row header = mySheet.createRow(0);
			for (int i = 0; i < colname.length; i++) {
				Cell monthCell = header.createCell(i);
				monthCell.setCellValue(colname[i]);
			}
			LoginSessionDetails loginSessionDetails = (LoginSessionDetails)httpSession.getAttribute("userObj");
			
			if(loginSessionDetails.getRole().equalsIgnoreCase("limit")){
				if(hub.equalsIgnoreCase("all")){
					sqlQuery = "select CONVERT(VARCHAR, date_time, 112) as _date, max(OPERATOR) as _operator, max(PARTNER) as _partner, max(LOCATION) as _location, BNI as _bni, max(CHATID) as _chatid, max(CIRCLE) as _circle, max(ZONE) as _zone, max(TYPE) as _type, sum(TOTAL_CALL) as _total_call, sum(FAILED_CALL) as _failed_call, sum(NOANSWERED) as _noanswered, sum(SWITCHOFF) as _switchoff, sum(USERBUSY) as _userbusy, sum(ANSWERD) as _answerd, sum(DURATION) as _duration, sum(PULSE) as _pulse, sum(MOU) as _mou, sum(HRS) as _hrs, CASE WHEN sum(answerd) = 0 THEN 0 ELSE isnull(sum(mou)/sum(answerd),0) END AS _att, CASE WHEN sum(total_call) = 0 THEN 0 ELSE isnull((cast(sum(failed_call) as float)/cast(sum(total_call) as float))*100,0) END AS _fail, sum(CALL_LESS_THEN_1_MINT) as _call_mint, sum(MOU_LESS_THEN_1_MINT) as _mou_mint, max(login_hour) as _login_hour from east_db.bgm.dbo.tbl_vchat_agent_mis where PARTNER='"+loginSessionDetails.getPartnerName()+"' and  convert(varchar,date_time,112) between convert(varchar,getdate()-7,112) and convert(varchar,getdate(),112) and SHIFT in('D','N') group by BNI, CONVERT(VARCHAR, date_time, 112) union all select CONVERT(VARCHAR, date_time, 112) as _date, max(OPERATOR) as _operator, max(PARTNER) as _partner, max(LOCATION) as _location, BNI as _bni, max(CHATID) as _chatid, max(CIRCLE) as _circle, max(ZONE) as _zone, max(TYPE) as _type, sum(TOTAL_CALL) as _total_call, sum(FAILED_CALL) as _failed_call, sum(NOANSWERED) as _noanswered, sum(SWITCHOFF) as _switchoff, sum(USERBUSY) as _userbusy, sum(ANSWERD) as _answerd, sum(DURATION) as _duration, sum(PULSE) as _pulse, sum(MOU) as _mou, sum(HRS) as _hrs, CASE WHEN sum(answerd) = 0 THEN 0 ELSE isnull(sum(mou)/sum(answerd),0) END AS _att, CASE WHEN sum(total_call) = 0 THEN 0 ELSE isnull((cast(sum(failed_call) as float)/cast(sum(total_call) as float))*100,0) END AS _fail, sum(CALL_LESS_THEN_1_MINT) as _call_mint, sum(MOU_LESS_THEN_1_MINT) as _mou_mint, max(login_hour) as _login_hour from north_db.hutch_bgm.dbo.tbl_vchat_agent_mis where PARTNER='"+loginSessionDetails.getPartnerName()+"' and convert(varchar,date_time,112) between convert(varchar,getdate()-7,112) and convert(varchar,getdate(),112) and SHIFT in('D','N') group by BNI, CONVERT(VARCHAR, date_time, 112) union all select CONVERT(VARCHAR, date_time, 112) as _date, max(OPERATOR) as _operator, max(PARTNER) as _partner, max(LOCATION) as _location, BNI as _bni, max(CHATID) as _chatid, max(CIRCLE) as _circle, max(ZONE) as _zone, max(TYPE) as _type, sum(TOTAL_CALL) as _total_call, sum(FAILED_CALL) as _failed_call, sum(NOANSWERED) as _noanswered, sum(SWITCHOFF) as _switchoff, sum(USERBUSY) as _userbusy, sum(ANSWERD) as _answerd, sum(DURATION) as _duration, sum(PULSE) as _pulse, sum(MOU) as _mou, sum(HRS) as _hrs, CASE WHEN sum(answerd) = 0 THEN 0 ELSE isnull(sum(mou)/sum(answerd),0) END AS _att, CASE WHEN sum(total_call) = 0 THEN 0 ELSE isnull((cast(sum(failed_call) as float)/cast(sum(total_call) as float))*100,0) END AS _fail, sum(CALL_LESS_THEN_1_MINT) as _call_mint, sum(MOU_LESS_THEN_1_MINT) as _mou_mint, max(login_hour) as _login_hour from south_db.hutch.dbo.tbl_vchat_agent_mis where PARTNER='"+loginSessionDetails.getPartnerName()+"' and convert(varchar,date_time,112) between convert(varchar,getdate()-7,112) and convert(varchar,getdate(),112) and SHIFT in('D','N') group by BNI, CONVERT(VARCHAR, date_time, 112)  union all select CONVERT(VARCHAR, date_time, 112) as _date, max(OPERATOR) as _operator, max(PARTNER) as _partner, max(LOCATION) as _location, BNI as _bni, max(CHATID) as _chatid, max(CIRCLE) as _circle, max(ZONE) as _zone, max(TYPE) as _type, sum(TOTAL_CALL) as _total_call, sum(FAILED_CALL) as _failed_call, sum(NOANSWERED) as _noanswered, sum(SWITCHOFF) as _switchoff, sum(USERBUSY) as _userbusy, sum(ANSWERD) as _answerd, sum(DURATION) as _duration, sum(PULSE) as _pulse, sum(MOU) as _mou, sum(HRS) as _hrs, CASE WHEN sum(answerd) = 0 THEN 0 ELSE isnull(sum(mou)/sum(answerd),0) END AS _att, CASE WHEN sum(total_call) = 0 THEN 0 ELSE isnull((cast(sum(failed_call) as float)/cast(sum(total_call) as float))*100,0) END AS _fail, sum(CALL_LESS_THEN_1_MINT) as _call_mint, sum(MOU_LESS_THEN_1_MINT) as _mou_mint, max(login_hour) as _login_hour from upeast_db.hutch_bgm.dbo.tbl_vchat_agent_mis where PARTNER='"+loginSessionDetails.getPartnerName()+"' and convert(varchar,date_time,112) between convert(varchar,getdate()-7,112) and convert(varchar,getdate(),112) and SHIFT in('D','N') group by BNI, CONVERT(VARCHAR, date_time, 112)  union all select CONVERT(VARCHAR, date_time, 112) as _date, max(OPERATOR) as _operator, max(PARTNER) as _partner, max(LOCATION) as _location, BNI as _bni, max(CHATID) as _chatid, max(CIRCLE) as _circle, max(ZONE) as _zone, max(TYPE) as _type, sum(TOTAL_CALL) as _total_call, sum(FAILED_CALL) as _failed_call, sum(NOANSWERED) as _noanswered, sum(SWITCHOFF) as _switchoff, sum(USERBUSY) as _userbusy, sum(ANSWERD) as _answerd, sum(DURATION) as _duration, sum(PULSE) as _pulse, sum(MOU) as _mou, sum(HRS) as _hrs, CASE WHEN sum(answerd) = 0 THEN 0 ELSE isnull(sum(mou)/sum(answerd),0) END AS _att, CASE WHEN sum(total_call) = 0 THEN 0 ELSE isnull((cast(sum(failed_call) as float)/cast(sum(total_call) as float))*100,0) END AS _fail, sum(CALL_LESS_THEN_1_MINT) as _call_mint, sum(MOU_LESS_THEN_1_MINT) as _mou_mint, max(login_hour) as _login_hour from westdb1.hutch_bgm.dbo.tbl_vchat_agent_mis where PARTNER='"+loginSessionDetails.getPartnerName()+"' and convert(varchar,date_time,112) between convert(varchar,getdate()-7,112) and convert(varchar,getdate(),112) and SHIFT in('D','N') group by BNI, CONVERT(VARCHAR, date_time, 112)";
				}
			}else{
				if(hub.equalsIgnoreCase("all")){
					sqlQuery = "select CONVERT(VARCHAR, date_time, 112) as _date, max(OPERATOR) as _operator, max(PARTNER) as _partner, max(LOCATION) as _location, BNI as _bni, max(CHATID) as _chatid, max(CIRCLE) as _circle, max(ZONE) as _zone, max(TYPE) as _type, sum(TOTAL_CALL) as _total_call, sum(FAILED_CALL) as _failed_call, sum(NOANSWERED) as _noanswered, sum(SWITCHOFF) as _switchoff, sum(USERBUSY) as _userbusy, sum(ANSWERD) as _answerd, sum(DURATION) as _duration, sum(PULSE) as _pulse, sum(MOU) as _mou, sum(HRS) as _hrs, CASE WHEN sum(answerd) = 0 THEN 0 ELSE isnull(sum(mou)/sum(answerd),0) END AS _att, CASE WHEN sum(total_call) = 0 THEN 0 ELSE isnull((cast(sum(failed_call) as float)/cast(sum(total_call) as float))*100,0) END AS _fail, sum(CALL_LESS_THEN_1_MINT) as _call_mint, sum(MOU_LESS_THEN_1_MINT) as _mou_mint, max(login_hour) as _login_hour from east_db.bgm.dbo.tbl_vchat_agent_mis where convert(varchar,date_time,112) between convert(varchar,getdate()-7,112) and convert(varchar,getdate(),112) and SHIFT in('D','N') group by BNI, CONVERT(VARCHAR, date_time, 112) union all select CONVERT(VARCHAR, date_time, 112) as _date, max(OPERATOR) as _operator, max(PARTNER) as _partner, max(LOCATION) as _location, BNI as _bni, max(CHATID) as _chatid, max(CIRCLE) as _circle, max(ZONE) as _zone, max(TYPE) as _type, sum(TOTAL_CALL) as _total_call, sum(FAILED_CALL) as _failed_call, sum(NOANSWERED) as _noanswered, sum(SWITCHOFF) as _switchoff, sum(USERBUSY) as _userbusy, sum(ANSWERD) as _answerd, sum(DURATION) as _duration, sum(PULSE) as _pulse, sum(MOU) as _mou, sum(HRS) as _hrs, CASE WHEN sum(answerd) = 0 THEN 0 ELSE isnull(sum(mou)/sum(answerd),0) END AS _att, CASE WHEN sum(total_call) = 0 THEN 0 ELSE isnull((cast(sum(failed_call) as float)/cast(sum(total_call) as float))*100,0) END AS _fail, sum(CALL_LESS_THEN_1_MINT) as _call_mint, sum(MOU_LESS_THEN_1_MINT) as _mou_mint, max(login_hour) as _login_hour from north_db.hutch_bgm.dbo.tbl_vchat_agent_mis where convert(varchar,date_time,112) between convert(varchar,getdate()-7,112) and convert(varchar,getdate(),112) and SHIFT in('D','N') group by BNI, CONVERT(VARCHAR, date_time, 112) union all select CONVERT(VARCHAR, date_time, 112) as _date, max(OPERATOR) as _operator, max(PARTNER) as _partner, max(LOCATION) as _location, BNI as _bni, max(CHATID) as _chatid, max(CIRCLE) as _circle, max(ZONE) as _zone, max(TYPE) as _type, sum(TOTAL_CALL) as _total_call, sum(FAILED_CALL) as _failed_call, sum(NOANSWERED) as _noanswered, sum(SWITCHOFF) as _switchoff, sum(USERBUSY) as _userbusy, sum(ANSWERD) as _answerd, sum(DURATION) as _duration, sum(PULSE) as _pulse, sum(MOU) as _mou, sum(HRS) as _hrs, CASE WHEN sum(answerd) = 0 THEN 0 ELSE isnull(sum(mou)/sum(answerd),0) END AS _att, CASE WHEN sum(total_call) = 0 THEN 0 ELSE isnull((cast(sum(failed_call) as float)/cast(sum(total_call) as float))*100,0) END AS _fail, sum(CALL_LESS_THEN_1_MINT) as _call_mint, sum(MOU_LESS_THEN_1_MINT) as _mou_mint, max(login_hour) as _login_hour from south_db.hutch.dbo.tbl_vchat_agent_mis where convert(varchar,date_time,112) between convert(varchar,getdate()-7,112) and convert(varchar,getdate(),112) and SHIFT in('D','N') group by BNI, CONVERT(VARCHAR, date_time, 112)  union all select CONVERT(VARCHAR, date_time, 112) as _date, max(OPERATOR) as _operator, max(PARTNER) as _partner, max(LOCATION) as _location, BNI as _bni, max(CHATID) as _chatid, max(CIRCLE) as _circle, max(ZONE) as _zone, max(TYPE) as _type, sum(TOTAL_CALL) as _total_call, sum(FAILED_CALL) as _failed_call, sum(NOANSWERED) as _noanswered, sum(SWITCHOFF) as _switchoff, sum(USERBUSY) as _userbusy, sum(ANSWERD) as _answerd, sum(DURATION) as _duration, sum(PULSE) as _pulse, sum(MOU) as _mou, sum(HRS) as _hrs, CASE WHEN sum(answerd) = 0 THEN 0 ELSE isnull(sum(mou)/sum(answerd),0) END AS _att, CASE WHEN sum(total_call) = 0 THEN 0 ELSE isnull((cast(sum(failed_call) as float)/cast(sum(total_call) as float))*100,0) END AS _fail, sum(CALL_LESS_THEN_1_MINT) as _call_mint, sum(MOU_LESS_THEN_1_MINT) as _mou_mint, max(login_hour) as _login_hour from upeast_db.hutch_bgm.dbo.tbl_vchat_agent_mis where convert(varchar,date_time,112) between convert(varchar,getdate()-7,112) and convert(varchar,getdate(),112) and SHIFT in('D','N') group by BNI, CONVERT(VARCHAR, date_time, 112)  union all select CONVERT(VARCHAR, date_time, 112) as _date, max(OPERATOR) as _operator, max(PARTNER) as _partner, max(LOCATION) as _location, BNI as _bni, max(CHATID) as _chatid, max(CIRCLE) as _circle, max(ZONE) as _zone, max(TYPE) as _type, sum(TOTAL_CALL) as _total_call, sum(FAILED_CALL) as _failed_call, sum(NOANSWERED) as _noanswered, sum(SWITCHOFF) as _switchoff, sum(USERBUSY) as _userbusy, sum(ANSWERD) as _answerd, sum(DURATION) as _duration, sum(PULSE) as _pulse, sum(MOU) as _mou, sum(HRS) as _hrs, CASE WHEN sum(answerd) = 0 THEN 0 ELSE isnull(sum(mou)/sum(answerd),0) END AS _att, CASE WHEN sum(total_call) = 0 THEN 0 ELSE isnull((cast(sum(failed_call) as float)/cast(sum(total_call) as float))*100,0) END AS _fail, sum(CALL_LESS_THEN_1_MINT) as _call_mint, sum(MOU_LESS_THEN_1_MINT) as _mou_mint, max(login_hour) as _login_hour from westdb1.hutch_bgm.dbo.tbl_vchat_agent_mis where convert(varchar,date_time,112) between convert(varchar,getdate()-7,112) and convert(varchar,getdate(),112) and SHIFT in('D','N') group by BNI, CONVERT(VARCHAR, date_time, 112)";
				}
			}
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Timestamp llDate=null;
			
			LOGGER.info("Query is [{}]",sqlQuery);
			
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlQuery);
			
			for (Map<String, Object> map : list) {
				myRow = mySheet.createRow(rowNum++);
				
				
				myRow.createCell(0).setCellValue(Integer.valueOf((String) map.get("_date")));
				myRow.createCell(1).setCellValue(String.valueOf(map.get("_operator")));
				myRow.createCell(2).setCellValue(String.valueOf(map.get("_partner")));
				myRow.createCell(3).setCellValue(String.valueOf(map.get("_location")));
				
				//llDate= (Timestamp) map.get("Login_Logout_Date");
				
				myRow.createCell(4).setCellValue(String.valueOf(map.get("_bni")));
				myRow.createCell(5).setCellValue(String.valueOf(map.get("_chatid")));
				myRow.createCell(6).setCellValue(String.valueOf(map.get("_circle")));
				myRow.createCell(7).setCellValue(String.valueOf(map.get("_zone")));
				myRow.createCell(8).setCellValue(String.valueOf(map.get("_type")));
				myRow.createCell(9).setCellValue(String.valueOf( map.get("_total_call")));
				myRow.createCell(10).setCellValue(String.valueOf( map.get("_failed_call")));
				myRow.createCell(11).setCellValue(String.valueOf(map.get("_noanswered")));
				myRow.createCell(12).setCellValue(String.valueOf(map.get("_switchoff")));
				myRow.createCell(13).setCellValue(String.valueOf(map.get("_userbusy")));
				
				myRow.createCell(14).setCellValue(String.valueOf(map.get("_answerd")));
				myRow.createCell(15).setCellValue(String.valueOf(map.get("_duration")));
				myRow.createCell(16).setCellValue(String.valueOf(map.get("_pulse")));
				myRow.createCell(17).setCellValue(String.valueOf(map.get("_mou")));
				myRow.createCell(18).setCellValue(String.valueOf(map.get("_hrs")));
				myRow.createCell(19).setCellValue(String.valueOf(map.get("_att")));
				myRow.createCell(20).setCellValue(String.valueOf(map.get("_fail")));
				myRow.createCell(21).setCellValue(String.valueOf(map.get("_call_mint")));
				myRow.createCell(22).setCellValue(String.valueOf( map.get("_mou_mint")));
				myRow.createCell(23).setCellValue(String.valueOf( map.get("_login_hour")));
				
			}
			return "success";
		}catch(Exception e){
			LOGGER.error("Error while fetch the data for downloaded file [{}]",e);
			return null;
		}
	}
	
	@Override
	public List<ChatOutDialLog> getOutdialLog(String hub, String dataType, String number) {
		try{
			String sql=null,dbLink=null,yaarriDbLink=null;
			//LoginSessionDetails loginSessionDetails = (LoginSessionDetails)httpSession.getAttribute("userObj");
			dbLink=getHubDbLink(hub);
			yaarriDbLink=getYaarriHubDbLink(hub);
			
			/*if(dataType.equalsIgnoreCase("byNumber"))
				sql="select date_time,ani,a_gender,a_chatid,b_ani,b_circle,b_chatid,category,duration,call_value,call_code,reason,dnis,disconnect,flow,status from "+dbLink+"dbo.TBL_VCHAT_OUTcall where datediff(d,date_time,getdate())=0 and (b_ani=ltrim(rtrim('"+number+"')) or ani=ltrim(rtrim('"+number+"')))";
			else if(dataType.equalsIgnoreCase("byChatId")) 			
				sql="select date_time,ani,a_gender,a_chatid,b_ani,b_circle,b_chatid,category,duration,call_value,call_code,reason,dnis,disconnect,flow,status from "+dbLink+"dbo.TBL_VCHAT_OUTcall where datediff(d,date_time,getdate())=0 and (b_chatid=ltrim(rtrim('"+number+"')) or a_chatid=ltrim(rtrim('"+number+"')))";
			*/
			
			
			if(dataType.equalsIgnoreCase("byNumber"))
				sql="select 'VCHAT' as ProductName,date_time,ani,a_gender,a_chatid,b_ani,b_circle,b_chatid,category,duration,call_value,call_code,reason,dnis,disconnect,flow,status from "+dbLink+"dbo.TBL_VCHAT_OUTcall where datediff(d,date_time,getdate())<=1 and (b_ani=ltrim(rtrim('"+number+"')) or ani=ltrim(rtrim('"+number+"'))) union select 'YAARRI' as ProductName,date_time,ani,a_gender,a_chatid,b_ani,b_circle,b_chatid,category,duration,call_value,call_code,reason,dnis,disconnect,flow,status from "+yaarriDbLink+"dbo.tbl_yaarri_outcall where datediff(d,date_time,getdate())<=1 and (b_ani=ltrim(rtrim('"+number+"')) or ani=ltrim(rtrim('"+number+"')))";
			else if(dataType.equalsIgnoreCase("byChatId")) 			
				sql="select 'VCHAT' as ProductName,date_time,ani,a_gender,a_chatid,b_ani,b_circle,b_chatid,category,duration,call_value,call_code,reason,dnis,disconnect,flow,status from "+dbLink+"dbo.TBL_VCHAT_OUTcall where datediff(d,date_time,getdate())<=1 and (b_chatid=ltrim(rtrim('"+number+"')) or a_chatid=ltrim(rtrim('"+number+"'))) union select 'YAARRI' as ProductName,date_time,ani,a_gender,a_chatid,b_ani,b_circle,b_chatid,category,duration,call_value,call_code,reason,dnis,disconnect,flow,status from "+yaarriDbLink+"dbo.tbl_yaarri_outcall where datediff(d,date_time,getdate())<=1 and (b_chatid=ltrim(rtrim('"+number+"')) or a_chatid=ltrim(rtrim('"+number+"')))";
			
			
			LOGGER.info("Query is [{}]",sql);
			List<ChatOutDialLog> loginLogoutReport = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ChatOutDialLog>(ChatOutDialLog.class));
			
			return loginLogoutReport;
			
		}catch(Exception e){
			LOGGER.error("Error while fetching the outdail data [{}]",e);
			return null;
		}
	}
	
	public LoginSessionDetails getSessionDetails(){
		try{
			LoginSessionDetails loginSessionDetails= new LoginSessionDetails();
			
			Enumeration<String> e = httpSession.getAttributeNames();
			while (e.hasMoreElements()){
				String s = e.nextElement();
				loginSessionDetails=(LoginSessionDetails) httpSession.getAttribute(s);
			}
			return loginSessionDetails;
		}catch(Exception e){
			LOGGER.error("Error while getting the value from http session [{}]",e);
			return null;
		}
	}
	public String getHubDbLink(String hubname){
		if (hubname.equalsIgnoreCase("West")) {
			return "westdb1.hutch_bgm.";
		} else if (hubname.equalsIgnoreCase("Upeast")) {
			return "upeast_db.hutch_bgm.";
		} else if (hubname.equalsIgnoreCase("North")) {
			return "north_db.hutch_bgm.";
		} else if (hubname.equalsIgnoreCase("East")) {
			return "east_db.bgm.";
		} else if (hubname.equalsIgnoreCase("South")) {
			return "south_db.hutch.";
		} else {
			return "no record";
		}
	}public String getYaarriHubDbLink(String hubname){
		if (hubname.equalsIgnoreCase("West")) {
			return "westdb1.yaarri.";
		} else if (hubname.equalsIgnoreCase("Upeast")) {
			return "upeast_db.yaarri.";
		} else if (hubname.equalsIgnoreCase("North")) {
			return "north_db.yaarri.";
		} else if (hubname.equalsIgnoreCase("East")) {
			return "east_db.yaarri.";
		} else if (hubname.equalsIgnoreCase("South")) {
			return "south_db.yaarri.";
		} else {
			return "no record";
		}
	}
	

	

}
