package com.spice.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.spice.bean.MisGamingRobi;
import com.spice.bean.MisGamingAirtel;
import com.spice.bean.MisLogin;

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

	public List<MisGamingRobi> getMis(String startdate, String enddate,String service) {

		boolean userFound = false;
		// Query using Hibernate Query Language
		
		String SQL_QUERY = " FROM MisGamingRobi as o where date(o.date_time) between '" + startdate + "' " + "and'"
				+ enddate + "' order by date(o.date_time)";
		template.find(SQL_QUERY);

		return (List<MisGamingRobi>) template.find(SQL_QUERY);
		
	}
	
	public List<MisGamingAirtel> getMis_airtel(String startdate, String enddate,String service) 
	{
		
	
		String SQL_QUERY1 = " FROM MisGamingAirtel as o where date(o.date_time) between '" + startdate + "' " + "and'"
				+ enddate + "' order by date(o.date_time)";
		template.find(SQL_QUERY1);

		return (List<MisGamingAirtel>) template.find(SQL_QUERY1);
		}	
	}
