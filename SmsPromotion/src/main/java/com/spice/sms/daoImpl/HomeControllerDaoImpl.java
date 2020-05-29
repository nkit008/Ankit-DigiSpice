package com.spice.sms.daoImpl;

import java.io.FileOutputStream;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spice.sms.dao.HomeControllerDao;
import com.spice.sms.entites.ConnectionFactory;
import com.spice.sms.entites.LoginEntitiy;
import com.spice.sms.entites.SmsCli;

@Repository
@Transactional
public class HomeControllerDaoImpl implements HomeControllerDao{
	
	private static final Logger logger = Logger.getLogger(HomeControllerDaoImpl.class.getName());
	
	@Autowired
	HibernateTemplate template;
	
	@Autowired
	HttpSession session;
	
	@Override
	public LoginEntitiy checkLogin(String username,String pass)
	{
		if(template==null)
		{
			
			logger.info("Connection not established");
			return null;
		}
		else
		{
			String query="from LoginEntitiy where username=? and password=?";
			List login  = (List<LoginEntitiy>)template.find(query, username, pass);
			
			if(login.isEmpty())
				return null;
			
			else
				return (LoginEntitiy)login.get(0);
		}
		
	}
	
	@Override
	public List<SmsCli> getAllCli(String cName)
	{
		if(template==null)
		{
			
			logger.info("Connection not established");
			return null;
		}
		else
		{
			String query="select cli from SmsCli where circle='"+cName+"'";
			List<SmsCli> cli  = (List<SmsCli>)template.find(query);
		
			if(cli.isEmpty())
				return null;
			
			else
				return cli;
			
		}
	}
	
	@Override
	public String baseUpload(String base,String circle,String cli,String smsType,String smsScript)
	{
		Connection con=null;
		FileOutputStream out=null;
		
		try
		{
		con=ConnectionFactory.getConnection();
		
		if (con == null) {
			logger.info("connection is not establish!");
			return null;
		}
		
		else
		{
			int i=0;
			PreparedStatement pst=null;

			Statement st=con.createStatement();
			
			String tru="TRUNCATE TABLE tbl_sms_promotionbase_temp";
			st.executeUpdate(tru);
			
			logger.info("final path in dao is "+base);
			
			String sql="load data local infile '"+base+"' into table tbl_sms_promotionbase_temp LINES TERMINATED BY '\n' (base)";
			i=st.executeUpdate(sql);
			logger.info(i+" rows uploaded in tbl_sms_promotionbase_temp table");
			
			/*Truncating temporary table*/
			
			
			final int batchSize=1000;
			String sql1=ConnectionFactory.getProperty("tbl_sms_promotionbase_temp");
			
			ResultSet rs=st.executeQuery(sql1);
			int count=0;
			con.setAutoCommit(false);
			
			String by=((LoginEntitiy)session.getAttribute("userSesseion")).getUsername();
			Calendar cal = Calendar. getInstance();
			Date date=cal. getTime();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String at=dateFormat.format(date);
			String filename=base.substring(base.indexOf("/")+1);
			String ip=InetAddress.getLocalHost().getHostAddress();
			
			/*pst=con.prepareStatement("insert into tbl_sms_master_new(ref_id,circle,msisdn,cli,message,"
					+ "type,priority,insert_time,status,submit_response,delivery_receipt,"
					+ "delivery_time,delivery_details,remarks)"
					+ " values('1',?,?,?)");*/
			
			String sql_query=ConnectionFactory.getProperty("tbl_sms_master_new");
			pst=con.prepareStatement(sql_query);
			
			int priority=Integer.parseInt(ConnectionFactory.getProperty("priority"));
			int status=Integer.parseInt(ConnectionFactory.getProperty("status"));
			
			
			while(rs.next())
			{
				String ani = rs.getString(1).trim();
				ani.replace("'", "");
				
				UUID uuid = UUID.randomUUID();
		        String randomUUIDString = uuid.toString();
				
		        	pst.setString(1, randomUUIDString);
					pst.setString(2, circle);
					pst.setString(3, "91"+ani);
					pst.setString(4, cli);
					pst.setString(5, smsScript);
					pst.setString(6, smsType);
					pst.setInt(7, priority);
					pst.setString(8, at);
					pst.setInt(9, status);
					
					pst.addBatch();
					
					if(++count%batchSize==0)
					{
						int[] res=pst.executeBatch();
					}
				
				}
				
				pst.executeBatch();
				con.commit();
				logger.info("");
				logger.info("\n ["+count+"] base uploaded by ["+by+"] at ["+at+"] from ["+ip+"] filename is ["+filename+"]\n");
				logger.info("");
				return String.valueOf(count);
			}
		}
		
		catch (Exception e)
		{
			logger.info(e);
		}
		
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
