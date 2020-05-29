package com.nxcelcrbt.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

public class InsertBatchCalllog{	
	
	public static Logger logger=Logger.getLogger(InsertBatchCalllog.class.getName());
	
		public static void main(String[] args) {
		
			logger.info("\r\nStart Time of Program is "+Calendar.getInstance().getTime());
		
		if (args.length > 0)
		{
			
			ToneLog tplog=new ToneLog(Integer.parseInt(args[0]));
			tplog.start();
			
			CallLog callog=new CallLog(Integer.parseInt(args[0]));
			callog.start();
			
			for(;;)
			{
				if(tplog.isAlive()==false && callog.isAlive()==false)
				{
					logger.info("End Time of Program is "+Calendar.getInstance().getTime());
					break;
				}
			}
		}
			
		else
		{
			ToneLog tplog=new ToneLog(1);
			tplog.start();
			
			
			CallLog callog=new CallLog(1);
			callog.start();
			
			for(;;)
			{
				if(tplog.isAlive()==false && callog.isAlive()==false)
				{
					logger.info("End Time of Program is "+Calendar.getInstance().getTime());
					break;
				}
			}
			
		}
		
		
		
			
	}
	
	
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Properties prop=new Properties();
			InputStream is=new FileInputStream("db.properties");
			prop.load(is);
			String driver=prop.getProperty("jdbc.driver");
			
			if(driver != null)
			{
				Class.forName(driver);
			}

			String url=prop.getProperty("jdbc.url");
			String user=prop.getProperty("jdbc.username");
			String dbpassword=prop.getProperty("jdbc.password");
			
			con=DriverManager.getConnection(url,user,dbpassword);
			
				return con;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
				
	}

}


class ToneLog extends Thread
{
	Logger logger=Logger.getLogger(ToneLog.class.getName());
	
	/*TP_Call-logs*/
	private String val_country="";
	private String val_aParty="";
	private String val_bParty="";
	private String val_callDate="";
	private String val_startTime="";
	private String val_endTime="";
	private String val_duration="";
	private String val_userinput="";
	private String val_starCopy="";
	private String val_toneCode="";
	private String val_filename="";
	
	
	
	private String filepath="";
	String line="";
	int nToken=0;
	Connection con=null;
	BufferedReader reader;
	int batchsize=0;
	int count=0;
	int c=0;
	public void run()
	{
		
		try 
		{
			
			logger.info("Final tp_log file path is "+filepath);
			con=InsertBatchCalllog.getConnection();
			logger.info("Connection establish ---"+con);


			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select count(1) from tbl_tp_calllog where call_date='"+val_filename+"'");
			
			while(rs.next())
			{
				c=rs.getInt(1);
				
			}
			
			if(c>0)
			{
				logger.info("deleting "+ c +" records");
				int length=st.executeUpdate("delete from tbl_tp_calllog where call_date='" + val_filename +"'");
				logger.info(length +" records Deleted");
			}
		
			
			logger.info("inserting records");
			PreparedStatement pst=con.prepareStatement("insert into tbl_tp_calllog(call_date,total_records) values(?,?)");
			File file=new File(filepath);
			
			if(file.exists())
			{
				reader=new BufferedReader(new FileReader(file));
				
				while((line=reader.readLine())!=null)
				{
					count++;
					
					/*StringTokenizer token = new StringTokenizer(line,"#");
					nToken=token.countTokens();
					if(nToken==10)
					{
						val_country=token.nextToken().trim();
						val_aParty=token.nextToken().trim();
						val_bParty=token.nextToken().trim();
						val_callDate=token.nextToken().trim();
						val_startTime=token.nextToken().trim();
						val_endTime=token.nextToken().trim();
						val_duration=token.nextToken().trim();
						val_userinput=token.nextToken().trim();
						val_starCopy=token.nextToken().trim();
						val_toneCode=token.nextToken().trim();
						
						
						pst.setString(1, val_country);
						pst.setString(2, val_aParty);
						pst.setString(3, val_bParty);
						pst.setString(4, val_callDate);
						pst.setString(5, val_startTime);
						pst.setString(6, val_endTime);
						pst.setString(7, val_duration);
						pst.setString(8, val_userinput);
						pst.setString(9, val_starCopy);
						pst.setString(10, val_toneCode);
						pst.addBatch();
						
						if(batchsize++==10000)
						{
							System.out.println("Uploading batchSize of "+ batchsize);
							pst.executeBatch();
							pst.clearBatch();
							batchsize=0;
						}
						
						if(batchsize>0)
						{
							pst.executeBatch();
						}
					
					}
					
					else
					{
						logger.info("No of Token is greater or less then 10 "+line);
					}*/
						
				}
				
				pst.setString(1, val_filename);
				pst.setString(2, String.valueOf(count));
				pst.executeUpdate();
			}
			
				
			else
			{
				logger.info("File not found "+filepath);
			}
		
		
			con.close();
		}
		
		
		catch (Exception e)
		{
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		finally
		{
			if(reader!=null)
			{
				try {
					reader.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	

	
	
	public ToneLog(int i)
	{
		InputStream is=null;
		try
		{
			Properties prop=new Properties();
			is=new FileInputStream("db.properties");
			prop.load(is);
			filepath=prop.getProperty("tp_log_path");
			Calendar cal=Calendar.getInstance();
			cal.add(Calendar.DATE, -i);;
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			val_filename=sdf.format(cal.getTime());
			filepath+=val_filename+".txt";
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(is!=null)
			{
				try 
				{
					is.close();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
	
}



/*Second thread to insert data into Call-Logs Table*/

class CallLog extends Thread
{
	Logger logger=Logger.getLogger(CallLog.class.getName());
	
	/*Crbt_Call-logs*/
	private String var_callerNumber;
	private String var_shortCode;
	private String var_crbt_callDate;
	private String var_crbt_startTime;
	private String var_crbt_endTime;
	private String var_crbt_duration;
	private String val_filename="";
	private String filepath="";
	String line="";
	int nToken=0;
	Connection con=null;
	BufferedReader reader;
	int c=0;
	public void run()
	{
		Connection con=InsertBatchCalllog.getConnection();
		String n=Thread.currentThread().getName();
		
		try {
			logger.info("Final call_log file path is "+filepath);
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select count(1) from tbl_crbt_calllog where call_date='"+val_filename+"'");
			
			while(rs.next())
			{
				c=rs.getInt(1);
				
			}
			
			if(c>0)
			{
				logger.info("deleting "+ c +" records");
				int length=st.executeUpdate("delete from tbl_crbt_calllog where call_date='" + val_filename +"'");
				logger.info(length +" records Deleted");
			}
			
			PreparedStatement pst=con.prepareStatement("insert into tbl_crbt_calllog(caller_no,short_code,call_date,start_time,end_time,duration) values(?,?,?,?,?,?)");
			File file =new File(filepath);
			
			reader=new BufferedReader(new FileReader(file));
			
			while((line=reader.readLine())!=null)
			{
				/*line=reader.readLine();*/
				StringTokenizer token = new StringTokenizer(line,"#");
				nToken=token.countTokens();
				if(nToken==6)
				{
					var_callerNumber=token.nextToken().trim();
					var_shortCode=token.nextToken().trim();
					var_crbt_callDate=token.nextToken().trim();
					var_crbt_startTime=token.nextToken().trim();
					var_crbt_endTime=token.nextToken().trim();
					var_crbt_duration=token.nextToken().trim();
					
					pst.setString(1, var_callerNumber);
					pst.setString(2, var_shortCode);
					pst.setString(3, var_crbt_callDate);
					pst.setString(4, var_crbt_startTime);
					pst.setString(5, var_crbt_endTime);
					pst.setString(6, var_crbt_duration);
					
					pst.addBatch();
				
				}
				
				else
				{
					logger.info("No of Token is greater or less then 6 "+line);
				}
				
			}
			pst.executeBatch();
			con.close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		finally
		{
			if(reader!=null)
			{
				try {
					reader.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
	/*Set File name according to date getting by cmd line argument*/
	public CallLog(int i)
	{
		InputStream is=null;
		try
		{
			Properties prop=new Properties();
			is=new FileInputStream("db.properties");
			prop.load(is);
			filepath=prop.getProperty("call_log_path");
			Calendar cal=Calendar.getInstance();
			cal.add(Calendar.DATE, -i);;
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			val_filename=sdf.format(cal.getTime());
			filepath+=val_filename+".txt";
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(is!=null)
			{
				try 
				{
					is.close();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	}
