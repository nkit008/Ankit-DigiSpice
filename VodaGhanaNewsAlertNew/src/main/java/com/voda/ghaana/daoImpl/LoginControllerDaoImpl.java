package com.voda.ghaana.daoImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.voda.ghaana.model.LoginModel;
import com.voda.ghaana.model.ServiceList;

@Component
public class LoginControllerDaoImpl {
	
	@Autowired
	HttpSession httpsession;
	
	@Autowired
	LoginModel model;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginControllerDaoImpl.class);
	
	private static final String POST_URL = "http://80.87.70.134:8080/VodaGhanaNewsAlertAPI/checkLogin";
	//private static final String POST_URL = "http://localhost:8080/VodaGhanaNewsAlertAPI/checkLogin";
	
	private String strResponseData=null;
	
	public String checkLogin(String userName,String password)
	{
		
		String value=null;
		OutputStream os = null;
		HttpURLConnection con = null;
		BufferedReader br = null;
		String userIpAddress = null;
		List<ServiceList> serviceList = new ArrayList<ServiceList>();
		
		try{
			/*
			 * //userIpAddress = request.getRemoteAddr(); if(userIpAddress == null) {
			 * userIpAddress = request.getRemoteAddr(); }
			 */
			
			URL obj = new URL(POST_URL);
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept", "application/json");
			con.setDoInput(true);
			con.setDoOutput(true);
			String jsonInputString = "{name: "+userName+", password: "+password+"}";
			os = con.getOutputStream();
			
			    byte[] input = jsonInputString.getBytes("utf-8");
			    os.write(input, 0, input.length);
			    
			br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			strResponseData = response.toString();
			logger.info("[ Response from API :- " + POST_URL + " ] [ Response " + strResponseData + " ]");
			
			if(strResponseData.equalsIgnoreCase("Not a valid user"))
			{
				value="error";
			}
			
			else if(strResponseData.equalsIgnoreCase("exception"))
			{
				value="exception";
			}
			else
			{
				JSONObject jsonObj = new JSONObject(strResponseData);
				
				/* sessionMap.put("loginStatus", jsonObj.get("loginStatus")); */
				model.setUsername(jsonObj.get("UserName").toString());
				model.setUserrole(jsonObj.get("role").toString());
				model.setUserstatus(jsonObj.get("status").toString());
				model.setUserIpAdd("NA");
				
				httpsession.setAttribute("loginObj", model);
				
				
				
				JSONArray arr = jsonObj.getJSONArray("Services");
				
				for(int i = 0;i<arr.length();i++)
				{
					ServiceList s = new ServiceList();
					JSONArray arr1 = arr.getJSONArray(i);
					
					s.setId(arr1.getString(0));
					s.setName(arr1.getString(1)); 	 	
					s.setParent_id(arr1.getString(2));
					
					serviceList.add(s);
				}
				httpsession.setAttribute("serviceList", serviceList);
				value="success";
				
				System.out.println("login session object is " +httpsession.getAttribute("loginObj"));
			}
			
			
		}
		catch(Exception e)
		{
			logger.info("exception in hitting API "+POST_URL);
			e.printStackTrace();
			value="exception";
			
		}
		finally {
			try {
				if(br!=null)
					br.close();
				if(os!=null)
					os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con.disconnect();
		}
		
		return value;
	}

}
