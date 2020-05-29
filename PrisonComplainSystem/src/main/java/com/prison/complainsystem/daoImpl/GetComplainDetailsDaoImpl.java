package com.prison.complainsystem.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prison.complainsystem.connection.ConnectionFactory;
import com.prison.complainsystem.dao.GetComplainDetailsDao;
import com.prison.complainsystem.model.AllComplainModel;
import com.prison.complainsystem.model.ConnectivityComplainModel;
import com.prison.complainsystem.model.HardwareComplainModel;
import com.prison.complainsystem.model.PhysicalDamageModel;
import com.prison.complainsystem.model.SoftwareComplainModel;
import com.prison.complainsystem.model.UpdateComplainModel;
import com.prison.complainsystem.model.UserLogin;

@Repository
@Transactional
public class GetComplainDetailsDaoImpl implements GetComplainDetailsDao {

	@Autowired
	HttpSession session;
	
	int i=0;
	private static final Logger logger = LoggerFactory.getLogger(GetComplainDetailsDaoImpl.class);

	Connection con = null;

	public List<AllComplainModel> getConnectionCompDetail() {
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("connection is not establish!");
				return null;
			}

			else {
				List<AllComplainModel> complainList = new ArrayList<AllComplainModel>();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(
						"select id,catagory,prison_name,complain_logg_by,created_at,status,phone,mail,designation"
								+ " from tbl_complain_details where pid is null ORDER BY DATE_FORMAT(created_at, '%Y-%m-%d %k:%i:%s') DESC limit 5");

				if (rs == null) {
					logger.info("Records not found in tbl_complain_details!");
					return complainList;
				}

				else {
					while (rs.next()) {
						AllComplainModel model = new AllComplainModel();
						model.setId(rs.getLong(1));
						model.setCatagory(rs.getString(2));
						model.setPrison_name(rs.getString(3));
						model.setComplain_logg_by(rs.getString(4));
						model.setCreated_at(rs.getString(5));
						model.setStatus(rs.getString(6));
						model.setPhone(rs.getLong(7));
						model.setMail(rs.getString(8));
						model.setDesignation(rs.getString(9));
						complainList.add(model);
					}

					return complainList;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

				}
			}
		}
	}


	
	public Map<String, String> getCompCount() {
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("connection is not establish!");
				return null;
			}

			else {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT COUNT(1)COUNT,catagory FROM `tbl_complain_details` where pid is null GROUP BY `catagory`");
				Map<String, String> countMap = new HashMap<String, String>();
				while (rs.next()) {
					countMap.put(rs.getString(2), rs.getString(1));
				}

				return countMap;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

				}
			}

		}
	}

	
	public List<AllComplainModel> getHwCompDetail() 
	{

		try
		{
			con=ConnectionFactory.getConnection();
			
			if(con==null)
			{
				logger.info("connection is not establish!");
				return null;
			}
			
			else
			{
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("Select id,prison_id,prison_name,complain_logg_by,status,phone,created_at,catagory,created_by from tbl_complain_details where catagory='Hardware' and pid is null ORDER BY DATE_FORMAT(created_at, '%Y-%m-%d %k:%i:%s') DESC");
				List<AllComplainModel> list=new  ArrayList<AllComplainModel>();
				
				while(rs.next())
				{
					AllComplainModel model=new AllComplainModel();
					model.setId(rs.getLong(1));
					model.setPrison_id(rs.getString(2));
					model.setPrison_name(rs.getString(3));
					model.setComplain_logg_by(rs.getString(4));
					model.setStatus(rs.getString(5));
					model.setPhone(rs.getLong(6));
					model.setCreated_at(rs.getString(7));
					model.setCatagory(rs.getString(8));
					model.setCreated_by(rs.getString(9));
					
					list.add(model);
				}
				
				return list;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
		return null;
	}
	
	

	
	
	public List<AllComplainModel> getSwCompDetail() 
	{
		try
		{
			con=ConnectionFactory.getConnection();
			
			if(con==null)
			{
				logger.info("connection is not establish!");
				return null;
			}
			
			else
			{
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("Select id,prison_id,prison_name,complain_logg_by,status,phone,created_at,catagory,created_by from tbl_complain_details where catagory='Software' and pid is null ORDER BY DATE_FORMAT(created_at, '%Y-%m-%d %k:%i:%s') DESC");
				List<AllComplainModel> list=new  ArrayList<AllComplainModel>();
				
				while(rs.next())
				{
					AllComplainModel model=new AllComplainModel();
					model.setId(rs.getLong(1));
					model.setPrison_id(rs.getString(2));
					model.setPrison_name(rs.getString(3));
					model.setComplain_logg_by(rs.getString(4));
					model.setStatus(rs.getString(5));
					model.setPhone(rs.getLong(6));
					model.setCreated_at(rs.getString(7));
					model.setCatagory(rs.getString(8));
					model.setCreated_by(rs.getString(9));
					
					list.add(model);
				}
				
				return list;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
		return null;
	}

	
	
	public List<AllComplainModel> getPhysicalCompDetail() {
		try
		{
			con=ConnectionFactory.getConnection();
			
			if(con==null)
			{
				logger.info("connection is not establish!");
				return null;
			}
			
			else
			{
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("Select id,prison_id,prison_name,complain_logg_by,status,phone,created_at,catagory,created_by from tbl_complain_details where catagory='Physical Damage' and pid is null ORDER BY DATE_FORMAT(created_at, '%Y-%m-%d %k:%i:%s') DESC");
				List<AllComplainModel> list=new  ArrayList<AllComplainModel>();
				
				while(rs.next())
				{
					AllComplainModel model=new AllComplainModel();
					model.setId(rs.getLong(1));
					model.setPrison_id(rs.getString(2));
					model.setPrison_name(rs.getString(3));
					model.setComplain_logg_by(rs.getString(4));
					model.setStatus(rs.getString(5));
					model.setPhone(rs.getLong(6));
					model.setCreated_at(rs.getString(7));
					model.setCatagory("Physical_Damage");
					model.setCreated_by(rs.getString(9));
					list.add(model);
				}
				
				return list;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
		return null;
	}



	public List<AllComplainModel> getconnCompDetail() 
	{

		try
		{
			con=ConnectionFactory.getConnection();
			
			if(con==null)
			{
				logger.info("connection is not establish!");
				return null;
			}
			
			else
			{
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("Select id,prison_id,prison_name,complain_logg_by,status,phone,created_at,catagory,created_by from tbl_complain_details where catagory='Connectivity' and pid is null ORDER BY DATE_FORMAT(created_at, '%Y-%m-%d %k:%i:%s') DESC");
				List<AllComplainModel> list=new  ArrayList<AllComplainModel>();
				
				while(rs.next())
				{
					AllComplainModel model=new AllComplainModel();
					model.setId(rs.getLong(1));
					model.setPrison_id(rs.getString(2));
					model.setPrison_name(rs.getString(3));
					model.setComplain_logg_by(rs.getString(4));
					model.setStatus(rs.getString(5));
					model.setPhone(rs.getLong(6));
					model.setCreated_at(rs.getString(7));
					model.setCatagory(rs.getString(8));
					model.setCreated_by(rs.getString(9));
					
					list.add(model);
				}
				
				return list;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
		return null;
	}
	
	

	@Override
	public List<AllComplainModel> getSingleComplainDetail(String id)
	{
		try
		{
			con=ConnectionFactory.getConnection();
			
			if(con==null)
			{
				logger.info("connection is not establish!");
				return null;
			}
			
			else
			{
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("Select id,prison_name,prison_id,complain_logg_by,designation,phone,mail,hw_name,"
						+ "issue_arr_date,complain_desc,type_of_connectivity,damage_item,serial_no,"
						+ "damage_desc,assign_to,date_of_visit,observation_detail,"
						+ "action_taken,repair_replace,STATUS,complain_close_date,created_at,created_by,updated_at,"
						+ "updated_by,catagory from tbl_complain_details where id='"+id+"' and pid is null ORDER BY DATE_FORMAT(created_at, '%Y-%m-%d %k:%i:%s') DESC");
				List<AllComplainModel> list=new  ArrayList<AllComplainModel>();
				
				while(rs.next())
				{
					AllComplainModel model=new AllComplainModel();
					model.setId(rs.getLong(1));
					model.setPrison_name(rs.getString(2));
					model.setPrison_id(rs.getString(3));
					model.setComplain_logg_by(rs.getString(4));
					model.setDesignation(rs.getString(5));
					model.setPhone(rs.getLong(6));
					model.setMail(rs.getString(7));
					model.setHw_name(rs.getString(8));
					model.setIssue_arr_date(rs.getString(9));
					model.setComplain_desc(rs.getString(10));
					model.setType_of_connectivity(rs.getString(11));
					model.setDamage_item(rs.getString(12));
					model.setSerial_no(rs.getString(13));
					model.setDamage_desc(rs.getString(14));
					model.setAssign_to(rs.getString(15));
					model.setDate_of_visit(rs.getString(16));
					model.setObservation_detail(rs.getString(17));
					model.setAction_taken(rs.getString(18));
					model.setRepair_replace(rs.getString(19));
					model.setStatus(rs.getString(20));
					model.setComplain_close_date(rs.getString(21));
					model.setCreated_at(rs.getString(22));
					model.setCreated_by(rs.getString(23));
					model.setUpdated_at(rs.getString(24));
					model.setUpdated_by(rs.getString(25));
					model.setCatagory(rs.getString(26));
					list.add(model);
				}
				
				return list;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
		return null;
	}
	
	@Override
	public List<AllComplainModel> getComplainHistory(String id)
	{
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("connection is not establish!");
				return null;
			}

			else 
			{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select id,prison_name,prison_id,complain_logg_by,designation,phone,mail,hw_name,"
					+ "issue_arr_date,complain_desc,type_of_connectivity,damage_item,serial_no,"
					+ "damage_desc,assign_to,date_of_visit,observation_detail,"
					+ "action_taken,repair_replace,STATUS,complain_close_date,created_at,created_by,updated_at,"
					+ "updated_by,catagory from tbl_complain_details where pid='"+id+"'");
			
			List<AllComplainModel> list=new ArrayList<AllComplainModel>();
			
			while(rs.next())
			{
				AllComplainModel model=new AllComplainModel();
				model.setId(rs.getLong(1));
				model.setPrison_name(rs.getString(2));
				model.setPrison_id(rs.getString(3));
				model.setComplain_logg_by(rs.getString(4));
				model.setDesignation(rs.getString(5));
				model.setPhone(rs.getLong(6));
				model.setMail(rs.getString(7));
				model.setHw_name(rs.getString(8));
				model.setIssue_arr_date(rs.getString(9));
				model.setComplain_desc(rs.getString(10));
				model.setType_of_connectivity(rs.getString(11));
				model.setDamage_item(rs.getString(12));
				model.setSerial_no(rs.getString(13));
				model.setDamage_desc(rs.getString(14));
				model.setAssign_to(rs.getString(15));
				model.setDate_of_visit(rs.getString(16));
				model.setObservation_detail(rs.getString(17));
				model.setAction_taken(rs.getString(18));
				model.setRepair_replace(rs.getString(19));
				model.setStatus(rs.getString(20));
				model.setComplain_close_date(rs.getString(21));
				model.setCreated_at(rs.getString(22));
				model.setCreated_by(rs.getString(23));
				model.setUpdated_at(rs.getString(24));
				model.setUpdated_by(rs.getString(25));
				model.setCatagory(rs.getString(26));
				list.add(model);
			}
				return list; 
		}
	}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
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
	
	






/*@Override
	public int connectivityUpdate(UpdateComplainModel openupdate)
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
				DateFormat df1=new SimpleDateFormat("MM/dd/yyyy");
				DateFormat df2=new SimpleDateFormat("yyyy-MM-dd");
				DateFormat df3=new SimpleDateFormat("hh:mm:ss");
				
				String curtime=df3.format(date);
				Date a=df1.parse(openupdate.getDate_of_visit());
				String visitdate=df2.format(a);
				
				String updatedBy=((UserLogin)session.getAttribute("userObj")).getName();
				String updatedAt=df.format(date);
		
				
				PreparedStatement pst=con.prepareStatement("update tbl_complain_details set assign_to=?,observation_detail=?"
						+ ",repair_replace=?,status=?,date_of_visit=?,action_taken=?,updated_by=?,updated_at=? where id="+openupdate.getSno());
				pst.setString(1, openupdate.getAssign_to());
				pst.setString(2, openupdate.getObservation_detail());
				pst.setString(3, openupdate.getRepair_replace());
				pst.setString(4, openupdate.getStatus());
				pst.setString(5, visitdate+" "+curtime);
				pst.setString(6, openupdate.getAction_taken());
				pst.setString(7, updatedBy);
				pst.setString(8, updatedAt);
				i=pst.executeUpdate();
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
*/

