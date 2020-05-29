package com.spice.vchatinterfacebulk.dao.impl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spice.vchatinterfacebulk.beans.ChatLoginStatusQuery;
import com.spice.vchatinterfacebulk.beans.ChatLoginStatusResp;
import com.spice.vchatinterfacebulk.beans.GetDblink;
import com.spice.vchatinterfacebulk.beans.LoginSessionDetails;
import com.spice.vchatinterfacebulk.dao.IChatLoginStatusDao;

@Repository
public class ChatLoginStatusDaoImpl implements IChatLoginStatusDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(ChatLoginStatusDaoImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	HttpSession httpSession;

	@Override
	public List<ChatLoginStatusResp> getDetailsByChatid(String hub, String chatId) {
		String chatIdSqlQuery = null;
		try {
			LoginSessionDetails loginSessionDetails = (LoginSessionDetails)httpSession.getAttribute("userObj");

			String dbLink = getHubDbLink(hub);

			if (loginSessionDetails.getRole().equalsIgnoreCase("limit")) {
				chatIdSqlQuery = "select agent_circle,last_call_time,b_chatid,b_ani,b_circle,login_status,status,loginlogout_datetime,datediff(mi,loginlogout_datetime,getdate()) as mint,priority_flag,isnull((select top 1 proc_name from "
						+ dbLink
						+ "dbo.tbl_loginlogout_history with(nolock) where ani=a.b_ani order by date_time desc),'0') as proc_name ,isnull((select top 1 center from "
						+ dbLink + "dbo.VCHAT_AGENT_DETAIL where chat_id =a.b_chatid),'NA') as center_name from "
						+ dbLink + "bgm.vchat_professional_agents as a where b_chatid in (select chat_id from " + dbLink
						+ "dbo.VCHAT_AGENT_DETAIL where b_chatid='" + chatId + "' and center_id='"
						+ loginSessionDetails.getUserName().substring(3) + "')";
			} else {
				chatIdSqlQuery = "select agent_circle,last_call_time,b_chatid,b_ani,b_circle,login_status,status,loginlogout_datetime,datediff(mi,loginlogout_datetime,getdate()) as mint,priority_flag,isnull((select top 1 proc_name from "
						+ dbLink
						+ "dbo.tbl_loginlogout_history with(nolock) where ani=a.b_ani order by date_time desc),'0') as proc_name,isnull((select top 1 center from "
						+ dbLink + "dbo.VCHAT_AGENT_DETAIL where chat_id =a.b_chatid),'NA') as center_name from "
						+ dbLink + "bgm.vchat_professional_agents as a where b_chatid='" + chatId + "'";
			}

			LOGGER.info("Query is [{}]", chatIdSqlQuery);
			List<ChatLoginStatusQuery> chatLoginStatusQuery = jdbcTemplate.query(chatIdSqlQuery,
					new BeanPropertyRowMapper<ChatLoginStatusQuery>(ChatLoginStatusQuery.class));
			
			
			List<ChatLoginStatusResp> response = (List<ChatLoginStatusResp>) getValue(chatLoginStatusQuery, hub);

			if (response.isEmpty())
				return null;
			else
				return response;

		} catch (Exception e) {
			LOGGER.error("Error while fetching the records from ChatLoginStatusResp method is [{}]", e);
			return null;
		}
	}

	@Override
	public List<ChatLoginStatusResp> getDetailsByHub(String hub) {
		String hubSqlQuery = null;
		List<ChatLoginStatusResp> response =null;
		try {
			LoginSessionDetails loginSessionDetails = getSessionDetails();
			String dbLink = getHubDbLink(hub);

			if (loginSessionDetails.getRole().equalsIgnoreCase("limit")) {
				hubSqlQuery = "select  agent_circle,last_call_time,b_chatid,b_ani,b_circle,login_status,status,loginlogout_datetime,datediff(mi,loginlogout_datetime,getdate()) as mint,priority_flag,isnull((select top 1 proc_name from "
						+ dbLink
						+ " dbo.tbl_loginlogout_history with(nolock) where ani=a.b_ani order by date_time desc),'0') as proc_name,isnull((select top 1 center from "
						+ dbLink + "dbo.VCHAT_AGENT_DETAIL where chat_id =a.b_chatid),'NA') as center_name from "
						+ dbLink + "bgm.vchat_professional_agents as a where b_chatid in (select chat_id from " + dbLink
						+ "dbo.VCHAT_AGENT_DETAIL where center_id='" + loginSessionDetails.getUserName().substring(3)
						+ "')";
			} else {
				hubSqlQuery = "select  agent_circle,last_call_time,b_chatid,b_ani,b_circle,login_status,status,loginlogout_datetime,datediff(mi,loginlogout_datetime,getdate()) as mint,priority_flag,isnull((select top 1 proc_name from "
						+ dbLink
						+ "dbo.tbl_loginlogout_history with(nolock) where ani=a.b_ani order by date_time desc),'0') as proc_name,isnull((select top 1 center from "
						+ dbLink + "dbo.VCHAT_AGENT_DETAIL where chat_id =a.b_chatid),'NA') as center_name from "
						+ dbLink + "bgm.vchat_professional_agents as a";
			}

			LOGGER.info("Query is [{}]", hubSqlQuery);
			List<ChatLoginStatusQuery> chatLoginStatusQuery = jdbcTemplate.query(hubSqlQuery,
					new BeanPropertyRowMapper<ChatLoginStatusQuery>(ChatLoginStatusQuery.class));

			/*List<ChatLoginStatusResp> response = (List<ChatLoginStatusResp>) getValue(chatLoginStatusQuery, hub);*/
			response = (List<ChatLoginStatusResp>) getValue(chatLoginStatusQuery, hub);

			
		} catch (Exception e) {
			LOGGER.error("Error while fetching the records from ChatLoginStatusResp method is [{}]", e);
		}
		
		return response;
	}

	public List<ChatLoginStatusResp> getValue(List<ChatLoginStatusQuery> chatLoginStatusQuery, String hub) {
		List<ChatLoginStatusResp> respList = new ArrayList<ChatLoginStatusResp>();
		ChatLoginStatusResp resp = new ChatLoginStatusResp();

		try {
			if (!chatLoginStatusQuery.isEmpty()) {
				LoginSessionDetails loginSessionDetails = getSessionDetails();
				for (ChatLoginStatusQuery list : chatLoginStatusQuery) {
					resp = new ChatLoginStatusResp();

					resp.setAgentCircle(list.getAgentCircle());
					resp.setbAni(list.getbAni());
					resp.setbChatid(list.getbChatid());
					resp.setbCircle(list.getbCircle());
					resp.setCenterName(list.getCenterName());
					resp.setLastCallTime(list.getLastCallTime());
					resp.setLoginLogoutDatetime(list.getLoginlogoutDatetime());
					resp.setLoginStatus(list.getLoginStatus());
					resp.setMnt(list.getMint());

					if (loginSessionDetails.getRole().equalsIgnoreCase("limit")) {
						if (list.getPriorityFlag().equals("11"))
							resp.setPriorityFlag("1");
						else
							resp.setPriorityFlag(list.getPriorityFlag());
					} else
						resp.setPriorityFlag(list.getPriorityFlag());

					resp.setStatus(list.getStatus());
					resp.setUpdateStatus(checkUpdateStatus(list.getProcName()));

					resp.setHub(hub);

					respList.add(resp);
				}
				LOGGER.info("ChatLoginStatusResp is ########## [{}]", respList.toString());
			}

		} catch (Exception e) {
			LOGGER.error("Error while mapping the data [{}]", e);
		}
		return respList;
	}

	public LoginSessionDetails getSessionDetails() {
		try {
			LoginSessionDetails loginSessionDetails = new LoginSessionDetails();

			Enumeration<String> e = httpSession.getAttributeNames();
			while (e.hasMoreElements()) {
				String s = e.nextElement();
				loginSessionDetails = (LoginSessionDetails) httpSession.getAttribute(s);
			}
			return loginSessionDetails;
		} catch (Exception e) {
			LOGGER.error("Error while getting the value from http session [{}]", e);
			return null;
		}
	}

	public String checkUpdateStatus(String updateStatus) {
		try {
			if (updateStatus.contains("VCS_LOGIN_SYNC") || updateStatus.contains("VCS_VCHAT_LOGIN")
					|| updateStatus.contains("VCS_VCHAT_OUT")) {
				return "Agent";
			} else if (updateStatus.contains("VCS_VCHAT_ALERT")) {
				return "System";
			} else if (updateStatus.contains("M_")) {
				return "Manager";
			} else if (updateStatus.contains("MANUAL_CALL")) {
				return "MANUAL_CALL";
			} else if (updateStatus.contains("GUI")) {
				return updateStatus;
			} else {
				return "";
			}
		} catch (Exception ex) {
			LOGGER.error("Error while checking the update status [{}]", ex);
			return "";
		}
	}

	public String getHubDbLink(String hubname) {
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
	}

	@Override
	public int editUser(String userHub, String bAni, String loginStatus, String priorityFlag) {
		String oldstatus = "";
		int res = 0;
		String dbl = GetDblink.getDblink(userHub);

		String query = "select login_status from " + dbl + "bgm.vchat_professional_agents where b_ani='" + bAni + "'";

		LOGGER.info(query);

		try {
			jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);

			oldstatus = (String) jdbcTemplate.queryForObject(query, String.class);

			LoginSessionDetails loginSessionDetails = getSessionDetails();

			if (loginSessionDetails.getRole().equalsIgnoreCase("admin") || loginSessionDetails.getRole().equalsIgnoreCase("superadmin")) {
				if (oldstatus.equalsIgnoreCase("FLOGOUT"))
					query = "UPDATE " + dbl
							+ "bgm.VCHAT_PROFESSIONAL_AGENTS SET success_count='0',fail_count='0',out_line='0',login_status ='"
							+ loginStatus + "',status='FREE',loginlogout_datetime=getdate(),priority_flag='"
							+ priorityFlag + "' WHERE b_ani='" + bAni + "';";
				else if (oldstatus.equalsIgnoreCase("LOGIN"))
					query = "UPDATE " + dbl + "bgm.VCHAT_PROFESSIONAL_AGENTS SET login_status ='" + loginStatus
							+ "',loginlogout_datetime=getdate(),priority_flag='" + priorityFlag + "' WHERE b_ani='"
							+ bAni + "';";
				else
					query = "UPDATE " + dbl + "bgm.VCHAT_PROFESSIONAL_AGENTS SET login_status ='" + loginStatus
							+ "',status='FREE',loginlogout_datetime=getdate(),priority_flag='" + priorityFlag
							+ "' WHERE b_ani='" + bAni + "';";
			} else {
				if (oldstatus.equalsIgnoreCase("FLOGOUT"))
					query = "UPDATE " + dbl
							+ "bgm.VCHAT_PROFESSIONAL_AGENTS SET success_count='0',fail_count='0',out_line='0',login_status ='"
							+ loginStatus + "',status='FREE',loginlogout_datetime=getdate() WHERE b_ani='" + bAni
							+ "';";
				else if (oldstatus.equalsIgnoreCase("LOGIN"))
					query = "UPDATE " + dbl + "bgm.VCHAT_PROFESSIONAL_AGENTS SET login_status ='" + loginStatus
							+ "',loginlogout_datetime=getdate() WHERE b_ani='" + bAni + "';";
				else
					query = "UPDATE " + dbl + "bgm.VCHAT_PROFESSIONAL_AGENTS SET login_status ='" + loginStatus
							+ "',status='FREE',loginlogout_datetime=getdate() WHERE b_ani='" + bAni + "';";
			}
			//LOGGER.info("User Ip Address is [{}] and update query is [{}]",loginSessionDetails.getUserIp(),query);
			res = jdbcTemplate.update(query);
			LOGGER.info("User Ip Address is [{}] and update query is [{}] and response is [{}]",loginSessionDetails.getUserIp(),query,res);
			if (res > 0) {
				query = "insert into " + dbl + "dbo.tbl_loginlogout_history(ani,date_time,type,proc_name) values('"
						+ bAni + "',getdate(),'" + loginStatus + "','GUI_" + loginSessionDetails.getUserName() + "');";
				res = jdbcTemplate.update(query);
				LOGGER.info("User Ip Address is [{}] and insert query is [{}] and response is [{}]",loginSessionDetails.getUserIp(),query,res);
				if (res > 0)
					jdbcTemplate.getDataSource().getConnection().setAutoCommit(true);
			}

		} catch (Exception e) {
			LOGGER.error("Error while updating the records [{}]", e);
		}
		LOGGER.info("final response is [{}]", res);
		return res;
	}

}
