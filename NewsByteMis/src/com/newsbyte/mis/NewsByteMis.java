package com.newsbyte.mis;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

public class NewsByteMis {

	private String fromdate=null;
	private String todate=null;
	private Connection con;
	private String table_name=null;
	
	public static Logger logger=Logger.getLogger(NewsByteMis.class.getName());
	
	public static void main(String[] args) {
		
		logger.info("\r\nStart Time of Program is "+Calendar.getInstance().getTime());
		
		if(args.length > 0)
		{
			NewsByteMis news = new NewsByteMis(Integer.parseInt(args[0]));
			news.downloadExcel();
		}
		
		else
		{
			NewsByteMis news = new NewsByteMis(1);
			news.downloadExcel();
		}

	}
	
	
	
	public NewsByteMis(int i)
	{
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, -i);
		
		DateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		todate=sdf.format(cal.getTime());
		fromdate=todate.substring(0,4)+""+todate.substring(4,6)+"01";
		
		System.out.println("to date is "+todate);
		
		System.out.println("from date is "+fromdate);
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
	
	
	public void downloadExcel()
	{
		con=NewsByteMis.getConnection();
		if(con==null)
		{
			logger.info("connection not established");
		}
		
		else
		{
			logger.info("connection established");
			
			try
			{
				Properties prop=new Properties();
				InputStream is=new FileInputStream("db.properties");
				prop.load(is);
				table_name=prop.getProperty("table_name");
				logger.info("fetching records from "+table_name+" from "+fromdate+" to "+todate);
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select TOTAL_CALLS,SUBS_USERS_CALLS,NON_SUBS_USERS_CALLS,"
						+ "TOTAL_MOUS,SUBS_USERS_MOU,NON_SUBS_USERS_MOU,TOTAL_PULSES,SUBS_USERS_PULSES,"
						+ "NON_SUBS_USERS_PULSES,TOTAL_UNIQUE_CALLERS,UNIQUE_SUBS_CALLERS,UNIQUE_NON_SUBS_CALLERS,"
						+ "UNIQUE_CALLERS_TILL_DATE,CC_DAILY_PACK,CC_VOLUNTARY_UNSUBS,CC_INVOLUNTARY_UNSUBS,"
						+ "CC_GROSS_ADDS,CC_DAILY_RE_PACK,IVR_SUBS,CCI_SUBS,OBD_SUBS,SMS_SUBS,IBD_SUBS,"
						+ "USSD_SUBS,OTHERS_SUBS,IVR_UNSUBS,CCI_UNSUBS,SMS_UNSUBS,USSD_UNSUBS,OTHERS_UNSUBS,"
						+ "DAILY_REVENUE_CC,GROSS_REVENUE_LOCAL,GROSS_REVENUE_USD,ACTIVE_SUBSCRIBER,BILLED_SUBSCRIBERS,"
						+ "CALLING_SUBSCRIBERS,AVG_CALL_UNIQUE,AVG_MOU_UNIQUE,AVG_MOU_CALL,UNIQUE_CALLER_ACTIVE,"
						+ "SERVICE_PENETRATION,ARPU,GRACE1TO7,GRACE8TO14,GRACE15TO21,GRACE22TO30,MIN1,"
						+ "MIN2,MIN3,MIN4,MIN5,MIN6,MIN7,MIN8,MIN9,MIN10,MIN10ABOVE,HR0,HR1,HR2,HR3,HR4,HR5,HR6,"
						+ "HR7,HR8,HR9,HR10,HR11,HR12,HR13,HR14,HR15,HR16,HR17,HR18,HR19,HR20,HR21,HR22,HR23,"
						+ "DATE_TIME from " + table_name +" where DATE_TIME BETWEEN '"+ fromdate +"' and '"+todate+"' "
								+ "order by date_time asc");
				
				List<MisBean> list=new ArrayList<MisBean>();
				
				while(rs.next())
				{
					MisBean bean=new MisBean();
					bean.setTOTAL_CALLS(rs.getString(1));
					bean.setSUBS_USERS_CALLS(rs.getString(2));
					bean.setNON_SUBS_USERS_CALLS(rs.getString(3));
					bean.setTOTAL_MOUS(rs.getString(4));
					bean.setSUBS_USERS_MOU(rs.getString(5));
					bean.setNON_SUBS_USERS_MOU(rs.getString(6));
					bean.setTOTAL_PULSES(rs.getString(7));
					bean.setSUBS_USERS_PULSES(rs.getString(8));
					bean.setNON_SUBS_USERS_PULSES(rs.getString(9));
					bean.setTOTAL_UNIQUE_CALLERS(rs.getString(10));
					bean.setUNIQUE_SUBS_CALLERS(rs.getString(11));
					bean.setUNIQUE_NON_SUBS_CALLERS(rs.getString(12));
					bean.setUNIQUE_CALLERS_TILL_DATE(rs.getString(13));
					bean.setCC_DAILY_PACK(rs.getString(14));
					bean.setCC_VOLUNTARY_UNSUBS(rs.getString(15));
					bean.setCC_INVOLUNTARY_UNSUBS(rs.getString(16));
					bean.setCC_GROSS_ADDS(rs.getString(17));
					bean.setCC_DAILY_RE_PACK(rs.getString(18));
					bean.setIVR_SUBS(rs.getString(19));
					bean.setCCI_SUBS(rs.getString(20));
					bean.setOBD_SUBS(rs.getString(21));
					bean.setSMS_SUBS(rs.getString(22));
					bean.setIBD_SUBS(rs.getString(23));
					bean.setUSSD_SUBS(rs.getString(24));
					bean.setOTHERS_SUBS(rs.getString(25));
					bean.setIVR_UNSUBS(rs.getString(26));
					bean.setCCI_UNSUBS(rs.getString(27));
					bean.setSMS_UNSUBS(rs.getString(28));
					bean.setUSSD_UNSUBS(rs.getString(29));
					bean.setOTHERS_UNSUBS(rs.getString(30));
					bean.setDAILY_REVENUE_CC(rs.getString(31));
					bean.setGROSS_REVENUE_LOCAL(rs.getString(32));
					bean.setGROSS_REVENUE_USD(rs.getString(33));
					bean.setACTIVE_SUBSCRIBER(rs.getString(34));
					bean.setBILLED_SUBSCRIBERS(rs.getString(35));
					bean.setCALLING_SUBSCRIBERS(rs.getString(36));
					bean.setAVG_CALL_UNIQUE(rs.getString(37));
					bean.setAVG_MOU_UNIQUE(rs.getString(38));
					bean.setAVG_MOU_CALL(rs.getString(39));
					bean.setUNIQUE_CALLER_ACTIVE(rs.getString(40));
					bean.setSERVICE_PENETRATION(rs.getString(41));
					bean.setARPU(rs.getString(42));
					bean.setGRACE1TO7(rs.getString(43));
					bean.setGRACE8TO14(rs.getString(44));
					bean.setGRACE15TO21(rs.getString(45));
					bean.setGRACE22TO30(rs.getString(46));
					bean.setMIN1(rs.getString(47));
					bean.setMIN2(rs.getString(48));
					bean.setMIN3(rs.getString(49));
					bean.setMIN4(rs.getString(50));
					bean.setMIN5(rs.getString(51));
					bean.setMIN6(rs.getString(52));
					bean.setMIN7(rs.getString(53));
					bean.setMIN8(rs.getString(54));
					bean.setMIN9(rs.getString(55));
					bean.setMIN10(rs.getString(56));
					bean.setMIN10ABOVE(rs.getString(57));
					bean.setHR0(rs.getString(58));
					bean.setHR1(rs.getString(59));
					bean.setHR2(rs.getString(60));
					bean.setHR3(rs.getString(61));
					bean.setHR4(rs.getString(62));
					bean.setHR5(rs.getString(63));
					bean.setHR6(rs.getString(64));
					bean.setHR7(rs.getString(65));
					bean.setHR8(rs.getString(66));
					bean.setHR9(rs.getString(67));
					bean.setHR10(rs.getString(68));
					bean.setHR11(rs.getString(69));
					bean.setHR12(rs.getString(70));
					bean.setHR13(rs.getString(71));
					bean.setHR14(rs.getString(72));
					bean.setHR15(rs.getString(73));
					bean.setHR16(rs.getString(74));
					bean.setHR17(rs.getString(75));
					bean.setHR18(rs.getString(76));
					bean.setHR19(rs.getString(77));
					bean.setHR20(rs.getString(78));
					bean.setHR21(rs.getString(79));
					bean.setHR22(rs.getString(80));
					bean.setHR23(rs.getString(81));
					String date=rs.getString(82).trim();
					bean.setDATE_TIME(date.substring(6)+"-"+date.substring(4, 6)+"-"+date.substring(0,4));
					list.add(bean);
					
				}
				
				
				int startRowIndex = 0;
				int startColIndex = 3;
				GenratePoi poi=new GenratePoi();
				poi.genrateXLS(startRowIndex, startColIndex,list, fromdate, todate);
			}
			
			catch(Exception e)
			{
				logger.info(e);
			}
			
			
			finally
			{
	
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
