package com.digispice.indosat.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digispice.indosat.connection.ConnectionFactory;



@Repository
@Transactional
public class VoiceAlert {
	
	
	private static HttpSession connection;
	
	
	public static Logger logger=Logger.getLogger(VoiceAlert.class.getName());
	
	static Connection conn=null;

	@Autowired
	public void setConnection(HttpSession connec) {
		VoiceAlert.connection = connec;
	}

	

	public static  HashMap<String,String> getSubscription(String ani)
	{
		conn=(Connection)connection.getAttribute("active_connection");
		
		if(conn!=null)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");           
			SimpleDateFormat dbDateFmt=new  SimpleDateFormat("yyyy-MM-dd HH:mm");   
       
			HashMap<String, String> h =null;
			PreparedStatement ps =null; 
			ResultSet rs =null;
			String sql= null; /////////////////////////////VOICEALERT///////////////////
			try
			{
				sql= ConnectionFactory.getProperty("CHK_IBADAH_SUBS");
				ps = conn.prepareStatement(sql, 1004, 1007); 
				ps.setString(1, ani);
				rs= ps.executeQuery();
				while(rs.next())
				{
	                h =  new HashMap<String, String>();
	                String def_lang = rs.getString("def_lang");
	                if(rs.wasNull())
	                {
	                   def_lang="-";
	                }
	                String STATUS = rs.getString("STATUS");
	                if(rs.wasNull())
	                {
	                   STATUS="-";
	                }
	                else
	                {
	                   STATUS=ConnectionFactory.getProperty(STATUS);
	                }
	                String SUB_DATE =  rs.getString("SUB_DATE");                  
	                if(rs.wasNull())
	                {
	                   SUB_DATE="-";
	                }
	                else
	                {
	                	SUB_DATE= sdf.format(dbDateFmt.parse(rs.getString("SUB_DATE")));
	                }
	               
	                String RENEW_DATE =  rs.getString("RENEW_DATE");                  
	                if(rs.wasNull())
	                {
	                   RENEW_DATE="-";
	                }
	                else
	                {
	                	RENEW_DATE= sdf.format(dbDateFmt.parse(rs.getString("RENEW_DATE")));
	                }
	                String BILLING_DATE =  rs.getString("BILLING_DATE");                  
	                
	                if(rs.wasNull())
	                {
	                   BILLING_DATE="-";
	                }
	                else
	                {
	                	BILLING_DATE= sdf.format(dbDateFmt.parse(rs.getString("BILLING_DATE")));
	                }
	                String service_type = rs.getString("service_type");
	                
	                if(rs.wasNull())
	                {
	                   service_type="-";
	                }	
	               
	               String serviceTypeDesc=rs.getString("serviceTypeDesc");
	               if(rs.wasNull())
	               {
	                   serviceTypeDesc="-";
	               }
	               
	              /* String PACK_TYPE = rs.getString("PACK_TYPE");
	               if(rs.wasNull()){
	                  PACK_TYPE="-" ;
	               }*/
	               
	               String IN_MODE = rs.getString("MODE");
	               if(rs.wasNull())
	               {
	                   IN_MODE="-";
	               }
	               
	               String DAYS = rs.getString("DAYS");
	               if(rs.wasNull())
	               {
	                   DAYS="-";
	               }
	               
	               h.put("MOBILE_NUMBER", ani);
	               h.put("LANGUAGE", def_lang.toUpperCase());
	               h.put("STATUS", STATUS);
	               h.put("SUB_DATE", SUB_DATE);
	               h.put("RENEW_DATE", RENEW_DATE);
	               h.put("BILLING_DATE", BILLING_DATE);
	               h.put("PACK_TYPE",DAYS+" Days");
	               h.put("SERVICE_NAME", service_type.toUpperCase());
	               h.put("SERVICEDESCRIPTION", serviceTypeDesc.toUpperCase());
	               h.put("ACT_SOURCE", IN_MODE.toUpperCase());   
	               h.put("MAIN_SERVICE_NAME"," IBADAH");
				}
            
               
             ///////////////////////////  END VOICE AALERT/////////////////// 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return h;
		}
		else
		{
			logger.info("---Connection not estabished with Database---");
			return null;
		}
    }
	
	
	
	public static HashMap<String,String> fetchCustomerSummaryDetail(String ani) throws SQLException
	{
		conn=(Connection)connection.getAttribute("active_connection");
		HashMap<String, String> h =null;

		if(conn==null)
		{
			logger.info("---Connection not estabished with Database---");
		}
		
		else
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");           
		    SimpleDateFormat dbDateFmt=new  SimpleDateFormat("yyyy-MM-dd HH:mm");   
	        PreparedStatement pstmt=null;
	        

	        String prepStmtSql = ConnectionFactory.getProperty("IBADAH_SQL_BILLING_DETAILS");
	        logger.info("VA_SQL_BILLING_DETAILS::" + prepStmtSql);/*     */
	        ResultSet rs = null;
	        try
	        {
	        	pstmt = conn.prepareStatement(prepStmtSql);
	            pstmt.setString(1, ani);

	            rs = pstmt.executeQuery();
	            while (rs.next())
	            {
	            	h = new HashMap<String,String>();
	            	String STATUS = rs.getString("STATUS");
	            	if(rs.wasNull())
	            	{
	                   STATUS="-";
	            	}
	            	else
	            	{
	                   STATUS=ConnectionFactory.getProperty(STATUS);
	            	}
	                String SUB_DATE =  rs.getString("SUB_DATE");                  
	                if(rs.wasNull())
	                {
	                    SUB_DATE="-";
	                }
	                else
	                {
	                	SUB_DATE= sdf.format(dbDateFmt.parse(rs.getString("SUB_DATE")));
	                }                
	                String RENEW_DATE =  rs.getString("RENEW_DATE");                  
	                if(rs.wasNull())
	                {
	                    RENEW_DATE="-";
	                }
	                else
	                {
	                	RENEW_DATE= sdf.format(dbDateFmt.parse(rs.getString("RENEW_DATE")));
	                }
	                
	                String BILLING_DATE =  rs.getString("BILLING_DATE");                  
	                if(rs.wasNull())
	                {
	                    BILLING_DATE="-";
	                }
	                else
	                {
	                	BILLING_DATE= sdf.format(dbDateFmt.parse(rs.getString("BILLING_DATE")));
	                }
	                String PACK_TYPE = rs.getString("PACK_TYPE");
	                if(rs.wasNull())
	                {
	                   PACK_TYPE="-" ;
	                }
	                 
	               String AMOUNT= rs.getString("AMOUNT");
	                if(rs.wasNull())
	                {
	                    AMOUNT="-";
	                }
	                   
	                String ACT_SOURCE = rs.getString("ACT_SOURCE");
	                if(rs.wasNull())
	                {
	                       ACT_SOURCE="-";
	                }
	                   String SERVICE_TYPE = rs.getString("SERVICE_TYPE");
	                   if(rs.wasNull())
	                   {
	                       SERVICE_TYPE="-";
	                   }
	                   
	                   String PACK_VALIDITY= rs.getString("PACK_VALIDITY");
	                    if(rs.wasNull()){
	                        PACK_VALIDITY="-";
	                    }
	                String serviceTypeDesc=rs.getString("serviceTypeDesc");
	                if(rs.wasNull()){
	                    serviceTypeDesc="-";
	                }
	                
	                h.put("MOBILE_NUMER", ani);
	                h.put("SUB_DATE",SUB_DATE);
	                h.put("RENEW_DATE", RENEW_DATE);
	                h.put("BILLING_DATE",BILLING_DATE);
	                h.put("AMOUNT", AMOUNT);
	                h.put("SERVICE_TYPE", SERVICE_TYPE);
	                h.put("SERVICEDESCRIPTION", serviceTypeDesc.toUpperCase());
	                h.put("PACK_TYPE", PACK_TYPE);
	                h.put("ACT_SOURCE", ACT_SOURCE.toUpperCase());
	                h.put("PACK_VALIDITY", PACK_VALIDITY+" DAYS PACK");
	                h.put("MAIN_SERVICE_NAME"," IBADAH");
	             }

	         } 
	         catch (Exception e) 
	         {
	        	 logger.info("Error in Fetching Prepared Statement :" + e);

	         }
	 	}
		logger.info("value of h is "+h);
	    return h;
	}
	
	
	
	public static String unSubsCustomer(String mobileNo, String service_name)
	{
		conn=(Connection)connection.getAttribute("active_connection");
		String outpara="";	
		if(conn==null)
		{
			logger.info("---Connection not estabished with Database---");
		}
		else
		{
			logger.info("in Un SUBSCRIPTION  service_name ::: "+ service_name);
			CallableStatement callstmt = null;    
			
			try
			{
				logger.info("mobileNo = " + mobileNo);
				callstmt = conn.prepareCall("{call Devotional.DEVOTIONAL_IN(?,?,?,?,?,?,?)}");
				callstmt.setString(1, mobileNo.trim());                
				callstmt.setString(2, "e"); 
				callstmt.setString(3, "VA_SUB1");
				callstmt.setString(4, service_name);    
				callstmt.setString(5,"CCI");                
				callstmt.setInt(6, Integer.parseInt(ConnectionFactory.getProperty("VA_UNSUBS_PARA")));
				callstmt.registerOutParameter(7, 12);
				logger.info(" Devotional.DEVOTIONAL_IN " + callstmt.execute());
				outpara = callstmt.getString(7);
				logger.info("outpara :: " + outpara);
			}
			catch (Exception e)
			{
				logger.info("Exception occured in registering " + e);
				outpara ="100";
			} 
			finally 
			{
				try 
				{
					callstmt.close();
				}
				catch (Exception e) 
				{
				}
			}
		}
		return outpara;
	}
	
	public static ArrayList <HashMap<String,String>> getUnSubscriptionData(String ani)
	{
		conn=(Connection)connection.getAttribute("active_connection");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");           
		SimpleDateFormat dbDateFmt=new  SimpleDateFormat("yyyy-MM-dd HH:mm");   
		ArrayList <HashMap<String,String>>  list = new   ArrayList <HashMap<String,String>> ();
		HashMap<String, String> h = null;
		PreparedStatement ps =null; 
		ResultSet rs =null;
		String sql= null;
		
		if(conn==null)
		{
			logger.info("---Connection not estabished with Database---");
		}
		
		else
		{
			try 
			{
				sql= ConnectionFactory.getProperty("CHK_IBADAH_UNSUBS");
				logger.info("CHK_IBADAH_UNSUBS:: "+ sql);
	            ps = conn.prepareStatement(sql, 1004, 1007); 
	            ps.setString(1, ani);
	            rs= ps.executeQuery();
             
	            while(rs.next())
	            {
	            	logger.info("IBADAH  EXECUTED::::");
	            	h = new HashMap<String, String>();
	            	String LANGUAGE = rs.getString("LANGUAGE");
	            	if(rs.wasNull())
	            	{
	            		LANGUAGE="-";
	            	}            
	            	String STATUS = rs.getString("STATUS");
	            	if(rs.wasNull())
	            	{
	            		STATUS="-";
	            	}
	            	else
	            	{
	            		STATUS=ConnectionFactory.getProperty(STATUS);
	            	}
	            	String SUB_DATE =  rs.getString("SUB_DATE");                  
	            	if(rs.wasNull())
	            	{
	            		SUB_DATE="-";
	            	}
	            	else
	            	{                 
	            		SUB_DATE= sdf.format(dbDateFmt.parse(rs.getString("SUB_DATE")));
	            	}
                
	            	String RENEW_DATE =  rs.getString("RENEW_DATE");                  
	                if(rs.wasNull())
	                {
	                    RENEW_DATE="-";
	                }
	                else
	                {
	                    RENEW_DATE= sdf.format(dbDateFmt.parse(rs.getString("RENEW_DATE")));       
	                }
	                
	                String BILLING_DATE =  rs.getString("BILLING_DATE");                  
	                if(rs.wasNull())
	                {
	                    BILLING_DATE="-";
	                }
	                else
	                {
	                    BILLING_DATE= sdf.format(dbDateFmt.parse(rs.getString("BILLING_DATE")));              
	                }
                
	                String UNSUB_DATE = rs.getString("UNSUB_DATE");
	                if(rs.wasNull())
	                {
	                    UNSUB_DATE="-";
	                }
	                else
	                {
	                    UNSUB_DATE= sdf.format(dbDateFmt.parse(rs.getString("UNSUB_DATE")));                           
	                }
	                 
	                String AMOUNT= rs.getString("AMOUNT");
	                if(rs.wasNull())
	                {
	                    AMOUNT="-";
	                }
	                
	                String ACT_SOURCE = rs.getString("ACT_SOURCE");
	                if(rs.wasNull())
	                {
	                    ACT_SOURCE="-";
	                }                                                
	                
	                String DAYS = rs.getString("DAYS");
	                if(rs.wasNull())
	                {
	                    DAYS="-";
	                }
	                
	                String UNSUB_SOURCE = rs.getString("UNSUB_SOURCE");
	                if(rs.wasNull())
	                {
	                    UNSUB_SOURCE="NA";
	                }
	                
	                h.put("MOBILE_NUMBER",ani);
	                h.put("LANGUAGE",LANGUAGE);  
	                h.put("STATUS",STATUS);         
	                h.put("AMOUNT",AMOUNT);
	                h.put("SUB_DATE",SUB_DATE);       
	                h.put("RENEW_DATE",RENEW_DATE);     
	                h.put("BILLING_DATE",BILLING_DATE);  
	                h.put("UNSUB_DATE",UNSUB_DATE);  
	                
	                h.put("PACK_TYPE",DAYS+" Days");      
	                h.put("ACT_SOURCE",ACT_SOURCE);     
	                h.put("SERVICE_NAME", "IBADAH");
	                h.put("SERVICEDESCRIPTION", "");
	                h.put("UNSUB_SOURCE", UNSUB_SOURCE);
	                h.put("MAIN_SERVICE_NAME","IBADAH");   
	                list.add(h);
	            }
	            rs.close();
	            ps.close();
            } 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
        return list;
	}

	
	public static String subsCustomer(String mobileNo, String service_name, String packType)
	{
		CallableStatement callstmt = null;    
		String outpara="";
		conn=(Connection)connection.getAttribute("active_connection");
		
		logger.info("Connection in VoiceAlert "+conn);
		if(conn!=null)
		{
			try
			{
				logger.info("mobileNo = " + mobileNo);
				callstmt = conn.prepareCall("{call Devotional.DEVOTIONAL_IN(?,?,?,?,?,?,?)}");
				callstmt.setString(1, mobileNo.trim());                
				callstmt.setString(2, "e"); 
				callstmt.setString(3, packType);  // pack 
				callstmt.setString(4, "ISLAMIC");      // service
				callstmt.setString(5,"CCI");                
				callstmt.setInt(6, Integer.parseInt(ConnectionFactory.getProperty("VA_SUBS_PARA")));
				callstmt.registerOutParameter(7, 12);
				logger.info(" Devotional DEVOTIONAL_IN PROCEDURE " + callstmt.execute());
				outpara = callstmt.getString(7);
				logger.info("outpara :: " + outpara);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				outpara ="100";
			} 
			finally
			{
				try
				{
					callstmt.close();
				}
				catch (Exception e) {
				}
			}
		}
		return outpara;
	}
 
	

}
