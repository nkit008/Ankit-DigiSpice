package com.spice.vchatinterfacebulk.dao.impl;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.spice.vchatinterfacebulk.beans.AgentManagerAgentProfileReq;
import com.spice.vchatinterfacebulk.beans.AgentManagerCreateUserDetailsDTO;
import com.spice.vchatinterfacebulk.beans.AgentManagerProfileUpdateReq;
import com.spice.vchatinterfacebulk.beans.AgentManagerUser;
import com.spice.vchatinterfacebulk.beans.CreateAgentProfile;
import com.spice.vchatinterfacebulk.beans.DeleteUserLog;
import com.spice.vchatinterfacebulk.beans.LoginDetails;
import com.spice.vchatinterfacebulk.beans.LoginSessionDetails;
import com.spice.vchatinterfacebulk.dao.IAgentManagerDao;

@Repository
@Transactional
public class AgentManagerDaoImpl implements IAgentManagerDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(AgentManagerDaoImpl.class);
	ResultSet rs = null;
	String outResp= null;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	HttpSession httpSession;
	
	Session sessionFact1=null;

	@Override
	public String create(AgentManagerUser agentManagerUser) {

		// set Hub to session in order to get into partner agent manager
		httpSession.setAttribute("session_hub", agentManagerUser.getHub());

		try {

			String AgentDoc = "F:" + File.separator + "vchatinterface_DoNotDelete" + File.separator
					+ "PartnerAgentRecords" + File.separator + "AgentDocImage";
			File agentDir = new File(AgentDoc);

			if (!agentDir.exists()) {
				if (agentDir.mkdir()) {
					LOGGER.info("[{}] Directory is created!", AgentDoc);
				} else {
					LOGGER.info("[{}] Failed to create directory!", AgentDoc);
				}
			}

			MultipartFile agentDocImage = agentManagerUser.getAgentDocImage();
			String dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			String agentDocfilePath = dateFormat + "_" + agentDocImage.getOriginalFilename().replace("'", "");
			File agentDocFileToCreate = new File(agentDir + File.separator + agentDocfilePath);

			File agentDocSrcFile = new File(agentDocImage.getOriginalFilename());
			agentDocImage.transferTo(agentDocSrcFile);
			FileUtils.copyFile(agentDocSrcFile, agentDocFileToCreate);
			/**********/
			String VenderCertificate = "F:" + File.separator + "vchatinterface_DoNotDelete" + File.separator
					+ "PartnerAgentRecords" + File.separator + "VenderCertificateImage";
			File venderCertDir = new File(VenderCertificate);

			if (!venderCertDir.exists()) {
				if (venderCertDir.mkdir()) {
					LOGGER.info("[{}] Directory is created!", VenderCertificate);
				} else {
					LOGGER.info("[{}] Failed to create directory!", VenderCertificate);
				}
			}
			MultipartFile venderCertImage = agentManagerUser.getVenderCertificateImage();
			String venderCertfilePath = dateFormat + "_" + venderCertImage.getOriginalFilename().replace("'", "");
			File venderCertfileToCreate = new File(venderCertDir + File.separator + venderCertfilePath);

			File venderCertSrcFile = new File(venderCertImage.getOriginalFilename());
			venderCertImage.transferTo(venderCertSrcFile);
			FileUtils.copyFile(venderCertSrcFile, venderCertfileToCreate);
			/**********/

			Session sessionFact = sessionFactory.getCurrentSession();
			CreateAgentProfile agentProfile = new CreateAgentProfile();

			LoginSessionDetails loginSessionDetails = (LoginSessionDetails) httpSession.getAttribute("userObj");

			if (loginSessionDetails.getRole().equalsIgnoreCase("admin"))
				agentProfile.setPartnerName("Admin");
			else if (loginSessionDetails.getRole().equalsIgnoreCase("superadmin"))
				agentProfile.setPartnerName("SuperAdmin");
			else
				agentProfile.setPartnerName(loginSessionDetails.getPartnerName());

			LOGGER.info("In DAO impl class agentManagerUser is #######       " + agentManagerUser.toString());

			agentProfile.setHub(agentManagerUser.getHub());
			agentProfile.setNewAgentAge(agentManagerUser.getAgentAge());
			agentProfile.setNewAgentLang(agentManagerUser.getAgentLang());
			agentProfile.setNewAgentName(agentManagerUser.getAgentName().replace("'", ""));
			agentProfile.setNewAgentType(agentManagerUser.getType());
			agentProfile.setAgentAni(agentManagerUser.getAni().replace("'", ""));
			agentProfile.setNewCircle(agentManagerUser.getCircle());
			agentProfile.setCertificatePath(venderCertfilePath);
			agentProfile.setUserDocPath(agentDocfilePath);
			agentProfile.setNewLocation(agentManagerUser.getAgentLocation());
			agentProfile.setNewState(agentManagerUser.getCircle());
			agentProfile.setNewUserDoc(agentManagerUser.getAgentDoc().replace("'", ""));
			agentProfile.setNewUserDocNo(agentManagerUser.getAgentDocNo().replace("'", ""));
			agentProfile.setAgentStatus("Pending");
			agentProfile.setReqType("Create");
			agentProfile.setPartnerRemarks((agentManagerUser.getUserRemarks().replace("'", ""))
					.replace(System.getProperty("line.separator"), " "));

			LOGGER.info("In DAO impl class agentProfile is #######       " + agentProfile.toString());

			sessionFact.save(agentProfile);

			LOGGER.info("save records sucessfully");
			return "success";

		} catch (Exception e) {
			LOGGER.error("error while save records [{}]", e);
			return null;
		}
	}

	@Override
	public List<AgentManagerAgentProfileReq> view() {
		ArrayList<AgentManagerAgentProfileReq> list = new ArrayList<AgentManagerAgentProfileReq>();
		try {
			LoginSessionDetails loginSessionDetails = (LoginSessionDetails) httpSession.getAttribute("userObj");
			AgentManagerAgentProfileReq agentProfile = new AgentManagerAgentProfileReq();
			Session sessionFact = sessionFactory.getCurrentSession();
			Criteria crit = sessionFact.createCriteria(CreateAgentProfile.class);
			// if(loginSessionDetails.getRole().equalsIgnoreCase("admin")){
			crit.add(Restrictions.eq("agentStatus", "Pending"));
			// }

			LOGGER.info("Inside the view method");

			LOGGER.info("User Session details are [{}]", loginSessionDetails.toString());

			if (loginSessionDetails.getRole().equalsIgnoreCase("limit")) {
				if (loginSessionDetails.getPartnerName().length() > 0)
					crit.add(Restrictions.eq("partnerName", loginSessionDetails.getPartnerName()));
				else
					return null;
			}

			@SuppressWarnings("unchecked")
			List<CreateAgentProfile> results = crit.list();

			for (CreateAgentProfile createAgentProfile : results) {
				agentProfile = new AgentManagerAgentProfileReq();

				agentProfile.setId(createAgentProfile.getId());
				agentProfile.setPartnerName(createAgentProfile.getPartnerName());
				agentProfile.setAge(createAgentProfile.getNewAgentAge());
				agentProfile.setAgentName(createAgentProfile.getNewAgentName());
				agentProfile.setAllocatedCircle(createAgentProfile.getNewCircle());
				agentProfile.setChatId(createAgentProfile.getNewChatid());
				agentProfile.setDocument(createAgentProfile.getNewUserDoc());
				agentProfile.setDocumentNumber(createAgentProfile.getNewUserDocNo());
				agentProfile.setLanguages(createAgentProfile.getNewAgentLang());
				agentProfile.setLocation(createAgentProfile.getNewLocation());
				agentProfile.setNumber(createAgentProfile.getAgentAni());
				// agentProfile.setOperator("Vodafone");
				agentProfile.setState(createAgentProfile.getNewState());
				agentProfile.setStatus(createAgentProfile.getAgentStatus());
				agentProfile.setType(createAgentProfile.getNewAgentType());
				agentProfile.setNewNumber(createAgentProfile.getNewAni());

				agentProfile.setReqType(createAgentProfile.getReqType());

				if (null == createAgentProfile.getUserDocPath())
					agentProfile.setDocumentPath("");
				else
					agentProfile.setDocumentPath(createAgentProfile.getUserDocPath());

				if (null == createAgentProfile.getCertificatePath())
					agentProfile.setCertificatePath("");
				else
					agentProfile.setCertificatePath(createAgentProfile.getCertificatePath());

				if (null == createAgentProfile.getAdminRemarks())
					agentProfile.setAdminRemarks("");
				else
					agentProfile.setAdminRemarks((createAgentProfile.getAdminRemarks().replace("'", " "))
							.replace(System.getProperty("line.separator"), " "));

				if (null == createAgentProfile.getPartnerRemarks())
					agentProfile.setPartnerRemarks("");
				else
					agentProfile.setPartnerRemarks((createAgentProfile.getPartnerRemarks().replace("'", " "))
							.replace(System.getProperty("line.separator"), " "));

				agentProfile.setInsertDate(createAgentProfile.getReqInsertDate());
				agentProfile.setHub(createAgentProfile.getHub());

				list.add(agentProfile);
			}

			return list;
		} catch (Exception e) {
			LOGGER.error("Error while getting the Agent data from table [{}]", e);
			return null;
		}
	}

	/*
	 * public int userStatus(String userName){
	 * LOGGER.info("User Name is [{}]",userName); try { Session sessionFact =
	 * sessionFactory.getCurrentSession(); String SQL_QUERY =
	 * "SELECT COUNT(1) FROM t_cci_login_details where userName='"+userName+"'";
	 * SQLQuery query=sessionFact.createSQLQuery(SQL_QUERY); return ((BigInteger)
	 * query.list().get(0)).intValue(); }catch(Exception e){
	 * LOGGER.error("error while fetching the CCI user records [{}]",e); return 0; }
	 * }
	 */

	@Override
	public String updateReq(AgentManagerProfileUpdateReq profileUpdateReq) {
		LOGGER.info("profile update request param are [{}]", profileUpdateReq.toString());
		try {
			Session sessionFact = sessionFactory.getCurrentSession();
			CreateAgentProfile agentProfileReq = new CreateAgentProfile();

			// LoginSessionDetails loginSessionDetails =
			// (LoginSessionDetails)httpSession.getAttribute("userObj");
			LoginSessionDetails loginSessionDetails = (LoginSessionDetails) httpSession.getAttribute("userObj");

			agentProfileReq.setAgentAni(profileUpdateReq.getUserNumber().replace("'", ""));

			if (profileUpdateReq.getHub() == null)
				agentProfileReq.setHub("");
			else
				agentProfileReq.setHub(profileUpdateReq.getHub());

			if (profileUpdateReq.getVender() == null)
				agentProfileReq.setPartnerName("");
			else
				agentProfileReq.setPartnerName(profileUpdateReq.getVender());

			if (loginSessionDetails.getRole().equalsIgnoreCase("admin"))
				agentProfileReq.setRequestBy("Admin");
			else if (loginSessionDetails.getRole().equalsIgnoreCase("superadmin"))
				agentProfileReq.setRequestBy("SuperAadmin");
			else
				agentProfileReq.setRequestBy(loginSessionDetails.getPartnerName());

			if (profileUpdateReq.getNewAgentType() == null)
				agentProfileReq.setNewAgentType("");
			else
				agentProfileReq.setNewAgentType(profileUpdateReq.getNewAgentType());

			if (profileUpdateReq.getNewAni() == null)
				agentProfileReq.setNewAni("");
			else
				agentProfileReq.setNewAni(profileUpdateReq.getNewAni().replace("'", ""));

			if (profileUpdateReq.getNewChatid() == null)
				agentProfileReq.setNewChatid("");
			else
				agentProfileReq.setNewChatid(profileUpdateReq.getNewChatid().replace("'", ""));

			if (profileUpdateReq.getNewCircle() == null)
				agentProfileReq.setNewCircle("");
			else
				agentProfileReq.setNewCircle(profileUpdateReq.getNewCircle());

			if (profileUpdateReq.getNewLocation() == null)
				agentProfileReq.setNewLocation("");
			else
				agentProfileReq.setNewLocation(profileUpdateReq.getNewLocation());

			if (profileUpdateReq.getReqType() == null)
				agentProfileReq.setReqType("Update");
			else
				agentProfileReq.setReqType(profileUpdateReq.getReqType());

			if (profileUpdateReq.getUserRemarks() == null)
				agentProfileReq.setPartnerRemarks("");
			else
				agentProfileReq.setPartnerRemarks((profileUpdateReq.getUserRemarks().replace("'", ""))
						.replace(System.getProperty("line.separator"), " "));

			agentProfileReq.setAgentStatus("Pending");

			sessionFact.save(agentProfileReq);

			LOGGER.info("save records sucessfully");
			return "success";

		} catch (Exception e) {
			LOGGER.error("Error while updating the records [{}]", e);
			return null;
		}
	}

	/*
	 * public LoginSessionDetails getSessionDetails(){ try{ LoginSessionDetails
	 * loginSessionDetails= new LoginSessionDetails();
	 * 
	 * Enumeration<String> e = httpSession.getAttributeNames(); while
	 * (e.hasMoreElements()){ String s = e.nextElement();
	 * loginSessionDetails=(LoginSessionDetails) httpSession.getAttribute(s); }
	 * LOGGER.info(loginSessionDetails.toString()); return loginSessionDetails;
	 * }catch(Exception e){
	 * LOGGER.error("Error while getting the value from http session [{}]",e);
	 * return null; } }
	 */

	@Override
	public AgentManagerCreateUserDetailsDTO createUserAjaxReq(String hubName) {
		String dblink = null, sqlQuery = null;
		AgentManagerCreateUserDetailsDTO userDetails = new AgentManagerCreateUserDetailsDTO();

		LinkedHashMap<String, String> circleDetails = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> typeDetails = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> venderDetails = new LinkedHashMap<String, String>();
		circleDetails.clear();
		typeDetails.clear();
		venderDetails.clear();

		if (hubName.equals("North"))
			dblink = "north_db.hutch_bgm.";
		else if (hubName.equals("East"))
			dblink = "east_db.bgm.";
		else if (hubName.equals("West"))
			dblink = "westdb1.hutch_bgm.";
		else if (hubName.equals("South"))
			dblink = "south_db.hutch.";
		else if (hubName.equals("Upeast"))
			dblink = "upeast_db.hutch_bgm.";

		try {
			/* CreateUserHubDetails hubDetails = new CreateUserHubDetails(); */
			Session sessionFact = sessionFactory.getCurrentSession();

			// LoginSessionDetails loginSessionDetails =
			// (LoginSessionDetails)httpSession.getAttribute("userObj");
			LoginSessionDetails loginSessionDetails = (LoginSessionDetails) httpSession.getAttribute("userObj");

			if (loginSessionDetails.getRole().equalsIgnoreCase("limit"))
				sqlQuery = ((new StringBuilder("select center_name,center_id,'1' as 'extra','NA' as 'b_circle' from "))
						.append(dblink)
						.append("dbo.VCHAT_CENTER_DETAIL where center_name='" + loginSessionDetails.getPartnerName()
								+ "' union all select distinct(agent_category) as 'center_name','1' as 'center_id','2'  as 'extra',upper(b_circle) as 'b_circle' from ")
						.append(dblink).append("bgm.VCHAT_PROFESSIONAL_AGENTS order by center_name asc").toString());
			else
				sqlQuery = ((new StringBuilder("select center_name,center_id,'1' as 'extra','NA' as 'b_circle' from "))
						.append(dblink)
						.append("dbo.VCHAT_CENTER_DETAIL union all select distinct(agent_category) as 'center_name','1' as 'center_id','2'  as 'extra',upper(b_circle) as 'b_circle' from ")
						.append(dblink).append("bgm.VCHAT_PROFESSIONAL_AGENTS order by center_name asc").toString());

			LOGGER.info(sqlQuery);
			SQLQuery query = sessionFact.createSQLQuery(sqlQuery);

			@SuppressWarnings("unchecked")
			List<Object[]> list = query.list();
			LOGGER.info("query output is !!!!!  [{}] ", list.toString());

			venderDetails.put("Select Vender", "Select Vender");
			circleDetails.put("", "Click to Choose..");
			typeDetails.put("", "Select Type");

			for (Object[] row : list) {
				if (row[2].toString().equalsIgnoreCase("1")) {
					venderDetails.put(row[0].toString(), row[1].toString());
				} else {
					typeDetails.put(row[0].toString(), row[0].toString());
					circleDetails.put(row[3].toString(), row[3].toString());
				}
			}

			if (circleDetails.containsKey("HUTCH_ROB"))
				circleDetails.remove("HUTCH_ROB");

			LOGGER.info("circleDetails are [{}]", circleDetails.toString());

			userDetails.setCircleMap(circleDetails);
			userDetails.setVenderMap(venderDetails);
			userDetails.setTypeMap(typeDetails);
			return userDetails;

		} catch (Exception e) {
			LOGGER.error("Error while getting the HUB details [{}]", e);
			return null;
		}
	}

	@Override
	public String updateRecords(AgentManagerAgentProfileReq profileUpdateReq) {
		LOGGER.info(profileUpdateReq.toString());
		//String hqlQuery = null;
		try {
			String resp = updateAgentRecords(profileUpdateReq);
			LOGGER.info("updateRecords procedure resp is [{}]", resp);
			
						
			/*
			Session sessionFact = sessionFactory.getCurrentSession();
			LoginSessionDetails loginSessionDetails = (LoginSessionDetails) httpSession.getAttribute("userObj");

			if (profileUpdateReq.getStatus().equalsIgnoreCase("approve")) {
				if (profileUpdateReq.getReqType().equalsIgnoreCase("chatidChange")) {
					LOGGER.info("chatidChange");

					String hql = "UPDATE AgentManagerUserRecord u set u.chatId = :agentChatid WHERE u.mobileNo = :uNumber";
					Query query = sessionFact.createQuery(hql);
					query.setParameter("agentChatid", profileUpdateReq.getChatId().replace("'", ""));
					query.setParameter("uNumber", profileUpdateReq.getNumber().replace("'", ""));
					int result = query.executeUpdate();
					LOGGER.info("chatidChange Rows affected: " + result);
				} else if (profileUpdateReq.getReqType().equalsIgnoreCase("circleChange")) {
					LOGGER.info("circleChange");

					String hql = "UPDATE AgentManagerUserRecord u set u.circle = :agentCircle WHERE u.mobileNo = :uNumber";
					Query query = sessionFact.createQuery(hql);
					query.setParameter("agentCircle", profileUpdateReq.getAllocatedCircle().replace("'", ""));
					query.setParameter("uNumber", profileUpdateReq.getNumber().replace("'", ""));
					int result = query.executeUpdate();
					LOGGER.info("circleChange Rows affected: " + result);

				} else if (profileUpdateReq.getReqType().equalsIgnoreCase("delete")) {
					LOGGER.info("delete");
					LOGGER.info(profileUpdateReq.toString());

					AgentManagerUserRecordLog userLogs = new AgentManagerUserRecordLog();
					Criteria crit = sessionFact.createCriteria(AgentManagerUserRecord.class);
					crit.add(Restrictions.eq("mobileNo", profileUpdateReq.getNumber()));

					AgentManagerUserRecord usrList = (AgentManagerUserRecord) crit.list().get(0);

					LOGGER.info("selected Records are [{}]", usrList.toString());

					if (usrList != null) {
						userLogs.setAgentAge(usrList.getAgentAge());
						userLogs.setAgentLang(usrList.getAgentLang());
						userLogs.setAgentName(usrList.getAgentName());
						userLogs.setAgentType(usrList.getAgentType());
						userLogs.setCertificatePath(usrList.getCertificatePath());
						userLogs.setChatId(usrList.getChatId());
						userLogs.setCircle(usrList.getCircle());
						userLogs.setLocation(usrList.getLocation());
						userLogs.setMobileNo(usrList.getMobileNo());
						userLogs.setPartnerName(usrList.getPartnerName());
						userLogs.setRemoveBy(loginSessionDetails.getUserName());
						userLogs.setState(usrList.getState());
						userLogs.setUserDoc(usrList.getUserDoc());
						userLogs.setUserDocNo(usrList.getUserDocNo());
						userLogs.setUserDocPath(usrList.getUserDocPath());
						sessionFact.save(userLogs);

						LOGGER.info("Delete Request received and move the existing entry in log table");

						Query query = sessionFact.createQuery("delete AgentManagerUserRecord where mobileNo = :mobile");
						query.setParameter("mobile", profileUpdateReq.getNumber());

						int result = query.executeUpdate();

						LOGGER.info(Integer.toString(result));

						LOGGER.info("Agent mobile number [{}] has been deleted and response is [{}] ",
								profileUpdateReq.getNumber(), Integer.toString(result));
					}
				} else if (profileUpdateReq.getReqType().equalsIgnoreCase("locationChange")) {
					LOGGER.info("locationChange");

					String hql = "UPDATE AgentManagerUserRecord u set u.location = :agentLocation WHERE u.mobileNo = :uNumber";
					Query query = sessionFact.createQuery(hql);
					query.setParameter("agentLocation", profileUpdateReq.getLocation().replace("'", ""));
					query.setParameter("uNumber", profileUpdateReq.getNumber().replace("'", ""));
					int result = query.executeUpdate();
					LOGGER.info("locationChange Rows affected: " + result);

				} else if (profileUpdateReq.getReqType().equalsIgnoreCase("numberChange")) {
					LOGGER.info("numberChange");

					String hql = "UPDATE AgentManagerUserRecord u set u.mobileNo = :agentNewNumber WHERE u.mobileNo = :uNumber";
					Query query = sessionFact.createQuery(hql);
					query.setParameter("agentNewNumber", profileUpdateReq.getNewNumber().replace("'", ""));
					query.setParameter("uNumber", profileUpdateReq.getNumber().replace("'", ""));
					int result = query.executeUpdate();
					LOGGER.info("numberChange Rows affected: " + result);

				} else if (profileUpdateReq.getReqType().equalsIgnoreCase("typeChange")) {
					LOGGER.info("typeChange");

					String hql = "UPDATE AgentManagerUserRecord u set u.agentType = :agentTypeReq WHERE u.mobileNo = :uNumber";
					Query query = sessionFact.createQuery(hql);
					query.setParameter("agentTypeReq", profileUpdateReq.getType().replace("'", ""));
					query.setParameter("uNumber", profileUpdateReq.getNumber().replace("'", ""));
					int result = query.executeUpdate();
					LOGGER.info("typeChange Rows affected: " + result);

				} else if (profileUpdateReq.getReqType().equalsIgnoreCase("Create")) {
					LOGGER.info("create");

					AgentManagerUserRecord userRecord = new AgentManagerUserRecord();

					userRecord.setAgentAge(profileUpdateReq.getAge().replace("'", ""));
					userRecord.setAgentLang(profileUpdateReq.getLanguages());
					userRecord.setAgentName(profileUpdateReq.getAgentName().replace("'", ""));
					userRecord.setAgentType(profileUpdateReq.getType());
					userRecord.setCertificatePath(profileUpdateReq.getCertificatePath().replace("'", ""));
					userRecord.setChatId(profileUpdateReq.getChatId().replace("'", ""));
					userRecord.setCircle(profileUpdateReq.getAllocatedCircle());
					userRecord.setLocation(profileUpdateReq.getLocation());
					userRecord.setMobileNo(profileUpdateReq.getNumber().replace("'", ""));
					userRecord.setPartnerName(profileUpdateReq.getPartnerName().replace("'", ""));
					userRecord.setState(profileUpdateReq.getState());
					userRecord.setUserDoc(profileUpdateReq.getDocument().replace("'", ""));
					userRecord.setUserDocNo(profileUpdateReq.getDocumentNumber().replace("'", ""));
					userRecord.setUserDocPath(profileUpdateReq.getDocumentPath().replace("'", ""));

					sessionFact.save(userRecord);
					LOGGER.info("Record has been saved successfully !!");
				}
			}

			int res = 0, res1 = 0;

			hqlQuery = "UPDATE CreateAgentProfile u set u.agentStatus = :status, u.adminRemarks=:adminRe WHERE u.agentAni = :uNumber and u.id= :uId";
			Query q = sessionFact.createQuery(hqlQuery);
			q.setParameter("status", profileUpdateReq.getStatus().replace("'", ""));
			q.setParameter("adminRe", (profileUpdateReq.getAdminRemarks().replace("'", "").replace(System.getProperty("line.separator"), " ")));
			q.setParameter("uNumber", profileUpdateReq.getNumber().replace("'", ""));
			q.setParameter("uId", profileUpdateReq.getId());
			res = q.executeUpdate();

			if (profileUpdateReq.getReqType().equalsIgnoreCase("numberChange") || profileUpdateReq.getReqType().equalsIgnoreCase("delete")) {

				String hqlQuery1 = "UPDATE CreateAgentProfile u set u.agentStatus = :status, u.adminRemarks=:adminRe WHERE u.agentAni = :uNumber and u.agentStatus= :ifStatus";
				Query q1 = sessionFact.createQuery(hqlQuery1);
				q1.setParameter("status", "reject");
				q1.setParameter("adminRe","Request Reject !!! because [" + profileUpdateReq.getNewNumber() + "] has been changed");
				q1.setParameter("uNumber", profileUpdateReq.getNumber().replace("'", ""));
				q1.setParameter("ifStatus", "pending");
				res1 = q1.executeUpdate();

				LOGGER.info("CreateAgentProfile numberChange Rows affected: " + res1);
			}
			LOGGER.info("CreateAgentProfile Rows affected: " + res);
			*/	
			return resp;
		} catch (Exception e) {
			LOGGER.error("Error while updating the records [{}]", e);
			return null;
		}

	}

	@Override
	public List<AgentManagerAgentProfileReq> viewFinal() {
		ArrayList<AgentManagerAgentProfileReq> list = new ArrayList<AgentManagerAgentProfileReq>();
		try {
			// LoginSessionDetails loginSessionDetails =
			// (LoginSessionDetails)httpSession.getAttribute("userObj");
			LoginSessionDetails loginSessionDetails = (LoginSessionDetails) httpSession.getAttribute("userObj");
			AgentManagerAgentProfileReq agentProfile = new AgentManagerAgentProfileReq();
			Session sessionFact = sessionFactory.getCurrentSession();
			Criteria crit = sessionFact.createCriteria(CreateAgentProfile.class);
			crit.add(Restrictions.ne("agentStatus", "Pending"));

			LOGGER.info("Inside the view method");

			LOGGER.info("User Session details are [{}]", loginSessionDetails.toString());

			if (loginSessionDetails.getRole().equalsIgnoreCase("limit")) {
				if (loginSessionDetails.getPartnerName().length() > 0)
					crit.add(Restrictions.eq("partnerName", loginSessionDetails.getPartnerName()));
				else
					return null;
			}

			@SuppressWarnings("unchecked")
			List<CreateAgentProfile> results = crit.list();

			for (CreateAgentProfile createAgentProfile : results) {
				agentProfile = new AgentManagerAgentProfileReq();

				agentProfile.setId(createAgentProfile.getId());
				agentProfile.setPartnerName(createAgentProfile.getPartnerName());
				agentProfile.setAge(createAgentProfile.getNewAgentAge());
				agentProfile.setAgentName(createAgentProfile.getNewAgentName());
				agentProfile.setAllocatedCircle(createAgentProfile.getNewCircle());
				agentProfile.setChatId(createAgentProfile.getNewChatid());
				agentProfile.setDocument(createAgentProfile.getNewUserDoc());
				agentProfile.setDocumentNumber(createAgentProfile.getNewUserDocNo());
				agentProfile.setLanguages(createAgentProfile.getNewAgentLang());
				agentProfile.setLocation(createAgentProfile.getNewLocation());
				agentProfile.setNumber(createAgentProfile.getAgentAni());
				agentProfile.setOperator("Vodafone");
				agentProfile.setState(createAgentProfile.getNewState());
				agentProfile.setStatus(createAgentProfile.getAgentStatus());
				agentProfile.setType(createAgentProfile.getNewAgentType());
				agentProfile.setNewNumber(createAgentProfile.getNewAni());

				agentProfile.setReqType(createAgentProfile.getReqType());

				if (null == createAgentProfile.getUserDocPath())
					agentProfile.setDocumentPath("");
				else
					agentProfile.setDocumentPath(createAgentProfile.getUserDocPath());

				if (null == createAgentProfile.getCertificatePath())
					agentProfile.setCertificatePath("");
				else
					agentProfile.setCertificatePath(createAgentProfile.getCertificatePath());

				if (null == createAgentProfile.getAdminRemarks())
					agentProfile.setAdminRemarks("");
				else
					agentProfile.setAdminRemarks(
							createAgentProfile.getAdminRemarks().replace(System.getProperty("line.separator"), " "));

				if (null == createAgentProfile.getPartnerRemarks())
					agentProfile.setPartnerRemarks("");
				else
					agentProfile.setPartnerRemarks(
							createAgentProfile.getPartnerRemarks().replace(System.getProperty("line.separator"), " "));

				agentProfile.setInsertDate(createAgentProfile.getReqInsertDate());
				agentProfile.setHub(createAgentProfile.getHub());

				list.add(agentProfile);
			}

			return list;
		} catch (Exception e) {
			LOGGER.error("Error while getting the Agent data from table [{}]", e);
			return null;
		}
	}

	@Override
	public int resetPassword(String loginId, String newPassword) {
		int resp = 0;
		try {
			Session sessionFact = sessionFactory.getCurrentSession();
			String hqlQuery1 = "UPDATE LoginDetails set password = :pass WHERE userName = :loginId";
			LOGGER.info("Query is " + hqlQuery1);
			Query q1 = sessionFact.createQuery(hqlQuery1);
			q1.setParameter("pass", newPassword.replace("'", ""));
			q1.setParameter("loginId", loginId);
			resp = q1.executeUpdate();

			return resp;
		}

		catch (Exception e) {
			LOGGER.info("Error in Reset User New Password " + e);
		}
		return resp;
	}

	@Override
	public int delUser(String userName, String PartnerName, String userRole, String password) {
		int resp = 0;
		try {
			Session sessionFact = sessionFactory.getCurrentSession();

			LoginDetails loginDetails = (LoginDetails) sessionFact.load(LoginDetails.class, userName);
			if (loginDetails != null) {
				sessionFact.delete(loginDetails);
				resp = 1;
				LOGGER.info("User Deleted Successfully having  id [{}], Name [{}], Password [{}] and having role [{}]",
						userName, PartnerName, password, userRole);
			}

			if (resp == 1) {
				String adminName = ((LoginSessionDetails) httpSession.getAttribute("userObj")).getUserName();
				String adminIp = ((LoginSessionDetails) httpSession.getAttribute("userObj")).getUserIp();
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String delDate = sdf.format(date);

				DeleteUserLog delUser = new DeleteUserLog();
				delUser.setUserName(userName);
				delUser.setPartnerName(PartnerName);
				delUser.setUserPassword(password.replace("'", ""));
				delUser.setUserRole(userRole);
				delUser.setUserRemoveBy(adminName);
				delUser.setIpAddress(adminIp);
				delUser.setUserRemoveDateTime(delDate);

				sessionFact.save(delUser);

				LOGGER.info("User Added Successfully INTO tbl_interfaceuser_log" + delUser.toString());
				resp = 2;
			}
		}

		catch (Exception e) {
			LOGGER.info("Error in Deleing User " + e);
		}
		return resp;
	}

	public String updateAgentRecords(final AgentManagerAgentProfileReq agentManagerAgentProfileReq) {
		try {
			LOGGER.info("Inside the updateAgentRecords");
			LOGGER.info("Request parameters are updateAgentRecords [{}]", agentManagerAgentProfileReq.toString());
			Session sessionFact = sessionFactory.getCurrentSession();
			sessionFact.doWork(new Work() {
				@Override
				public void execute(Connection connection) throws SQLException {

					String insertDate = String.valueOf(agentManagerAgentProfileReq.getInsertDate());
					LOGGER.info(insertDate);

					LoginSessionDetails loginSessionDetails = (LoginSessionDetails) httpSession.getAttribute("userObj");
					String sqlString = "{call VChat_UserInterface_PartnerReqUpdate(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					CallableStatement cStat = connection.prepareCall(sqlString);
					cStat.setString(1, String.valueOf(agentManagerAgentProfileReq.getHub()));
					cStat.setString(2, String.valueOf(agentManagerAgentProfileReq.getReqType()));
					cStat.setString(3, String.valueOf(insertDate));
					cStat.setString(4, String.valueOf(agentManagerAgentProfileReq.getPartnerName()));
					cStat.setString(5, String.valueOf(agentManagerAgentProfileReq.getNumber()));
					cStat.setString(6, String.valueOf(agentManagerAgentProfileReq.getNewNumber()));
					cStat.setString(7, String.valueOf(agentManagerAgentProfileReq.getAllocatedCircle()));
					cStat.setString(8, String.valueOf(agentManagerAgentProfileReq.getChatId()));
					cStat.setString(9, String.valueOf(agentManagerAgentProfileReq.getLocation()));
					cStat.setString(10, String.valueOf(agentManagerAgentProfileReq.getType()));
					cStat.setString(11, String.valueOf(agentManagerAgentProfileReq.getDocument()));
					cStat.setString(12, String.valueOf(agentManagerAgentProfileReq.getDocumentNumber()));
					cStat.setString(13, String.valueOf(agentManagerAgentProfileReq.getAgentName()));
					cStat.setString(14, String.valueOf(agentManagerAgentProfileReq.getAge()));
					cStat.setString(15, String.valueOf(agentManagerAgentProfileReq.getLanguages()));
					cStat.setString(16, String.valueOf(agentManagerAgentProfileReq.getPartnerRemarks().replace("'", "").replace(System.getProperty("line.separator"), " ")));
					cStat.setString(17, String.valueOf(agentManagerAgentProfileReq.getAdminRemarks().replace("'", "").replace(System.getProperty("line.separator"), " ")));
					cStat.setString(18, String.valueOf(agentManagerAgentProfileReq.getStatus()));
					cStat.setString(19, String.valueOf(agentManagerAgentProfileReq.getDocumentPath()));
					cStat.setString(20, String.valueOf(agentManagerAgentProfileReq.getCertificatePath()));
					cStat.setString(21, String.valueOf(loginSessionDetails.getUserName()));
					cStat.setInt(22, agentManagerAgentProfileReq.getId());
					cStat.registerOutParameter(23, java.sql.Types.VARCHAR);
					cStat.execute();

					outResp = cStat.getString(23);
					LOGGER.info("procedure executed !!!!");

					LOGGER.info(outResp);
					LOGGER.info("procedure Out response !!!!");
				}
			});
			LOGGER.info("after procedure execution");

			return outResp;

		} catch (Exception e) {
			LOGGER.error("Getting Error while fetching the Records from viewRecords Method [{}]", e);
			return null;
		}

	}
}
