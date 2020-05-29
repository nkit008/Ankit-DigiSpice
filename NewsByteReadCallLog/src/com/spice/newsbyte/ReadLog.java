/**
 * This class created on(1-05-2019) for read the call log of
 * NEWS_BYTE service and insert these logs into 
 * the table (TBL_NEWSBYTE_CDR)
 * @author Ankit_Bijalwan
 */


package com.spice.newsbyte;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadLog {

	public static Logger logger=Logger.getLogger(ReadLog.class.getName());
	
	public static void main(String[] args) {
		
		logger.info("\r\nStart Time of Program is "+Calendar.getInstance().getTime());
		
		if(args.length > 0)
		{
			NewsByte news = new NewsByte(Integer.parseInt(args[0]));
			news.insertData();
		}
		
		else
		{
			NewsByte news = new NewsByte(1);
			news.insertData();
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

class NewsByte
{
	
	String filepath=null; //to save filepath
	Connection con=null;  //to Store Connection
	String date=null;	//to save dateformat(yyyyMMdd)
	int count=0;		
	BufferedReader br=null;
	String line=null;
	
	
	String channel=null;
	String calldate=null;
	String calltime=null;
	String duration=null;
	String ani=null;
	String dnis=null;
	String status=null;
	
	
	
	//Constructor to set the filename according to command line arguments
	public NewsByte(int i)
	{
		InputStream is=null;
		try
		{
		Properties prop=new Properties();
		is=new FileInputStream("db.properties");
		prop.load(is);
		filepath=prop.getProperty("call_log_path");
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, -i);
		
		DateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		date=sdf.format(cal.getTime());
		filepath+=date+".txt";
		}
		
		catch(Exception e)
		{
			System.out.println(e);
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
		
		System.out.println(filepath);
	}
	
	
	//function to insert call_log data unto table
	public void insertData()
	{
		Logger logger=Logger.getLogger(NewsByte.class.getName());
		
		
		con=ReadLog.getConnection();
		if(con==null)
		{
			logger.info("connection not established");
		}
		
		else
		{
			logger.info("connection established");
			
			try
			{
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select count(1) from mis..tbl_newsbyte_calllog where CALLDATE='"+ date +"'");
				
				while(rs.next())
				{
					count=rs.getInt(1);
				}
				
				if(count > 0)
				{
					logger.info("deleting "+ count +" records");
					int length=st.executeUpdate("delete from mis..tbl_newsbyte_calllog where CALLDATE='" + date +"'");
					logger.info(length +" records Deleted");
				}
				
				
				logger.info("\r\nInserting new records");
					
				PreparedStatement pst=con.prepareStatement("insert into mis..tbl_newsbyte_calllog"
				+ "(OPERATOR,CHANNEL,CALLDATE,CALLTIME,DURATION,ANI,DNIS,STATUS) values(?,?,?,?,?,?,?,?)");
				
				br=new BufferedReader(new FileReader(new File(filepath)));
				
				while((line=br.readLine())!=null)
				{
					String[] token=line.split("#");
					
					if(token.length==9)
					{
						channel=token[1];
						calldate=token[2];
						calltime=token[3];
						duration=token[4];
						ani=token[5];
						dnis=token[6];
						status=token[8];
						
						pst.setString(1, "Safaricom_kenya");
						pst.setInt(2, Integer.parseInt(channel));
						pst.setString(3, calldate);
						pst.setString(4, calltime);
						pst.setLong(5, Long.parseLong(duration));
						pst.setString(6, ani);
						pst.setString(7, dnis);
						pst.setInt(8, Integer.parseInt(status));
						
						pst.addBatch();
					}
				}
				
				int[] res=pst.executeBatch();
				logger.info(res.length +" records uploded");
				}
			
			catch(Exception e)
			{
				logger.info(e);
			}
			
			
			finally
			{
				if(br!=null)
				{
					try {
						br.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				if(con!=null)
				{
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
			
	}
	
}
