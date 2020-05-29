package com.digispice.indosat.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class VoiceChat {
	
	public static Logger logger=Logger.getLogger(Kleek.class.getName());
	
	static HttpSession connection;
	static Connection conn=null;
	
	@Autowired
	public static void setConnection(HttpSession connection) {
		VoiceChat.connection = connection;
	}


	
	
    public static  HashMap<String,String>  getSubscription(Connection conn, String CISUBani) throws SQLException
    {
    	conn=(Connection)connection.getAttribute("active_connection");
    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");           
        SimpleDateFormat dbDateFmt=new  SimpleDateFormat("yyyy-MM-dd HH:mm");   
        HashMap<String,String> h = null;
        String prepStmtSql = ConnectionFactory.getProperty("CHK_VC_SUBS");
        String prepStmtSql1 = ConnectionFactory.getProperty("CHK_VC_RESUBS");
        logger.info("VC query::" + prepStmtSql);
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        ResultSet rs = null;
        ResultSet rs1 = null; 
        String gender,age;
        
        if(conn==null)
        {
        	logger.info("--Connection is not established with database");
        }
        else
        {
        	try
        	{
        		pstmt = conn.prepareStatement(prepStmtSql, 1004, 1007);
        		pstmt1 = conn.prepareStatement(prepStmtSql1, 1004, 1007);   
        		pstmt.setString(1, CISUBani);
        		pstmt1.setString(1, CISUBani);
        		rs = pstmt.executeQuery();
              	rs1= pstmt1.executeQuery();   
              	if (!rs.next())
              	{
              		pstmt.close();
              		rs.close();
              		logger.info("<<<<<<<<<<<<<<<<<<<There is no data in VC SUBS>>>>>>>>>>>>>>>>>>>>>>");
              		logger.info("VC query::" + prepStmtSql1);
              		rs = pstmt1.executeQuery();
              	}
              	else
				{
              		rs.previous();
				}
              	while (rs.next())
              	{
              		h = new HashMap();
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
                       
              		String PACK_TYPE = rs.getString("PACK_TYPE");
              		if(rs.wasNull())
              		{
              			PACK_TYPE="-" ;
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
                   
              		h.put("MOBILE_NUMBER",CISUBani);
              		h.put("LANGUAGE",LANGUAGE);
              		h.put("STATUS",STATUS);
              		h.put("SUB_DATE", SUB_DATE);
              		h.put("RENEW_DATE", RENEW_DATE);
              		h.put("PACK_TYPE", PACK_TYPE);
              		h.put("BILLING_DATE", BILLING_DATE);
              		h.put("ACT_SOURCE", ACT_SOURCE);
              		h.put("AMOUNT", AMOUNT);
              		h.put("SERVICE_NAME","VOICE CHAT");
              		h.put("MAIN_SERVICE_NAME","VOICE CHAT");   
              	}
        	} 
        	catch (Exception e) 
        	{
        		e.printStackTrace();
        		System.out.println("Error in Fetching Prepared Statement :" + e);
        	}
        }
        return h;
    }
	
	
    public static HashMap<String,String>  fetchCustomerSummaryDetail(Connection conn, String ani) throws SQLException
    {
    	HashMap<String, String> h = null;
    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");           
    	SimpleDateFormat dbDateFmt=new  SimpleDateFormat("yyyy-MM-dd HH:mm");   
    	String prepStmtSql = ConnectionFactory.getProperty("MOD_SQL_BILLING_DETAILS");
    	PreparedStatement pstmt=null;
    	logger.info("query::"+prepStmtSql);
    	ResultSet rs = null;
    	
    	if(conn==null)
        {
        	logger.info("--Connection is not established with database");
        }
        else
        {
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
                        
                    String DAYS = rs.getString("DAYS");
                    if(rs.wasNull())
                    {
                    	DAYS="-";
                    }
                    
                    h.put("MOBILE_NUMER", ani);
                    h.put("SUB_DATE", SUB_DATE);
                    h.put("RENEW_DATE",RENEW_DATE);
                    h.put("BILLING_DATE", BILLING_DATE);
                    h.put("PACK_TYPE", PACK_TYPE);
                    h.put("ACT_SOURCE", ACT_SOURCE);
                    h.put("AMOUNT", AMOUNT);
                    h.put("SERVICE_TYPE", "VOICE CHAT");
                    h.put("SERVICEDESCRIPTION", "VOICE CHAT");
                    h.put("PACK_TYPE",DAYS+" Days");
                    h.put("SERVICEDESCRIPTION", "VOICE CHAT");   
                    
                    h.put("PACK_VALIDITY", PACK_VALIDITY+" DAYS PACK");
                    h.put("SERVICE_NAME","VOICE CHAT");
                    h.put("MAIN_SERVICE_NAME","VOICE CHAT");   
                }
            } 
        	catch (Exception e) 
        	{
        		logger.info("Error in Fetching Prepared Statement :" + e);
        	}
        }
    	return h;
    }
	
	public static String unSubsCustomer(String mobileNo)
	{
		CallableStatement callstmt = null;    
		String outpara="";
		
		conn=(Connection)connection.getAttribute("active_connection");
		
		if(conn==null)
		{
			logger.info("--Connection is not established with database");
		}
		else
		{
			try
			{
				System.out.println("mobileNo = " + mobileNo);
				callstmt = conn.prepareCall("{call VoiceChat..VCHAT_SUB_CCI(?,?,?,?,?,?,?)}");
				callstmt.setString(1, mobileNo);
				callstmt.setString(2, "f");
				callstmt.setString(3, "0");
				callstmt.setString(4, "VC_SUB1");
				callstmt.setString(5, "CCI");
				callstmt.setInt(6, 2);
				callstmt.registerOutParameter(7, 12);
				System.out.println("VOICE CHAT:: SUBS " + callstmt.execute());
				outpara = callstmt.getString(7);
				System.out.println("outpara :: " + outpara);
			}
			catch(Exception e)
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
	
	
	
    public static String subsCustomer(Connection conn, String mobileNo)
    {
    	CallableStatement    callstmt = null;    
        String outpara="";
  		conn=(Connection)connection.getAttribute("active_connection");
		
  		if(conn==null)
  		{
  			logger.info("--Connection is not established with database");
  		}
  		else
  		{
  			try
  			{
  				logger.info("mobileNo = " + mobileNo);
  				callstmt = conn.prepareCall("{call VoiceChat..VCHAT_SUB_CCI(?,?,?,?,?,?,?)}");
  				callstmt.setString(1, mobileNo);
  				callstmt.setString(2, "e");
  				callstmt.setString(3, "0");
  				callstmt.setString(4, "VC_SUB1");
  				callstmt.setString(5, "CCI");
  				callstmt.setInt(6, 1);
  				callstmt.registerOutParameter(7, 12);
  				logger.info("VOICE CHAT:: SUBS " + callstmt.execute());
  				outpara = callstmt.getString(7);
  				logger.info("outpara :: " + outpara);
  			}
  			catch (Exception e)
  			{
  				outpara ="100";
  				e.printStackTrace();
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
                     e.printStackTrace();
  				}
  			}
  		}
  		return outpara;
    }
	
	

}
