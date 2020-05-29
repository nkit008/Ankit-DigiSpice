package com.digispice.indosat.daoImpl;

import java.sql.Connection;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.digispice.indosat.connection.ConnectionFactory;
import com.digispice.indosat.dao.CheckSubscriptionDao;


@Repository
@Transactional
public class CheckSubscriptionDaoImpl implements CheckSubscriptionDao{
	
	@Autowired
	HttpSession session;
	
	public static Logger logger=Logger.getLogger(CheckSubscriptionDaoImpl.class.getName());
	
	Connection con=null;
	
	
	@Override
	public ArrayList<HashMap<String,String>> getSubscription(String mobile)
	{
		con=(Connection)session.getAttribute("active_connection");
		
		if(con==null)
		{
			logger.info("---connection is not established with database---");
			return null;
		}
			
		else
		{
			ArrayList<HashMap<String,String>>  list = new ArrayList<HashMap<String, String>>();
			
			try
			{
				if(Kleek.getSubscription(mobile)!=null )
				{
	                list.add( Kleek.getSubscription(mobile));            
				}
				
				/*if(Ms.getSubscription(ani) !=null)   
				{
	               list.add(Ms.getSubscription(ani));
	           	}*/
				
				if(VoiceAlert.getSubscription(mobile)!=null)    
				{
					list.add(VoiceAlert.getSubscription(mobile));
				}
			
			}
			
			catch(Exception e)
			{
				logger.info(e);
			}
			
			return list;
		}
	}
	
	
	@Override
	public ArrayList<HashMap<String,String>> getBillingDetails(String ani)
	{
		con=(Connection)session.getAttribute("active_connection");
		ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		
		if(con==null)
		{
			logger.info("---connection is not established with database---");
			return null;
		}
			
		else
		{
			try
	        {
	           if(Kleek.fetchBillingDetail(ani)!=null )
	           {                
	                    list.add(Kleek.fetchBillingDetail(ani));
	           }
	           else if(VoiceAlert.fetchCustomerSummaryDetail(ani)!=null )
	           {
	                logger.info("IN IBADAH BILLING DETAILS *********************");
	                list.add(VoiceAlert.fetchCustomerSummaryDetail(ani));
	            }
	        }
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
		}
        return list;
    }
	
	
	@Override
	public String doUnsubscribe(String ani , String MainService, String service)
	{
        logger.info( "UNSUB DETAILS in DAO ::  ANI  "+ ani +"MAIN SERVICE :  "+ MainService +"  service "+ service );        
	    String outpara ="";
	    if(MainService.equals("IBADAH"))
	    {
	       logger.info("IN IBADAH");
	       outpara= VoiceAlert.unSubsCustomer(ani, service);
	    }
	    else if(MainService.equals("MUSIC SCORER"))
	    {
	       logger.info(" in MS");
	       outpara=Ms.unSubsCustomer(ani);
	    }
	    else if(MainService.equals("INDOMUSIK"))
	    {
	    	logger.info(" in INDOMUSIK");
	    	outpara = Kleek.unSubsCustomer(ani);
	     }
	    else  if(MainService.equals("VOICE CHAT"))
	    {
	    	logger.info(" in VOICE CHAT");
	    	outpara = VoiceChat.unSubsCustomer(ani);
	     }
	       
	     return outpara;
	}
	
	
	@Override
	public HashMap<String, String> showPackTypeDetails(String service_name)
	{
		con=(Connection)session.getAttribute("active_connection");
		HashMap<String, String> packMap=new HashMap<String, String>();
		String sql=null;
		if(con==null)
		{
			logger.info("---connection is not established with database---");
			return null;
		}
		
		else
		{
			if(service_name.equalsIgnoreCase("Indomusik"))
			{
				sql= ConnectionFactory.getProperty("GET_MOD_PACKS");
				logger.info("Query for Service "+service_name+" is "+sql);
			}
		     
			if(service_name.equalsIgnoreCase("IBADAH"))
			{
				sql= ConnectionFactory.getProperty("GET_IBADAH_PACKS");
				logger.info("Query for Service "+service_name+" is "+sql);
			}
			
			PreparedStatement ps = null;
			ResultSet rs =null;
        
			try 
			{
	            ps = con.prepareStatement(sql);
	            rs= ps.executeQuery();
	            while (rs.next()) 
	            {
	                String key=rs.getString("SERVICE_NAME_KEY");
	                if(rs.wasNull()){
	                    key="-";
	                }
	                
	                 String value=rs.getString("FULL_SERVICE_NAME");
	                if(rs.wasNull()){
	                    value="-";
	                }                 
	                packMap.put(key, value);                 
	            }
            
			} 
			catch (Exception e) 
			{
				logger.info(e);
			}
			System.out.println(packMap);
			return packMap;
		}
		
	}
	
	
	@Override
	public String goSubscription(String mobile,String service_name,String cat,String packType)
	{
		con=(Connection)session.getAttribute("active_connection");
		String out="";

		if(con==null)
		{
			logger.info("---connection is not established with database---");
			return null;
		}
		
		else
		{
			if(service_name.equalsIgnoreCase("IBADAH"))
				{
					out = VoiceAlert.subsCustomer(mobile,cat,packType);
				}
				else  if(service_name.equalsIgnoreCase("INDOMUSIK") )
				{
					out= Kleek.subsCustomer(mobile, packType);
					logger.info("Output paramter for Kleek.subsCustomer() is "+out);	
				}
		}
		
		return out;
	}
	
	@Override
	public ArrayList<HashMap<String,String>> getUnSubscriptionDetails(String ani)
	{
		ArrayList<HashMap<String,String>>  list = new ArrayList<HashMap<String, String>>();
		
		try{
            if(Kleek.getUnSubscriptionData(ani)!=null )
            {  
                list.addAll(Kleek.getUnSubscriptionData(ani));
            }
          
//          if(MS.getSubscription(ani)!=null)
//          {
//               list.add(MS.getSubscription(ani));
//          }
           
            if(VoiceAlert.getUnSubscriptionData(ani) !=null)    
            {
                list.addAll(VoiceAlert.getUnSubscriptionData(ani));
            }

//           if(VoiceChat.getSubsscription(ani) !=null)  
//           {
//               list.add(VoiceChat.getSubscription(ani));  
//           }
//                  
        } 
		catch (Exception e)
		{
            logger.info(e);
        }
        return list;
    }
	
	
	public ResultSet getMISSummaryData(String fromDate, String toDate)
	{
        ResultSet rs = null;
        PreparedStatement ps = null;
        DatabaseMetaData meta=null;
        
		con=(Connection)session.getAttribute("active_connection");

		if(con==null)
		{
			logger.info("---connection is not established with database---");
			return null;
		}
		
		else
		{
			
			try
			{
				meta=con.getMetaData();
				
				if(meta.getDatabaseProductName().equalsIgnoreCase("Microsoft SQL Server")) 
				{
					ps = con.prepareStatement(ConnectionFactory.getProperty("SQL_DetailedMIS_getMISSummaryData"), 1004, 1007);
	            }
				else if(meta.getDatabaseProductName().equalsIgnoreCase("Oracle"))
				{
					ps = con.prepareStatement(ConnectionFactory.getProperty("ORACLE_DetailedMIS_getMISSummaryData"), 1004, 1007);
				}
				else if(meta.getDatabaseProductName().equalsIgnoreCase("MySQL"))
				{
					ps = con.prepareStatement(ConnectionFactory.getProperty("MySQL_DetailedMIS_getMISSummaryData"), 1004, 1007);
	            }
	            
				ps.setString(1, fromDate);
	            ps.setString(2, toDate);
	            logger.info("FROM DATE :: [" + fromDate+"] and ToDate is  ["+toDate+"]");
	            rs = ps.executeQuery();
	         } 
			catch (Exception e)
			{
	            logger.info("Exception in  getMISSummaryData " + e.getMessage());
	        }
		}
			
		return rs;
        
	}
	
		
}
