package com.spice.reminderservice.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.spice.reminderservice.bean.MisServiceLogin;
import com.spice.reminderservice.bean.ReminderServiceBean;

@Component
public class ReminderServiceDao {
	@Autowired
	HibernateTemplate template;
	
	public Boolean checkLogin(String userName, String userPassword) {
		boolean userFound = false;
		// Query using Hibernate Query Language
		String SQL_QUERY = "from MisServiceLogin as o where o.name='" + userName + "' and o.pass='" + userPassword
				+ "' and o.role='admin'";
		List<MisServiceLogin> list = (List<MisServiceLogin>) template.find(SQL_QUERY);
		if (list.size() > 0)
			userFound = true;
		return userFound;
	}
	
	
	public List<ReminderServiceBean> getMis(String startdate, String enddate) {
		boolean userFound = false;
		
		String SQL_QUERY = " FROM ReminderServiceBean as o where date(o.date) between '" + startdate + "' " + "and'"
				+ enddate + "' order by date(o.date)";
		List<ReminderServiceBean> list = (List<ReminderServiceBean>)template.find(SQL_QUERY);
		
		System.out.println("Checking if list is empty -------" +list.isEmpty());
		
		for(ReminderServiceBean a:list)
		{
			a.setDate(a.getDate().substring(0,10));
			a.setHits_per_uniq_user(a.getHits_per_uniq_user().substring(0,5));
			a.setSession_per_uniq_user(a.getSession_per_uniq_user().substring(0,5));
		}

		return (List<ReminderServiceBean>) list;
	}
}