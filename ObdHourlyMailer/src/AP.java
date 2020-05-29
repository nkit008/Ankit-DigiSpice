import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class AP {
	
	
	private static final Logger LOGGER = Logger.getLogger(AP.class.getName());
	
	Connection connMIS = null;
	Statement stmtMIS  	= null;
	String htmlstring="";
	String driver=null;
	String name=null;
	String pass=null;
	String ip=null;
	ResultSet rs=null;
	
	String sql_AP1=null;
	String sql_AP2=null;
	String sql_AP4=null;
	String sql_AP5=null;
	String sql_AP6=null;
	String sql_AP7=null;
	
	
	
	public void fetchDataForAP()
	{
		LOGGER.info("-----Getting MIS for AP--------");
		
		ConnectionConfig alert= new ConnectionConfig();

		try
		{	
			LOGGER.info("-----Trying Establishing Connection With AP1--------");
			connMIS = alert.DB_connection("driver","AP1_username","AP1_password","AP1_ip");
			LOGGER.info("Connection establish Successfully for AP1 {["+connMIS+"}]");
			if(connMIS!=null)
			{
				sql_AP1 = alert.getValuefromProperties("AP1_query");
			}
			stmtMIS  = connMIS.createStatement();
			rs=stmtMIS.executeQuery(sql_AP1);
			htmlstring = "<HTML>";

						htmlstring += "<BODY bgColor=white><br>";

						htmlstring += "<FONT face=Arial size=2></FONT>&nbsp;";
						htmlstring += "Dear All,<br><br>";
						htmlstring += "         Please Find Attached Hourly Based MIS for AP<br><br>";
						htmlstring +="<table  width=100%><TBODY></TBODY></table>";
						htmlstring += "<table border=1  borderColor=#003366 width=100% height=50%>";
						htmlstring += "<tr  bgcolor=#9999cc><th align=left>Date</th><th align=left>Circle</th><th align=left>Product</th><th align=left>Base Count</th><th align=left>Attempts</th>"
								+ "<th align=left>Contact</th><th align=left>Patch</th><th align=left>Contact Percent</th><th align=left>Patch Percent</th></tr>";
						
						
						
			while(rs.next())
			{
				String c1=rs.getString("Date");
				String c2=rs.getString("Circle");
				String c3=rs.getString("Product");
				String c4=rs.getString("BaseCount");
				String c5=rs.getString("Attempts");
				String c6=rs.getString("Contact");
				String c7=rs.getString("PATCH");
				String c8=rs.getString("ContactPercentage");
				String c9=rs.getString("PATCHPercentage");
				
				/*LOGGER.info("Result from query date is {["+c1+"}]  circle is {["+c2+"}] Product is {["+c3+"}] BaseCount is  {["+c4+"}]  Attempts is {["+c5+"}] Contact {["+c6+"}]"
						+ " Patch is {["+c7+"}]  ContactPercent is {["+c8+"}] patchPercent {["+c9+"}]");*/				
				
				htmlstring += " <tr bgcolor=#c8cbff><td>" + c1 + "</td><td>" + c2 + "</td><td>" + c3 + "</td><td>" + c4 + "</td>"
						+ "<td>" + c5 + "</td><td>" + c6 + "</td><td>" + c7 + "</td><td>" + c8 + "</td><td>" + c9 + "</td></tr>";

			}
			
			
			LOGGER.info("----Established Connection With AP2-----");
			
			connMIS = alert.DB_connection("driver","AP2_username","AP2_password","AP2_ip");
			LOGGER.info("Connection establish Successfully for AP2 {["+connMIS+"}]" );
			
			if(connMIS!=null)
			{
				sql_AP2 = alert.getValuefromProperties("AP2_query");
			}
			stmtMIS  = connMIS.createStatement();
			rs = stmtMIS.executeQuery(sql_AP2);
			
			
			while(rs.next())
			{
				String c1=rs.getString("Date");
				String c2=rs.getString("Circle");
				String c3=rs.getString("Product");
				String c4=rs.getString("BaseCount");
				String c5=rs.getString("Attempts");
				String c6=rs.getString("Contact");
				String c7=rs.getString("PATCH");
				String c8=rs.getString("ContactPercentage");
				String c9=rs.getString("PATCHPercentage");
				
				/*LOGGER.info("Result from query date is {["+c1+"}]  circle is {["+c2+"}] Product is {["+c3+"}] BaseCount is  {["+c4+"}]  Attempts is {["+c5+"}] Contact {["+c6+"}]"
						+ " Patch is {["+c7+"}]  ContactPercent is {["+c8+"}] patchPercent {["+c9+"}]");*/
				
				htmlstring += " <tr bgcolor=#c8cbff><td>" + c1 + "</td><td>" + c2 + "</td><td>" + c3 + "</td><td>" + c4 + "</td>"
						+ "<td>" + c5 + "</td><td>" + c6 + "</td><td>" + c7 + "</td><td>" + c8 + "</td><td>" + c9 + "</td></tr>";

			}
			
			
			
			/**/
			LOGGER.info("-----Trying Establishing Connection With AP4--------");
			connMIS = alert.DB_connection("driver","AP4_username","AP4_password","AP4_ip");
			LOGGER.info("Connection establish Successfully for AP4 {["+connMIS+"}]");
			
			if(connMIS!=null)
			{
				sql_AP4 = alert.getValuefromProperties("AP4_query");
			}
			stmtMIS  = connMIS.createStatement();
			rs = stmtMIS.executeQuery(sql_AP4);
			
			
			while(rs.next())
			{
				String c1=rs.getString("Date");
				String c2=rs.getString("Circle");
				String c3=rs.getString("Product");
				String c4=rs.getString("BaseCount");
				String c5=rs.getString("Attempts");
				String c6=rs.getString("Contact");
				String c7=rs.getString("PATCH");
				String c8=rs.getString("ContactPercentage");
				String c9=rs.getString("PATCHPercentage");
				
				/*LOGGER.info("Result from query date is {["+c1+"}]  circle is {["+c2+"}] Product is {["+c3+"}] BaseCount is  {["+c4+"}]  Attempts is {["+c5+"}] Contact {["+c6+"}]"
						+ " Patch is {["+c7+"}]  ContactPercent is {["+c8+"}] patchPercent {["+c9+"}]");*/
				
				
				htmlstring += " <tr bgcolor=#c8cbff><td>" + c1 + "</td><td>" + c2 + "</td><td>" + c3 + "</td><td>" + c4 + "</td>"
						+ "<td>" + c5 + "</td><td>" + c6 + "</td><td>" + c7 + "</td><td>" + c8 + "</td><td>" + c9 + "</td></tr>";

			}
			
			
			
			
			LOGGER.info("-----Established Connection With AP5-----");
			connMIS = alert.DB_connection("driver","AP5_username","AP5_password","AP5_ip");
			LOGGER.info("Connection establish Successfully for AP5 {["+connMIS+"}]");
			if(connMIS!=null)
			{
				sql_AP5 = alert.getValuefromProperties("AP5_query");
			}
			stmtMIS  = connMIS.createStatement();
			rs = stmtMIS.executeQuery(sql_AP5);
			
			
			while(rs.next())
			{
				String c1=rs.getString("Date");
				String c2=rs.getString("Circle");
				String c3=rs.getString("Product");
				String c4=rs.getString("BaseCount");
				String c5=rs.getString("Attempts");
				String c6=rs.getString("Contact");
				String c7=rs.getString("PATCH");
				String c8=rs.getString("ContactPercentage");
				String c9=rs.getString("PATCHPercentage");
				
				/*LOGGER.info("Result from query date is {["+c1+"}]  circle is {["+c2+"}] Product is {["+c3+"}] BaseCount is  {["+c4+"}]  Attempts is {["+c5+"}] Contact {["+c6+"}]"
						+ " Patch is {["+c7+"}]  ContactPercent is {["+c8+"}] patchPercent {["+c9+"}]");*/
				
				
				htmlstring += " <tr bgcolor=#c8cbff><td>" + c1 + "</td><td>" + c2 + "</td><td>" + c3 + "</td><td>" + c4 + "</td>"
						+ "<td>" + c5 + "</td><td>" + c6 + "</td><td>" + c7 + "</td><td>" + c8 + "</td><td>" + c9 + "</td></tr>";

			}
			
			
			LOGGER.info("-----Trying Establishing Connection With AP6--------");
			connMIS = alert.DB_connection("driver","AP6_username","AP6_password","AP6_ip");
			LOGGER.info("Connection establish Successfully for AP6 {["+connMIS+"}]");
			if(connMIS!=null)
			{
				sql_AP6 = alert.getValuefromProperties("AP6_query");
			}
			stmtMIS  = connMIS.createStatement();
			rs = stmtMIS.executeQuery(sql_AP6);
			
			
			while(rs.next())
			{
				String c1=rs.getString("Date");
				String c2=rs.getString("Circle");
				String c3=rs.getString("Product");
				String c4=rs.getString("BaseCount");
				String c5=rs.getString("Attempts");
				String c6=rs.getString("Contact");
				String c7=rs.getString("PATCH");
				String c8=rs.getString("ContactPercentage");
				String c9=rs.getString("PATCHPercentage");
				
				/*LOGGER.info("Result from query date is {["+c1+"}]  circle is {["+c2+"}] Product is {["+c3+"}] BaseCount is  {["+c4+"}]  Attempts is {["+c5+"}] Contact {["+c6+"}]"
						+ " Patch is {["+c7+"}]  ContactPercent is {["+c8+"}] patchPercent {["+c9+"}]");*/
				
				
				htmlstring += " <tr bgcolor=#c8cbff><td>" + c1 + "</td><td>" + c2 + "</td><td>" + c3 + "</td><td>" + c4 + "</td>"
						+ "<td>" + c5 + "</td><td>" + c6 + "</td><td>" + c7 + "</td><td>" + c8 + "</td><td>" + c9 + "</td></tr>";

			}
			
			
			
			LOGGER.info("-----Trying Establishing Connection With AP7--------");
			connMIS = alert.DB_connection("driver","AP7_username","AP7_password","AP7_ip");
			LOGGER.info("Connection establish Successfully for AP7 {["+connMIS+"}]");
			if(connMIS!=null)
			{
				sql_AP7 = alert.getValuefromProperties("AP7_query");
			}
			stmtMIS  = connMIS.createStatement();
			rs = stmtMIS.executeQuery(sql_AP7);
			
			
			while(rs.next())
			{
				String c1=rs.getString("Date");
				String c2=rs.getString("Circle");
				String c3=rs.getString("Product");
				String c4=rs.getString("BaseCount");
				String c5=rs.getString("Attempts");
				String c6=rs.getString("Contact");
				String c7=rs.getString("PATCH");
				String c8=rs.getString("ContactPercentage");
				String c9=rs.getString("PATCHPercentage");
				
				/*LOGGER.info("Result from query date is {["+c1+"}]  circle is {["+c2+"}] Product is {["+c3+"}] BaseCount is  {["+c4+"}]  Attempts is {["+c5+"}] Contact {["+c6+"}]"
						+ " Patch is {["+c7+"}]  ContactPercent is {["+c8+"}] patchPercent {["+c9+"}]");*/
				
				htmlstring += " <tr bgcolor=#c8cbff><td>" + c1 + "</td><td>" + c2 + "</td><td>" + c3 + "</td><td>" + c4 + "</td>"
						+ "<td>" + c5 + "</td><td>" + c6 + "</td><td>" + c7 + "</td><td>" + c8 + "</td><td>" + c9 + "</td></tr>";

			}
			
				htmlstring +="</table>";
				htmlstring += "<FONT face=Arial size=2></FONT>&nbsp;";
				htmlstring += "<br><br>Thanks and Regards,<br><br>";
				htmlstring += "Service Delivery |  DigiSpice<br><br></body></html>";

				rs.close();
				stmtMIS.close();

}

		catch(Exception ex)
		{
			LOGGER.info("Exception in select of Data from DB", ex);
			System.out.println("::"+ex);
		}


		try
		{
			SendFile sendmail= new SendFile();
			String From = alert.getValuefromProperties("mail_from");
			 
			String TO=alert.getValuefromProperties("ap_mail_to");
			String CC=alert.getValuefromProperties("ap_mail_cc");
			
			Date date= new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("hh");
			String hour = sdf.format(date);
			
			String Subject="Hourly OBD MIS_AP_"+hour;
			String Body=htmlstring;
			sendmail.sendMessage(From,TO,CC,Subject,Body,"");
		}
		catch(Exception e)
		{
			LOGGER.info("Exception in calling sendMessage()", e);
			
		}
	}
	
	
}
