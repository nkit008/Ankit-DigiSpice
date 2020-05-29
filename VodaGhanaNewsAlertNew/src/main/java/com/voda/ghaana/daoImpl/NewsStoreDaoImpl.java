package com.voda.ghaana.daoImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.voda.ghaana.model.NewsBean;

@Component
public class NewsStoreDaoImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(NewsStoreDaoImpl.class);
	
	private static final String UPLOAD_POST_URL = "http://80.87.70.134:8080/VodaGhanaNewsAlertAPI/uploadContent";
	//private static final String UPLOAD_POST_URL = "http://localhost:8080/VodaGhanaNewsAlertAPI/uploadContent";
		
	OutputStream os = null;
	HttpURLConnection con = null;
		BufferedReader br = null;
		String strResponseData = null;

	
	public String uploadRecord(NewsBean bean)
	{
		String value= null;
		String ipAddress = "NA";
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			Date saveDate = sdf.parse(bean.getDatepicker());
			String datepicker = sdf1.format(saveDate);
			
			logger.info("Final datepicker is "+datepicker);
			
			URL url = new URL(UPLOAD_POST_URL);
			
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept", "application/json");
			con.setDoInput(true);
			con.setDoOutput(true);
			String jsonInputString = "{genre:"+bean.getCategory()+",mainCat:"+bean.getMainCategory()+",subCat:"+
			bean.getSubCategory()+",date:"+datepicker+",smsalert:"+bean.getAlertsms()+",ip:"+ipAddress+"}";
			
			logger.info("Json Request Body {}",jsonInputString);
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
			logger.info("[ Response from API :- " + UPLOAD_POST_URL + " ] [ Response " + strResponseData + " ]");
			
				if(strResponseData.equalsIgnoreCase("success")){
					value="success";
				}else{
					return "exception";
				}
				
		}
		catch(Exception e){
			logger.error(" error while Saving the records {}",e);
			e.printStackTrace();
			value="exception";
		}
		finally{
			try {
				if(br!=null)
					br.close();
				if(os!=null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			con.disconnect();
			}
		
		return value;
	}
}
