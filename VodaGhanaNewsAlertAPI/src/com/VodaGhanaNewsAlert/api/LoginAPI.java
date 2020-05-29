package com.VodaGhanaNewsAlert.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


//@WebServlet(urlPatterns = "/checkLogin",name="loginServlet")
public class LoginAPI extends HttpServlet{
	
	private static final Logger logger = LogManager.getLogger(LoginAPI.class);
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Connection con=null;
		PreparedStatement pstmt=null;
		CallableStatement cstmt = null;
		String response = null;
		try
		{
			resp.setContentType("application/json");
			 StringBuilder buffer = new StringBuilder();
			    BufferedReader reader = req.getReader();
			    String line;
			    while ((line = reader.readLine()) != null) {
			    	System.out.println(line);
			        buffer.append(line);
			    }
			    String data = buffer.toString();
			    
			    JSONObject jsonObject = new JSONObject(data);
			    
			String usrName = jsonObject.getString("name").trim();
			String pass = jsonObject.getString("password").trim();
			
			logger.info("Entered Username is "+usrName+" and password is "+pass);
			
			con=ConnectionFactory.getDBConnection();
			
			//calling procedures to check the details..
			cstmt = con.prepareCall("{call PROC_QUICK_SMS_serviceslist(?,?,?)}");
			cstmt.setString(1, usrName);
			cstmt.setString(2, pass);
			
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.execute();
			String out_resp = cstmt.getString(3); 
			
			if(out_resp==null || out_resp=="")
			{
				logger.info("Something went Wrong!!! please Contact to your Administrator");
				response = ("Something went Wrong!!! please Contact to your Administrator");
			}
			
			else if(out_resp.contains("#"))
			{
				logger.info("Login Successfully with UserName and password "+usrName+" "+pass);
				
				JSONObject jsonObj = new JSONObject();
				String[] token=out_resp.split("#");
				
				jsonObj.put("loginStatus", token[0]);
				jsonObj.put("UserName", token[1]);
				jsonObj.put("role", token[2]);
				jsonObj.put("status", token[3]);
				
				pstmt = con.prepareStatement("select id,name,parent_id from tbl_quicksms_serlist_interface where parent_id!=0");
				ResultSet rs = pstmt.executeQuery();
				JSONArray array = new JSONArray();
					while(rs.next())
					{
						List<String> list = new ArrayList<String>();
						list.add(String.valueOf(rs.getInt(1)));
						list.add(rs.getString(2));
						list.add(String.valueOf(rs.getInt(3)));
						array.put(list);
					}
				
				jsonObj.put("Services", array);
				response = jsonObj.toString();
			}
			
			else
			{
				logger.info(out_resp);
				response = out_resp;
			}
			
		}
		catch (Exception e) {
			logger.info("Exception Occured "+e);
			e.printStackTrace();
			
			response = "exception";
		}
		
		finally
		{
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		PrintWriter pw = resp.getWriter();
		pw.print(response);
		pw.flush();
	}
}
