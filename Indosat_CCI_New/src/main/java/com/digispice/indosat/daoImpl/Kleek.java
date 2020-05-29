package com.digispice.indosat.daoImpl;

import java.sql.CallableStatement;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class Kleek {
	
	private static HttpSession connection;
	
	public static Logger logger=Logger.getLogger(Kleek.class.getName());
	
	static Connection conn=null;
	
	@Autowired
	public void setConnection(HttpSession connection) {
		Kleek.connection = connection;
	}


	public static HashMap<String,String> getSubscription(String ani)
    {
    	conn=(Connection)connection.getAttribute("active_connection");
    	HashMap<String, String> h = null;
    	
    	if(conn!=null)
    	{
    		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");           
            SimpleDateFormat dbDateFmt=new  SimpleDateFormat("yyyy-MM-dd HH:mm");   
        
            
            PreparedStatement ps =null; 
            ResultSet rs =null;
            String sql= null;
            try 
            {
            	sql= ConnectionFactory.getProperty("CHK_MOD_SUBS");
            	ps = conn.prepareStatement(sql, 1004, 1007); 
            	ps.setString(1, ani);
            	rs= ps.executeQuery();

	             while(rs.next())
	             {
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
	                
	                 String AMOUNT= rs.getString("AMOUNT");
	                 if(rs.wasNull())
	                 {
	                	 AMOUNT="-";
	                 }
	                          
	               /* String PACK_TYPE = rs.getString("PACK_TYPE");
	                if(rs.wasNull()){
	                   PACK_TYPE="-" ;
	                }
	                */
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
	                  
	                
	                h.put("MOBILE_NUMBER",ani);
	                h.put("LANGUAGE",LANGUAGE);  
	                h.put("STATUS",STATUS);         
	                h.put("AMOUNT",AMOUNT);
	                h.put("SUB_DATE",SUB_DATE);       
	                h.put("RENEW_DATE",RENEW_DATE);     
	                h.put("BILLING_DATE",BILLING_DATE);  
	                h.put("PACK_TYPE",DAYS+" Days");      
	                h.put("ACT_SOURCE",ACT_SOURCE);     
	                h.put("SERVICE_NAME", "INDOMUSIK");
	                h.put("SERVICEDESCRIPTION", "");
	                h.put("MAIN_SERVICE_NAME","INDOMUSIK");   
	
	             }
	             rs.close();
	             ps.close();
              /////////////////// END MOD //////////////////////
              }
            catch (Exception e)
            {
            	logger.info(e);
            }
            
         }
    	
    	else
    	{
    		logger.info("---Connection is not Established with database");
    	}
    	return h;
    }
    
    
    
    public static HashMap<String,String> fetchBillingDetail(String ani)
    {
    	conn=(Connection)connection.getAttribute("active_connection");
    	HashMap<String, String> h = null;
    	
    	if(conn!=null)
    	{
   	 		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");           
   	 		SimpleDateFormat dbDateFmt=new  SimpleDateFormat("yyyy-MM-dd HH:mm");   
   	 
   	 		String prepStmtSql = ConnectionFactory.getProperty("MOD_SQL_BILLING_DETAILS");/*     */
   	 		PreparedStatement pstmt=null;
   	 		logger.info("query::"+prepStmtSql);

   	 		ResultSet rs = null;
   	 		try
   	 		{
   	 			pstmt = conn.prepareStatement(prepStmtSql);
   	 			pstmt.setString(1, ani);
   	 			rs = pstmt.executeQuery();


   	 			while (rs.next()) 
   	 			{            	 
   	 				h = new HashMap<String, String>();                 
   	 				
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
   	 				
   	 				String PACK_TYPE = rs.getString("SERVICETYPEDESC");
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
	                
   	 				String PACK_VALIDITY= rs.getString("PACK_VALIDITY");
   	 				if(rs.wasNull())
   	 				{
                       PACK_VALIDITY="-";
   	 				}
	               
	                   
	                h.put("MOBILE_NUMER", ani);
	                h.put("SUB_DATE", SUB_DATE);
	                h.put("RENEW_DATE",RENEW_DATE);
	                h.put("BILLING_DATE", BILLING_DATE);
	                h.put("PACK_TYPE", PACK_TYPE);
	                h.put("ACT_SOURCE", ACT_SOURCE);
	                h.put("AMOUNT", AMOUNT);
	                h.put("SERVICE_TYPE", "INDOMUSIK");
	                h.put("SERVICEDESCRIPTION", "INDOMUSIK");
	                h.put("PACK_TYPE", PACK_TYPE);
	                h.put("SERVICEDESCRIPTION", "INDOMUSIK");   
	                h.put("MAIN_SERVICE_NAME","INDOMUSIK"); 
	                h.put("PACK_VALIDITY", PACK_VALIDITY+" DAYS PACK");
   	 			}
            
   	 		} 
   	 		catch (Exception e)
   	 		{
   	 			logger.info("Error in Fetching Prepared Statement :" + e);
            }
   	 		
     	}
    	
    	else
    	{
    		logger.info("---Connection is not established with Database--");
    	}
    	
    	return h;
    }
    
    
    public  static String unSubsCustomer(String mobileNo )
    {
        CallableStatement callstmt = null;    
        String outpara="";
        
        conn=(Connection)connection.getAttribute("active_connection");
        
        if(conn==null)
        {
        	logger.info("---Connection is not established with Database---");
        }
        else
        {
        	try 
        	{
        		logger.info("mobileNo = " + mobileNo);
        		callstmt = conn.prepareCall("{call mobile_radio.radio_subs(?,?,?,?,?,?,?,?)}");//current_date in format : 2/21/2009 1:09:30 PM
        		callstmt.setString(1, mobileNo);            
        		callstmt.setInt(2, 0);            
        		callstmt.setString(3, "MR_SUB1");//Pack_type             
        		callstmt.setString(4, "e");//IN_DEACT_REASON
        		callstmt.setString(5, "CCI");//Act_source
        		callstmt.setString(6, "CCI");//De act
        		callstmt.setInt(7, 3);           
        		callstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
        		logger.info("MOD UNSUB :: RADIO_SUBS  " + callstmt.execute()); 
        		outpara = callstmt.getString(8);
        		logger.info("outpara :: " + outpara);
        	} 
        	catch (Exception e)
        	{
        		outpara ="100";
        		logger.info("Exception occured in registering " + e);
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
        
    	ArrayList <HashMap<String,String>>  list = new   ArrayList <HashMap<String,String>> ();
        if(conn==null)
        {
        	logger.info("---Connection is not established with Database---");
        }
        else
        {
        	SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");           
            SimpleDateFormat dbDateFmt=new  SimpleDateFormat("yyyy-MM-dd HH:mm");   
            
            HashMap<String, String> h = null;
            PreparedStatement ps =null; 
            ResultSet rs =null;
            String sql= null;
            try
            {
            	sql= ConnectionFactory.getProperty("CHK_MOD_UNSUBS");
            	logger.info("CHK_MOD_UNSUBS:: "+ sql);
            	ps = conn.prepareStatement(sql, 1004, 1007); 
            	ps.setString(1, ani);
            	rs= ps.executeQuery();
             
            	while(rs.next())
            	{
            		logger.info("CHK_MOD_UNSUBS EXECUTED::::");
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
	                h.put("SERVICE_NAME", "INDOMUSIK");
	                h.put("SERVICEDESCRIPTION", "");
	                h.put("UNSUB_SOURCE", UNSUB_SOURCE);
	                h.put("MAIN_SERVICE_NAME","INDOMUSIK");   
	                list.add(h);
            	}
            	rs.close();
            	ps.close();
              /////////////////// END MOD //////////////////////
               
              
            
            }
            catch (Exception e) 
            {
            	e.printStackTrace();
            }
       }
       return list;
    }
    
    
    public  static String subsCustomer(String mobileNo, String packType) 
    {
    	CallableStatement callstmt = null;    
        String outpara="";
        
        conn=(Connection)connection.getAttribute("active_connection");
        
        if(conn==null)
        {
        	logger.info("---Connection is not established with Database---");
        }
        
        else
        {
        	try
        	{
        		logger.info("subsCustomer mobileNo = " + mobileNo + "PACK :: "+ packType);
        		callstmt = conn.prepareCall("{call mobile_radio.radio_subs(?,?,?,?,?,?,?,?)}");//current_date in format : 2/21/2009 1:09:30 PM
		        callstmt.setString(1, mobileNo);            
		        callstmt.setInt(2, 0);            
		        callstmt.setString(3, packType);//Pack_type             
		        callstmt.setString(4, "e");//IN_DEACT_REASON
		        callstmt.setString(5, "CCI");//Act_source
		        callstmt.setString(6, "CCI");//De act
		        callstmt.setInt(7, 1);           
		        callstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
		        logger.info("MOD UNSUB :: RADIO_SUBS  " + callstmt.execute());       
		        logger.info("outpara :: " + outpara);
	            
        	}
        	catch (Exception e) 
        	{
        		outpara ="100";
        		logger.info("Exception occured in registering " + e);
        	}
           
       }
       return outpara;
   }

}
