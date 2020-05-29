package com.spice.expertmgmtbsnl.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spice.expertmgmtbsnl.dao.PartnerConfigurationDao;
import com.spice.expertmgmtbsnl.model.ConfigureNewPartnerModel;


@RestController
public class DemoApi {
	ConfigureNewPartnerModel configureNewPartnerModel = new ConfigureNewPartnerModel();
	@Autowired
	PartnerConfigurationDao dao;
	
	@RequestMapping(value = "/display", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ConfigureNewPartnerModel> configureNewPartner()
	{
		System.out.println(":::::::::::::::::::::::::::asdadadasdadasdasdasdadadasdqweweqwe");
				List<ConfigureNewPartnerModel> partnerList=dao.getAllConfigurepartner();	
				return partnerList;
		
	}
	
	 
	   /* @RequestMapping(value = "/display", method = RequestMethod.GET, produces = "application/json")
	    public ConfigureNewPartnerModel getEmployeeInJSON() {
	    	configureNewPartnerModel.setLocation("chnadihkdha");
	    	configureNewPartnerModel.setUserId("employee1@genuitec.com");
	       return configureNewPartnerModel;
	    }*/
}