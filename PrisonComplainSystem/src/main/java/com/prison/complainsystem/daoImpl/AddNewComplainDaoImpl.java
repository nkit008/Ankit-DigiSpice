package com.prison.complainsystem.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prison.complainsystem.connection.ConnectionFactory;
import com.prison.complainsystem.dao.AddNewComplainDao;
import com.prison.complainsystem.model.AllComplainModel;
import com.prison.complainsystem.model.ConnectivityComplainModel;
import com.prison.complainsystem.model.HardwareComplainModel;
import com.prison.complainsystem.model.PhysicalDamageModel;
import com.prison.complainsystem.model.SoftwareComplainModel;
import com.prison.complainsystem.model.UserLogin;


@Repository
@Transactional
public class AddNewComplainDaoImpl implements AddNewComplainDao{
	
	@Autowired
	HttpSession session;
	
	private static final Logger logger = LoggerFactory.getLogger(AddNewComplainDaoImpl.class);
	Connection con = null;
	int i=0;
	
	public int addNewHwComplain(HardwareComplainModel newHw)
	{
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("connection is not establish!");
				return 0;
			}

			else 
			{
				Date date=new Date();
				DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				DateFormat df1=new SimpleDateFormat("hh:mm:ss");
				DateFormat df2=new SimpleDateFormat("yyyy-MM-dd");
				DateFormat df3=new SimpleDateFormat("MM/dd/yyyy");
				
				String curDate=df.format(date);
				String curTime=df1.format(date);
				String issueDate=df2.format(df3.parse(newHw.getIssueDate()));
		
				String createdBy=((UserLogin)session.getAttribute("userObj")).getName();
		
				PreparedStatement pst=con.prepareStatement("insert into tbl_complain_details (prison_name,prison_id,"
						+ "complain_logg_by,designation,phone,mail,hw_name,serial_no,issue_arr_date,complain_desc,"
						+ "created_at,created_by,updated_at,updated_by,catagory,status) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pst.setString(1, newHw.getPrison_name());
				pst.setString(2, newHw.getPrison_id());
				pst.setString(3, newHw.getComp_loggby());
				pst.setString(4, newHw.getDesignation());
				pst.setLong(5, newHw.getPhone());
				pst.setString(6, newHw.getMail());
				pst.setString(7, newHw.getHw_name());
				pst.setString(8, newHw.getSerial_no());
				pst.setString(9, issueDate+" "+curTime);
				pst.setString(10, newHw.getComplain_desc());
				pst.setString(11, curDate);
				pst.setString(12, createdBy);
				pst.setString(13, curDate);
				pst.setString(14, createdBy);
				pst.setString(15, "Hardware");
				pst.setString(16, "open");
				
				i=pst.executeUpdate();
				System.out.println("value of i " +i);
				
				return i;
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
				
				}
			}
		}
		

	}
	
	
	public int addNewSwComplain(SoftwareComplainModel newSw)
	{
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("connection is not establish!");
				return 0;
			}

			else 
			{
				Date date=new Date();
				DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				
				String curDate=df.format(date);
		
				String createdBy=((UserLogin)session.getAttribute("userObj")).getName();
		
				
				PreparedStatement pst=con.prepareStatement("insert into tbl_complain_details (prison_name,prison_id,"
						+ "complain_logg_by,designation,phone,mail,complain_desc,"
						+ "created_at,created_by,updated_at,updated_by,catagory,status) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pst.setString(1, newSw.getPrison_name());
				pst.setString(2, newSw.getPrison_id());
				pst.setString(3, newSw.getComp_loggby());
				pst.setString(4, newSw.getDesignation());
				pst.setLong(5, newSw.getPhone());
				pst.setString(6, newSw.getMail());
				pst.setString(7, newSw.getComplain_desc());
				pst.setString(8, curDate);
				pst.setString(9, createdBy);
				pst.setString(10, curDate);
				pst.setString(11, createdBy);
				pst.setString(12, "Software");
				pst.setString(13, "open");
				
				i=pst.executeUpdate();
				System.out.println("value of i " +i);
				return i;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
				
				}
			}
		}
		
	}
	
	
	public int addNewPhysicalDamageComplain(PhysicalDamageModel newPd)
	{
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("connection is not establish!");
				return 0;
			}

			else 
			{
				Date date=new Date();
				DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				
				String curDate=df.format(date);
		
				String createdBy=((UserLogin)session.getAttribute("userObj")).getName();
		
				
				PreparedStatement pst=con.prepareStatement("insert into tbl_complain_details (prison_name,prison_id,"
						+ "complain_logg_by,designation,phone,mail,damage_item,serial_no,damage_desc,"
						+ "created_at,created_by,updated_at,updated_by,catagory,status) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pst.setString(1, newPd.getPrison_name());
				pst.setString(2, newPd.getPrison_id());
				pst.setString(3, newPd.getComp_loggby());
				pst.setString(4, newPd.getDesignation());
				pst.setLong(5, newPd.getPhone());
				pst.setString(6, newPd.getMail());
				pst.setString(7, newPd.getDamage_item());
				pst.setString(8, newPd.getSerial_no());
				pst.setString(9, newPd.getDamage_desc());
				pst.setString(10, curDate);
				pst.setString(11, createdBy);
				pst.setString(12, curDate);
				pst.setString(13, createdBy);
				pst.setString(14, "Physical Damage");
				pst.setString(15, "open");
				
				i=pst.executeUpdate();
				System.out.println("value of i " +i);
				return i;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
				
				}
			}
		}
		
	}
	
	
	
	
	public int addNewConnectivityComplain(ConnectivityComplainModel newCm)
	{
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("connection is not establish!");
				return 0;
			}

			else 
			{
				Date date=new Date();
				DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				
				String curDate=df.format(date);
		
				String createdBy=((UserLogin)session.getAttribute("userObj")).getName();
		
				
				PreparedStatement pst=con.prepareStatement("insert into tbl_complain_details (prison_name,prison_id,"
						+ "complain_logg_by,designation,phone,mail,type_of_connectivity,complain_desc,"
						+ "created_at,created_by,updated_at,updated_by,catagory,status) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pst.setString(1, newCm.getPrison_name());
				pst.setString(2, newCm.getPrison_id());
				pst.setString(3, newCm.getComp_loggby());
				pst.setString(4, newCm.getDesignation());
				pst.setLong(5, newCm.getPhone());
				pst.setString(6, newCm.getMail());
				pst.setString(7, newCm.getConnectivity_type());
				pst.setString(8, newCm.getComplain_desc());
				pst.setString(9, curDate);
				pst.setString(10, createdBy);
				pst.setString(11, curDate);
				pst.setString(12, createdBy);
				pst.setString(13, "Connectivity");
				pst.setString(14, "open");
				
				i=pst.executeUpdate();
				System.out.println("value of i " +i);
				return i;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
				
				}
			}
		}
		
	}

}
