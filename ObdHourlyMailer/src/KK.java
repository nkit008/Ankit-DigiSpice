import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class KK {

	private static final Logger LOGGER = Logger.getLogger(KK.class.getName());

	Connection connMIS = null;
	Statement stmtMIS  	= null;
	String htmlstring="";
	String driver=null;
	String name=null;
	String pass=null;
	String ip=null;
	ResultSet rs=null;
	
	String sql_KK2=null;
	String sql_KK3=null;
	
	
	
	public void fetchDataForKK()
	{
		LOGGER.info("-----Getting MIS for KK--------");
		ConnectionConfig alert= new ConnectionConfig();

		try
		{	
			
			LOGGER.info("-----Trying Establishing Connection With KK2--------");
			connMIS = alert.DB_connection("driver","KK2_username","KK2_password","KK2_ip");
			LOGGER.info("Connection establish Successfully for KK2 {["+connMIS+"}]");
			if(connMIS!=null)
			{
				sql_KK2 = alert.getValuefromProperties("KK2_query");
			}
			stmtMIS  = connMIS.createStatement();
			rs=stmtMIS.executeQuery(sql_KK2);
			htmlstring = "<HTML>";

						htmlstring += "<BODY bgColor=white><br>";

						htmlstring += "<FONT face=Arial size=2></FONT>&nbsp;";
						htmlstring += "Dear All,<br><br>";
						htmlstring += "         Please Find Attached Hourly Based MIS for KK<br><br>";
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
				
/*				LOGGER.info("Result from query date is {["+c1+"}]  circle is {["+c2+"}] Product is {["+c3+"}] BaseCount is  {["+c4+"}]  Attempts is {["+c5+"}] Contact {["+c6+"}]"
						+ " Patch is {["+c7+"}]  ContactPercent is {["+c8+"}] patchPercent {["+c9+"}]");*/

				htmlstring += " <tr bgcolor=#c8cbff><td>" + c1 + "</td><td>" + c2 + "</td><td>" + c3 + "</td><td>" + c4 + "</td>"
						+ "<td>" + c5 + "</td><td>" + c6 + "</td><td>" + c7 + "</td><td>" + c8 + "</td><td>" + c9 + "</td></tr>";

			}
			
			
			/*Established Connection With KK3*/
			LOGGER.info("-----Trying Establishing Connection With KK3--------");
			connMIS = alert.DB_connection("driver","KK3_username","KK3_password","KK3_ip");
			LOGGER.info("Connection establish Successfully for KK3 {["+connMIS+"}]");
			if(connMIS!=null)
			{
				sql_KK3 = alert.getValuefromProperties("KK3_query");
			}
			stmtMIS  = connMIS.createStatement();
			rs = stmtMIS.executeQuery(sql_KK3);
			
			
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
			LOGGER.info("Exception in select of Data from DB ::", ex);
		}


		try
		{
			SendFile sendmail= new SendFile();
			String From = alert.getValuefromProperties("mail_from");
			 
			String TO=alert.getValuefromProperties("kk_mail_to");
			String CC=alert.getValuefromProperties("kk_mail_cc");
			
			Date date= new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("hh");
			String hour = sdf.format(date);
			
			String Subject="Hourly OBD MIS_KK_"+hour;
			String Body=htmlstring;
			sendmail.sendMessage(From,TO,CC,Subject,Body,"");
		}
		catch(Exception e)
		{
			LOGGER.info("Exception in calling sendMessage() method ",e);
		}
	}
	
	
}
