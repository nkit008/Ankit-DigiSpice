package com.VodaGhanaNewsAlert.api;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

/*@WebServlet(urlPatterns = "/uploadContent",name="uploadServlet")*/
public class SaveContent extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(SaveContent.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection con=null;
		CallableStatement cstmt = null;
		String response = null;
		try
		{
			resp.setContentType("application/json");
			 StringBuilder buffer = new StringBuilder();
			    BufferedReader reader = req.getReader();
			    
			    String line;
			    while ((line = reader.readLine()) != null) {
			    	
			    	logger.info("Json in API {}", line);
			        buffer.append(line);
			    }
			    String data = buffer.toString();
			    
			    
			    System.out.println("Data value is   #####     "+data);
			    JSONObject jsonObject = new JSONObject(data);
			    
			String genre = jsonObject.getString("genre").trim();
			String mainCat = jsonObject.getString("mainCat").trim();
			String subCat = jsonObject.getString("subCat").trim();
			String date = jsonObject.getString("date").trim();
			String smsalert = jsonObject.getString("smsalert").trim();
			//String ip = jsonObject.getString("ip").trim();
			
			
			con=ConnectionFactory.getDBConnection();
			
			//calling procedures to check the details..
			cstmt = con.prepareCall("{call PROC_QUICK_SMS_SAVE_CONTNENT(?,?,?,?,?,?,?)}");
			cstmt.setString(1, genre);
			cstmt.setString(2, mainCat);
			cstmt.setString(3, subCat);
			cstmt.setString(4, date);
			cstmt.setString(5, URLDecoder.decode(smsalert));
			cstmt.setString(6, "IP");
			
			cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			cstmt.execute();
			String out_resp = cstmt.getString(7); 
			
			logger.info("Response from procedure is "+out_resp);
			if(out_resp.equalsIgnoreCase("Vendor Name is not allowed."))
			{
				response = "exception";
			}
			else if(out_resp.equalsIgnoreCase("Content Upload Successfully."))
			{
				response = "success";
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