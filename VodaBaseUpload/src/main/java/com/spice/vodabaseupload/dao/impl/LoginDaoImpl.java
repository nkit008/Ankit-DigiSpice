package com.spice.vodabaseupload.dao.impl;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spice.vodabaseupload.beans.Login;
import com.spice.vodabaseupload.beans.LoginEntity;
import com.spice.vodabaseupload.beans.LoginSessionDetails;
import com.spice.vodabaseupload.dao.ILoginDao;

@Repository
@Transactional
public class LoginDaoImpl implements ILoginDao{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginDaoImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public LoginSessionDetails getLoginStatus(Login login, HttpServletRequest request) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(LoginEntity.class);
		
		LoginSessionDetails loginSessionDetails =new LoginSessionDetails();
		
		LOGGER.info("user name is " + login.getUserName());
		LOGGER.info("password is " + login.getUserPwd());

		criteria.add(Restrictions.eq("userName", login.getUserName()));
		criteria.add(Restrictions.eq("userPassword", login.getUserPwd()));

		if (criteria.list().isEmpty()) {
			LOGGER.info("Login Records not found  !!!!!  ");
			return null;
		} else {
			LOGGER.info("Successful Login");
			LoginEntity loginList= (LoginEntity) criteria.list().get(0);
			
			loginSessionDetails.setUserName(loginList.getUserName());
			loginSessionDetails.setPassword(loginList.getUserPassword());
			loginSessionDetails.setRole(loginList.getUserRole());
		
			loginSessionDetails.setUserIp(request.getRemoteAddr());
			session.close();
			return loginSessionDetails;
		}	
		
	}
}
