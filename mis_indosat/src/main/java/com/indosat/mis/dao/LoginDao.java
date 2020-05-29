package com.indosat.mis.dao;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.indosat.mis.bean.IGamePojo;
import com.indosat.mis.bean.MisLogin;

import java.util.*;

@Component
public class LoginDao {
	
	@Autowired
	HibernateTemplate template;
	
	public Boolean checkLogin(String userName, String userPassword) {

		boolean userFound = false;
		// Query using Hibernate Query Language
		String SQL_QUERY = "  from MisLogin as o where o.username='" + userName + "' and o.password='" + userPassword
				+ "'";
		List<MisLogin> list = (List<MisLogin>) template.find(SQL_QUERY);
		if (list.size() > 0)
			userFound = true;

		return userFound;
	}

		public List<IGamePojo> getMis_igame(String startdate, String enddate,String service) 
	{
		
	
		String SQL_QUERY1 = " FROM IGamePojo as o where date(o.date_time) between '" + startdate + "' " + "and'"
				+ enddate + "' order by date(o.date_time)";
		template.find(SQL_QUERY1);

		return (List<IGamePojo>) template.find(SQL_QUERY1);
		}	
	}
