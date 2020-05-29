package com.digispice.indosat.daoImpl;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digispice.indosat.connection.ConnectionFactory;


@Repository
@Transactional
public class Ms
{
	public static Logger logger=Logger.getLogger(Ms.class.getName());
	
	static HttpSession connection;
	
	static Connection con=null;

	@Autowired
	public void setCon(HttpSession con) 
	{
		Ms.connection= con;
	}


    public static HashMap<String,String> getSubscription(Connection conn, String ani)
    {
    	con=(Connection)connection.getAttribute("active_connection");
    	HashMap<String, String> h = null;
    	
    	if(con==null)
		{
    		logger.info("---Connection not established with Database---");
		}
    	else
		{
    		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");           
		 	//SimpleDateFormat dbDateFmt=new  SimpleDateFormat("yyyy-MM-dd HH:mm");  
		 	PreparedStatement ps =null; 
		 	ResultSet rs =null;
		 	String sql= null;
		 	try
		 	{
		 		sql= ConnectionFactory.getProperty("CHK_MS_SUBS");
		 		ps = conn.prepareStatement(sql, 1004, 1007); 
		 		ps.setString(1, ani);
		 		rs= ps.executeQuery();
                while (rs.next()) 
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
                    	SUB_DATE= sdf.format(rs.getDate("SUB_DATE"));
                    }
                
                    String RENEW_DATE =  rs.getString("RENEW_DATE");                  
                    if(rs.wasNull())
                    {
                    	RENEW_DATE="-";
                    }
                    else
                    {
                    	RENEW_DATE= sdf.format(rs.getDate("RENEW_DATE"));                 
                    }
                
                    String BILLING_DATE =  rs.getString("BILLING_DATE");                  
                    if(rs.wasNull())
                    {
                    	BILLING_DATE="-";
                    }
                    else
                    {
                    	BILLING_DATE= sdf.format(rs.getDate("BILLING_DATE"));                 
                    }
                
                    String AMOUNT= rs.getString("AMOUNT");
                    if(rs.wasNull())
                    {
                    	AMOUNT="-";
                    }
                          
                    /*String PACK_TYPE = rs.getString("PACK_TYPE");
                    if(rs.wasNull())
                    {
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
	                h.put("SERVICE_NAME", "MUSIC SCORER");
	                h.put("SERVICEDESCRIPTION", "");
	                h.put("MAIN_SERVICE_NAME","MUSIC SCORER");   
                
                }
              
		 	}
		 	catch(Exception e)  
		 	{
		 		e.printStackTrace();
		 	}
		}
        return h;
    }
    
    
    public static String subsCustomer(Connection conn, String mobileNo )
    {
    	con=(Connection)connection.getAttribute("active_connection");
        CallableStatement callstmt = null;    
        String outpara="";
    	
        if(con==null)
		{
    		logger.info("---Connection not established with Database---");
		}
    	else
		{
    		try
    		{
    			logger.info("mobileNo = " + mobileNo);
    			callstmt = conn.prepareCall("{call MSCORER..PROC_MSCORER_SUBS(?,?,?,?,?,?,?,?,?)}");
    			callstmt.setString(1, mobileNo);
    			callstmt.setString(2, "e");
    			callstmt.setInt(3, 1);
    			callstmt.setString(4, "MS_SUB1");
    			callstmt.setString(5, "CCI");
    			callstmt.setString(6, "CCI");
    			callstmt.setInt(7, 1234567890);
    			callstmt.setInt(8, 2);
    			callstmt.registerOutParameter(9, 12);
    			logger.info(" MS SUBS:: PROC_MSCORER_SUBS " + callstmt.execute());
    			outpara = callstmt.getString(9);
    			logger.info("outpara :: " + outpara);
    		}
    		catch(Exception e)
    		{
    			logger.info("Exception occured in registering " + e);
    			outpara ="100";
    		}
		}
        return outpara;
    }
    
	
	public static String unSubsCustomer(String mobileNo)
	   {
		   String outpara = null;
		   CallableStatement  callstmt = null;
		   
		   con=(Connection)connection.getAttribute("active_connection");
		   
		   if(con==null)
		   {
			   logger.info("---Connection not established with Database---");
		   }
		   else
		   {
			   try
			   {
				   System.out.println("mobileNo = " + mobileNo);
				   callstmt = con.prepareCall("{call MSCORER..PROC_MSCORER_SUBS(?,?,?,?,?,?,?,?,?)}");
				   callstmt.setString(1, mobileNo);
				   callstmt.setString(2, "e");
				   callstmt.setInt(3, 1);
				   callstmt.setString(4, "");
				   callstmt.setString(5, "CCI");
				   callstmt.setString(6, "CCI");
				   callstmt.setInt(7, 1234567890);
				   callstmt.setInt(8, 3);
				   callstmt.registerOutParameter(9, 12);
				   System.out.println(" MS UNSUBS:: PROC_MSCORER_SUBS " + callstmt.execute());
				   outpara = callstmt.getString(9);
				   System.out.println("outpara :: " + outpara); 
			   }
			   catch (Exception e)
			   {
				   System.out.println("Exception occured in registering " + e);
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
	
	
	
	public static  HashMap<String,String>  fetchBillingDetail(Connection conn, String ani)
	{
		   con=(Connection)connection.getAttribute("active_connection");
		   
		   HashMap<String, String> h = null;
		   
		   if(con==null)
		   {
			   logger.info("---Connection not established with Database---");
		   }
		   else
		   {
			   SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
			   SimpleDateFormat dbDateFmt=new  SimpleDateFormat("yyyy-MM-dd HH:mm");   
   	 
			   String prepStmtSql = ConnectionFactory.getProperty("MS_SQL_BILLING_DETAILS");
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
					   if(rs.wasNull()){
                       PACK_VALIDITY="-";
					   }
               
                   
		                h.put("MOBILE_NUMER", ani);
		                h.put("SUB_DATE", SUB_DATE);
		                h.put("RENEW_DATE",RENEW_DATE);
		                h.put("BILLING_DATE", BILLING_DATE);
		                h.put("PACK_TYPE", PACK_TYPE);
		                h.put("ACT_SOURCE", ACT_SOURCE);
		                h.put("AMOUNT", AMOUNT);
		                h.put("PACK_VALIDITY", PACK_VALIDITY+" DAYS PACK");
		                h.put("MAIN_SERVICE_NAME","MUSIC SCORER");   
		                h.put("SERVICEDESCRIPTION", "MUSIC SCORER");   
				   	}
			   } 
			   catch (Exception e)
			   {
				   logger.info("Error in Fetching Prepared Statement :" + e);
			   }
		  }
		  return h;
	}
}
